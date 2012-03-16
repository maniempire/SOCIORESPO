<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script language = "Javascript">
function checkEmail(myForm) {
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(myForm.personalMail.value)){
	return (true);
	}
	alert("Invalid E-mail Address! Please re-enter.");
	return (false);
	}

function verify(pass) {
var themessage = "You are required to complete the following fields:" +"\n";
if (document.form.oldPassword.value=="") {
themessage = themessage + " - Old Password" +"\n" ;
}
if (document.form.newPwd.value=="") {
themessage = themessage + " -  New Password" +"\n";
}
if (document.form.accNumber.value=="") {
themessage = themessage + " -  Acc.Number"  +"\n";
}
if (themessage == "You are required to complete the following fields:" +"\n") {
document.form.action="ProfileAction.do?&check="+pass;
}
else {
alert(themessage);
return false;
   }
}


function reqReport(pass){
	document.form.action="RequestReportAction.do?&check="+pass;
}
	function assignedTask(pass){
		document.form.action="AssignedTaskAction.do?&check="+pass;
	
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PIM - My Profile</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="pim-styles.css" rel="stylesheet" type="text/css" />
</head>

<body onload="initScript();">
<form onSubmit="return checkEmail(this)" name="form" method="post" >
<table width="1010" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="1010"><jsp:include page="header.jsp" /></td>
  </tr>
  <tr>
    <td height="2"></td>
  </tr>
  <tr>
     <td class="hd-br">
    
    <jsp:include page="header-title-home.jsp" />
    </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="9"> </td>
        <td width="9" style="text-align: right;"><img src="images/login_top_lt.png" width="9" height="29" /></td>
        <td class="login-top-bg" style="text-align: left;">My Profile</td>
        <td width="9"><img src="images/login_top_rt.png" width="9" height="29" /></td>
        <td width="9"> </td>
      </tr>
      <tr>
        <td width="9"> </td>
        <td width="8" class="login-lt-br">. </td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
          </tr>
          <tr>
            <td width="15">&nbsp;</td>
            <td width="125" class="form-cont">Employee ID</td>
            
            <td width="180" class="form-cont" >&nbsp; <%String userId = (String)session.getAttribute("USERID");     %>  
<%if(userId!=null){    %>
    <%=  userId %>
   <%  } 
%></td>
            <td width="15" class="login-cont">&nbsp;</td>
          </tr>
           <tr>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
          </tr>
          <tr>
            <td width="15">&nbsp;</td>
            <td width="125" class="form-cont">First Name</td>
            <td width="180" class="form-cont">&nbsp;<% String firstName = (String)session.getAttribute("FIRSTNAME"); %>  
<%if(firstName!=null){  %>
    <%=  firstName %>
   <%  } 
%></td>
            <td width="75" class="form-cont">&nbsp;</td>
            <td class="form-cont">Old Password</td>
           <td class="form-cont"><input  type="password" name="oldPassword" class="login-txt-bx" id="textfield" readonly="readonly" <% String oldPwd = (String)session.getAttribute("EMPPWD");     %>  
<%if(oldPwd!=null){    %>
   value=" <%=oldPwd%>"
   <%  } 
%>/></td>
            <td width="15" class="login-cont">&nbsp;</td>
          </tr>
         <tr>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
          </tr>
          <tr>
            <td width="15">&nbsp;</td>
            <td width="125" class="form-cont">Last Name</td>
           <td width="180" class="form-cont">&nbsp;<% String lastName = (String)session.getAttribute("LASTNAME");     %>  
<%if(lastName!=null){    %>
    <%=  lastName %>
   <%  } 
%></td>
            <td width="75" class="form-cont">&nbsp;</td>
            <td class="form-cont">Mobile Phone</td>
            <td class="form-cont"><input  type="text" name="cellNumber" class="login-txt-bx" id="textfield" <% String mobile = (String)session.getAttribute("MOBILE");     %>  
<%if(mobile!=null){    %>
    value="<%=mobile %>"
   <%  } 
%>/></td>
            <td width="15" class="login-cont">&nbsp;</td>
          </tr>
          <tr>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
          </tr>
          <tr>
            <td width="15">&nbsp;</td>
            <td width="125" class="form-cont">Employee Type</td>
            <td width="180" class="form-cont">&nbsp;<% String empType = (String)session.getAttribute("EMPROLE");     %>  
<%if(empType!=null){ %>
    <%=  empType %>
   <%  } 
%></td>
            <td width="75" class="form-cont">&nbsp;</td>
            <td class="form-cont">Residence Phone</td>
             <td class="form-cont"><input  type="text" name="landLine" class="login-txt-bx" id="textfield" <% String landLine = (String)session.getAttribute("LANDLINE");     %>  
<%if(landLine!=null){ %>
    value="<%=landLine %>"
   <%  } 
%>/></td>
            <td width="15" class="login-cont">&nbsp;</td>
          </tr>
          <tr>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
          </tr>
          <tr>
            <td width="15">&nbsp;</td>
            <td width="125" class="form-cont">Designation</td>
            <td width="180" class="form-cont">&nbsp;<%String designation = (String)session.getAttribute("EMPDESC");     %>  
<%if(designation!=null){    %>
    <%=  designation %>
   <%  } 
%></td>
            <td width="75" class="form-cont">&nbsp;</td>
            <td class="form-cont">Personal Email</td>
            <td class="form-cont"><input  type="text" name="personalMail" class="login-txt-bx" id="textfield" <%String personalMail = (String)session.getAttribute("PERSONALMAIL");     %>  
<%if(personalMail!=null){    %>
    value="<%=  personalMail %>"
   <%  } 
%>/></td>
            <td width="15" class="login-cont">&nbsp;</td>
          </tr>
          <tr>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
          </tr>
          <tr>
            <td width="15">&nbsp;</td>
            <td width="125" class="form-cont">Team</td>
            <td width="180" class="form-cont">&nbsp;<% String team = (String)session.getAttribute("DEPTDESC");     %>  
<%if(team!=null){    %>
    <%=team %>
   <%  } 
%></td>
            <td width="75" class="form-cont">&nbsp;</td>
            <td class="form-cont">Permanent Address</td>
            <td class="form-cont"><input  type="text" name="permanentAddress" class="login-txt-bx" id="textfield" <% String permanentAddress = (String)session.getAttribute("DEPTDESC");     %>  
<%if(permanentAddress!=null){    %>
    value="<%=permanentAddress %>"
   <%  } 
%>/></td>
            <td width="15" class="login-cont">&nbsp;</td>
          </tr>
          <tr>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
          </tr>
          <tr>
            <td width="15">&nbsp;</td>
            <td width="125" class="form-cont">Reporting To</td>
            <td width="180" class="form-cont">&nbsp;<% String reportingTo = (String)session.getAttribute("EMPSUPVID");     %>  
<%if(reportingTo!=null){    %>
    <%=  reportingTo %>
   <%  } 
%></td>
            <td width="75" class="form-cont">&nbsp;</td>
            <td class="form-cont">Contact  Address </td>
            <td class="form-cont"><input  type="text" name="contactAddress" class="login-txt-bx" id="textfield" <% String contactAddress = (String)session.getAttribute("TEMPADDRESS");     %>  
<%if(contactAddress!=null){    %>
    value="<%=  contactAddress %>"
   <%  } 
%>/></td>
            <td width="15" class="login-cont">&nbsp;</td>
          </tr>
          <tr>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
          </tr>
          <tr>
            <td width="15">&nbsp;</td>
            <td width="125" class="form-cont">Official Email</td>
           <td width="180" class="form-cont">&nbsp;<% String officeMail = (String)session.getAttribute("EMPMAIL");     %>  
<%if(officeMail!=null){    %>
    <%= officeMail %>
   <%  } 
%></td>
            <td width="75" class="form-cont">&nbsp;</td>
            <td class="form-cont">New Password</td>
            <td class="form-cont"><input  type="password" name="newPwd" class="login-txt-bx" id="textfield" /></td>
            <td width="15" class="login-cont">&nbsp;</td>
          </tr>
          <tr>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
          </tr>
          <tr>
            <td width="15">&nbsp;</td>
            <td width="125" class="form-cont">D.O.B</td>
           <td width="180" class="form-cont">&nbsp;<% String dob = (String)session.getAttribute("DOB");     %>  
<%if(dob!=null){    %>
    <%=  dob %>
   <%  } 
%></td>
            <td width="75" class="form-cont">&nbsp;</td>
            <td class="form-cont">Confirm Password</td>
            <td class="form-cont"><input  type="password" name="confirmPwd" class="login-txt-bx" id="textfield"/></td>
            <td width="15" class="login-cont">&nbsp;</td>
          </tr>
          <tr>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
          </tr>
          <tr>
            <td width="15">&nbsp;</td>
            <td width="125" class="form-cont">D.O.J</td>
           <td width="180" class="form-cont">&nbsp;<% String doj = (String)session.getAttribute("HIREDATE"); %>  
<%if(doj!=null){    %>
    <%=  doj %>
   <%  } 
%></td>
            <td width="75" class="form-cont">&nbsp;</td>
            <td class="form-cont">Acc.Number</td>
           <td class="form-cont"><input  type="text" name="accNumber" class="login-txt-bx" id="textfield" <% String empAcc = (String)session.getAttribute("EMPACC"); %>  
<%if(empAcc!=null){    %>
    value="<%=  empAcc %>"
   <%  } 
%>/></td>
            <td width="15" class="login-cont">&nbsp;</td>
          </tr>
          <tr>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
            <td height="3"></td>
          </tr>
          <tr>
            <td width="15">&nbsp;</td>
            <td width="125" class="form-cont">Gender</td>
            <td width="180" class="form-cont">&nbsp;<% String gender = (String)session.getAttribute("GENDER");     %>  
<%if(gender!=null){    %>
    <%=  gender %>
   <%  } 
%></td>
            <td width="75" class="form-cont">&nbsp;</td>
            <td class="form-cont">PF Number</td>
            <td class="form-cont"><input  type="text" name="pfNumber" class="login-txt-bx" id="textfield" <% String pfNum = (String)session.getAttribute("EMPPF");     %>  
<%if(pfNum!=null){    %>
    value="<%=  pfNum %>"
   <%  } 
%>/></td>
            <td width="15" class="login-cont">&nbsp;</td>
          </tr>
          <tr>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td class="form-cont">&nbsp;</td>
            <td class="form-cont">&nbsp;</td>
            <td class="form-cont">&nbsp;</td>
            <td class="form-cont">&nbsp;</td>
            <td class="form-cont"><table width="100%" border="0">
              <tr>
          
          <td width="50">
          
          <input name="Save" type="submit" class="login-but"   value="Save" onclick="verify('userProfile');"/></td>
               
          <td>
          <html:button property="back" styleClass="login-but" onclick="location.href='homeAction.do'">Cancel</html:button>
          </td>
          
              </tr>
            </table></td>
            <td class="login-cont">&nbsp;</td>
          </tr>
        </table></td>
        <td width="8" class="login-rt-br"> </td>
        <td width="9"> </td>
      </tr>
      <tr>
        <td width="9" valign="bottom"> </td>
        <td width="8" valign="bottom"><img src="images/login_bot_lt.png" width="9" height="9" /></td>
        <td class="login-bot"> </td>
        <td width="8" valign="bottom"><img src="images/login_bot_rt.png" width="9" height="9" /></td>
        <td width="9" valign="bottom"> </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
 
  
  <tr>
    <td class="hd-br"><jsp:include page="footer.jsp" /></td>
  </tr>
</table>
</form>
</body>
</html>
