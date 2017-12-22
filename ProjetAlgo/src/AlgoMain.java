
public class AlgoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AABRR_Aleatoire aleatoire = new AABRR_Aleatoire();
		AABRR_Vers_Fichier fichier = new AABRR_Vers_Fichier();
		
		AABRR test = aleatoire.Generation(10, 100);
		fichier.execute(test, "testjambon");
		
	}

}
