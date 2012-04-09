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
<title>Debate</title>
<link href="styles/styles.css" rel="stylesheet" type="text/css" />
</head>
<body onload="initScript();">

<html:form action="/postComplaintsAction" method="post" >
<table width="1004" border="0" cellpadding="0" cellspacing="0">
<tr>
<td>
<jsp:include page="/common/header.jsp" />

</td>
</tr>
<tr>
<td>
<jsp:include page="/common/header-title-home.jsp" />

</td>


</tr>

<tr>
<td>
<table border="0">
<tr>
<td height="500" width="700" valign="top">


<table border="0" cellpadding="0" height="400"  cellspacing="0" width="600" align="center" >
<tr>
<td valign="top">


<table border="0" cellpadding="0" height="200"  cellspacing="0" width="300" align="center" >
<tr>
<td height="35" class="text-headline">
Complaint here:
</td>
</tr>

<tr>
<td height="60" class="body-text">
 Tag: <input  type="text" name="complaintTitleText" class="login-txt-bx" id="complaintId" /><br/>
		 
	&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="postComplaint" rows="4" cols="10" style=" width : 176px;"></textarea>
</td>
</tr>
<tr>
<td height="30" class="body-text">
	&nbsp;&nbsp;&nbsp;&nbsp;
  		<input type="checkbox" name="shareFacebook"></input>Facebook 
    
		<input type="checkbox" name="shareTwitter"></input>Twitter
		
		<input type="checkbox" name="shareLinkedIn"></input>LinkedIn
</td>
</tr>
<tr>
<td height="30">
	&nbsp;&nbsp;&nbsp;&nbsp;<input name="submit" type="submit" class="login-but" value="Complaint" />
</td>
</tr>

</table>

</td>
<td valign="top">

<table border="0" cellpadding="0" height="200"  cellspacing="0" width="300" align="center" >
<tr>
<td class="text-headline" height="35" valign="top">
My Complaints:
</td>
</tr>
 <logic:notEmpty name="postComplaintsActionForm" property="userComplaintsList">
	  <logic:iterate id="result" name="postComplaintsActionForm" property="userComplaintsList">
	
<tr>
<td class="body-text" height="25">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="result" property="postComplaint" />
</td>
</tr>
</logic:iterate>
</logic:notEmpty>
</table>
 

</td>

</tr>
<tr>
<td>

<table border="0" cellpadding="0" height="200"  cellspacing="0" width="300" align="center" >
<tr>
<td class="text-headline" height="35" valign="top">
All Complaints:
</td>
</tr>
 <logic:notEmpty name="postComplaintsActionForm" property="complaintsList">
	  <logic:iterate id="result" name="postComplaintsActionForm" property="complaintsList">
	
<tr>
<td class="body-text" height="25">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="result" property="postComplaint" />
</td>
</tr>
</logic:iterate>
</logic:notEmpty>
</table>
</td>
<td>
&nbsp;
</td>

</tr>


</table>






</td>
<td width="304" valign="top">
<table border="0" width="300" align="center">
<tr>
<td height="150" valign="top" >
<table border="0" bgcolor="" width="200" align="center">

<tr>
<td colspan="3">

&nbsp;
</td>
</tr>
<tr>
<td width="50">
&nbsp;
</td>
<td>
<img src="images/default-human.jpg" width="100" height="100" />
</td>
<td  width="50">
&nbsp;
</td>

</tr>
<tr>
<td colspan="3" align="center" class="body-text">
Logged in as <html:link href="profileAction.do"><%=session.getAttribute("FIRSTNAME")%> </html:link>

</td>
</tr>

</table>
</td>
</tr>
<tr>
<td height="150" valign="top" >
<table border="0" bgcolor="" width="200" align="center">

<tr>
<td>
&nbsp;
</td>
<td align="center" height="60" class="marque-headline">
Hot Links
</td>
<td>
&nbsp;
</td>
</tr>
<tr>
<td>
&nbsp;
</td>
<td  height="35">
<html:link href="postComplaintsAction.do?link_url=complaint">Complaints</html:link>
</td>
<td>
&nbsp;
</td>
</tr>
<tr>
<td>
&nbsp;
</td>
<td height="35">
<html:link href="debateAction.do?link_url=debate" >Online Debate</html:link>
</td>
<td>
&nbsp;
</td>
</tr>

</table>
</td>
</tr>
<tr>
<td>
&nbsp;
</td>
</tr>
</table>
</td>
</tr>
</table>

</td>


</tr>

<tr>
    	<td class="hd-br"><jsp:include page="/common/footer.jsp" /></td>
  	</tr>
</table>





</html:form>
</body>
</html:html>