package com.pid.util;

public interface Db2ServerInfo {
	  
	  /**
	   * Enter the computer name of the one that you want to use as server. 
	   */
	  public String   HOST = Db2XML.value.get("serverHost");  

	  /**
	   * Enter the DB name of the one that you want to use as server. 
	   */
	  public String   DB = Db2XML.value.get("serverDBName");  

	  /**
	   * the port to be used by the server.
	   */
	  public int   PORT = Integer.valueOf(Db2XML.value.get("serverPort")).intValue();
	  
	  /**
	   * the user name for access control.
	   */
	  public String   USER = Db2XML.value.get("serverUID");
	  
	  /**
	   * the pasword for access control.
	   */
	  public String   PASS = Db2XML.value.get("serverPwd");

	  /**
	   * the Mail for access control.
	   */
	  public String   MAIL = Db2XML.value.get("serverMailID");

	  /**
	   * the Mail pwd for access control.
	   */
	  public String   MAILPASS = Db2XML.value.get("serverMailPwd");

}
