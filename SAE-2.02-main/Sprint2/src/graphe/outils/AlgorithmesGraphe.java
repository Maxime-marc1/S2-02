package graphe.outils;

import graphe.modele.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class AlgorithmesGraphe {
     /**
     * Retourne les entités qui dépendent directement de la cible
     * via une seule arête de dépendance statique.
     *
     * La relation CONTIENT n'est pas prise en compte.
     */
    public static Set<IEntite> dependantsDirects(IGraphe graphe, IEntite cible) {
    	Set<IEntite> tmp = new HashSet<>();
    	for (RelationSortante relation : graphe.relationsSortantes(cible)) {
    		if (relation.nature().estDependanceStatique()) {
    			tmp.add(relation.cible());
    		}
    	}
		return tmp;

    }

    /**
     * Retourne les dépendants directs de la cible, puis remonte par contenance :
     * - à travers les types contenants éventuels ;
     * - jusqu'au premier paquetage rencontré, inclus ;
     * - sans jamais remonter au-delà de ce premier paquetage ;
     * - sans erreur si aucun paquetage englobant n'existe.
     */
    public static Set<IEntite> dependantsElargis(IGraphe graphe, IEntite cible) {
    	Set<IEntite> tmp = new HashSet<>();
		return dependantsRecursif(graphe, cible, tmp);
    }
    
    private static Set<IEntite> dependantsRecursif(IGraphe graphe, IEntite cible, Set<IEntite> set){
    	if (!cible.estType()) {
    		set.add(cible);
    	}
    	else {
    		Set<IEntite> tmp = dependantsDirects(graphe, cible);
    		for (IEntite dep : tmp) {
    			set.add(dep);
    			dependantsRecursif(graphe, dep, set);
    		}
    	}	
    	return set;
    }

}
