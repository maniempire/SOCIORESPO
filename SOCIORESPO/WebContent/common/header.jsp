<link href="pim-styles.css" rel="stylesheet" type="text/css" />
<% String currentURL="http://" + request.getServerName() + ":" + request.getServerPort() +  request.getContextPath();  %>
<script src="<%=currentURL%>/scripts/CommonScript.js" language="javascript">
</script>
<script src="<%=currentURL%>/scripts/TimeScript.js" language="javascript">
</script>
<script src="<%=currentURL%>/scripts/DateScript.js" language="javascript">
</script>
<table border="0" height="123" width="100%" cellpadding="0" cellspacing="0" background="images/socio-respo-header.jpg">
<tr><td width="75%">
</td>
<td class="pim-header-title">
&nbsp; <%= session.getAttribute("USERFNAME") %>
</td>

</tr>
</table>