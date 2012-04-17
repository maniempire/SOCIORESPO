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
<title>Edit Profile</title>
<link href="styles/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function connectLinkedIn(url){
	window.location.href = url;
}



function popup()
{

	url = "http://www.facebook.com/login.php?api_key=35da82b9e7418dc5c3a10267b1c0812f&v=1.0&req_perms=read_stream,publish_stream,offline_access,sms,email,user_location";
 var width  = 600;
 var height = 400;
 var left   = (screen.width  - width)/2;
 var top    = (screen.height - height)/2;
 var params = 'width='+width+', height='+height;
 params += ', top='+top+', left='+left;
 params += ', directories=no';
 params += ', location=no';
 params += ', menubar=no';
 params += ', resizable=no';
 params += ', scrollbars=yes';
 params += ', status=no';
 params += ', toolbar=no';
 newwin=window.open(url,'windowname5', params);
 if (window.focus) {newwin.focus();}
 return false;
}

/*function reload(){
	  location.href="/profileAction.do";
	}*/

function update(){
	
	window.location.href="./profileAction.do?link_url=update";
	
	
}


</script>
</head>
<body onload="initScript();">
<html:form action="/profileAction" method="post">

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


<table border="0" cellpadding="0" height="200"  cellspacing="0" width="261" align="center" >
<tr>
<td width="261" height="35" class="login-cont">
First Name:
</td>
</tr>
<tr>
<td height="35" class="login-cont">
Last Name:
</td>
</tr>
<tr>
<td height="35" class="login-cont">
Email:
</td>
</tr>
<tr>
<td height="35" class="login-cont">
Password:
</td>
</tr>
<tr>
<td height="35" class="login-cont">
New Password:
</td>
</tr>
<tr>
<td height="35" class="login-cont">
Confirm Password:
</td>
</tr>
<tr>
<td height="35" class="login-cont">
Gender:
</td>
</tr>
<tr>
<td height="35" class="login-cont">Phone No.:
</td>
</tr>
<tr>
<td height="35" class="login-cont">
Date of Birth:
</td>
</tr>
<tr>
<td height="35" class="login-cont">Voter Id:
</td>
</tr>
<tr>
      
<td height="60" class="body-text" align="right"><br/>
<input type="hidden" name="link_url" value="update"/>
		 <input type="submit" value="Update"  class="login-but" />
	&nbsp;&nbsp;&nbsp;&nbsp; </td>
</tr>
<tr>
<td height="30" class="body-text">
	&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
<td height="30">
	&nbsp;&nbsp;&nbsp;&nbsp; </td>
</tr>

</table>

</td>
<td valign="top">

<table border="0" cellpadding="0" height="200"  cellspacing="0" width="300" align="center" >
<tr>
<td height="35" class="login-cont">
<html:text property="firstName" name="profileActionForm" styleClass="login-txt-bx"></html:text>
</td>
</tr>
<tr>
<td height="35" class="login-cont">
<html:text property="lastName" name="profileActionForm" styleClass="login-txt-bx"></html:text>
</td>
</tr>
<tr>
<td height="35" class="login-cont">
<html:text property="mailId" name="profileActionForm" styleClass="login-txt-bx" ></html:text>
</td>
</tr>
<tr>
<td height="35" class="login-cont">
<html:password property="password" name="profileActionForm" styleClass="login-txt-bx" disabled="true"></html:password>
</td>
</tr>
<tr>
<td height="35" class="login-cont">
<html:password property="newPassword" name="profileActionForm" styleClass="login-txt-bx" ></html:password>
</td>
</tr>
<tr>
<td height="35" class="login-cont">
<html:password property="confirmPassword" name="profileActionForm" styleClass="login-txt-bx" ></html:password>
</td>
</tr>
<tr>
<td height="35" class="login-cont">
<html:select property="gender" name="profileActionForm">
  			<html:option value="selectGender">Select Gender</html:option>
  			<html:option value="male">Male</html:option>
            <html:option value="female">Female</html:option>	
  			<html:option value="transgender">Transgender</html:option>  				
  				
  
</html:select></td>
</tr>

<tr>
<td height="35" class="login-cont">
<html:text property="phoneNum" name="profileActionForm" styleClass="login-txt-bx"></html:text>
</td>
</tr>
<tr>
<td height="35" class="login-cont">
<html:text property="dob" name="profileActionForm" styleClass="login-txt-bx"></html:text>
</td>
</tr>
<tr>
<td height="35" class="login-cont">
<html:text property="voterId" name="profileActionForm" styleClass="login-txt-bx"></html:text>
</td>
</tr>


</table>
 

</td>

</tr>
<tr>
<td>


</td>
<td>&nbsp;

</td>

</tr>


</table>






</td>
<td width="304" valign="top" bgcolor="#F0F8FF">
<table border="0" width="300" align="center">
<tr>
<td height="150" valign="top" >
<table border="0" bgcolor="" width="200" align="center">

<tr>
<td colspan="3">&nbsp;


</td>
</tr>
<tr>
<td width="50">&nbsp;

</td>
<td>
<img src="images/default-human.jpg" width="100" height="100" />
</td>
<td  width="50">&nbsp;

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
<td>&nbsp;

</td>
<td align="center" height="60" class="marque-headline">
Hot Links
</td>
<td>&nbsp;

</td>
</tr>
<tr>
<td>&nbsp;

</td>
<td  height="35">
<html:link href="postComplaintsAction.do?link_url=complaint">Complaints</html:link>
</td>
<td>&nbsp;

</td>
</tr>
<tr>
<td>&nbsp;

</td>
<td height="35">
<html:link href="debateAction.do?link_url=debate" >Online Debate</html:link>
</td>
<td>&nbsp;

</td>
</tr>

</table>
</td>
</tr>
<tr>
<td>&nbsp;

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