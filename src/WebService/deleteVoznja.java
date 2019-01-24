package WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Putnik;
import model.Voznja;
import dao.DBConnection;

public class deleteVoznja {
	
	public void delete(int id) {  

		String sql = "DELETE ssmtk.Voznja, ssmtk.Putnik FROM ssmtk.Voznja INNER JOIN ssmtk.Putnik ON id = idVoznje WHERE id=?";
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
				
			boolean rs = stmt.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
