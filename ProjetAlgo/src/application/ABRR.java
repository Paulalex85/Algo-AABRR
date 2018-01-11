package application;
import java.util.ArrayList;
import java.util.List;

public class ABRR {
	
	private int val;
	private ABRR sag;
	private ABRR sad;
	
	public ABRR (int val, ABRR sag, ABRR sad) {
		this.val = val;
		this.sag = sag;
		this.sad = sad;
	}
	
	public ABRR (int val) {
		this.val = val;
	}
	
	public ABRR () {
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public ABRR getSag() {
		return sag;
	}

	public void setSag(ABRR sag) {
		this.sag = sag;
	}

	public ABRR getSad() {
		return sad;
	}

	public void setSad(ABRR sad) {
		this.sad = sad;
	}
	
	public void fillABRR(ArrayList<Integer> data, int deb, int fin) {
		ABRR newsad = new ABRR(), newsag = new ABRR();
		if(data.size() > 2) {
			this.val = data.get(deb);
			int i = deb+1;
			if(deb < fin) {
				while(i<= fin && data.get(deb)<data.get(i)) {
					i++;
				}
				i--;
				if((deb+1) <= i) {
					newsag.fillABRR(data, deb+1, i);
					this.sag = newsag;
				}
				if((i+1) <= fin) {
					newsad.fillABRR(data, i+1, fin);
					this.sad = newsad;
				}
			}
		}
	}
	
	public AABRR convertToAABRR(int k) {
		AABRR aabrr = new AABRR();
		if(k>0) {
			int max = this.getMax();
			int min = this.getMin();
			ArrayList<ArrayList<Integer>> listeIntervalles = new ArrayList<ArrayList<Integer>>();
			int ecart = (max - min)/k;
			int val = min-1;
			for(int i = 0; i<k; i ++) {
				ArrayList<Integer> intervalle = new ArrayList<Integer>();
				val += (ecart+1);
				intervalle.add(val-ecart);
				if (i==k-1)
					intervalle.add(max);
				else
					intervalle.add(val);
				listeIntervalles.add(intervalle);
			}
			aabrr = generateAABRR(listeIntervalles, listeIntervalles.size()/2, listeIntervalles.size()/2, listeIntervalles.size()-1-listeIntervalles.size()/2);
			InsertionEntier insert = new InsertionEntier();
			for(int el : get_list_prefixe()) {
				//System.out.println(el + " " + insert.insertion(aabrr, el));
				insert.insertion(aabrr, el);
			}
		}
		else {
			System.out.println("k ne peut etre négatif");
			return null;
		}
		return aabrr;
	}
	
	private AABRR generateAABRR(ArrayList<ArrayList<Integer>> listeIntervalles, int rac, int tsag, int tsad) {
		AABRR aabrr = new AABRR();
		aabrr.setMin(listeIntervalles.get(rac).get(0));
		aabrr.setMax(listeIntervalles.get(rac).get(1));
		int sag = rac-(1+tsag/2);
		int sad = rac+(1+tsad/2);
		int ntsag = tsag-1;
		int ntsad = tsad-1;
		
		if(tsag > 0) {
			aabrr.setSag(generateAABRR(listeIntervalles, sag, ntsag/2, ntsag-ntsag/2));
		}
		if(tsad > 0){
			aabrr.setSad(generateAABRR(listeIntervalles, sad, ntsad+ntsad/2, ntsad/2));
		}
		return aabrr;
	}
	
	private int getMin() {
		return getMin(this.sag);
	}
	
	private int getMin(ABRR abr) {
		if (abr.sag == null) {
			return abr.val;
		}
		return getMin(abr.sag);
	}
	
	private int getMax() {
		return getMax(this.sad);
	}
	
	private int getMax(ABRR abr) {
		if (abr.sad == null) {
			return abr.val;
		}
		return getMax(abr.sad);
	}
	
	private void aff(ABRR a, int prof) {
		for (int i=1; i < prof; i++) {
			if(i+1 == prof)
				System.out.printf("|___ ");
			else
				System.out.printf("|    ");
		}
		System.out.printf("["+a.val+"]\n");
	    if (a.sag != null) 
	    		aff(a.sag, prof + 1);
	    if (a.sad != null) 
	    		aff(a.sad, prof + 1);
	}
	
	public void afficherStruct() {
		aff(this, 1);
	}

	public List<Integer> get_list_prefixe(){
		List<Integer> list_value_prefixe = new ArrayList<Integer>();
		
		parcours_prefixe(this, list_value_prefixe);
		
		return list_value_prefixe;
	}
	
	public String toString() {
		String ligne ="";
		List<Integer> list_prefixe = get_list_prefixe();
		
		for(int i = 0; i< list_prefixe.size(); i++) {
			if(i != 0) {
				ligne += ":";
			}
			ligne += list_prefixe.get(i);
		}
		
		return ligne;
	}
	
	public List<Integer> parcours_prefixe(){
		List<Integer> l = new ArrayList<Integer>();
		return parcours_prefixe(this, l);
	}
	
	private List<Integer> parcours_prefixe(ABRR arbre, List<Integer> list) {
		list.add(arbre.val);
		if(arbre.sag != null) {
			parcours_prefixe(arbre.sag, list);
		}
		
		if(arbre.sad != null) {
			parcours_prefixe(arbre.sad, list);
		}
		
		return list;
	}
	
	public List<Integer> parcours_infixe(){
		List<Integer> l = new ArrayList<Integer>();
		return parcours_infixe(this, l);
	}
	
	private List<Integer> parcours_infixe(ABRR arbre, List<Integer> list) {
		
		if(arbre.sag != null) {
			parcours_prefixe(arbre.sag, list);
		}
		list.add(arbre.val);
		if(arbre.sad != null) {
			parcours_prefixe(arbre.sad, list);
		}
		
		return list;
	}
	
	public List<Integer> parcours_sufixe(){
		List<Integer> l = new ArrayList<Integer>();
		return parcours_sufixe(this, l);
	}
	
	private List<Integer> parcours_sufixe(ABRR arbre, List<Integer> list) {
		
		if(arbre.sag != null) {
			parcours_prefixe(arbre.sag, list);
		}
		
		if(arbre.sad != null) {
			parcours_prefixe(arbre.sad, list);
		}
		list.add(arbre.val);
		return list;
	}
	
	public boolean checkABRR(int min, int max) {
		return checkABRR(this, min, max);
    }
	
	public boolean searchValue(int value) {
		return searchValue(value, this);
	}
	
	private boolean searchValue(int value, ABRR a) {
		if(a != null) {
			if(a.val == value)
				return true;
			else if(a.val < value )
				return searchValue(value, a.sag);
			else
				return searchValue(value, a.sad);
		}
		else
			return false;
	}
	
	private ABRR getGreatestSAG() {
		return getGreatestSAG(sag);
	}
	
	private ABRR getGreatestSAG(ABRR abr) {
		return abr.sad == null ? abr : getGreatestSAG(abr.sad);
	}
	
	public void deletteValueFromABRR(int x) {
		ABRR abr = deletteValueFromABRR(x, this);
		this.val = abr.val;
		this.sag = abr.sag;
		this.sad = abr.sad;
	}
	
	/*3 cas
	 * 1er : a est feuille => suppression immédiate (impossible si seul noeud dans arbre)
	 * 2eme : a possède un fils => remplacement de a par ce fils
	 * 3 eme : a possède 2 fils => echanger a par le plus grand 
	 * 	fils du sag de a et ensuite supprimer a (qui possède 
	 * 	0 ou 1 fils)
	 * */
	private ABRR deletteValueFromABRR(int x, ABRR abr) {
	  if (abr == null)
	    return abr;
	  if (x == abr.val) {
		  return deletteABRR(abr);
	  }
	  if (x > abr.val)
	    abr.sag = deletteValueFromABRR(x, abr.sag);
	  else 
	    abr.sad = deletteValueFromABRR(x, abr.sad);
	  return abr;
	}
	
	private ABRR deletteABRR(ABRR abr) {
	  if (abr.sag == null)
		  return abr.sad;
	  if (abr.sad == null)
		  return abr.sag;
	  ABRR gsag = abr.getGreatestSAG();
	  abr.val = gsag.val;
	  abr.sag = deletteValueFromABRR(gsag.val, abr.sag);
	  return abr;
	}
	
    private boolean checkABRR(ABRR abr, int min, int max) {
		if (abr == null)
			return true;
		if (abr.val < min || abr.val > max)
			return false;
		if ((abr.sag != null) && (abr.sag.getVal() < abr.getVal()))
			return false;
		if ((abr.sad != null) && (abr.sad.getVal() > abr.getVal()))
			return false;
		return (checkABRR(abr.sag, min, max) && checkABRR(abr.sad, min, max));
    }

}
