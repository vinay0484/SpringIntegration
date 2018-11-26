package com.knack.targetProcess;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


@SuppressWarnings("javadoc")
public class TargetProcess
{

	String type;

	public Message<Map<String, String>> target_obj(final Map<?, ?> map)
			throws ParserConfigurationException, SAXException, IOException
	{
		final Map<String, String> target_fileds = new HashMap<String, String>();
		final File xmlFile = new File("target.xml");
		final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		final Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		final NodeList nodeList1 = doc.getElementsByTagName("target");
		for (int i = 0; i < nodeList1.getLength(); i++)
		{
			final Node node1 = nodeList1.item(i);
			type = node1.getAttributes().getNamedItem("type").getNodeValue();
		}
		final NodeList nodeList2 = doc.getElementsByTagName("property");
		for (int i = 0; i < nodeList2.getLength(); i++)
		{
			final Node node2 = nodeList2.item(i);
			final String str = node2.getTextContent().trim();
			if (map.containsKey(str))
			{
				target_fileds.put(str, (String) map.get(str));
			}
		}
		final Message<Map<String, String>> message = MessageBuilder.withPayload(target_fileds).setHeader("type", type).build();
		return message;
	}

}
