import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import oracle.jdbc.OracleTypes;

public class ProductosDao {

    private Conexion conexion;

    public ProductosDao() { }

    public List<Producto> obtenerProductos(int categoria) {

        List<Producto> lista = new ArrayList<>();

        String call = "{ call pkg_productos.p_get_productos_categoria(?, ?) }";

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
             CallableStatement cs = cone.prepareCall(call)) {

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
                    System.out.println(rs.getString("cpu_socket"));
                    
                    // Si en tu clase Producto tienes setters/campos para specs, aquí los rellenas:
                    if ("GPU".equals(tipoCompotente)) {
                        // Ejemplo (descomenta si existen esos setters/campos):
                        // producto.setVramGb(rs.getInt("gpu_vram_gb"));
                        // producto.setConsumoW(rs.getInt("gpu_consumo_w"));
                        // producto.setChipset(rs.getString("gpu_chipset"));
                    } else if ("CPU".equals(tipoCompotente)) {
                        // producto.setSocket(rs.getString("cpu_socket"));
                        // producto.setNucleos(rs.getInt("cpu_nucleos"));
                        // producto.setHilos(rs.getInt("cpu_hilos"));
                        // producto.setTdpW(rs.getInt("cpu_tdp_w"));
                    } else if ("RAM".equals(tipoCompotente)) {
                        // producto.setRamCapacidadGb(rs.getInt("ram_capacidad_gb"));
                        // producto.setRamTipo(rs.getString("ram_tipo"));
                        // producto.setRamFrecuenciaMhz(rs.getInt("ram_frecuencia_mhz"));
                    } else if ("ALMACENAMIENTO".equals(tipoCompotente)) {
                        // producto.setAlmTipo(rs.getString("alm_tipo"));
                        // producto.setAlmCapacidadGb(rs.getInt("alm_capacidad_gb"));
                        // producto.setAlmInterfaz(rs.getString("alm_interfaz"));
                    }

                    lista.add(producto);
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
