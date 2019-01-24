<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<br>

<form>
<input style="width: 100px; position: absolute; right: 50; cursor: pointer; font-weight: bold; position: right; font-size: 100%;" type="button" value="Odjavi se" onclick="window.location.href='/SmartBusTerminal/loginform'" />
</form>
 


<html>
<head>
<style>
body 
{
background-image: url("https://i.imgur.com/th0CViy.jpg");
background-size: 100%;
}

</style>
<title>Korisnik Home</title>
</head>

<body>
<br>
	<h4><center><b><span style="color:#003366">Pristup za korisnika</span></b></center></h4>	
</div> 
		
<html>
<body>	
<p>
<center><font size="50" face="calibri" color=#003366><b>
    Smart Bus Terminal
</b></center></font></p>
</body>
</html>
		

        <h3><center><span style="color:#003366">Pregledaj voznju</span></center></h3>
		<center><input style="width: 200px; cursor: pointer; font-weight: bold;  font-size: 90%;" type="button" value="Pretrazi voznju" onclick="window.location.href='getVoznjaForm'" /></center>
		
		<h3><center><span style="color:#003366"> Informacije senzora </span></center></h3>
		<center><input style="width: 200px; cursor: pointer; font-weight: bold;  font-size: 90%;" type="button" value="Prikazi inforamcije senzora" onclick="window.location.href='getSensorInfoForm'" /></center>		

	</ul>
</body>
</html>