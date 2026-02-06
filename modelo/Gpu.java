
public class Gpu {
	private int gpuVramGb;
	private int gpuConsumoW;
	private String gpuChipset;
	
	Gpu(int gpuVramGb, int gpuConsumoW, String gpuChipset){
		this.gpuVramGb=gpuVramGb;
		this.gpuConsumoW=gpuConsumoW;
		this.gpuChipset=gpuChipset;
	}
	public int getGpuVramGb() {
		return gpuVramGb;
	}
	public void setGpuVramGb(int gpuVramGb) {
		this.gpuVramGb = gpuVramGb;
	}
	public int getGpuConsumoW() {
		return gpuConsumoW;
	}
	public void setGpuConsumoW(int gpuConsumoW) {
		this.gpuConsumoW = gpuConsumoW;
	}
	public String getGpuChipset() {
		return gpuChipset;
	}
	public void setGpuChipset(String gpuChipset) {
		this.gpuChipset = gpuChipset;
	}
}
