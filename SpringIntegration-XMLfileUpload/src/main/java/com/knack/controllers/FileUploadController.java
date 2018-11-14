
package com.knack.controllers;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FileUploadController
{


	@Resource(name = "MessageChannel")
	MessageChannel message_channel;



	final static Logger logger = Logger.getLogger(FileUploadController.class);

	@RequestMapping(value = "/xml", method = RequestMethod.POST)
	public String uploadFileHandler(@RequestBody final String file)
	{



		final Message msg = MessageBuilder.withPayload(file.toString()).build();

		message_channel.send(msg);


		logger.info("File succesfully sent to spring integration");
		return "success";




	}

}
