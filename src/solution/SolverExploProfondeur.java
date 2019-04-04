package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import probleme.Etat;
import probleme.Probleme;

/**
 * Classe permettant la résolution de problèmes en utilisant l'exploration d'arbres en profondeur
 */
public class SolverExploProfondeur implements Solver{
	
	/**
	 * Résoud un problème donné en utilisant un algorithme d'exploration d'arbre de profondeur
	 * @param p le problème à résoudre
	 * @return la solution au problème et des données statistiques concernant la résolution
	 */
	public Resultat resoudre(Probleme p) {
		
		ArrayList<Etat> listeFermes = new ArrayList<>();
		ArrayList<Noeud> frontiere = new ArrayList<>();
		
		// ajout de l'état initial
		frontiere.add(new Noeud(p.getEtatInitial(), null, null, 0, 0));
		
		long startTime = System.currentTimeMillis();
		
		int etapes = 1;
		int tmp = 1;
		while (true) {
			if(frontiere.isEmpty()) {
				return new Resultat(p, false, (double)(System.currentTimeMillis()-startTime)/1000.0, etapes, null);
			}else {
				Noeud n = frontiere.remove(frontiere.size()-tmp);
				if (n.getEtat().equals(p.getEtatFinal())) {
					return new Resultat(p, true, (double)(System.currentTimeMillis()-startTime)/1000.0, etapes, n);
				} else if (!listeFermes.contains(n.getEtat())) {
					List<Noeud> ns = developper(n, p);
					etapes += ns.size();
					frontiere.addAll(ns);
					listeFermes.add(n.getEtat());
				}
			}
		}
	}
}
