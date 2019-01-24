<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>pocetna</title>
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
		<h3><center><span style="color:#003366">Login</span></center></h3>
	<form:form method="post" action="Login1" modelAttribute="log">
		<div>
			<p align="center"><form:input path="username" placeholder="Username" /></p>
		</div>
		<div>
			<p align="center"><form:input path="password" placeholder="Password" /></p>
		</div>
		<div>
			<p align="center"><input type="submit" value="Potvrdi" /></p>
		</div>
	</form:form>
</body>
</html>
