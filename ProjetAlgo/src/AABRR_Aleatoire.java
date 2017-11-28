import java.util.Stack;

public class AABRR_Aleatoire {

	
	public AABRR_Aleatoire() {
		
	}
	
	
	/***
	 * 
	 * @param p : Nombres de Noeuds
	 * @param q : Valeur max des données de l'arbre, doit etre > 1
	 * @return retourne l'arbre aabrr généré
	 */
	public AABRR Generation(int p, int q) {
		AABRR generate = new AABRR(null, null, null, 0, 0);
		
		if( p > 1 && q > 1) {
			
			//créer une pile pour créer l'arbre
			Stack<AABRR> pile = new Stack<AABRR>(); 
			pile.push(generate);
			int reste = p -1; // correspond au nombre a creer
			
			while(reste > 0 && !pile.isEmpty()) { // tant que il faut ajouter des noeuds
				if(pile.peek().getSag() == null) {
					pile.peek().setSag(new AABRR(null, null, null, 0, 0));
					pile.push(pile.peek().getSag());
					reste--;
				}
				else if(pile.peek().getSad() == null) {
					pile.peek().setSad(new AABRR(null, null, null, 0, 0));
					pile.push(pile.peek().getSad());
					reste--;
				}
				else {
					pile.pop();
				}
			}
			
			//on parcours le AABRR pour fixer les valeurs min max et créer le ABRR
			
			
			
		}
		
		return generate;
	}
	
	private void ParcoursInfixeAABRR(AABRR arbre) {
		//CreationABRR(arbre.getSag());
		//action
		//CreationABRR(arbre.getSad());
	}
}
