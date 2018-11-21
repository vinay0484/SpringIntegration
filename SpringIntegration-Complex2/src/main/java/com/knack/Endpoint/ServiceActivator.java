package com.knack.Endpoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.knack.Jax.Attributes;


/**
 *
 */
public class ServiceActivator

{


	Attributes properties;

	final static Logger logger = Logger.getLogger(ServiceActivator.class);

	@SuppressWarnings("javadoc")
	public Map<String, String> xml_data(final Map map) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, NoSuchMethodException, IOException
	{

		final Map<String, String> Canonical_Fileds = new HashMap<String, String>();

		for (final String prop : properties.getProperty())
		{
			map.get(prop.trim());

			Canonical_Fileds.put(prop.trim(), (String) map.get(prop.trim()));

		}
		System.out.println("from xml_data");
		return Canonical_Fileds;
	}





	@SuppressWarnings("javadoc")
	public void properties(final Attributes attribute)
	{

		System.out.println("from_properties");
		properties = attribute;
	}

}

