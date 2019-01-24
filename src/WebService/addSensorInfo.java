package WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.sensorInfo;
import dao.DBConnection;

public class addSensorInfo {

        public void createSensorInfo(int id, String dio, int temperature) {
                String sql = "INSERT INTO ssmtkdb.RoomSensorInfo "
                                + "(id, dio , temperature) VALUES (?, ?, ?)";
                Connection conn;
                try {
                        conn = DBConnection.getConnection();
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, id);
                        stmt.setString(2, dio);
                        stmt.setInt(3, temperature);
                        stmt.executeUpdate();
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
}