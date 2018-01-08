package application;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class AABRR_Vers_Fichier {
	
	
	public AABRR_Vers_Fichier() {
		
	}
	
	/***
	 * Fonction pour cr�er le fichier 
	 * @param arbre prend l'arbre courant a ecrire
	 * @param nom_du_fichier Ne pas mettre le .txt
	 */
	public void execute(AABRR arbre, String nom_du_fichier) {
		List<String> list_line = new ArrayList<String>(); // contient toutes les lignes a �crire
		
		parcoursArbre(arbre, list_line);
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(nom_du_fichier + ".txt", "UTF-8"); // cr�e le fichier
			
			for(int i = 0; i < list_line.size(); i++) {
				writer.println(list_line.get(i));
			}
			writer.close();
			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private List<String> parcoursArbre(AABRR arbre, List<String> list_line) {
		list_line.add(Generate_String(arbre));
		
		if(arbre.getSag() != null) {
			parcoursArbre(arbre.getSag(), list_line);
		}
		if(arbre.getSad() != null) {
			parcoursArbre(arbre.getSad(), list_line);
		}
		
		return list_line;
	}
	
	private String Generate_String(AABRR arbre) {
		String ligne = arbre.getMin() + ":" + arbre.getMax() + ";";
		
		List<Integer> list_prefixe = arbre.getA().get_list_prefixe();
		
		for(int i = 0; i< list_prefixe.size(); i++) {
			if(i != 0) {
				ligne += ":";
			}
			ligne += list_prefixe.get(i);
		}
		
		return ligne;
	}
}
