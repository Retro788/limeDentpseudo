package dao.extra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Database;
import model.extra.Review;

public class ReviewDAO {
    public ArrayList<Review> getAll() {
        ArrayList<Review> list = new ArrayList<>();
        Connection c = Database.getDatabase().getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("select * from resenas");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Review r = new Review(
                    rs.getInt("id"),
                    rs.getInt("cita_id"),
                    rs.getInt("paciente_id"),
                    rs.getInt("calificacion"),
                    rs.getString("comentario")
                );
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
