<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin - Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Expires" content="-1"> 
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Expires" content="-1"> 
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">  
<script language="javascript"> 
window.history.forward(1); 
browser.cache.offline.enable = false; 
function noBack() { window.history.forward(1); 

} 
//***Get what is above onto one line*** 

self.close() 
function disableBackButton() 
{ 
window.history.forward(1); 
} 
setTimeout("disableBackButton()", 0); 
</script>  
 

</head>
<link href="styles/adminLogin.css" type="text/css" rel="stylesheet">
</head>
<body onload="noBack()">
		<div id="main" align="center" class="container-fluid">
		<div id="picture"><img id="picture1" src="images/bear.jpg" alt="Grizzly"></div>
		<div id="text">
			<h1>GRIZZLY STORE</h1>
			<hr id="underline"/>
		</div>
		<div id="form">
			<form name="myForm" action="/grizzly-store-admin-web/VerifyAdminController" novalidate>
				<input type="text" id="login" name="uname" placeholder="Username" /><br/><br/>
				<input type="password" id="password" name="pass" placeholder="Password" /><br/><br/>
				<input type="submit" id="check" value="Login" />		
			</form>
		</div>
	</div>
</body>
</html>