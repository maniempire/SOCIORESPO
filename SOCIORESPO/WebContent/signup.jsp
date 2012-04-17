<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<html:html>
<head>
<% String currentURL="http://" + request.getServerName() + ":" + request.getServerPort() +  request.getContextPath();  %>
<script type="text/javascript" src="<%=currentURL%>/scripts/jquery-1.4.3.min.js"></script>
<script type="text/javascript" src="<%=currentURL%>/scripts/jquery.datepick.js"></script>
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

jQuery(document).ready(function () {	
    $('#dob').datepick();
    
});

/*var dob = new Date();
var curr_date = dob.getDate();
var curr_month = dob.getMonth() + 1; //months are zero based
var curr_year = dob.getFullYear();
document.write(curr_year + "-" + curr_month + "-" + curr_date);*/

</script>

<link href="<%=currentURL%>/styles/jquery.datepick.css" rel="stylesheet" type="text/css" />
</head>

<body>
<html:form action="/signupAction" method="post">

<table width="1010" border="0" height="100%">

<tr>
    <td valign="top" ><img src="images/socio-respo-header.jpg" width="1010" height="123" /></td>
  </tr>
  
<tr>
    
    <td class="hd-br">&nbsp;</td>
  </tr>
  <tr>
  
        <td height="50">&nbsp;</td>
        <td height="50">&nbsp;</td>
        <td height="50">&nbsp;</td>
      </tr>
      
<tr align="center">

	<td valign="middle">
	
    <table border="0" width="400" height="50%">
    <caption class="login-top-bg" >Sign Up</caption>
    <tr></tr>
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
  <tr></tr>
  <tr>
  <td height="7" align="center"><input name="Submit" type="submit" class="login-but" value="Submit" onclick="save()"/></td>
  <td height="7" align="left">
  <input name="Cancel" type="submit" class="login-but" value="Cancel" onclick="cancel()" />
  </td>
  </tr>
  
    </table>
    </td>

  
  
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