package model.extra;

public class Practice {
    private Integer id;
    private Integer practicanteId;
    private Integer docenteId;
    private String descripcion;

    public Practice() {}

    public Practice(Integer id, Integer practicanteId, Integer docenteId, String descripcion) {
        this.id = id;
        this.practicanteId = practicanteId;
        this.docenteId = docenteId;
        this.descripcion = descripcion;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getPracticanteId() { return practicanteId; }
    public void setPracticanteId(Integer practicanteId) { this.practicanteId = practicanteId; }
    public Integer getDocenteId() { return docenteId; }
    public void setDocenteId(Integer docenteId) { this.docenteId = docenteId; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
