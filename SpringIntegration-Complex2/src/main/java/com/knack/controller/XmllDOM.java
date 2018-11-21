package com.knack.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.knack.dynamicPojos.DynamicPojo;


public class XmllDOM
{

	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public static void main(final String[] args) throws ParserConfigurationException, SAXException, IOException,
			ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException

	{
		Class<?> beanClass = null;
		final Map<String, Class<?>> properties = new HashMap<String, Class<?>>();
		final String filePath = "Properties.xml";
		final File xmlFile = new File(filePath);
		final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		dBuilder = dbFactory.newDocumentBuilder();

		final Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();


		final NodeList nodeList = doc.getElementsByTagName("property");

		for (int i = 0; i < nodeList.getLength(); i++)
		{
			final Node node = nodeList.item(i);


			properties.put(node.getTextContent(), Integer.class);

		}


		beanClass = DynamicPojo.createBeanClass("some.ClassName", properties);






		for (final Method method : beanClass.getDeclaredMethods())
		{

			String getmethod = null;
			System.out.println(".........." + method);

			final Class<?> clazz = Class.forName("com.knack.jaxbClasses.Employee");

			final String str = "" + method;
			for (int i = str.length() - 1; i > 0; i--)
			{
				if (str.charAt(i) == 'g')
				{
					if (str.charAt(i - 1) == '.')
					{
						getmethod = str.substring(i, str.length() - 2);

					}
				}
			}

			final Object obj = clazz.newInstance();

			if (!(getmethod == null))
			{
				final String s = getmethod.replaceAll("\\s+", "");
				final String result = (String) clazz.getMethod(s).invoke(obj);
				System.out.println(result);

				//System.out.println(value);

			}



		}

	}
















}


