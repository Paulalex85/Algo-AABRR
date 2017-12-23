
public class InsertionEntier {
	public InsertionEntier() {
		
	}
	
	public String insertion(AABRR arbre, int x) {
		String retour = "";
		
		AABRR current_AABRR = rechercheAABRR(arbre, x);
		
		if(current_AABRR == null) {
			retour = "Pas d AABRR dans l interval de x";
		}else {
			ajoutDansABRR(current_AABRR.getA(), x);
			retour = x + " ajouté dans l interval " + current_AABRR.getMin() + " - " + current_AABRR.getMax();
		}
		return retour;
	}
	
	private AABRR rechercheAABRR(AABRR arbre, int x) {
		if(arbre == null) {
			return null;
		}else {
			if(arbre.getMin() <= x && arbre.getMax() >= x) {
				return arbre;
			}
			else if( arbre.getMin() < x) {
				return rechercheAABRR(arbre.getSag(), x);
			}else {
				return rechercheAABRR(arbre.getSad(), x);
			}
		}
	}
	
	private void ajoutDansABRR(ABRR arbre, int x) {
		if(arbre.getVal() < x ) {
			if(arbre.getSag() == null) {
				arbre.setSag(new ABRR(x, null, null));
			}else {
				ajoutDansABRR(arbre.getSag(), x);
			}
		}else {
			if(arbre.getSad() == null) {
				arbre.setSad(new ABRR(x, null, null));
			}else {
				ajoutDansABRR(arbre.getSad(), x);
			}
		}
	}
}
