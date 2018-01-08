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
	
	public boolean checkABRR(int min, int max) {
		return checkABRR(this, min, max);
    }
	
	public ABRR searchValue(int value) {
		return searchValue(value, this);
	}
	
	private ABRR searchValue(int value, ABRR a) {
		if(a != null) {
			if(a.val == value)
				return a;
			else if(a.val < value )
				return searchValue(value, a.sag);
			else
				return searchValue(value, a.sad);
		}
		else
			return null;
	}
	
	public void deletteValue(int value) {
		/*3 cas
		 * 1er : a est feuille => suppression immédiate
		 * 2eme : a possède un fils => remplacement de a par ce fils
		 * 3 eme : a possède 2 fils => echanger a par le plus grand 
		 * 	fils du sag de a et ensuite supprimer a (qui possède 
		 * 	0 ou 1 fils)
		 * */
		//1er : a est feuille => suppression immédiate
		if(sag == null && sad == null) {
			val = -1;
		}
		else if(sag == null && sad != null) {
			val = sad.val;
			sad.val = -1;
		}
		else if(sag != null && sad == null) {
			val = sag.val;
			sag.val = -1;
		}
		else {
			ABRR gsa = getGreatestSAG();
			val = gsa.val;
			gsa.val = -1;
		}
	}
	
	private ABRR getGreatestSAG() {
		return getGreatestSAG(sag);
	}
	
	private ABRR getGreatestSAG(ABRR a) {
		return a.sad == null ? a : getGreatestSAG(a.sad);
	}
	
	public void clean() {
		if(sad != null && sad.val == -1) {
			sad = null;
		}
		else if(sag != null && sag.val == -1) {
			sag = null;
		}
	}
	
    private boolean checkABRR(ABRR a, int min, int max) {
		if (a == null)
			return true;
		if (a.val < min || a.val > max)
			return false;
		if ((a.sag != null) && (a.sag.getVal() < a.getVal()))
			return false;
		if ((a.sad != null) && (a.sad.getVal() > a.getVal()))
			return false;
		return (checkABRR(a.sag, min, max) && checkABRR(a.sad, min, max));
    }

}
