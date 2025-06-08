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

    public void add(Publication p) {
        Connection c = Database.getDatabase().getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("insert into publicaciones(practica_id, cuota, detalle) values (?,?,?)");
            pst.setInt(1, p.getPracticaId());
            pst.setBigDecimal(2, p.getCuota());
            pst.setString(3, p.getDetalle());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Connection c = Database.getDatabase().getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("delete from publicaciones where id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
