package com.knack.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@SuppressWarnings("javadoc")
@Controller
public class IntegrationController
{

	final static Logger logger = Logger.getLogger(IntegrationController.class);
	@Resource
	MessageChannel MessageChannel;

	/**
	 * @param file
	 */
	@RequestMapping(value = "/integration")
	public ResponseEntity<String> parse_xmlfile(@RequestBody final String file)
	{

		final Message<String> message = MessageBuilder.withPayload(file).build();
		try
		{
			MessageChannel.send(message);

			return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
		}
		catch (final Exception e)
		{
			logger.error(e);
			e.printStackTrace();
			return new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);
		}

	}

}
