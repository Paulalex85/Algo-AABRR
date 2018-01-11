package application;
public class AlgoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//importation d'un fichier
		/*AABRR aabrr = new AABRR("./ressources/fichierTest.txt");
		System.out.println("Affichage de l'AABRR import� : ");
		System.out.println(aabrr);
		System.out.println("ABR a correct ? "+(aabrr.checkAABRR()?"oui.":"non."));
		/*
		AABRR_Aleatoire aleatoire = new AABRR_Aleatoire();
		AABRR_Vers_Fichier fichier = new AABRR_Vers_Fichier();
		AABRR test = aleatoire.Generation(10, 100);
		fichier.execute(test, "testjambon");
		
		aabrr.deletteValueABRR(32);
		aabrr.deletteValueABRR(80);
		*/
		
		/*aabrr.deletteValueABRR(9);
		System.out.println(aabrr.getSag());*/
		
		AABRR_Aleatoire aleatoire = new AABRR_Aleatoire();
		RechercheEntier recherche = new RechercheEntier();
		InsertionEntier insert = new InsertionEntier();
		AABRRversABR toAbr = new AABRRversABR();
		
		
		
		System.out.println("********");
		AABRR aabrr = new AABRR("./ressources/fichierTest2.txt");
		System.out.println(aabrr);
		System.out.println("********");
		ABRR test = toAbr.transformationVersABR(aabrr);
		test.afficherStruct();
		System.out.println("**********");
		AABRR testaabrr = test.convertToAABRR(3);
		System.out.println(testaabrr);
		
		
		
	}
}
