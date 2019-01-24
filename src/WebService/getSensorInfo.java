package WebService;

import model.sensorInfo;
import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class getSensorInfo {
	
	public void inputSensorValues(sensorInfo SenzoriTemperatura) {
		String sql = "UPDATE ssmtk.SenzoriTemperatura SET temperatura = ? WHERE dio = 'kabina'";
		String sql2 = "UPDATE ssmtk.SenzoriTemperatura SET temperatura = ? WHERE dio = 'prtljaznik'";
		String sql3 = "UPDATE ssmtk.SenzoriTemperatura SET temperatura = ? WHERE dio = 'motor'";
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			PreparedStatement stmt3 = conn.prepareStatement(sql3);


			
				stmt.setString(1, SenzoriTemperatura.getKabina());
				stmt2.setString(1, SenzoriTemperatura.getPrtljaznik());
				stmt3.setString(1, SenzoriTemperatura.getMotor());
				
				stmt.executeUpdate();
				stmt2.executeUpdate();
				stmt3.executeUpdate();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public sensorInfo getSensorInfo() {
		sensorInfo sensorInfo = new sensorInfo();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM ssmtk.SenzoriTemperatura");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString(2).equals("kabina"))
				{
					sensorInfo.setKabina(rs.getString(3));
				}
				else if (rs.getString(2).equals("prtljaznik"))
				{
					sensorInfo.setPrtljaznik(rs.getString(3));
				}
				else if (rs.getString(2).equals("motor"))
				{
					sensorInfo.setMotor(rs.getString(3));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sensorInfo.getKabina());
		System.out.println(sensorInfo.getPrtljaznik());
		System.out.println(sensorInfo.getMotor());
		System.out.println("--------------------------");
		return sensorInfo;
	}
}
