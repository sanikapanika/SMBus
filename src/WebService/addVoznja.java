package WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Voznja;
import dao.DBConnection;

public class addVoznja {

	
        public void createVoznja(int id, String polaziste,String odrediste, int trajanjePutovanja,String prevoznik) {
                String sql = "INSERT INTO Voznja"
                                + "(id, polaziste, odrediste, trajanjePutovanja, prevoznik) VALUES (?, ?, ?, ?, ?)";
                Connection conn;
                try {
                        conn = DBConnection.getConnection();
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, id);
                        stmt.setString(2, polaziste);
                        stmt.setString(3, odrediste);
                        stmt.setInt(4, trajanjePutovanja);
                        stmt.setString(5, prevoznik);

                        stmt.executeUpdate();
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
}