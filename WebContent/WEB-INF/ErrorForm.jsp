<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>greska</title>
</head>
<style type="text/css">
body {
	background-image:url("https://i.imgur.com/th0CViy.jpg");
	background-size: 100%;
}
</style>
<body>
<p>
<center><font size="50" face="calibri" color=#003366><b> Smart Bus Terminal</b></center></font></p>			
		</p>
	<form:form method="post" action="Login" modelAttribute="log">
		<div>
			<h1><p align="center"><span style = "color:#FF0000"><b>Tri puta ste unijeli pogresan username ili password!</b></span></p></h1>
		</div>
	</form:form>
	<p align="center"><a href="loginform"><span style = "color:#FFFF00"><b>Vrati se na pocetnu</b></a></p>
</body>
</html>


