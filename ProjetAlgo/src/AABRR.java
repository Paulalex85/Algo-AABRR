public class AABRR { 
	private ABRR a;
	private AABRR sag, sad;
	private int min, max;
	
	public AABRR(ABRR a, AABRR sag, AABRR sad, int min, int max) {
		this.a = a;
		this.sag = sag;
		this.sad = sad;
		this.min = min;
		this.max = max;
	}
	
	
	public ABRR getA() {
		return a;
	}
	public void setA(ABRR a) {
		this.a = a;
	}
	public AABRR getSag() {
		return sag;
	}
	public void setSag(AABRR sag) {
		this.sag = sag;
	}
	public AABRR getSad() {
		return sad;
	}
	public void setSad(AABRR sad) {
		this.sad = sad;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
}
