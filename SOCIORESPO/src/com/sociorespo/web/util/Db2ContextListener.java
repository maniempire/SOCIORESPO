package com.sociorespo.web.util;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sociorespo.util.Db2ServerInfo;
import com.sociorespo.util.Db2XML;

public class Db2ContextListener implements ServletContextListener,Db2ServerInfo {
	
	private static String fs = System.getProperty("file.separator");
	// To set Db4o configuration XML file name
	public static final String KEY_DB4O_CONFIG_FILE = "SocioRespoConfig.xml";
	// To set as context attribute key value for server
	public static final String KEY_DB4O_SERVER = "db2Server";
	

	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();

		/* Read the DB4O_CONFIG_FILE from the context */
		String filePathnew[] = context.getRealPath(fs).split("default");
		ApplicationConfig.setBaseUrlPath(filePathnew[0] + "default" + fs + "deploy" + fs + KEY_DB4O_CONFIG_FILE);
		context.log("PIMConfig.xml file on " + ApplicationConfig.getBaseUrlPath());
		System.setProperty("PIMConfig", ApplicationConfig.getBaseUrlPath());
		Db2XML.readXMLFile();
		/* End */
	}

	public void contextDestroyed(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		context.removeAttribute(KEY_DB4O_SERVER);		
		context.log("db4o shutdown");
	}

	
}
