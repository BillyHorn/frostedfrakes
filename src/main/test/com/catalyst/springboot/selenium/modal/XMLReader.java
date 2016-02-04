package com.catalyst.springboot.selenium.modal;

import java.io.File;
import java.util.TreeMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {
	public static TreeMap<String, InputbeanList> XMLdata;
	public boolean readingxml(String methodname) {
		XMLdata = new TreeMap<String, InputbeanList>();
		InputbeanList inputdata = null;
		try {
			File fXmlFile = new File(
					"C://Users//spallipatt//Desktop//frostedfrakes//src//main//test//com//catalyst//springboot//selenium//test//TestInputData.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			// System.out.println("XML READER.java : classname" + classname);
			NodeList nList = doc.getElementsByTagName(methodname);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("nNode" + nNode + "temp:" + temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					inputdata = new InputbeanList();
					inputdata.setSNO(eElement.getAttribute("id"));
					inputdata.setScenarioname(methodname);
					inputdata.setUsername(eElement.getElementsByTagName("username").item(0).getTextContent());
					inputdata.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
				//	inputdata.setVerifyPassword(eElement.getElementsByTagName("verifypassword").item(0).getTextContent());
					XMLdata.put(inputdata.getSNO(), inputdata);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public static TreeMap<String, InputbeanList> getInputdata() {
		return XMLdata;
	}

}