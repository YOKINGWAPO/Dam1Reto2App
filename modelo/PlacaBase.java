
public class PlacaBase {
	private String pbSocket;
	private String pbChipset;
	private String pbFormato;
	private String pbRamTipo;
	PlacaBase(String pbSocket, String pbChipset,String pbFormato,String pbRamTipo ){
		this.pbSocket=pbSocket;
		this.pbChipset=pbChipset;
		this.pbFormato=pbFormato;
		this.pbFormato=pbFormato;
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
}
