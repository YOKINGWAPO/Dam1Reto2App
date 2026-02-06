
public class Monitor {
	private int monTamanoPulg;
	private String monResolucion;
	private int monHz;
	private String monPanel;
	Monitor(int monTamanoPulg, String monResolucion, int monHz,String monPanel){
		this.monTamanoPulg=monTamanoPulg;
		this.monResolucion=monResolucion;
		this.monHz=monHz;
		this.monPanel=monPanel;
	}
	public int getMonTamanoPulg() {
		return monTamanoPulg;
	}
	public void setMonTamanoPulg(int monTamanoPulg) {
		this.monTamanoPulg = monTamanoPulg;
	}
	public String getMonResolucion() {
		return monResolucion;
	}
	public void setMonResolucion(String monResolucion) {
		this.monResolucion = monResolucion;
	}
	public int getMonHz() {
		return monHz;
	}
	public void setMonHz(int monHz) {
		this.monHz = monHz;
	}
	public String getMonPanel() {
		return monPanel;
	}
	public void setMonPanel(String monPanel) {
		this.monPanel = monPanel;
	}
}
