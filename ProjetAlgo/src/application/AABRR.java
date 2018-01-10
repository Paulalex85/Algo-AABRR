package application;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AABRR {
	
	private ABRR a;
	private AABRR sag, sad;
	private int min, max;
	
	public AABRR(ABRR a, AABRR sag, AABRR sad, int min, int max) {
		this.a = a;
		this.sag = sag;
		this.sad = sad;
		this.min = min;
		this.max = max;
	}
	
	public AABRR() {
	}
	
	public AABRR(String fileName) {
		List<ArrayList<Integer>> dataInt = new ArrayList<ArrayList<Integer>>();
		//theta(n)
		try {
			Files.lines(new File(fileName).toPath()).map(s -> s.trim())
			.forEach(str -> {
				//On transforme la ligne en liste de str
				String[] myData = str.split("(\\s*:\\s*)|(\\s*;\\s*)");
				ArrayList<Integer> nl = new ArrayList<Integer>(myData.length);
				
				//On convertit la liste de str en liste de int
				for (String s: myData)
					nl.add(Integer.parseInt(s));
				if (myData.length > 2)	
					dataInt.add(nl);
			}
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.fillAABRR(dataInt, 0, dataInt.size()-1);
	}
	
	public ABRR getA() {
		return a;
	}
	
	public void setA(ABRR a) {
		this.a = a;
	}
	
	public AABRR getSag() {
		return sag;
	}
	
	public void setSag(AABRR sag) {
		this.sag = sag;
	}
	
	public AABRR getSad() {
		return sad;
	}
	
	public void setSad(AABRR sad) {
		this.sad = sad;
	}
	
	public int getMin() {
		return min;
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public String toString() {
		return afficherArbre(this);
	}
	
	private String afficherArbre(AABRR arbre) {
		String s= Generate_String(arbre) + "\n";
		if(arbre.getSag() != null) {
			s+=  afficherArbre(arbre.getSag());
		}
		if(arbre.getSad() != null) {
			s+=  afficherArbre(arbre.getSad());
		}
		return s;
	}
	
	private String Generate_String(AABRR arbre) {
		String ligne = arbre.getMin() + ":" + arbre.getMax() + ";" + (arbre.getA()==null?"ø":arbre.getA());
		return ligne;
	}
	
	public boolean checkAABRR() {
		return checkAABRR(this);
    }
	
	private boolean checkAABRR(AABRR abr) {
		//Teste si l'arbre est vide
		if (abr == null)
			return true;
		
		//Teste si l'intervalle du noeud est correct
		if (abr.min >= abr.max || abr.min < 0 || abr.max < 0)
			return false;
		
		//Teste si l'arbre ABR' de a est valide
		if(!abr.getA().checkABRR(abr.min, abr.max))
			return false;
		
		//Teste si les fils droit et gauche de a sont à la bonne place
		if ((abr.sag != null) && (abr.sag.getMin() > abr.getMin()))
			return false;
		if ((abr.sad != null) && (abr.sad.getMax() < abr.getMax()))
			return false;
		
		//Teste si les intervalles des fils sont disjoints
		if ((abr.sag != null) && (abr.sag.getMax() >= abr.getMin()))
			return false;
		if ((abr.sad != null) && (abr.sad.getMin() <= abr.getMax()))
			return false;

		return (checkAABRR(abr.sag) && checkAABRR(abr.sad));
    }
	
	public void fillAABRR(List<ArrayList<Integer>> data, int deb, int fin) {
		ABRR newabrr = new ABRR();
		newabrr.fillABRR(data.get(deb), 2, data.get(deb).size()-1);
		
		AABRR newsad = new AABRR(), newsag = new AABRR();
		
		this.a = newabrr;
		this.min = data.get(deb).get(0);
		this.max = data.get(deb).get(1);

		int i = deb+1;
		if(deb < fin) {
			while(i<= fin && data.get(deb).get(0)>data.get(i).get(0))
				i++;
			i--;
			if((deb+1) <= i) {
				newsag.fillAABRR(data, deb+1, i);
				this.sag = newsag;
			}
			if((i+1) <= fin) {
				newsad.fillAABRR(data, i+1, fin);
				this.sad = newsad;
			}
		}
	}
	
	private AABRR getGreatestSAD() {
		return getGreatestSAD(sad);
	}
	
	private AABRR getGreatestSAD(AABRR abr) {
		return abr.sag == null ? abr : getGreatestSAD(abr.sag);
	}
	
	public void deletteValueABRR(int value) {
		System.out.println("Recherche de "+value+" dans l'AABRR :");
		deletteValueFromAABRR(value, this);
	}
	
	private void deletteValueFromAABRR(int value, AABRR abr) {
		if(value >= abr.min && value <= abr.max) {
			System.out.println("La valeur se trouve dans l'intervalle "+abr.min+" "+abr.max);
			if(abr.getA().getVal() == value && abr.getA().getSad() == null && abr.getA().getSag() == null) {
				abr.a = null;
			}
			else {
				//On récupère le noeud qui contient l'entier recherché
				ABRR ap = abr.getA().searchValue(value);
				if(ap == null)
					System.out.println("La valeur "+value+" ne se trouve pas dans l'ABRR de cet AABRR..." );
				else {
					System.out.println("La valeur "+value+" se trouve bien dans l'ABRR de cet AABRR" );
					//On supprime ce noeud
					ap.deletteABRR();
				}
			}
		}
		else if (abr.sag != null && value < abr.min) {
			deletteValueFromAABRR(value, abr.sag);
		}
		else if (abr.sad != null && value > abr.max) {
			deletteValueFromAABRR(value, abr.sad);
		}
		else {
			System.out.println("La valeur "+value+" ne se trouve pas dans l'AABRR..." );
		}
	}
	
	public void addValueABRR(int value, ABRR arbre) {
		ABRR current_arbre;
		boolean ajoute = false;
		if(value >= min && value <= max) {//vérifie que la valeur est ajoutable 
			if(a == null) {//ajout
				a = new ABRR(value, null, null);
			}else {
				current_arbre = a;
				while(!ajoute) {
					if(value > current_arbre.getVal()) {//va a sag
						if(current_arbre.getSag() == null) {//creation
							ajoute = true;
							current_arbre.setSag(new ABRR(value, null, null));
						}else {
							current_arbre = current_arbre.getSag();
						}
					}
					else {// va a sad
						if(current_arbre.getSad() == null) {//creation
							ajoute = true;
							current_arbre.setSad(new ABRR(value, null, null));
						}else {
							current_arbre = current_arbre.getSad();
						}
					}
				}
			}
		}
	}
}
