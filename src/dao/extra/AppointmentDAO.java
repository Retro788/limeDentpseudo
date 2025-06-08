package dao.extra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDateTime;

import model.Database;
import model.extra.Appointment;

public class AppointmentDAO {
    public ArrayList<Appointment> getAll() {
        ArrayList<Appointment> list = new ArrayList<>();
        Connection c = Database.getDatabase().getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("select * from citas");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Appointment a = new Appointment(
                    rs.getInt("id"),
                    rs.getInt("publicacion_id"),
                    rs.getInt("paciente_id"),
                    rs.getTimestamp("fecha").toLocalDateTime()
                );
                list.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
