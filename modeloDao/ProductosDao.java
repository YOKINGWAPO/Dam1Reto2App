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
                            fechaRegistro
                    );
                    //System.out.println(rs.getString("cpu_socket"));
                    
                    if ("GPU".equals(tipoCompotente)) {
                    	int gpuVramGb;
                    	int gpuConsumoW;
                    	String gpuChipset;
                    	
                    	gpuVramGb=rs.getInt("gpu_vram_gb");
                    	gpuConsumoW=rs.getInt("gpu_consumo_w");
                    	gpuChipset=rs.getString("gpu_chipset");
                    	
                    	Producto producto2 = new Producto(producto,gpuVramGb,gpuConsumoW,gpuChipset);
                    	lista.add(producto2);
                    	
                    } else if ("CPU".equals(tipoCompotente)) {
                    	String cpuSocket;
                    	int cpuNucleos;
                    	int cpuHilos;
                    	int cpuTdpW;
                    	
                    	cpuSocket=rs.getString("cpu_socket");
                    	cpuNucleos=rs.getInt("cpu_nucleos");
                    	cpuHilos=rs.getInt("cpu_hilos");
                    	cpuTdpW=rs.getInt("cpu_tdp_w");
                    	
                    	Producto producto2 = new Producto(producto,cpuSocket,cpuNucleos,cpuHilos,cpuTdpW);
                    	lista.add(producto2);

                    } else if ("RAM".equals(tipoCompotente)) {
                    	int ramCapacidadGb;
                    	String ramTipo;
                    	int ramFrecuenciaMhz;
                    	
                    	ramCapacidadGb=rs.getInt("ram_capacidad_gb");
                    	ramTipo=rs.getString("ram_tipo");
                    	ramFrecuenciaMhz=rs.getInt("ram_frecuencia_mhz");
                    	
                    	Producto producto2 = new Producto(producto,ramCapacidadGb,ramTipo,ramFrecuenciaMhz);
                    	lista.add(producto2);

                    } else if ("ALMACENAMIENTO".equals(tipoCompotente)) {
                    	String almTipo;
                    	int almCapacidadGb;
                    	String almInterfaz;
                    	
                    	almTipo=rs.getString("alm_tipo");
                    	almCapacidadGb=rs.getInt("alm_capacidad_gb");
                    	almInterfaz=rs.getString("alm_interfaz");
                    	
                    	Producto producto2 = new Producto(producto,almTipo,almCapacidadGb,almInterfaz);
                    	lista.add(producto2);

                    } else if ("PLACA_BASE".equals(tipoCompotente)) {
                    	String pbSocket;
                    	String pbChipset;
                    	String pbFormato;
                    	String pbRamTipo;
                    	
                    	pbSocket=rs.getString("pb_socket");
                    	pbChipset=rs.getString("pb_chipset");
                    	pbFormato=rs.getString("pb_formato");
                    	pbRamTipo=rs.getString("pb_ram_tipo");

                    	Producto producto2 = new Producto(producto,pbSocket,pbChipset,pbFormato,pbRamTipo);
                    	lista.add(producto2);

                    } else if ("MONITOR".equals(tipoCompotente)) {
                    	int monTamanoPulg;
                    	String monResolucion;
                    	int monHz;
                    	String monPanel;
                    	
                    	monTamanoPulg=rs.getInt("mon_tamano_pulg");
                    	monResolucion=rs.getString("mon_resolucion");
                    	monHz=rs.getInt("mon_hz");
                    	monPanel=rs.getString("mon_panel");
                    	
                    	Producto producto2 = new Producto(producto,monTamanoPulg,monResolucion,monHz,monPanel);
                    	lista.add(producto2);
                    	
                    } else if ("CASCOS".equals(tipoCompotente)) {
                    	String casConexion;
                    	int casMicrofono;
                    	
                    	casConexion=rs.getString("cas_conexion");
                    	casMicrofono=rs.getInt("cas_microfono");
                    	
                    	Producto producto2 = new Producto(producto,casConexion,casMicrofono);
                    	lista.add(producto2);

                    } else if ("CONSOLA".equals(tipoCompotente)) {
                    	int conAlmacenamientoGb;
                    	
                    	conAlmacenamientoGb=rs.getInt("con_almacenamiento_gb");
                    	
                    	Producto producto2 = new Producto(producto,conAlmacenamientoGb);
                    	lista.add(producto2);

                    } else if ("PSU".equals(tipoCompotente)) {
                    	String psuCertificacion;
                    	int psuPotenciaW;
                    	int psuModular;
                    	
                    	psuCertificacion=rs.getString("psu_certificacion");
                    	psuPotenciaW=rs.getInt("psu_potencia_w");
                    	psuModular=rs.getInt("psu_modular");
                    	
                    	Producto producto2 = new Producto(producto,psuCertificacion,psuPotenciaW,psuModular);
                    	lista.add(producto2);

                    } else if ("CAJA".equals(tipoCompotente)) {
                    	String cajaFormatoSoportado;

                    	cajaFormatoSoportado=rs.getString("caja_formato_soportado");
                    	
                    	Producto producto2 = new Producto(producto,cajaFormatoSoportado);
                    	lista.add(producto2);
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
