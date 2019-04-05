package solution;

import java.util.ArrayList;
import java.util.List;

import probleme.Etat;
import probleme.Probleme;
import probleme.action.Deplacement;

public interface Solver {
	public Resultat resoudre(Probleme p);
	
	default public List<Noeud> developper(Noeud n, Probleme p, ArrayList<Noeud> frontiere, ArrayList<Etat> fermes) {
		List<Noeud> successeurs = new ArrayList<>();
		
		Etat e = n.getEtat();
		
		for (Deplacement a : p.getDeplacements()) {
			
			if (a.possible(e)) {
				int profondeur = n.getProfondeur()+1;
				double cout = n.getCoutChemin() + a.getCout();
				Etat next = e.faireDeplacement(a);
				Noeud n2 = new Noeud(next, n, a, cout, profondeur);
				
				if (!frontiere.contains(n2) && !fermes.contains(n2.getEtat()))
					successeurs.add(n2);
			}
		}
		return successeurs;
	}
}
