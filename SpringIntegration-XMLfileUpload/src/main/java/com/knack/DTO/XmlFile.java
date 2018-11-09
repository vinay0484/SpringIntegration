package com.knack.DTO;

import java.io.File;

public class XmlFile {
	File file;

	public File getFile() {
		System.out.println("from get method");
		return file;
	}

	public void setFile(File file) {
		System.out.println("from set method");
		this.file = file;
	}
	
}
