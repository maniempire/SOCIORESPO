<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<html:form action="/loginAction" method="post" >
<table width="1010" border="0" cellpadding="0" cellspacing="0">
<B>  ALREADY HAVING ACCOUNT </B>
<tr>
<td>
User Name <input  type="text" name="userName" id="userId"/>
</td>
</tr>
<tr>
<td>
Password<input  type="password" name="password" id="password"/>
</td>
</tr>
<tr>
 <td height="7"><input name="Submit" type="submit" value="Submit" /></td>
</tr>
</table>
<B>  NEED TO CREATE ACCOUNT THEN CLICK SIGNUP BUTTON </B>

<a href = "signup.jsp"><input type="button" value="signup"></input></a>
</html:form>
</body>
</html:html>