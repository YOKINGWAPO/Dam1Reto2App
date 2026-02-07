import java.math.BigDecimal;
import java.sql.Timestamp;

public class Categoria {
	
	
	private String nombre;
	
	private byte[] imagen;
	
		public Categoria(String nombre,byte[] imagen) {
			
				
				this.nombre=nombre;
				this.imagen=imagen;
				
		}

		

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		

		public byte[] getImagen() {
			return imagen;
		}

		public void setImagen(byte[] imagen) {
			this.imagen = imagen;
		}

}
