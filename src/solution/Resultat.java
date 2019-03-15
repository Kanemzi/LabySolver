package solution;

public class Resultat {
	private double time;
	private int etapes;

	public Resultat(double time, int etapes) {
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
	
}