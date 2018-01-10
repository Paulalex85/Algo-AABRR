package application;
public class AlgoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//importation d'un fichier
		/*AABRR aabrr = new AABRR("./ressources/fichierTest.txt");
		System.out.println("Affichage de l'AABRR importé : ");
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
		
		AABRR aabrr = aleatoire.Generation(10, 100);
		//System.out.println(aabrr);
		/*System.out.println(recherche.Rechercher(2, aabrr));
		System.out.println(recherche.Rechercher(5, aabrr));
		System.out.println(recherche.Rechercher(6, aabrr));*/
		
		System.out.println(insert.insertion(aabrr, 2));
		System.out.println(insert.insertion(aabrr, 3));
		System.out.println(insert.insertion(aabrr, 4));
		
		System.out.println(recherche.Rechercher(2, aabrr));
		System.out.println(recherche.Rechercher(3, aabrr));
		System.out.println(recherche.Rechercher(4, aabrr));
		
		System.out.println(aabrr);
		
		System.out.println("********");
		
		ABRR test = toAbr.transformationVersABR(aabrr);
		
		test.afficherStruct();
		
		
		
	}
}
