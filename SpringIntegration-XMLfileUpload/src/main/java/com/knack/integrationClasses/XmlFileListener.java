package com.knack.integrationClasses;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.knack.DTO.XmlFile;

public class XmlFileListener {
	@Autowired
	XmlFile xmlfile_DTO;
	
	public File send_File() {
		System.out.println("from listener class");
		return xmlfile_DTO.getFile();
		
	}

}
