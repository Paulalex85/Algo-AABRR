
public class AABRRversABR {
	ABRR retour;
	public AABRRversABR() {
		
	}
	
	public ABRR transformationVersABR(AABRR arbre) {
		retour = null;
		
		parcoursAABRR(arbre);
		
		return retour;
	}
	
	private void parcoursAABRR(AABRR arbre) {
		if(arbre!= null) {
			parcoursABRR(arbre.getA());
			parcoursAABRR(arbre.getSag());
			parcoursAABRR(arbre.getSad());
		}
	}
	
	private void parcoursABRR(ABRR arbre) {
		if(arbre!= null) {
			ajoutElementABR(retour, arbre.getVal());
			parcoursABRR(arbre.getSag());
			parcoursABRR(arbre.getSad());
		}
	}
	
	
	private void ajoutElementABR(ABRR arbre, int x) {
		if(arbre.getVal() >= x ) {
			if(arbre.getSag() == null) {
				arbre.setSag(new ABRR(x, null, null));
			}else {
				ajoutElementABR(arbre.getSag(), x);
			}
		}else {
			if(arbre.getSad() == null) {
				arbre.setSad(new ABRR(x, null, null));
			}else {
				ajoutElementABR(arbre.getSad(), x);
			}
		}
	}
}
