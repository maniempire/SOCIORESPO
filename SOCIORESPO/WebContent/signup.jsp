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
<title>Sign Up</title>
<link href="styles/styles.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">


function save() {

	document.forms[0].action = "signupAction.do?link_url=save";
	document.forms[0].submit();
}

function cancel() {

	document.forms[0].action = "signupAction.do?link_url=cancel"
	document.forms[0].submit();
}
</script>


</head>
<body>
<html:form action="/signupAction" method="post">
<table width="1010" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td width="1010"><img src="images/socio-respo-header.jpg" width="1010" height="123" /></td>
  </tr>
  <tr>
    <td height="2"></td>
  </tr>
  <tr>
    <!-- <td class="hd-br">&nbsp;<html:link href="loginAction.do?link_url=logout" styleClass="link">Logout</html:link></td>-->
    <td class="hd-br">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><table width="100%" border="0">
      <tr>
        <td height="50">&nbsp;</td>
        <td height="50">&nbsp;</td>
        <td height="50">&nbsp;</td>
      </tr>
  
  
  
   <tr>
  		<td class="login-cont">First Name</td>
  		<td>
            
                <input  type="text" name="firstName" class="login-txt-bx" id="firstName" />
         
        </td>
  
  
  </tr>
   <tr>
  		<td class="login-cont">Last Name</td>
  		<td>
            
                <input  type="text" name="lastName" class="login-txt-bx" id="lastName" />
         
        </td>
  
  
  </tr>
  
  <tr>
  		<td class="login-cont">Email Id</td>
  		<td>
            
                <input  type="text" name="mailId" class="login-txt-bx" id="mailId" />
         
        </td>
  
  
  </tr>
  
  
  <tr>
  		<td class="login-cont">Password</td>
  		<td>
            
                <input  type="password" name="password" class="login-txt-bx" id="password" />
         
        </td>
  
  
  </tr>
   <tr>
  		<td class="login-cont">Gender</td>
  		<td>
            <select id="gender" name="gender">
            	<option value="selectGender">Select Gender</option>
  				<option value="male">Male</option>
  				<option value="female">Female</option>
  				<option value="transgender">Transgender</option>
  
</select>
        </td>
  
  
  </tr>
   <tr>
  		<td class="login-cont">Phone No.</td>
  		<td>
            
                <input  type="text" name="phoneNum" class="login-txt-bx" id="phoneNum" />
         
        </td>
  
  
  </tr>
   
   <tr>
  		<td class="login-cont">Date Of Birth</td>
  		<td>
            
                <input  type="text" name="dob" class="login-txt-bx" id="dob" />
         
        </td>
  
  
  </tr>
  <tr>
  		<td class="login-cont">Voter Id</td>
  		<td>
            
                <input  type="text" name="voterId" class="login-txt-bx" id="voterId" />
         
        </td>
  
  </tr>
  <tr>
  	<td></td>
  </tr>
  <tr>
  <td height="7" align="center"><input name="Submit" type="submit" class="login-but" value="Submit" onclick="save()"/></td>
  <td height="7" align="left"><input name="Cancel" type="submit" class="login-but" value="Cancel" onclick="cancel()"/></td>
  </tr>
  
  
 </table>





	
   </table>
   <table>
    <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
   
   	<tr>
    	<td class="hd-br"><jsp:include page="/common/footer.jsp" /></td>
  	</tr></table>
</html:form>
</body>
</html:html>
