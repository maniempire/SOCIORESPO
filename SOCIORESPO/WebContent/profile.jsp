<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Profile</title>
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
	
	window.location.href="./profileAction.do?link_url=edit";
	
}


</script>

</head>
<body onload="initScript();">

<table width="1010" border="0" cellpadding="0" cellspacing="0">
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
  		
        	<bean:write property="firstName" name="profileActionForm" />
        </td>
        
</tr> 
  
  <tr>
  		<td class="login-cont">Last Name
  		&nbsp;&nbsp;&nbsp;
            
               <bean:write property="lastName" name="profileActionForm" />
         
        </td>
  
  
  </tr>
  
  <tr>
  		<td class="login-cont">Email
  		&nbsp;&nbsp;&nbsp;
            
               <bean:write property="mailId" name="profileActionForm" />
         
        </td>
  
  
  </tr>
  
  
  
   <tr>
  		<td class="login-cont">Gender
  		&nbsp;&nbsp;&nbsp; 
  		<bean:write property="gender" name="profileActionForm"/>
  		</td>
  
  
  </tr>
   <tr>
  		<td class="login-cont">Phone No.
  		&nbsp;&nbsp;&nbsp; 
            
               <bean:write property="phoneNum" name="profileActionForm" />
         
        </td>
  
  
  </tr>
   
   <tr>
  		<td class="login-cont">Date Of Birth
  		&nbsp;&nbsp;&nbsp; 
            
                <bean:write property="dob" name="profileActionForm" />
         
        </td>
  
  
  </tr>
  <tr>
  		<td class="login-cont">Voter Id
  		&nbsp;&nbsp;&nbsp; 
            
               <bean:write property="voterId" name="profileActionForm" />
         
        </td>
  
  
  </tr> 
  <tr>
  <td width="20%">
   
  	<input name="submit" type="submit" class="login-but" value="Edit Profile" onclick=update(); style=" width : 69px;"/>
  	
  	
  </td>
  	  
  </tr>	
  	
  	
<tr>
<td></td>




</tr>

  	
<logic:notPresent property="faceBookProfileDTO"  name="profileActionForm">
 <tr>
    <td>  <a href="<bean:write property="faceBookAuthURL" name="profileActionForm" />">Connect FaceBook</a>
     
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

<logic:notPresent property="linkedInProfileDTO"  name="profileActionForm">
 <tr>
    <td>
    <a href="#" onclick="connectLinkedIn('<bean:write property="linkedInAuthURL" name="profileActionForm" />')">Connect LinkedIn</a>
     
    &nbsp;</td>
  </tr>
</logic:notPresent>
<logic:present  property="linkedInProfileDTO"  name="profileActionForm">
 <tr>
    <td> <img alt="" src='<bean:write property="linkedInProfileDTO.linkedInImgUrl" name="profileActionForm" />' />
    &nbsp;You are connected to LinkedIn as <bean:write property="linkedInProfileDTO.firstName" name="profileActionForm" />
    &nbsp;<bean:write property="linkedInProfileDTO.lastName" name="profileActionForm" />
    </td>
  </tr>
</logic:present>


<logic:notPresent property="twitterProfileDTO"  name="profileActionForm">
 <tr>
    <td>  
    
     <a href="<bean:write property="twitterAuthURL" name="profileActionForm" />">Connect Twitter</a>
    
    &nbsp;</td>
  </tr>
</logic:notPresent>
<logic:present  property="twitterProfileDTO"  name="profileActionForm">
 <tr>
    <td> <img alt="" src='<bean:write property="twitterProfileDTO.twitterImgUrl" name="profileActionForm" />' />
    &nbsp; You are connected to Twitter as <bean:write property="twitterProfileDTO.firstName" name="profileActionForm" /></td>
  </tr>
</logic:present>
  
  
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
    <td>
    <html:link href="edit_profile.jsp" styleClass="link">Editprofile</html:link></td>
  </tr>

	<tr>
    	<td class="hd-br"><jsp:include page="/common/footer.jsp" /></td>
  	</tr>
</table>


</body>
</html:html>