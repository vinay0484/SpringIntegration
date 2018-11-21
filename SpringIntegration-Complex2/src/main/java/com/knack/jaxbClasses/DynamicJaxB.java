package com.knack.jaxbClasses;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;



@XmlType
public class DynamicJaxB
{
	private List<JAXBElement<String>> properties = new ArrayList<JAXBElement<String>>();




	@SuppressWarnings("javadoc")
	@XmlAnyElement
	public List<JAXBElement<String>> getProperties()
	{
		return properties;
	}


	@SuppressWarnings("javadoc")
	public void setProperties(final List<JAXBElement<String>> properties)
	{
		this.properties = properties;
	}


	@SuppressWarnings("javadoc")
	public void addEntry(final String key, final String value)
	{
		final JAXBElement<String> prop = new JAXBElement<String>(new QName(key), String.class, value);
		addEntry(prop);
	}

	@SuppressWarnings("javadoc")
	public void addEntry(final JAXBElement<String> prop)
	{
		properties.add(prop);
	}


}
