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

    public void add(Practice p) {
        Connection c = Database.getDatabase().getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("insert into practicas(practicante_id, docente_id, descripcion) values (?,?,?)");
            pst.setInt(1, p.getPracticanteId());
            pst.setInt(2, p.getDocenteId());
            pst.setString(3, p.getDescripcion());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Connection c = Database.getDatabase().getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("delete from practicas where id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
