<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ page import="com.sociorespo.dto.*, java.util.*"%>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link href="styles/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

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
	alert("hai");
	location.href="/profileAction.do?link_url='update'";
	
}


</script>
</head>
<body>
<html:form action="/profileAction" method="post">
<table width="1010" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="1010"><img src="images/socio-respo-header.jpg" width="1010" height="123" /></td>
  </tr>
  <tr>
    <td height="2"></td>
  </tr>
	<tr>
	
    	<td class="hd-br">&nbsp;<html:link href="logoutAction.do?link_url=logout" styleClass="link">Logout</html:link></td>
    	
  	</tr>
  	<tr>
  		<td align="right">
  			Logged in as <html:link href="profileAction.do"><%=session.getAttribute("FIRSTNAME")%> </html:link>	
  		</td>
  	
  	</tr>
  	<tr>
  		<td align="right">
  			<img alt="" src=""/>	
  		</td>
  	
  	</tr>
  	
  	
<tr>

	<td class="login-cont" >First Name
  		
        	<html:text property="firstName" name="profileActionForm" styleClass="login-txt-bx"></html:text>
        </td>
        
</tr> 
  
  <tr>
  		<td class="login-cont">Last Name
  		&nbsp;&nbsp;&nbsp;
            
               <html:text property="lastName" name="profileActionForm" styleClass="login-txt-bx"></html:text>
         
        </td>
  
  
  </tr>
  
  <tr>
  		<td class="login-cont">Email
  		&nbsp;&nbsp;&nbsp;
            
               <html:text property="mailId" name="profileActionForm" styleClass="login-txt-bx" disabled="true"></html:text>
         
        </td>
  
  
  </tr>
  
  
  <tr>
  		<td class="login-cont">Password
  		           &nbsp;&nbsp;&nbsp; 
  		           <html:password property="password" name="profileActionForm" styleClass="login-txt-bx" disabled="true"></html:password>
                         
        </td>
  
  
  </tr>
   <tr>
  		<td class="login-cont">New Password
  		           &nbsp;&nbsp;&nbsp; 
  		           <html:password property="changePassword" name="profileActionForm" styleClass="login-txt-bx" ></html:password>
                         
        </td>
  
  
  </tr>
   <tr>
  		<td class="login-cont">Confirm Password
  		           &nbsp;&nbsp;&nbsp; 
  		           <html:password property="changePassword" name="profileActionForm" styleClass="login-txt-bx" ></html:password>
                         
        </td>
  
  
  </tr>
   <tr>
  		<td class="login-cont">Gender
  		&nbsp;&nbsp;&nbsp; 
  		<html:select property="gender" name="profileActionForm">
  			<html:option value="selectGender">Select Gender</html:option>
  			<html:option value="male">Male</html:option>
            <html:option value="female">Female</html:option>	
  			<html:option value="transgender">Transgender</html:option>  				
  				
  
</html:select>
        </td>
  
  
  </tr>
   <tr>
  		<td class="login-cont">Phone No.
  		&nbsp;&nbsp;&nbsp; 
            
               <html:text property="phoneNum" name="profileActionForm" styleClass="login-txt-bx"></html:text>
         
        </td>
  
  
  </tr>
   
   <tr>
  		<td class="login-cont">Date Of Birth
  		&nbsp;&nbsp;&nbsp; 
            
                <html:text property="dob" name="profileActionForm" styleClass="login-txt-bx"></html:text>
         
        </td>
  
  
  </tr>
  <tr>
  		<td class="login-cont">Voter Id
  		&nbsp;&nbsp;&nbsp; 
            
               <html:text property="voterId" name="profileActionForm" styleClass="login-txt-bx"></html:text>
         
        </td>
  
  
  </tr> 
  <tr>
  <td width="20%">
  <input type="hidden" value="update" name="update"/>
  
  	<input name="submit" type="submit" class="login-but" value="Update" onclick=update(); style=" width : 59px;"/>
  	
  	
  </td>
  	  
  </tr>	
  	
  	
<tr>
<td></td>




</tr>

  	
<logic:notPresent property="faceBookProfileDTO"  name="profileActionForm">
 <tr>
    <td>  <html:link href="#" onclick="popup();">Connect FaceBook</html:link>
    &nbsp;</td>
  </tr>
</logic:notPresent>
<logic:present  property="faceBookProfileDTO"  name="profileActionForm">
 <tr>
    <td> <img alt="" src='<bean:write property="faceBookProfileDTO.faceBookImgUrl" name="profileActionForm" />' />
    &nbsp;You are connected to FaceBook as <bean:write property="faceBookProfileDTO.firstName" name="profileActionForm" />
    &nbsp;<bean:write property="faceBookProfileDTO.lastName" name="profileActionForm" />
    </td>
  </tr>
</logic:present>


<!--<logic:notPresent property="faceBookProfileDTO"  name="profileActionForm">-->
<!-- <tr>-->
<!--    <td>  <html:link href="#" onclick="popupTwiter();">Connect Twitter</html:link>-->
<!--    &nbsp;</td>-->
<!--  </tr>-->
<!--</logic:notPresent>-->
<!--<logic:present  property="faceBookProfileDTO"  name="profileActionForm">-->
<!-- <tr>-->
<!--    <td> <img alt="" src='<bean:write property="faceBookProfileDTO.faceBookImgUrl" name="profileActionForm" />' />-->
<!--    &nbsp;</td>-->
<!--  </tr>-->
<!--</logic:present>-->
  
  
  <tr>
   <td>
  

</td>
    <td>&nbsp;</td>
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