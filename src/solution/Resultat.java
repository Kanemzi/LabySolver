package solution;

public class Resultat {
	private double time;
	private int etapes;
	private boolean found;
	private Noeud noeudFinal;

	public Resultat(boolean found, double time, int etapes, Noeud noeudFinal) {
		this.noeudFinal = noeudFinal;
		this.found = found;
		this.time = time;
		this.etapes = etapes;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public int getEtapes() {
		return etapes;
	}

	public void setEtapes(int etapes) {
		this.etapes = etapes;
	}
	
	public boolean isFound() {
		return found;
	}
	
	public Noeud getNoeudFinal() {
		return noeudFinal;
	}
	
	public String toString() {
		String s = "";
		if (found) {
			s += "resolu ";
		} else {
			s += "non resolu ";
		}
		s += "en ";
		s += time + " secondes ( ";
		s += etapes + " )";
		
		return s;
	}
}