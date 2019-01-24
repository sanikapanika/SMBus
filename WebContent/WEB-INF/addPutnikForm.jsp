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
<title>Dodaj putnika</title>
</head>

<body>
<br>
	<h3><center><b><span style="color:#003366">Dodaj putnika</span></b></center></h3>	
</div> </html>

<br><br>
		
<html>
<body>
<form:form method="post" action="addPutnik" modelAttribute="putnik">
<div>
<center><form:input path="idVoznje" placeholder="ID Voznje" /></center>
</div>
<div>
<center><form:input path="ime" placeholder="Ime" /></center>
</div>
<div>
<center><form:input path="prezime" placeholder="Prezime" /></center>
</div>
<div>
<center><form:input path="starost" placeholder="Starost" /></center>
</div>
<div>
<center><form:input path="brojPasosa" placeholder="Broj pasosa" /></center>
</div>
<div>
<center><input style="width: 200px;cursor: pointer; font-weight: bold; position: right;font-size: 100%;" type="submit" value="Dodaj" onclick="window.location.href='/AdminHome'" /></center>
</div>
<div>
<center><input style="width: 200px;cursor: pointer; font-weight: bold; position: right;font-size: 100%;" type="submit" value="Odjavi se" onclick="window.location.href='/loginform'" /></center>
</div>
</form:form>
<br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>