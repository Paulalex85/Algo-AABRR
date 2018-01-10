package application;

public class RechercheEntier {

	public String Rechercher(int x , AABRR arbre) {
		String reponse = "";
		
		AABRR currentAABRR = parcoursAABRR(arbre, x);
		if(currentAABRR == null) {
			reponse = x + " n est dans aucun AABRR";
		}else {
			if(parcoursABRR(currentAABRR.getA(), x) == null) {
				reponse = x + " n existe pas dans l interval " + currentAABRR.getMin() + " - " + currentAABRR.getMax(); 
			}else {
				reponse = x + " est dans l interval " + currentAABRR.getMin() + " - " + currentAABRR.getMax(); 
			}
		}
		
		return reponse;
	}
	
	private AABRR parcoursAABRR(AABRR arbre, int x) {
		if(arbre.getMax() >= x && arbre.getMin() <= x ) {
			return arbre;
		}else if ( arbre.getMax() < x) {
			if(arbre.getSad() != null) {
				return parcoursAABRR(arbre.getSad(), x);
			}
			else {
				return null;
			}
		}else {
			if(arbre.getSag() != null) {
				return parcoursAABRR(arbre.getSag(), x);
			}
			else {
				return null;
			}
		}
	}
	
	private ABRR parcoursABRR(ABRR arbre, int x) {
		if(arbre != null) {
			if(arbre.getVal() == x) {
				return arbre;
			}else if(arbre.getVal() > x ) {
				return parcoursABRR(arbre.getSad(), x);
			}
			else {
				return parcoursABRR(arbre.getSag(), x);
			}
		}
		else {
			return null;
		}
	}
}


