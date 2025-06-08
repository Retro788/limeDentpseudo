package dao.extra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.math.BigDecimal;

import model.Database;
import model.extra.Publication;

public class PublicationDAO {
    public ArrayList<Publication> getAll() {
        ArrayList<Publication> list = new ArrayList<>();
        Connection c = Database.getDatabase().getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("select * from publicaciones");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Publication p = new Publication(
                    rs.getInt("id"),
                    rs.getInt("practica_id"),
                    rs.getBigDecimal("cuota"),
                    rs.getString("detalle")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
