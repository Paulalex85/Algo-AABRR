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
	
	public void addValueABRR(int value, ABRR arbre) {
		ABRR current_arbre;
		boolean ajoute = false;
		if(value >= min && value <= max) {//vérifie que la valeur est ajoutable 
			if(a == null) {//ajout
				a = new ABRR(value, null, null);
			}else {
				current_arbre = a;
				while(!ajoute) {
					if(value > current_arbre.getVal()) {//va a sag
						if(current_arbre.getSag() == null) {//creation
							ajoute = true;
							current_arbre.setSag(new ABRR(value, null, null));
						}else {
							current_arbre = current_arbre.getSag();
						}
					}
					else {// va a sad
						if(current_arbre.getSad() == null) {//creation
							ajoute = true;
							current_arbre.setSad(new ABRR(value, null, null));
						}else {
							current_arbre = current_arbre.getSad();
						}
					}
				}
			}
		}
	}
}
