package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

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
		
		System.out.println("SOLVING______________________________________________________");
		
		while (true) {
			
			if (frontiere.isEmpty()) {
				System.out.println("_________________________________________________________________");
				return new Resultat(p, false, (double)(System.currentTimeMillis()-startTime)/1000.0, listeFermes.size() + frontiere.size(), null);
			} else {
				Noeud n = frontiere.remove();
				
				if (n.getEtat().equals(p.getEtatFinal())) {
					System.out.println("_________________________________________________________________");
					return new Resultat(p, true, (double)(System.currentTimeMillis()-startTime)/1000.0, listeFermes.size() + frontiere.size(), n);
				} else if (!listeFermes.contains(n.getEtat())) {
					frontiere.addAll(developper(n, p));
					listeFermes.add(n.getEtat());
					
					System.out.println("noeud " + listeFermes.size() + "\t:\t" + n.getEtat().getPosX() + ", " + n.getEtat().getPosY());
				}
			}
		}
	}
}
