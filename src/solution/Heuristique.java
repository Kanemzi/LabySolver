package solution;

import probleme.Etat;
import probleme.Probleme;

public interface Heuristique {
	public double appliquer(Probleme p, Etat e);
}
