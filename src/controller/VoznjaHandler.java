package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Voznja;
import dao.DBConnection;
import model.Putnik;


public class VoznjaHandler {
	
	/**
	 * add
	 * @param voznja
	 */
	public void createVoznja(Voznja voznja) {
		String sql = "INSERT INTO Voznja"
				+ "(id, polaziste, odrediste, trajanjePtovanja, prevoznik) VALUES (?, ?, ?, ?, ?)";
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, voznja.getId());
			stmt.setString(2, voznja.getPolaziste());
			stmt.setString(3, voznja.getOdrediste());
			stmt.setString(4, voznja.getTrajanjePutovanja());
			stmt.setString(5, voznja.getPrevoznik());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*
	 * sve voznje u tabeli Voznja
	 */
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
	
/*
	 * brisanje voznje i putnika na njoj pomocu idVoznje
	 */
	
	public void delete(Voznja voznja, Putnik putnik) {  

		String sql = "DELETE ssmtk.Voznja, ssmtk.Putnik FROM ssmtk.Voznja INNER JOIN ssmtk.Putnik ON id = idVoznje WHERE id=?";
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			PreparedStatement stmt1 = conn.prepareStatement(sql);
			stmt.setInt(1, voznja.getId());
			stmt1.setInt(1, putnik.getIdVoznje());
						
			boolean rs = stmt.execute();
			boolean rs1 = stmt1.execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
