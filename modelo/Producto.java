import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

public class Producto {
	private int  id_componente;
	private int id_proveedor;
	private int id_categoria;
	private String nombre;
	private String descripcion;
	private String especificaciones;
	private BigDecimal precio;
	private int stock;
	private byte[] imagen;
	private int activo;
	private Timestamp fechaRegistro;


	public Producto(int  id_componente, int id_proveedor, int id_categoria,String nombre,String descripcion,  BigDecimal  precio, int stock, byte[] imagen, int activo, Timestamp fechaRegistro) {
		this. id_componente= id_componente;
		this.id_proveedor=id_proveedor;
		this.id_categoria=id_categoria;
		this.nombre=nombre;
		this.descripcion=descripcion;
		//this.especificaciones=especificaciones;
		this.precio=precio;
		this.stock=stock;
		this.imagen=imagen;
		this.activo=activo;
		this.fechaRegistro=fechaRegistro;
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
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

	public void setPrecio(BigDecimal  precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getId_componente() {
		return id_componente;
	}

	public void setId_componente(int id_componente) {
		this.id_componente = id_componente;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
}
