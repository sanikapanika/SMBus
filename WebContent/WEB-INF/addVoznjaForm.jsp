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
<title>Dodaj voznju</title>
</head>

<body>
<br>
	<h3><center><b><span style="color:#003366">Dodaj voznju</span></b></center></h3>	
</div> </html>

<br><br>
		
<html>
<body>
<center><form:form method="post" action="addVoznja" modelAttribute="voznja"></center>
<div>
<center><form:input path="polaziste" placeholder="Polaziste" /></center>
</div>
<div>
<center><form:input path="odrediste" placeholder="Odrediste" /></center>
</div>
<div>
<center><form:input path="trajanjePutovanja" placeholder="Trajanje putovanja" /></center>
</div>
<div>
<center><form:input path="prevoznik" placeholder="Prevoznik" /></center>
</div>

<div>
<center><input style="width: 200px;cursor: pointer; font-weight: bold; position: right; font-size: 100%;" type="submit" value="Dodaj voznju" onclick="window.location.href='/SmartBusTerminal/AdminHome'" /></center>
</div>

<div>
<center><input style="width: 200px;cursor: pointer; font-weight: bold; position: right;font-size: 100%;" type="submit" value="Odjavi se" onclick="window.location.href='/SmartBusTerminal/loginform'" /></center>
</div>
</form:form>
<br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>