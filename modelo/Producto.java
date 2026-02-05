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

	private int gpuVramGb;
	private int gpuConsumoW;
	private String gpuChipset;

	private String cpuSocket;
	private int cpuNucleos;
	private int cpuHilos;
	private int cpuTdpW;

	private int ramCapacidadGb;
	private String ramTipo;
	private int ramFrecuenciaMhz;

	private String almTipo;
	private int almCapacidadGb;
	private String almInterfaz;

	private String pbSocket;
	private String pbChipset;
	private String pbFormato;
	private String pbRamTipo;

	private int monTamanoPulg;
	private String monResolucion;
	private int monHz;
	private String monPanel;

	private String casConexion;
	private int casMicrofono;

	private int conAlmacenamientoGb;

	private int psuPotenciaW;
	private String psuCertificacion;
	private int psuModular;

	private String cajaFormatoSoportado;

	private Producto producto;
	
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
	public Producto(Producto producto, int gpuVramGb,int gpuConsumoW,String gpuChipset) {
		//Gpu
		this.producto=producto;
		this.gpuVramGb=gpuVramGb;
		this.gpuConsumoW=gpuConsumoW;
		this.gpuChipset=gpuChipset;


	}

	public Producto(Producto producto, String cpuSocket,int cpuNucleos,int cpuHilos,int cpuTdpW) {
		//Cpu
		this.producto=producto;
		this.cpuSocket=cpuSocket;
		this.cpuNucleos=cpuNucleos;
		this.cpuHilos=cpuHilos;
		this.cpuTdpW=cpuTdpW;


	}

	public Producto(Producto producto, int ramCapacidadGb, String ramTipo,int ramFrecuenciaMhz) {
		//Ram
		this.producto=producto;
		this.ramCapacidadGb=ramCapacidadGb;
		this.ramTipo=ramTipo;
		this.ramFrecuenciaMhz=ramFrecuenciaMhz;
	}

	public Producto(Producto producto, String almTipo, int almCapacidadGb, String almInterfaz) {
		//Almacenamiento
		this.producto=producto;
		this.almTipo=almTipo;
		this.almCapacidadGb=almCapacidadGb;
		this.almInterfaz=almInterfaz;
	}

	public Producto(Producto producto, String pbSocket,String pbChipset,String pbFormato,String pbRamTipo) {
		//Placa
		this.producto=producto;
		this.pbSocket=pbSocket;
		this.pbChipset=pbChipset;
		this.pbFormato=pbFormato;
		this.pbRamTipo=pbRamTipo;

	}

	public Producto(Producto producto, int monTamanoPulg,String monResolucion,int monHz,String monPanel) {
		//monitor
		this.producto=producto;
		this.monTamanoPulg=monTamanoPulg;
		this.monResolucion=monResolucion;
		this.monHz=monHz;
		this.monPanel=monPanel;
	}
	public Producto(Producto producto, String casConexion,int casMicrofono) {
		//Cascos
		this.producto=producto;
		this.casConexion=casConexion;
		this.casMicrofono=casMicrofono;

	}
	public Producto(Producto producto, int conAlmacenamientoGb) {
		//Consola
		this.producto=producto;
		this.conAlmacenamientoGb=conAlmacenamientoGb;
	}

	public Producto(Producto producto,String psuCertificacion, int psuPotenciaW, int psuModular) {
		//Alimentacion
		this.producto=producto;
		this.psuCertificacion=psuCertificacion;
		this.psuPotenciaW=psuPotenciaW;
		this.psuModular=psuModular;

	}
	public Producto(Producto producto, String cajaFormatoSoportado) {
		//Caja
		this.producto=producto;
		this.cajaFormatoSoportado=cajaFormatoSoportado;
	}
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
	public int getGpuVramGb() {
		return gpuVramGb;
	}
	public void setGpuVramGb(int gpuVramGb) {
		this.gpuVramGb = gpuVramGb;
	}
	public int getGpuConsumoW() {
		return gpuConsumoW;
	}
	public void setGpuConsumoW(int gpuConsumoW) {
		this.gpuConsumoW = gpuConsumoW;
	}
	public String getGpuChipset() {
		return gpuChipset;
	}
	public void setGpuChipset(String gpuChipset) {
		this.gpuChipset = gpuChipset;
	}
	public String getCpuSocket() {
		return cpuSocket;
	}
	public void setCpuSocket(String cpuSocket) {
		this.cpuSocket = cpuSocket;
	}
	public int getCpuNucleos() {
		return cpuNucleos;
	}
	public void setCpuNucleos(int cpuNucleos) {
		this.cpuNucleos = cpuNucleos;
	}
	public int getCpuHilos() {
		return cpuHilos;
	}
	public void setCpuHilos(int cpuHilos) {
		this.cpuHilos = cpuHilos;
	}
	public int getCpuTdpW() {
		return cpuTdpW;
	}
	public void setCpuTdpW(int cpuTdpW) {
		this.cpuTdpW = cpuTdpW;
	}
	public int getRamCapacidadGb() {
		return ramCapacidadGb;
	}
	public void setRamCapacidadGb(int ramCapacidadGb) {
		this.ramCapacidadGb = ramCapacidadGb;
	}
	public String getRamTipo() {
		return ramTipo;
	}
	public void setRamTipo(String ramTipo) {
		this.ramTipo = ramTipo;
	}
	public int getRamFrecuenciaMhz() {
		return ramFrecuenciaMhz;
	}
	public void setRamFrecuenciaMhz(int ramFrecuenciaMhz) {
		this.ramFrecuenciaMhz = ramFrecuenciaMhz;
	}
	public String getAlmTipo() {
		return almTipo;
	}
	public void setAlmTipo(String almTipo) {
		this.almTipo = almTipo;
	}
	public int getAlmCapacidadGb() {
		return almCapacidadGb;
	}
	public void setAlmCapacidadGb(int almCapacidadGb) {
		this.almCapacidadGb = almCapacidadGb;
	}
	public String getAlmInterfaz() {
		return almInterfaz;
	}
	public void setAlmInterfaz(String almInterfaz) {
		this.almInterfaz = almInterfaz;
	}
	public String getPbSocket() {
		return pbSocket;
	}
	public void setPbSocket(String pbSocket) {
		this.pbSocket = pbSocket;
	}
	public String getPbChipset() {
		return pbChipset;
	}
	public void setPbChipset(String pbChipset) {
		this.pbChipset = pbChipset;
	}
	public String getPbFormato() {
		return pbFormato;
	}
	public void setPbFormato(String pbFormato) {
		this.pbFormato = pbFormato;
	}
	public String getPbRamTipo() {
		return pbRamTipo;
	}
	public void setPbRamTipo(String pbRamTipo) {
		this.pbRamTipo = pbRamTipo;
	}
	public int getMonTamanoPulg() {
		return monTamanoPulg;
	}
	public void setMonTamanoPulg(int monTamanoPulg) {
		this.monTamanoPulg = monTamanoPulg;
	}
	public String getMonResolucion() {
		return monResolucion;
	}
	public void setMonResolucion(String monResolucion) {
		this.monResolucion = monResolucion;
	}
	public int getMonHz() {
		return monHz;
	}
	public void setMonHz(int monHz) {
		this.monHz = monHz;
	}
	public String getMonPanel() {
		return monPanel;
	}
	public void setMonPanel(String monPanel) {
		this.monPanel = monPanel;
	}
	public String getCasConexion() {
		return casConexion;
	}
	public void setCasConexion(String casConexion) {
		this.casConexion = casConexion;
	}
	public int getCasMicrofono() {
		return casMicrofono;
	}
	public void setCasMicrofono(int casMicrofono) {
		this.casMicrofono = casMicrofono;
	}
	public int getConAlmacenamientoGb() {
		return conAlmacenamientoGb;
	}
	public void setConAlmacenamientoGb(int conAlmacenamientoGb) {
		this.conAlmacenamientoGb = conAlmacenamientoGb;
	}
	public int getPsuPotenciaW() {
		return psuPotenciaW;
	}
	public void setPsuPotenciaW(int psuPotenciaW) {
		this.psuPotenciaW = psuPotenciaW;
	}
	public String getPsuCertificacion() {
		return psuCertificacion;
	}
	public void setPsuCertificacion(String psuCertificacion) {
		this.psuCertificacion = psuCertificacion;
	}
	public int getPsuModular() {
		return psuModular;
	}
	public void setPsuModular(int psuModular) {
		this.psuModular = psuModular;
	}
	public String getCajaFormatoSoportado() {
		return cajaFormatoSoportado;
	}
	public void setCajaFormatoSoportado(String cajaFormatoSoportado) {
		this.cajaFormatoSoportado = cajaFormatoSoportado;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	} 

}

	