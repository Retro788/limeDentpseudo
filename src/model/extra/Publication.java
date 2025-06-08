package model.extra;

import java.math.BigDecimal;

public class Publication {
    private Integer id;
    private Integer practicaId;
    private BigDecimal cuota;
    private String detalle;

    public Publication() {}

    public Publication(Integer id, Integer practicaId, BigDecimal cuota, String detalle) {
        this.id = id;
        this.practicaId = practicaId;
        this.cuota = cuota;
        this.detalle = detalle;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getPracticaId() { return practicaId; }
    public void setPracticaId(Integer practicaId) { this.practicaId = practicaId; }
    public BigDecimal getCuota() { return cuota; }
    public void setCuota(BigDecimal cuota) { this.cuota = cuota; }
    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }
}
