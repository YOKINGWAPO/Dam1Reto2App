import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

public class Producto {
	private int  id_componente;
	private int id_proveedor;
	private String nombre;
	private String descripcion;
	private String especificaciones;
	private BigDecimal precio;
	private int stock;
	private byte[] imagen;
	private int activo;
	private Timestamp fechaRegistro;
	private String tipoComponente;
	private String marca;
	
	private Cpu cpu;
	private Gpu gpu;
	private Ram ram;
	private PlacaBase placaBase;
	private Monitor monitor;
	private Cascos cascos;
	private Consolas consolas;
	private Almacenamiento almacenamiento;
	private Psu psu;
	private Caja caja;

	//private Producto producto;
	
	public Producto(int  id_componente, int id_proveedor ,String nombre,String descripcion,  BigDecimal  precio, int stock, byte[] imagen, int activo, Timestamp fechaRegistro,String marca,String tipoComponente) {
		this. id_componente= id_componente;
		this.id_proveedor=id_proveedor;
		
		this.nombre=nombre;
		this.descripcion=descripcion;
		//this.especificaciones=especificaciones;
		this.precio=precio;
		this.stock=stock;
		this.imagen=imagen;
		this.activo=activo;
		this.fechaRegistro=fechaRegistro;
		this.marca=marca;
		this.tipoComponente=tipoComponente;
	}
//	public Producto(Producto producto,Gpu gpu) {
//		//Gpu
//		this.producto=producto;
//		this.gpu=gpu;
//
//
//	}
//
//	public Producto(Producto producto,Cpu cpu) {
//		//Cpu
//		this.producto=producto;
//		this.cpu=cpu;
//
//	}
//
//	public Producto(Producto producto, Ram ram) {
//		//Ram
//		this.producto=producto;
//
//		this.ram=ram;
//	
//	}
//
//	public Producto(Producto producto, Almacenamiento almacenamiento) {
//		//Almacenamiento
//		this.producto=producto;
//
//		this.almacenamiento=almacenamiento;
//		
//	}
//
//	public Producto(Producto producto, PlacaBase placaBase) {
//		//Placa
//		this.producto=producto;
//
//		this.placaBase=placaBase;
//		
//
//	}
//
//	public Producto(Producto producto, Monitor monitor) {
//		//monitor
//		this.producto=producto;
//
//		this.monitor=monitor;
//	}
//	public Producto(Producto producto,Cascos cascos) {
//		//Cascos
//		this.producto=producto;
//
//		this.cascos=cascos;
//	
//
//	}
//	public Producto(Producto producto, Consolas consolas) {
//		//Consola
//		this.producto=producto;
//
//		this.consolas=consolas;
//	
//	}
//
//	public Producto(Producto producto,Psu psu) {
//		//Alimentacion
//		this.producto=producto;
//
//		this.psu=psu;
//		
//	}
//	public Producto(Producto producto, Caja caja) {
//		//Caja
//		this.producto=producto;
//
//		this.caja=caja;
//		
//	}
	
	//Getters Setters
	public int getId_componente() {
		return id_componente;
	}
	public void setId_componente(int id_componente) {
		this.id_componente = id_componente;
	}
	public int getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEspecificaciones() {
		return especificaciones;
	}
	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Cpu getCpu() {
		return cpu;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	public Gpu getGpu() {
		return gpu;
	}
	public void setGpu(Gpu gpu) {
		this.gpu = gpu;
	}
	public Ram getRam() {
		return ram;
	}
	public void setRam(Ram ram) {
		this.ram = ram;
	}
	public PlacaBase getPlacaBase() {
		return placaBase;
	}
	public void setPlacaBase(PlacaBase placaBase) {
		this.placaBase = placaBase;
	}
	public Monitor getMonitor() {
		return monitor;
	}
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	public Cascos getCascos() {
		return cascos;
	}
	public void setCascos(Cascos cascos) {
		this.cascos = cascos;
	}
	public Consolas getConsolas() {
		return consolas;
	}
	public void setConsolas(Consolas consolas) {
		this.consolas = consolas;
	}
	public Almacenamiento getAlmacenamiento() {
		return almacenamiento;
	}
	public void setAlmacenamiento(Almacenamiento almacenamiento) {
		this.almacenamiento = almacenamiento;
	}
	public Psu getPsu() {
		return psu;
	}
	public void setPsu(Psu psu) {
		this.psu = psu;
	}
	public Caja getCaja() {
		return caja;
	}
	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	

}

	