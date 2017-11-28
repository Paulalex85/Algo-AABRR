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

	public List<Integer> get_list_prefixe(){
		List<Integer> list_value_prefixe = new ArrayList<Integer>();
		
		parcours_prefixe(this, list_value_prefixe);
		
		return list_value_prefixe;
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
	
}
