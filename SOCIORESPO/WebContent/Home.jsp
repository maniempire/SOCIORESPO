<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PIM - HOME PAGE</title>
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
<script language="Javascript"> 
	function profileLogin(pass) {  
		
		document.Form1.action ="CommonPageAction.do?&check="+pass; 
	} 
 	function fundTransfer(pass) {
 		document.Form1.action="CommonPageAction.do?&check="+pass;
    } 
	function reqReport(pass){
		document.Form1.action="RequestReportAction.do?check="+pass;
	}
	function assignedTask(pass){
		document.Form1.action="AssignedTaskAction.do?&check="+pass;
	}
</script> 
</head>

<body onload="initScript();">



<html:form action="/holidayAction" name="holidayActionForm" type="actionform.HolidayActionForm">
<table width="500" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="1010"><jsp:include page="header.jsp" /></td>
  </tr>
  <tr>
    <td height="2"></td>
  </tr>
  <tr>
    <td class="hd-br"><jsp:include page="header-title.jsp" /></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="9"> </td>
        <td width="8"><img src="images/login_top_lt.png" width="9" height="29" /></td>
        <td class="login-top-bg">Declared Holidays</td>
        <td width="8"><img src="images/login_top_rt.png" width="9" height="29" /></td>
        <td width="9"> </td>
      </tr>
      <tr>
        <td width="9"> </td>
        <td width="8" class="login-lt-br"> </td>
        <td><table width="100%" border="0" cellpadding="1" cellspacing="1">

          <tr>
            <td width="2" height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td width="2" height="10"></td>
          </tr>
          <tr>
            <td width="2">&nbsp;</td>
            <td width="50" class="Hol-head">S.No</td>
            <td class="Hol-head">Date</td>
            <td class="Hol-head">Day</td>
            <td class="Hol-head">Particulars</td>
            <td width="2">&nbsp;</td>
          </tr>
          
         <logic:iterate id="holidayListId" indexId="i"
							name="holidayActionForm" property="holidayList">  
          <tr>
								<td width="2">&nbsp;</td>
								<td width="32" class="Hol-table"><%=i.intValue() + 1%></td>
								<td width="94" class="Hol-table"><bean:write
									name="holidayListId" property="date" /></td>
								<td class="Hol-table"><bean:write name="holidayListId"
									property="day" /></td>
								<td class="Hol-table"><bean:write name="holidayListId"
									property="reason" /></td>
								
								<td width="2">&nbsp;</td>
							</tr>
          
         </logic:iterate> 
          
           <tr>
            <td width="2" height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td height="10"></td>
            <td width="2" height="10"></td>
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
    <td><table cellpadding="0" border="0" width="600"cellspacing="0">
    <tr><td width="120"></td>
    <td><span class="return-error-message-text"><html:errors /></span></td>
    
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
    <td class="hd-br"><jsp:include page="footer.jsp" /></td>
  </tr>
</table>
</html:form>
</body>
</html:html>
