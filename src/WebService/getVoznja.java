package WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Voznja;
import dao.DBConnection;

public class getVoznja {
	
	public ArrayList<Voznja> getAllVoznje() {
		ArrayList<Voznja> result = new ArrayList<Voznja>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ssmtk.Voznja");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Voznja d = new Voznja();
				d.setId(rs.getInt("id"));
				d.setPolaziste(rs.getString("polaziste"));
				d.setOdrediste(rs.getString("odrediste"));
				d.setTrajanjePutovanja(rs.getString("trajanjePutovanja"));
				d.setPrevoznik(rs.getString("prevoznik"));
				result.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
