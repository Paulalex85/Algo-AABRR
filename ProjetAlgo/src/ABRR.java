
public class ABRR {
	
	private int val;
	private ABRR sag;
	private ABRR sad;
	
	public ABRR (int val, ABRR sag, ABRR sad) {
		this.val = val;
		this.sag = sag;
		this.sad = sad;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
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

	
}
