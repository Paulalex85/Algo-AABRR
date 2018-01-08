package application;
public class AlgoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//importation d'un fichier
		AABRR a = new AABRR("./ressources/fichierTest.txt");
		System.out.println("Affichage de l'AABRR importé : ");
		System.out.println(a);
		System.out.println("ABR a correct ? "+(a.checkAABRR()?"oui.":"non."));
		/*
		AABRR_Aleatoire aleatoire = new AABRR_Aleatoire();
		AABRR_Vers_Fichier fichier = new AABRR_Vers_Fichier();
		AABRR test = aleatoire.Generation(10, 100);
		fichier.execute(test, "testjambon");
		
		a.deletteValueABRR(32);
		*/
		a.deletteValueABRR(30);
		a.deletteValueABRR(80);
		System.out.println(a);
	}
}
