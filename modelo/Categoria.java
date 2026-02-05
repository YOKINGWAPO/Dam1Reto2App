import java.math.BigDecimal;
import java.sql.Timestamp;

public class Categoria {
	
	private int id_categoria;
	private String nombre;
	private String descripcion;
	private byte[] imagen;
	
		public Categoria(int id_categoria,String nombre,String descripcion,byte[] imagen) {
			
				this.id_categoria=id_categoria;
				this.nombre=nombre;
				this.descripcion=descripcion;
				this.imagen=imagen;
				
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

		public byte[] getImagen() {
			return imagen;
		}

		public void setImagen(byte[] imagen) {
			this.imagen = imagen;
		}

}
