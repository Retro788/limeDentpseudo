package dao.extra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Database;
import model.extra.Practice;

public class PracticeDAO {
    public ArrayList<Practice> getAll() {
        ArrayList<Practice> list = new ArrayList<>();
        Connection c = Database.getDatabase().getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("select * from practicas");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Practice p = new Practice(
                    rs.getInt("id"),
                    rs.getInt("practicante_id"),
                    rs.getInt("docente_id"),
                    rs.getString("descripcion")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
