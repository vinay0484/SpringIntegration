
package com.knack.controllers;

import java.io.File;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.knack.Authentications.AdminAuthentications;
import com.knack.integrationClasses.SpringIntegrationGateway;
import com.knack.integrationClasses.StringToMessage;

@Controller
public class FileUploadController {
	@Resource(name = "admin_authentication")
	AdminAuthentications admin_Authentications;

	@Resource(name = "MessageChannel")
	MessageChannel message_channel;

	@Resource(name = "gateway")
	SpringIntegrationGateway gateway_Service;

	final static Logger logger = Logger.getLogger(FileUploadController.class);

	@RequestMapping(value = "/passxml", method = RequestMethod.POST)
	public String uploadFileHandler(@RequestBody String file, @RequestParam("xmlfile") MultipartFile multipart,
			@RequestHeader("Authorization") String authentications) {

		Boolean auth_status = admin_Authentications.get_Auth(authentications);
		if (auth_status) {
			try {
				File convFile = new File(multipart.getOriginalFilename());
				multipart.transferTo(convFile);
				gateway_Service.send_File(convFile);

			} catch (Exception e) {
				logger.error(e);

			}

			/*
			 * Message msg=MessageBuilder.withPayload(file.toString()).build();
			 * 
			 * message_channel.send(msg);
			 */

			logger.info("File succesfully sent to spring integration");
			return "success";
		} else {
			logger.error("Authentication ERROR");
			return "Auth_failure";
		}

	}

}
