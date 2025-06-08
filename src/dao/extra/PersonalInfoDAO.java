package dao.extra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Database;
import model.extra.PersonalInfo;

public class PersonalInfoDAO {
    public ArrayList<PersonalInfo> getAll() {
        ArrayList<PersonalInfo> list = new ArrayList<>();
        Connection c = Database.getDatabase().getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("select * from personal_info");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                PersonalInfo p = new PersonalInfo(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("rol"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("email")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(PersonalInfo pi) {
        Connection c = Database.getDatabase().getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("insert into personal_info(user_id, rol, nombre, apellido, telefono, email) values (?, ?, ?, ?, ?, ?)");
            pst.setInt(1, pi.getUserId());
            pst.setString(2, pi.getRol());
            pst.setString(3, pi.getNombre());
            pst.setString(4, pi.getApellido());
            pst.setString(5, pi.getTelefono());
            pst.setString(6, pi.getEmail());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Connection c = Database.getDatabase().getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("delete from personal_info where id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
