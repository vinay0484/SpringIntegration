package com.knack.targetProcess;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.knack.targetJax.Target;


public class TargetProcess
{

	private Target target_prop_type;


	public Message target_obj(final Map map)
	{

		final Map<String, String> target_fileds = new HashMap<String, String>();
		System.out.println("from target_objk");

		for (final String prop : target_prop_type.getProperty())
		{
			map.get(prop.trim());

			System.out.println((String) map.get(prop.trim()));

			target_fileds.put(prop.trim(), (String) map.get(prop.trim()));

		}


		final Message<Map<String, String>> message = MessageBuilder.withPayload(target_fileds)
				.setHeader("type", target_prop_type.getType()).build();
		return message;

	}


	public void target_prop(final Target target)

	{
		System.out.println("from target_prop");
		target_prop_type = target;
	}
}
