package WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Putnik;
import dao.DBConnection;

public class addPutnik {

        public void createPutnik(int idVoznje, String ime, String prezime, int starost, int brojPasosa) {
                String sql = "INSERT INTO ssmtkdb.Employees"
                                + "(idVoznje, ime, prezime, starost, brojPasosa) VALUES (?, ?, ?, ?, ?)";
                Connection conn;
                try {
                        conn = DBConnection.getConnection();
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, idVoznje);
                        stmt.setString(2, ime);
                        stmt.setString(3, prezime);
                        stmt.setInt(4, starost);
                        stmt.setInt(5, brojPasosa);

                        stmt.executeUpdate();
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
}