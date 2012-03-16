package com.pid.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Db2XML {
	public static Map<String,String> value = new HashMap<String,String>();
	
	public  static void readXMLFile(){
	    try {
	    	Properties properties = System.getProperties();
	    	String path = properties.getProperty("PIMConfig");
	    	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	    	Document document = documentBuilder.parse(new File(path));
	    	
	    	NodeList list = document.getElementsByTagName("server");
	    	Node firstNode = list.item(0);
	    	if(firstNode.getNodeType() == Node.ELEMENT_NODE){
                Element firstElement = (Element)firstNode;
                
                NodeList serverHost = firstElement.getElementsByTagName("serverHost");
                Element server = (Element)serverHost.item(0);
                NodeList serverHostIP = server.getChildNodes();
                String ip = ((Node)serverHostIP.item(0)).getNodeValue().trim();
                System.out.println("Db2XML serverHost ==>" +ip);
                value.put("serverHost", ip);
                
                NodeList serverDBName = firstElement.getElementsByTagName("DBName");
                Element serverDBEle = (Element)serverDBName.item(0);
                NodeList serverDBNode = serverDBEle.getChildNodes();
                String dbName = ((Node)serverDBNode.item(0)).getNodeValue().trim();
                System.out.println("Db2XML serverDBName ==>" +dbName);
                value.put("serverDBName", dbName);

                NodeList serverPort = firstElement.getElementsByTagName("serverPort");
                Element serverUnUsedPort = (Element)serverPort.item(0);
                NodeList serverHostPort = serverUnUsedPort.getChildNodes();
                String port = ((Node)serverHostPort.item(0)).getNodeValue().trim();
                System.out.println("Db2XML serverPort ==>" +port);
                value.put("serverPort", port);

                NodeList serverUID = firstElement.getElementsByTagName("serverUID");
                Element serverUser = (Element)serverUID.item(0);
                NodeList serverUserId = serverUser.getChildNodes();
                String user = ((Node)serverUserId.item(0)).getNodeValue().trim();
                System.out.println("Db2XML serverUID ==>" +user);
                value.put("serverUID", user);

                NodeList serverPwd = firstElement.getElementsByTagName("serverPwd");
                Element serverPass = (Element)serverPwd.item(0);
                NodeList serverPassword = serverPass.getChildNodes();
                String password = ((Node)serverPassword.item(0)).getNodeValue().trim();
                System.out.println("Db2XML serverPwd ==>" +password);
                value.put("serverPwd", password);
                
                NodeList serverMail = firstElement.getElementsByTagName("serverMailID");
                Element serverMailEle = (Element)serverMail.item(0);
                NodeList serverMailNode = serverMailEle.getChildNodes();
                String mailId = ((Node)serverMailNode.item(0)).getNodeValue().trim();
                System.out.println("Db2XML serverPwd ==>" +mailId);
                value.put("serverMailID", mailId);

                NodeList serverMailPwd = firstElement.getElementsByTagName("serverMailPwd");
                Element serverMailPass = (Element)serverMailPwd.item(0);
                NodeList serverMailPassword = serverMailPass.getChildNodes();
                String mailPWD = ((Node)serverMailPassword.item(0)).getNodeValue().trim();
                System.out.println("Db2XML serverPwd ==>" +mailPWD);
                value.put("serverMailPwd", mailPWD);

	    	}
	    } catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	
}
