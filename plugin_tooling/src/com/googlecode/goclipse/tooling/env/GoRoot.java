/*******************************************************************************
 * Copyright (c) 2014, 2014 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package com.googlecode.goclipse.tooling.env;

import static melnorme.utilbox.core.Assert.AssertNamespace.assertNotNull;

import java.nio.file.Path;

import com.googlecode.goclipse.tooling.GoPackageName;

import melnorme.utilbox.core.CommonException;

public class GoRoot {
	
	protected final String goRoot;
	
	public GoRoot(String goRoot) {
		this.goRoot = assertNotNull(goRoot);
	}
	
	public String asString() {
		return goRoot;
	}
	
	public boolean isEmpty() {
		return goRoot.isEmpty();
	}
	
	public Path asPath() throws CommonException {
		return GoEnvironment.createPath(goRoot);
	}
	
	public Path getSourceRootLocation() throws CommonException {
		return asPath().resolve("src/pkg");
	}
	
	public GoPackageName findGoPackageForSourceModule(Path goModulePath) throws CommonException {
		return GoEnvironment.getGoPackageForSourceFile(goModulePath, getSourceRootLocation());
	}
	
}