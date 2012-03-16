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
<title>PIM</title>
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
<link href="pim-styles.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function checkLogin(){
	
 	var txtuser=document.getElementById("userId").value;
 	
 	if(txtuser=="") {
 		alert("Username cannot be blank");
 		
 	return false;
 }
	 var txtpass=document.getElementById("password").value;
 	if(txtpass=="") {
 		alert("Password cannot be blank");
 		
 		return false;
 	}
 	

	if(txtuser!="" && txtpass!=""){
		document.frmLogin.action="loginAction.do";
			
	}
 }

	 </script>

</head>

<body>

<form action="loginAction.do" method="post" name="frmLogin" id="frmLogin"  onsubmit="return checkLogin();" >
<table width="1010" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="1010"><img src="images/header.jpg" width="1010" height="123" /></td>
  </tr>
  <tr>
    <td height="2"></td>
  </tr>
  <tr>
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
        <td width="350">&nbsp;</td>
        <td align="right" valign="top">
        
        <table width="300" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td><img src="images/login_top_lt.png" width="9" height="29" /></td>
            <td width="285" class="login-top-bg">Login</td>
            <td align="left"><img src="images/login_top_rt.png" width="9" height="29" /></td>
          </tr>
          <tr>
            <td class="login-lt-br"> </td>
            <td class="login-bg"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="39%" height="15"></td>
                  <td width="61%" height="15"></td>
                </tr>
                <tr>
                  <td class="login-cont">User Id</td>
                  <td><!--  <form id="form1" name="form1" method="post" action="">-->
                      <label>
                      <input  type="text" name="userId" class="login-txt-bx" id="userId" />
                      <td></td>
                      </label>
                  <!--  </form>--></td>
                </tr>
                <tr>
                  <td height="10"></td>
                  <td height="10"></td>
                </tr>
                <tr>
                  <td class="login-cont">Password</td>
                  <td><!--  <form id="form2" name="form2" method="post" action="">-->
                      <label>
                      <input  type="password" name="password" class="login-txt-bx" id="password" />
                      <td></td>
                      </label>
                  <!--  </form>--></td>
                </tr>
                <tr>
                  <td height="11"></td>
                  <td height="11"></td>
                </tr>
				<tr>
				<td colspan="2"><span class="return-error-message-text"><html:errors /></span></td>
				</tr>
                <tr>
                  <td height="7"></td>                                   
                  <td height="7"><input name="Submit" type="submit" class="login-but" value="Submit" /></td>
                </tr>
            </table></td>
            <td class="login-rt-br"> </td>
          </tr>
          <tr>
            <td width="9" align="left" valign="top"><img src="images/login_bot_lt.png" width="9" height="9" /></td>
            <td class="login-bot"></td>
            <td width="10" align="right" valign="top"><img src="images/login_bot_rt.png" width="9" height="9" /></td>
          </tr>
        </table></td>
        <td width="350">&nbsp;</td>
      </tr>
      <tr>
        <td height="50">&nbsp;</td>
        <td height="50">&nbsp;</td>
        <td height="50">&nbsp;</td>
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
    <td class="hd-br"><jsp:include page="footer.jsp" /></td>
  </tr>
</table>
</form>
</body>
</html:html>
