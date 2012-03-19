<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>

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

function reload(){
	  location.href="/profileAction.do";
	}


</script>
</head>
<body>
<a href="#" onclick="popup();">Connect FaceBook</a>

</body>
</html>