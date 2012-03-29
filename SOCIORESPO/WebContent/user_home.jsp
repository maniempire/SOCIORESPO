<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link href="styles/styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
<html:form action="/homeAction" method="post" >
<table width="1010" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="1010"><img src="images/socio-respo-header.jpg" width="1010" height="123" /></td>
  </tr>
  <tr>
    <td height="2"></td>
  </tr>
	<tr>
	
    	<td class="hd-br">&nbsp;<html:link href="loginAction.do?link_url=logout" styleClass="link">Logout</html:link></td>
    	
  	</tr>
  	<tr>
  	<td align="right">Logged in as <html:link href="profileAction.do"><%=session.getAttribute("FIRSTNAME")%> </html:link></td>
  	</tr>
  	
 <tr>
    <td>&nbsp;</td>
  </tr>
  
  
  
  <tr>
  <td align="left">
  <textarea rows="2" name="postTags"></textarea>

  
  		
  	  <html:link href="https://www.google.com" styleClass="link">Hot News</html:link></td>
  </tr>
  <tr>
  <td>
  	<input name="submit" type="submit" class="login-but" value="Post" />
  	<html:link href="https://www.google.com" styleClass="link">Online Debate</html:link>
  </td>
  	  
  </tr>

  
  <tr>
  	  <td align="right"><html:link href="https://www.google.com">Complaints</html:link></td>
  </tr>
  
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
  	  <td align="right"><html:link href="https://www.google.com">TAGS</html:link></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>

	<tr>
    	<td class="hd-br"><jsp:include page="/common/footer.jsp" /></td>
  	</tr>
</table>
</html:form>
</body>
</html:html>