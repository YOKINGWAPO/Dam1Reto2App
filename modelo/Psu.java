
public class Psu {
	private String psuCertificacion;
	private int psuPotenciaW;
	private int psuModular;
	Psu(String psuCertificacion,int psuPotenciaW, int psuModular){
		this.psuCertificacion=psuCertificacion;
		this.psuPotenciaW=psuPotenciaW;
		this.psuModular=psuModular;
	}
	public String getPsuCertificacion() {
		return psuCertificacion;
	}
	public void setPsuCertificacion(String psuCertificacion) {
		this.psuCertificacion = psuCertificacion;
	}
	public int getPsuPotenciaW() {
		return psuPotenciaW;
	}
	public void setPsuPotenciaW(int psuPotenciaW) {
		this.psuPotenciaW = psuPotenciaW;
	}
	public int getPsuModular() {
		return psuModular;
	}
	public void setPsuModular(int psuModular) {
		this.psuModular = psuModular;
	}
}
