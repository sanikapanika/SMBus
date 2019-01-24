package WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Putnik;
import dao.DBConnection;

public class getPutnik {
	
	public Putnik getPutnikByIdVoznje(int idVoznje) {
		try {
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM ssmtk.Putnik WHERE idVoznje=?");
			stmt.setInt(1, idVoznje);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Putnik putnik = new Putnik();
				putnik.setIdVoznje(rs.getInt("idVoznje"));
				putnik.setIme(rs.getString("ime"));
				putnik.setPrezime(rs.getString("prezime"));
				putnik.setStarost(rs.getInt("starost"));
				putnik.setBrojPasosa(rs.getInt("brojPasosa"));
			
				return putnik;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
