
public class Cascos {
	private String casConexion;
	private int casMicrofono;
	Cascos(String casConexion,int casMicrofono){
		this.casConexion=casConexion;
		this.casMicrofono=casMicrofono;
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
}
