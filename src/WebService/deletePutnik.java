package WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Putnik;
import dao.DBConnection;

public class deletePutnik {
	
	public void deletePutnik(String ime, String prezime) {  

		String sql = "DELETE FROM ssmtk.Putnik WHERE ime = ? AND prezime = ? ";
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(2, ime);
			stmt.setString(3, prezime);
			boolean rs = stmt.execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
