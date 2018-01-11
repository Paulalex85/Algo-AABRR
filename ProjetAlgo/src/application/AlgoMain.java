package application;

import java.util.Scanner;

public class AlgoMain {

	public static void main(String[] args) {
		
		int opcode = -1;
		Scanner sc = new Scanner(System.in);
		AABRR aabrr = null;
		ABRR abr = null;
		AABRR_Aleatoire aleatoire = new AABRR_Aleatoire();
		AABRR_Vers_Fichier fichier = new AABRR_Vers_Fichier();
		RechercheEntier recherche = new RechercheEntier();
		InsertionEntier insert = new InsertionEntier();
		AABRRversABR toAbr = new AABRRversABR();
		
		
		while(opcode != 0) {
			System.out.println("*****");
			System.out.println("0 - Sortie");
			System.out.println("1 - Fichier vers AABRR");
			System.out.println("2 - AABRR vers Fichier");
			System.out.println("3 - Affichage a l'ecran");
			System.out.println("4 - AABRR aleatoire");
			System.out.println("5 - Verification");
			System.out.println("6 - Recherche d un entier");
			System.out.println("7 - Suppression d un entier");
			System.out.println("8 - Insertion d un entier");
			System.out.println("9 - ABR vers AABRR");
			System.out.println("10 - AABRR vers ABR");
			System.out.println("Entrez le code voulu");
			opcode = sc.nextInt();
			
			switch (opcode) {
			case 0:
				break;
			case 1:
				System.out.println("Entrer le chemin du fichier");
				sc.nextLine();
				String chemin = sc.nextLine();
				aabrr = new AABRR(chemin);
				break;
			case 2:
				System.out.println("Entrer le nom du fichier sans l'extention");
				sc.nextLine();
				String nom_fichier = sc.nextLine();
				fichier.execute(aabrr, nom_fichier);
				break;
			case 3:
				System.out.println(aabrr);
				break;
			case 4:
				int noeuds= 0 , val_max = 0;
				while (noeuds <= 1 || val_max <= 1) {
					System.out.println("Entrer le nombre de noeuds, doit etre > 1 ");
					noeuds = sc.nextInt();
					System.out.println("Entrer la valeur max possible, doit etre > 1");
					val_max = sc.nextInt();
				}
				aabrr = aleatoire.Generation(noeuds,val_max);
				break;
			case 5:
				System.out.println("ABR a correct ? "+(aabrr.checkAABRR()?"oui.":"non."));			
				break;
			case 6:
				int val_recherche = 0;
				while (val_recherche <= 1) {
					System.out.println("Entrer la valeur recherche, doit etre > 1 ");
					val_recherche = sc.nextInt();
				}
				System.out.println(recherche.Rechercher(val_recherche, aabrr));
				break;
			case 7:
				int val_del = 0;
				while (val_del <= 1) {
					System.out.println("Entrer la valeur a supprimer, doit etre > 1 ");
					val_del = sc.nextInt();
				}
				aabrr.deletteValueABRR(val_del);
				break;
			case 8:
				int val_insert = 0;
				while (val_insert <= 1) {
					System.out.println("Entrer la valeur a inserer, doit etre > 1 ");
					val_insert = sc.nextInt();
				}
				System.out.println(insert.insertion(aabrr, val_insert));
				break;
			case 9:
				aabrr = abr.convertToAABRR(3);
				System.out.println(aabrr);
				break;
			case 10:
				abr = toAbr.transformationVersABR(aabrr);
				abr.afficherStruct();
				break;

			default:
				System.out.println("Entrez un code valide");
				opcode = -1;
				break;
			}
		}
		sc.close();
		
	}
}
