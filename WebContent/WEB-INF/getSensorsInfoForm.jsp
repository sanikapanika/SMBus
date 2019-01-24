<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Informacije o senzorima</title>
</head>
<style type="text/css">
body {
	background-image: url("https://i.imgur.com/th0CViy.jpg");
	background-size: 100%;
}
</style>
<body>
	<h1>
		<p align="center">
			<b></b><b>Smart Bus Terminal</b>
		</p>
		<hr>
	</h1>
	<h1><p align="center">Informacije senzora</p></h1>
	<p align="center">
	<table border="1">
		<tr>
			<td><p align="center"><b><font size="5">Senzor</font></b></p></td>
			<td><p align="center"><b><font size="5">Vrijednost temperature</font></b></p></td>
		</tr>
		<tr>
			<td><p align="center"><font size="4">Kabina</font></p></td>
			<td><p align="center"><font size="4">${sensorInfo.kabina}</font></p></td>
		</tr>
		<tr>
			<td><p align="center"><font size="4">Prtljaznik</font></p></td>
			<td><p align="center"><font size="4">${sensorInfo.prtljaznik}</font></p></td>
		</tr>
		<tr>
			<td><p align="center"><font size="4">Motor</font></p></td>
			<td><p align="center"><font size="4">${sensorInfo.motor}</font></p></td>
		</tr>
		
	</table>
	</p>
	<ul>

		<p align="center"><a href="AdminHome">Back to main screen</a></p>
		<p align="center"><a href="loginform">Logout</a></p>
	</ul>
</body>
</html>