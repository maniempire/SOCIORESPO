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
<title>Login</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
div
	{	
		color:red;
			}
-->
</style>
<link href="styles/styles.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">


</script>

</head>

<body>

<form action="postComplaintsAction" method="post" >

<img src="images/socio-respo-header.jpg" width="1010" height="123" />
  <table>
  	<tr>
	<td class="hd-br">&nbsp;</td>  	
  	</tr>
  </table>
<!--    -->
  
<!--  <td align="right">Logged in as <html:link href="profileAction.do"><%=session.getAttribute("FIRSTNAME")%> </html:link></td>-->
<div style="width:1003px;">
	 <div style="height:500px; width : 1000px;">
		<html:select property="complaintTitleSelect" name="postComplaintsActionForm">
		</html:select>
		 /
		  <input  type="text" name="complaintTitleText" class="login-txt-bx" id="complaintId" />
		 
		 <html:link style="login-but" > </html:link>
		 
		<textarea name="postComplaint" rows="4" cols="10" style=" width : 176px;"></textarea>
		<input type="submit" value="Post Complaints" class="login-but"/>
	 
	  <logic:iterate id="result" name="postComplaintsActionForm" property="ComplaintList">
	
		<bean:write name="result" property="content" /></br>

	</logic:iterate>
  <div style="height : 299px; width : 118px; float: right;"> 
  
  <table align="left" cellpadding="0" cellspacing="0" style="height: 299px; width:118px;">
  
  <tr align="left">
	
  	  <html:link href="https://www.google.com" styleClass="link">Hot News</html:link>
  </tr>
  <tr>
  <td>
  	
  	<html:link href="https://www.google.com" styleClass="link">Online Debate</html:link>
  </td>
  	  
  </tr>

  
  <tr>
  	  <td align="right"><html:link href="https://www.google.com">Complaints</html:link></td>
  </tr>
  
  
  
  </table>
  </div>
  </div>
  </div>
  
  
     
      
   <table>
   <tr>
    	<td class="hd-br"><jsp:include page="/common/footer.jsp" /></td>
    </tr>
  	</table>

</form>
</body>
</html:html>
