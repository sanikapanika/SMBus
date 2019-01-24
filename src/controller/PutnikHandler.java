package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Putnik;
import dao.DBConnection;


public class PutnikHandler {
	/**
	 * Get for provided id
	 * 
	 * @param idVoznje
	 * @return
	 */
	public Putnik getPutnik(int idVoznje) {
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM ssmtk.Putnik WHERE idVoznje= ?");
			stmt.setInt(1, idVoznje);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Putnik putnik = new Putnik();
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
/**
	 * Create
	 * 
	 * @param putnik
	 */
	public void createPutnik(Putnik putnik) {
		String sql = "INSERT INTO ssmtk.Putnik "
				+ "(idVoznje, ime, prezime, starost, brojPasosa) VALUES (?, ?, ?, ?, ?)";
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, putnik.getIdVoznje());
			stmt.setString(2, putnik.getIme());
			stmt.setString(3, putnik.getPrezime());
			stmt.setInt(4, putnik.getStarost());
			stmt.setInt(5, putnik.getBrojPasosa());

			int rs = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
	 * Delete
	 * 
	 * @param putnik
	 */
	
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
