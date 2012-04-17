/*******************************************************************************
* Copyright (c) 2012 Harman International (http://www.harman.com).
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
package model.emf.dbusxml.typesystem;

public class DBusStructType extends DBusType {

	private DBusTypeList elementTypes;
	
	public DBusStructType (DBusTypeList elementTypes) {
		super("Struct[" + elementTypes.asString() + "]");
		this.elementTypes = elementTypes;
	}

	public DBusTypeList getElementTypes() {
		return elementTypes;
	}
	
	@Override
	public boolean validate() {
		for(DBusType elementType : elementTypes) {
			if (! elementType.validate()) {
				return false;
			}
		}
		return true;
	}
}

