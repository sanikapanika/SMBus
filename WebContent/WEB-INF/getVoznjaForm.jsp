<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<html>
<head>
<style>
body {
	background-image: url("https://i.imgur.com/th0CViy.jpg");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
}
</style>
<title>Pregled voznji</title>
</head>

<body>
	<br>
	<h3>
		<center>
			<b><div style="background-color: #FFF5EE">
					<span style="color: #003366">Voznje Info</span>
				</div></b>
		</center>
	</h3>
	</div>
</html>

<br>
<br>

<html>
<body>
	<form:form method="post" action="getVoznja" modelAttribute="voznja">
		<div>
			<center>
				<input
					style="width: 200px; cursor: pointer; font-weight: bold; position: right; font-size: 100%;"
					type="submit" value="Pregledaj" onclick="window.location.href='/SmartBusTerminal/getVoznjaForm'" />
			</center>
		</div>
	</form:form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

</body>
</html>