import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import oracle.jdbc.OracleTypes;

public class ProductosDao {

    private Conexion conexion;

    public ProductosDao() { }

    public List<Producto> obtenerProductos(int categoria) {

        List<Producto> lista = new ArrayList<>();

        String sql = "{ call pkg_productos.p_get_productos_categoria(?, ?) }";

        int id_componente;
        int id_proveedor;
        int id_categoria;
        String nombre;
        String descripcion;
        String marca;
        String tipoCompotente;
        BigDecimal precio;
        int stock;
        Blob imagen;
        int activo;
        Timestamp fechaRegistro;
        byte[] imgBytes;
      
        try (Connection cone = Conexion.conectar();
             CallableStatement cs = cone.prepareCall(sql)) {

            cs.setInt(1, categoria);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(2)) {
                while (rs.next()) {

                    id_componente = rs.getInt("id_componente");
                    id_proveedor = rs.getInt("id_proveedor");
                    id_categoria = rs.getInt("id_categoria");
                    nombre = rs.getString("nombre");
                    descripcion = rs.getString("descripcion");
                    tipoCompotente = rs.getString("tipo_componente");
                    precio = rs.getBigDecimal("precio");
                    stock = rs.getInt("stock");
                    activo = rs.getInt("activo");
                    fechaRegistro = rs.getTimestamp("fecha_alta");
                    marca = rs.getString("id_Marca");
                    imagen = rs.getBlob("imagen");
                    if (imagen != null) {
                        imgBytes = imagen.getBytes(1, (int) imagen.length());
                    } else {
                        imgBytes = new byte[0]; 
                    }

                    Producto producto = new Producto(
                            id_componente,
                            id_proveedor,
                            id_categoria,
                            nombre,
                            descripcion,
                            precio,
                            stock,
                            imgBytes,
                            activo,
                            fechaRegistro,
                            marca,
                            tipoCompotente
                            
                    );
                    //System.out.println(rs.getString("cpu_socket"));
                    
                    if ("GPU".equals(tipoCompotente)) {
                    	int gpuVramGb;
                    	int gpuConsumoW;
                    	String gpuChipset;
                    	
                    	gpuVramGb=rs.getInt("gpu_vram_gb");
                    	gpuConsumoW=rs.getInt("gpu_consumo_w");
                    	gpuChipset=rs.getString("gpu_chipset");
                    	
                    	Gpu gpu = new Gpu(gpuVramGb,gpuConsumoW,gpuChipset);
                    	producto.setGpu(gpu);
                    	lista.add(producto);
                    	
                    } else if ("CPU".equals(tipoCompotente)) {
                    	String cpuSocket;
                    	int cpuNucleos;
                    	int cpuHilos;
                    	int cpuTdpW;
                    	
                    	cpuSocket=rs.getString("cpu_socket");
                    	cpuNucleos=rs.getInt("cpu_nucleos");
                    	cpuHilos=rs.getInt("cpu_hilos");
                    	cpuTdpW=rs.getInt("cpu_tdp_w");
                    	
                    	Cpu cpu=new Cpu(cpuSocket,cpuNucleos,cpuHilos,cpuTdpW);
                    	producto.setCpu(cpu);
                    	lista.add(producto);

                    } else if ("RAM".equals(tipoCompotente)) {
                    	int ramCapacidadGb;
                    	String ramTipo;
                    	int ramFrecuenciaMhz;
                    	
                    	ramCapacidadGb=rs.getInt("ram_capacidad_gb");
                    	ramTipo=rs.getString("ram_tipo");
                    	ramFrecuenciaMhz=rs.getInt("ram_frecuencia_mhz");
                    	
                    	Ram ram = new Ram (ramCapacidadGb,ramTipo,ramFrecuenciaMhz);
                    	producto.setRam(ram);
                    	lista.add(producto);

                    } else if ("ALMACENAMIENTO".equals(tipoCompotente)) {
                    	String almTipo;
                    	int almCapacidadGb;
                    	String almInterfaz;
                    	
                    	almTipo=rs.getString("alm_tipo");
                    	almCapacidadGb=rs.getInt("alm_capacidad_gb");
                    	almInterfaz=rs.getString("alm_interfaz");
                    	
                    	Almacenamiento alm = new Almacenamiento(almTipo,almCapacidadGb,almInterfaz);
                    	producto.setAlmacenamiento(alm);
                    	lista.add(producto);

                    } else if ("PLACA_BASE".equals(tipoCompotente)) {
                    	String pbSocket;
                    	String pbChipset;
                    	String pbFormato;
                    	String pbRamTipo;
                    	
                    	pbSocket=rs.getString("pb_socket");
                    	pbChipset=rs.getString("pb_chipset");
                    	pbFormato=rs.getString("pb_formato");
                    	pbRamTipo=rs.getString("pb_ram_tipo");

                    	PlacaBase placaBase= new PlacaBase(pbSocket,pbChipset,pbFormato,pbRamTipo);
                    	producto.setPlacaBase(placaBase);
                    	lista.add(producto);

                    } else if ("MONITOR".equals(tipoCompotente)) {
                    	int monTamanoPulg;
                    	String monResolucion;
                    	int monHz;
                    	String monPanel;
                    	
                    	monTamanoPulg=rs.getInt("mon_tamano_pulg");
                    	monResolucion=rs.getString("mon_resolucion");
                    	monHz=rs.getInt("mon_hz");
                    	monPanel=rs.getString("mon_panel");
                    	
                    	Monitor monitor = new Monitor(monTamanoPulg,monResolucion,monHz,monPanel);
                    	producto.setMonitor(monitor);
                    	lista.add(producto);
                    	
                    } else if ("CASCOS".equals(tipoCompotente)) {
                    	String casConexion;
                    	int casMicrofono;
                    	
                    	casConexion=rs.getString("cas_conexion");
                    	casMicrofono=rs.getInt("cas_microfono");
                    	
                    	Cascos cascos = new Cascos(casConexion,casMicrofono);
                    	producto.setCascos(cascos);
                    	lista.add(producto);

                    } else if ("CONSOLA".equals(tipoCompotente)) {
                    	int conAlmacenamientoGb;
                    	
                    	conAlmacenamientoGb=rs.getInt("con_almacenamiento_gb");
                    	
                    	Consolas consolas = new Consolas(conAlmacenamientoGb);
                    	producto.setConsolas(consolas);
                    	lista.add(producto);

                    } else if ("PSU".equals(tipoCompotente)) {
                    	String psuCertificacion;
                    	int psuPotenciaW;
                    	int psuModular;
                    	
                    	psuCertificacion=rs.getString("psu_certificacion");
                    	psuPotenciaW=rs.getInt("psu_potencia_w");
                    	psuModular=rs.getInt("psu_modular");
                    	
                    	Psu psu = new Psu(psuCertificacion,psuPotenciaW,psuModular);
                    	producto.setPsu(psu);
                    	lista.add(producto);

                    } else if ("CAJA".equals(tipoCompotente)) {
                    	String cajaFormatoSoportado;

                    	cajaFormatoSoportado=rs.getString("caja_formato_soportado");
                    	
                    	Caja caja = new Caja(cajaFormatoSoportado);
                    	producto.setCaja(caja);
                    	lista.add(producto);
                    }


                    //lista.add(producto);
                }
            }

            System.out.println("Cargandoooo");
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista; // para que no devuelva null
    }
}
