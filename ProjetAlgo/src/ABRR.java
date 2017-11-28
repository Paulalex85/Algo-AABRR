
public class ABRR {
	protected ABRR a, sag, sad;
	protected int min, max;
	
	public ABRR(ABRR a, ABRR sag, ABRR sad, int min, int max) {
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
	public ABRR getSag() {
		return sag;
	}
	public void setSag(ABRR sag) {
		this.sag = sag;
	}
	public ABRR getSad() {
		return sad;
	}
	public void setSad(ABRR sad) {
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
