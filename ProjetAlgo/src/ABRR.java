
public class ABRR {
	protected ABRR a;
	protected ABRR fg; 
	protected ABRR fd;
	protected int k;
	
	public ABRR(ABRR a, ABRR fg, ABRR fd, int k) {
		this.a = a;
		this.fg = fg;
		this.fd = fd;
		this.k = k;
	}
	public ABRR getA() {
		return a;
	}
	public void setA(ABRR a) {
		this.a = a;
	}
	public ABRR getFg() {
		return fg;
	}
	public void setFg(ABRR fg) {
		this.fg = fg;
	}
	public ABRR getFd() {
		return fd;
	}
	public void setFd(ABRR fd) {
		this.fd = fd;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	
}
