package com.knack.integrationClasses;



import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class XmlServiceActivator
{

	final static Logger logger = Logger.getLogger(XmlServiceActivator.class);

	public void parse_XML(final Object object)

	{
		DOMConfigurator.configure("log4j.xml");
		logger.fatal(object);

	}

}
