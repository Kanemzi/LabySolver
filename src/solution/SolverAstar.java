package solution;

import java.util.ArrayList;

import probleme.Etat;
import probleme.Probleme;

public class SolverAstar implements Solver {
	
	private Heuristique h;
	
	public SolverAstar(Heuristique h) {
		this.h = h;
	}
	
	/**
	 * Résoud un problème donné en utilisant un algorithme d'exploration d'arbre de largeur
	 * @param p le problème à résoudre
	 * @return la solution au problème et des données statistiques concernant la résolution
	 */
	public Resultat resoudre(Probleme p) {
		
		ArrayList<Noeud> frontiere = new ArrayList<>();
		ArrayList<Etat> listeFermes = new ArrayList<>();
		
		// ajout de l'état initial
		frontiere.add(new Noeud(p.getEtatInitial(), null, null, 0, 0));
		
		long startTime = System.currentTimeMillis();
		
		int etapes = 0;
		
		while (true) {
			etapes ++;
			
			if (frontiere.isEmpty()) {
				return new Resultat(p, false, (double)(System.currentTimeMillis()-startTime)/1000.0, etapes, null);
			} else {
				
				Noeud n = prendreNoeudPlusProche(frontiere, p);
				
				if (n.getEtat().equals(p.getEtatFinal())) {
					return new Resultat(p, true, (double)(System.currentTimeMillis()-startTime)/1000.0, etapes, n);
				} else if (!listeFermes.contains(n.getEtat())) {
					frontiere.addAll(developper(n, p));
					listeFermes.add(n.getEtat());
				}
			}
		}
	}
	
	/**
	 * Supprime le noeud le plus proche de la solution de la frontière et le retourne.
	 * 
	 * @param frontiere la frontière actuelle
	 * @param p le problème à résoudre
	 * @return le noeud le plus proche de la solution selon l'heuristique définie pour le solveur
	 */
	public Noeud prendreNoeudPlusProche(ArrayList<Noeud> frontiere, Probleme p) {
		Noeud noeudProche = null;
		double minCout = Double.MAX_VALUE;
		
		for (Noeud n : frontiere) {
			double cout = n.getCoutChemin() + h.appliquer(p, n.getEtat());
			if (cout < minCout) {
				minCout = cout;
				noeudProche = n;
			}
		}
		
		frontiere.remove(noeudProche);
		
		return noeudProche;
	}
}
