package model.extra;

import java.time.LocalDateTime;

public class Appointment {
    private Integer id;
    private Integer publicacionId;
    private Integer pacienteId;
    private LocalDateTime fecha;

    public Appointment() {}

    public Appointment(Integer id, Integer publicacionId, Integer pacienteId, LocalDateTime fecha) {
        this.id = id;
        this.publicacionId = publicacionId;
        this.pacienteId = pacienteId;
        this.fecha = fecha;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getPublicacionId() { return publicacionId; }
    public void setPublicacionId(Integer publicacionId) { this.publicacionId = publicacionId; }
    public Integer getPacienteId() { return pacienteId; }
    public void setPacienteId(Integer pacienteId) { this.pacienteId = pacienteId; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
