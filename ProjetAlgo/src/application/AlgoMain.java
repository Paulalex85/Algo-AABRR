package application;
public class AlgoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//importation d'un fichier
		AABRR aabrr = new AABRR("./ressources/fichierTest.txt");
		System.out.println("Affichage de l'AABRR importé : ");
		System.out.println(aabrr);
		System.out.println("ABR a correct ? "+(aabrr.checkAABRR()?"oui.":"non."));
		/*
		AABRR_Aleatoire aleatoire = new AABRR_Aleatoire();
		AABRR_Vers_Fichier fichier = new AABRR_Vers_Fichier();
		AABRR test = aleatoire.Generation(10, 100);
		fichier.execute(test, "testjambon");
		*/
		aabrr.deletteValueABRR(80);
		System.out.println(aabrr);
	}
}
