<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Debate</title>
<link href="styles/styles.css" rel="stylesheet" type="text/css" />
</head>

<body>
<html:form action="/debateAction" method="post">
<img src="images/socio-respo-header.jpg" width="1010" height="123" />
<table>
  	<tr>
	<td class="hd-br">&nbsp;<html:link href="logoutAction.do?link_url=logout" styleClass="link">Logout</html:link></td>  	
  	</tr>
  	<tr>
  	  <td align="right">Logged in as <html:link href="profileAction.do"><%=session.getAttribute("FIRSTNAME")%> </html:link></td>
  	</tr>
  	<logic:notEmpty name="debateActionForm">
	  <logic:iterate id="result" name="debateActionForm" property="debateListView">
	
		<bean:write name="result" property="debateContent" /></br>

	</logic:iterate>
	</logic:notEmpty>
  	
  </table>
<table width="20%" align="right">
<logic:notEmpty name="debateActionForm">
	  <logic:iterate id="result" name="debateActionForm" property="userListView">
	
		<bean:write name="result" property="firstName" />
		<bean:write name="result" property="lastName" />

	</logic:iterate>
	</logic:notEmpty>

</table>
<table>
   <tr>
    	<td class="hd-br"><jsp:include page="/common/footer.jsp" /></td>
    </tr>
</table>


</html:form>
</body>
</html:html>