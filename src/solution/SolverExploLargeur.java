package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import probleme.Etat;
import probleme.Probleme;

/**
 * Classe permettant la résolution de problèmes en utilisant l'exploration d'arbres en largeur
 */
public class SolverExploLargeur implements Solver {
	
	/**
	 * Résoud un problème donné en utilisant un algorithme d'exploration d'arbre de largeur
	 * @param p le problème à résoudre
	 * @return la solution au problème et des données statistiques concernant la résolution
	 */
	public Resultat resoudre(Probleme p) {
		
		Queue<Noeud> frontiere = new LinkedList<>();
		ArrayList<Etat> listeFermes = new ArrayList<>();
		
		// ajout de l'état initial
		frontiere.add(new Noeud(p.getEtatInitial(), null, null, 0, 0));
		
		long startTime = System.currentTimeMillis();
		
		int etapes = 0;
		
		while (true) {
			etapes ++;
			
			if (frontiere.isEmpty()) {
				return new Resultat(false, (double)(System.currentTimeMillis()-startTime)/1000.0, etapes, null);
			} else {
				Noeud n = frontiere.remove();
				if (n.getEtat().equals(p.getEtatFinal())) {
					return new Resultat(true, (double)(System.currentTimeMillis()-startTime)/1000.0, etapes, n);
				} else if (!listeFermes.contains(n.getEtat())) {
					frontiere.addAll(developper(n, p));
					listeFermes.add(n.getEtat());
				}
			}
		}
	}
}
