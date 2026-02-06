
public class Ram {
	private int ramCapacidadGb;
	private String ramTipo;
	private int ramFrecuenciaMhz;
	Ram(int ramCapacidadGb, String ramTipo, int ramFrecuenciaMhz){
		this.ramCapacidadGb=ramCapacidadGb;
		this.ramTipo=ramTipo;
		this.ramFrecuenciaMhz=ramFrecuenciaMhz;
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
}
