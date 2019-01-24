<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form>
<input style="width: 100px; position: absolute; right: 50; cursor: pointer; font-weight: bold; position: right; font-size: 100%;" type="button" value="Nazad" onclick="goBack()" />
<script>
function goBack() {
    window.history.back();
}
</script>
</form>
 
<html>
<head>
<style>
body 
{
	background-image:url("https://i.imgur.com/th0CViy.jpg");
	background-size: 100%;
}

</style>
<title>Izbrisi voznju</title>
</head>

<body>
<br>
	<h3><center><b><span style="color:#003366">Izbrisi voznju</span></b></center></h3>	
</div> </html>

<br><br>
		
<html>
<body>
<form:form method="post" action="deleteVoznja" modelAttribute="voznja">
<div>
<center><form:input path="id" placeholder="ID Voznje" /></center>
</div>

<div>
<center><input style="width: 200px;cursor: pointer; font-weight: bold; position: right;font-size: 100%;" type="submit" value="Izbrisi" onclick="window.location.href='/AdminHome'" /></center>
</div>
<div>
<center><input style="width: 200px;cursor: pointer; font-weight: bold; position: right;font-size: 100%;" type="submit" value="Odjavi se" onclick="window.location.href='/loginform'" /></center>
</div>
</form:form>
<br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>