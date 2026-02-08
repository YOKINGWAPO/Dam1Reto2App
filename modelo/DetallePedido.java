public class DetallePedido {

    private int idDetalle;
    private int idConfiguracion;
    private int idComponente;
    private int cantidad;
    private double precioUnitario;
    private String nombreComponente;
    public DetallePedido() {}

    public DetallePedido(int idDetalle, int idConfiguracion, int idComponente, String nombreComponente,int cantidad, double precioUnitario) {
        this.idDetalle = idDetalle;
        this.idConfiguracion = idConfiguracion;
        this.idComponente = idComponente;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.nombreComponente=nombreComponente;
    }
   

    public String getNombreComponente() {
        return nombreComponente;
    }

    public void setNombreComponente(String nombreComponente) {
        this.nombreComponente = nombreComponente;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public int getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(int idComponente) {
        this.idComponente = idComponente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
