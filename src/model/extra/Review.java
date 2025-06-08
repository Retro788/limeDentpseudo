package model.extra;

public class Review {
    private Integer id;
    private Integer citaId;
    private Integer pacienteId;
    private int calificacion;
    private String comentario;

    public Review() {}

    public Review(Integer id, Integer citaId, Integer pacienteId, int calificacion, String comentario) {
        this.id = id;
        this.citaId = citaId;
        this.pacienteId = pacienteId;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getCitaId() { return citaId; }
    public void setCitaId(Integer citaId) { this.citaId = citaId; }
    public Integer getPacienteId() { return pacienteId; }
    public void setPacienteId(Integer pacienteId) { this.pacienteId = pacienteId; }
    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}
