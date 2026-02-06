
public class Almacenamiento {
	private String almTipo;
	private int almCapacidadGb;
	private String almInterfaz;
	Almacenamiento(String almTipo,int almCapacidadGb,String almInterfaz){
		this.almTipo=almTipo;
		this.almCapacidadGb=almCapacidadGb;
		this.almInterfaz=almInterfaz;
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
}
