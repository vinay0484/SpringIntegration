package com.knack.integrationClasses;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface Gateway
{
	public void send(File convFile);

	
}
