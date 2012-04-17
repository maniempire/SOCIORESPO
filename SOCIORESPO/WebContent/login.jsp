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
    <td valign="top" ><img src="images/socio-respo-header.jpg" width="1010" height="123" /></td>
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
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
      
      <tr>
        <td width="350" valign="top"><img src="images/soc.png" alt="Virtual society" width="333" height="429"></img></td>
        <td align="right" valign="top">
        
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
      
      <tr>
        
        <td height="40" valign="top" class="marque-headline" ><H1><marquee> <b>"AN EXCLUSIVE SOCIAL MEDIA TO UPLIFT THE SOCIETY"</b></marquee></H1></td>
     
      </tr>
       <tr>
        <td valign="top">
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
                  <td class="login-cont">Email Id</td>
                  <td><!--  <form id="form1" name="form1" method="post" action="">-->
                      <label>
                      <input  type="text" name="emailId" class="login-txt-bx" id="emailId" />
                     
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
                  <td height="7"><input name="Submit" type="submit" class="login-but" value="Submit" />
                  &nbsp;&nbsp;<html:link href="signup.jsp">Sign Up </html:link></td>
                </tr>
            </table></td>
            <td class="login-rt-br"> </td>
          </tr>
          <tr>
            <td width="9" align="left" valign="top"><img src="images/login_bot_lt.png" width="9" height="9" /></td>
            <td class="login-bot"></td>
            <td width="10" align="right" valign="top"><img src="images/login_bot_rt.png" width="9" height="9" /></td>
          </tr>
        </table>
        
        </td>
        
        
      </tr>
      <tr>
      <td height="10">
     &nbsp;
      </td>
      </tr>
       <tr>
        <td >
        
        	<table border="0" cellpadding="0" cellspacing="0">
        	
        	<tr>
        	    <td valign="top">
        	    
        	    
        	    <table border="0" cellpadding="0" cellspacing="0" width="250">
        	
        	<tr>
        	    <td valign="top" class="text-headline">
        	  <b>Features:</b>
        	   </td>
        	   </tr>
        	   
        	   <tr >
        	    <td valign="top" class="landing-page-text">
        	 <li> Share your thoughts about society</li>
        	   </td>
        	   </tr>
        	   
        	   <tr>
        	    <td valign="top" class="landing-page-text">
        	  <li> Post your thoughts as complaints</li>
        	   </td>
        	   </tr>
        	   
        	   <tr>
        	    <td valign="top" class="landing-page-text">
        	  <li> Debate on social issue</li>
        	   </td>
        	   </tr>
        	   <tr>
        	    <td valign="top" class="landing-page-text">
        	  <li> Share with your friends & peers</li>
        	   </td>
        	   </tr>
        	   </table>
        	   
        	    </td>
        		<td align="left" >
        		  <table border="0" cellpadding="0" cellspacing="0" width="250">
        	<tr>
        	<td class="text-headline">
        		<b>View Demo:</b>
        		</td>
        	</tr>
        	
        	<tr>
        	    <td valign="top">
        		
        		
  
        		<iframe width="360" height="215" src="http://www.youtube.com/embed/bveXo-BZrJQ" frameborder="0" ></iframe>
        		</td>
        		</tr>
        		</table>
        		</td>
        		<td>
        		
        		</td>
        	</tr> 
        	
        	<tr>
        	    
        		<td colspan="3" >
        		<table width="330" align="left">
        		<tr>
        		
        		<td class="text-headline">Connect with us: </td>
      		<td><img src="images/facebook_logo.jpg" width="30" height="30" /></td>
        		
        		<td><img src="images/twitter_logo.jpg" width="30" height="30" /></td>
        		
        		<td><img src="images/linkedin_logo.png" width="30" height="30" /></td>
        		<td width="100">
        		&nbsp;
        		</td>
        		
        	</tr></table>
        		
        	</td>
        	
        	</tr> 
        	 	
        	</table>
        
        
        </td>
      </tr>
     
    </table>
        
        
        </td>
        
      </tr>
     
    </table></td>
  </tr>

  <tr>
    <td>&nbsp;</td>
  </tr>
  	<tr>
    	<td class="hd-br"><jsp:include page="/common/footer.jsp" /></td>
  	</tr>
</table>
</form>
</body>
</html:html>