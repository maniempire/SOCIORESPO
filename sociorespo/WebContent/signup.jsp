<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup page</title>
</head>
<body>
<html:form action="/signupAction" method="post">
First name: <input type="text" name="firstname"  id="fname"/><br />
Last name: <input type="text" name="lastname"  id="lname"/><br />
Gender: <input type="text" name="gender" id="gendr" /><br />
Date of Birth: <input type="text" name="dateofbirth"  id="dob"/><br />
Voterid: <input type="text" name="voterid" id="vid"/><br />
Password: <input type="text" name="password"  id="pwd"/><br />
Signup button: <input type="Submit" name="SIGNUP"  id="Submit"/><br />
</html:form>
</body>
</html:html>