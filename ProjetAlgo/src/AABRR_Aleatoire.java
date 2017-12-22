import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class AABRR_Aleatoire {

	int current_min;
	
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
			Queue<AABRR> queue = new LinkedList<AABRR>();
			
			queue.add(generate);
			int reste = p -1; // correspond au nombre a creer
			
			while(reste > 0 && !queue.isEmpty()) { // tant que il faut ajouter des noeuds
				if(queue.peek().getSag() == null) {
					queue.peek().setSag(new AABRR(null, null, null, 0, 0));
					queue.add(queue.peek().getSag());
					reste--;
				}
				else if(queue.peek().getSad() == null) {
					queue.peek().setSad(new AABRR(null, null, null, 0, 0));
					queue.add(queue.peek().getSad());
					reste--;
				}
				else {
					queue.poll();
				}
			}
			
			//on parcours le AABRR pour fixer les valeurs min max et créer le ABRR
			current_min = 0;
			ParcoursInfixeAABRR(generate, (int)(q/p));
			
			
		}
		
		return generate;
	}
	
	private void ParcoursInfixeAABRR(AABRR arbre, int interval) {
		if(arbre.getSag() != null) {
			ParcoursInfixeAABRR(arbre.getSag(), interval);
		}
		CreationABRR(arbre, current_min, current_min + interval);
		if(arbre.getSad() != null) {
			ParcoursInfixeAABRR(arbre.getSad(), interval);
		}
	}
	
	private void CreationABRR(AABRR arbre,  int min, int max) {
		current_min = max;
		arbre.setMax(max-1);
		arbre.setMin(min);
		Random rand = new Random();
		for(int i = 0; i < 3; i++) {
			arbre.addValueABRR(min + rand.nextInt(arbre.getMax() - min) , arbre.getA());
		}
	}
	
}
