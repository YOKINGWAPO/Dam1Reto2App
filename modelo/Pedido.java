import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int idConfiguracion;
    private int idCliente;
    private String nombreConfig;
    private String descripcion;
    private String estado;
    private Timestamp fechaCreacion;

   
    private List<DetallePedido> detalles = new ArrayList<>();

    public Pedido() {}

    public Pedido(int idConfiguracion, int idCliente, String nombreConfig, String descripcion, String estado, Timestamp fechaCreacion) {
        this.idConfiguracion = idConfiguracion;
        this.idCliente = idCliente;
        this.nombreConfig = nombreConfig;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreConfig() {
        return nombreConfig;
    }

    public void setNombreConfig(String nombreConfig) {
        this.nombreConfig = nombreConfig;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }
}
