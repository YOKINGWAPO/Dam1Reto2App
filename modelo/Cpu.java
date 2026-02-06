
public class Cpu  {
	private String cpuSocket;
	private int cpuNucleos;
	private int cpuHilos;
	private int cpuTdpW;

	Cpu(String cpuSocket,int cpuNucleos,int cpuHilos,int cpuTdpW){
		this.cpuSocket=cpuSocket;
		this.cpuNucleos=cpuNucleos;
		this.cpuHilos=cpuHilos;
		this.cpuTdpW=cpuTdpW;
	}

	public String getCpuSocket() {
		return cpuSocket;
	}

	public void setCpuSocket(String cpuSocket) {
		this.cpuSocket = cpuSocket;
	}

	public int getCpuNucleos() {
		return cpuNucleos;
	}

	public void setCpuNucleos(int cpuNucleos) {
		this.cpuNucleos = cpuNucleos;
	}

	public int getCpuHilos() {
		return cpuHilos;
	}

	public void setCpuHilos(int cpuHilos) {
		this.cpuHilos = cpuHilos;
	}

	public int getCpuTdpW() {
		return cpuTdpW;
	}

	public void setCpuTdpW(int cpuTdpW) {
		this.cpuTdpW = cpuTdpW;
	}
}
