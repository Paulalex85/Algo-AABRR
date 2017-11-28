public class AABRR { 
	protected ABRR aprime;
	protected AABRR fg; 
	protected AABRR fd;
	protected int max;
	protected int min;
	
	public AABRR(int max, int min, AABRR fg, AABRR fd, ABRR aprime){ 
		this.fg = fg ;
		this.fd = fd;
		this.min = min;
		this.max = max;
		this.aprime = aprime;
	}

	public ABRR getAprime() {
		return aprime;
	}

	public void setAprime(ABRR aprime) {
		this.aprime = aprime;
	}

	public AABRR getFg() {
		return fg;
	}

	public void setFg(AABRR fg) {
		this.fg = fg;
	}

	public AABRR getFd() {
		return fd;
	}

	public void setFd(AABRR fd) {
		this.fd = fd;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	public void exporter(){
		String s="";
		s += min + " " + max;
		System.out.println(s);
	}
}
