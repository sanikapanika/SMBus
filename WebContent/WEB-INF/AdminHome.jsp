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
<title>Administrator Home</title>
</head>

<body>
<br>
	<h4><center><b><span style="color:#003366">Pristup za administratora</span></b></center></h4>	
</div> 
		
<html>
<body>	
<p>
<center><font size="50" face="calibri" color=#003366><b>
    Smart Bus Terminal
</b></center></font></p>
</body>
</html>

		<h3><center><span style="color:#003366">Dodaj podatke</span></center></h3>
		<center><input style="width: 200px; cursor: pointer; font-weight: bold;  font-size: 90%;" type="button" value="Dodaj voznju" onclick="window.location.href='/SmartBusTerminal/addVoznjaForm'" /></center>
		<center><input style="width: 200px; cursor: pointer; font-weight: bold;  font-size: 90%;" type="button" value="Dodaj putnika" onclick="window.location.href='/SmartBusTerminal/addPutnikForm'" /></center>

        <h3><center><span style="color:#003366">Pretrazi</span></center></h3>
		<center><input style="width: 200px; cursor: pointer; font-weight: bold;  font-size: 90%;" type="button" value="Pretrazi voznje" onclick="window.location.href='/SmartBusTerminal/getVoznjaForm'" /></center>
		<center><input style="width: 200px; cursor: pointer; font-weight: bold;  font-size: 90%;" type="button" value="Pretrazi putnike" onclick="window.location.href='/SmartBusTerminal/getPutnikForm'" /></center>
		
		<h3><center><span style="color:#003366">Pregled pristupa</span></center></h3>
		<center><input style="width: 200px; cursor: pointer; font-weight: bold;  font-size: 90%;" type="button" value="Uspjesni pristupi" onclick="window.location.href='/SmartBusTerminal/getUspjesniPristupiForm'" /></center>
	    <center><input style="width: 200px; cursor: pointer; font-weight: bold;  font-size: 90%;" type="button" value="Nasilni pokusaji" onclick="window.location.href='/SmartBusTerminal/getNasilniPokusajiForm'" /></center>
			
		<h3><center><span style="color:#003366"> Informacije senzora </span></center></h3>
		<center><input style="width: 200px; cursor: pointer; font-weight: bold; font-size: 90%;" type="button" value="Informacije senzora" onclick="window.location.href='/SmartBusTerminal/getSensorsInfoForm'" /></center>		

		<h3><center><span style="color:#003366">Izbrisi podatke</span></center></h3>
		<center><input style="width: 200px; cursor: pointer; font-weight: bold;  font-size: 90%;" type="button" value="Izbrisi voznju" onclick="window.location.href='/SmartBusTerminal/deleteVoznjaForm'" /></center>
		<center><input style="width: 200px; cursor: pointer; font-weight: bold;  font-size: 90%;" type="button" value="Izbrisi putnika" onclick="window.location.href='/SmartBusTerminal/deletePutnikaForm'" /></center>
	</ul>
</body>
</html>
