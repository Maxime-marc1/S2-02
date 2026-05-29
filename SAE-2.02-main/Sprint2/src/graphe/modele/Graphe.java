package graphe.modele;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graphe implements IGraphe {
	private HashMap<IEntite,Set<RelationSortante>> graphe;
	
	public Graphe() {
		this.graphe = new HashMap<IEntite, Set<RelationSortante>>();
	}
	
	@Override
	public boolean ajouterEntite(IEntite entite) {
		if(this.graphe.containsKey(entite))
			return false;
		this.graphe.put(entite, new HashSet<>());
		return true;
	}
	
	@Override
	public boolean ajouterRelation(IEntite source, IEntite cible, NatureRelation nature) {
		if (!this.graphe.containsKey(source)) {
			this.ajouterEntite(source);
		}		
		if (!this.graphe.containsKey(cible)) {
			this.ajouterEntite(cible);
		}
		if (this.relationExistante(source, cible, nature)) {
			return false;
		}
		this.graphe.get(source).add(new RelationSortante(cible, nature));
		return true;
	}
	
	private boolean relationExistante(IEntite source, IEntite cible, NatureRelation nature) {
		for (RelationSortante rel : this.graphe.get(source)) {
			if (rel.cible().equals(cible) && rel.nature() == nature) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder("[ ");
		for (IEntite entite : this.entites()) {
			s.append(entite + " : { ");
			for (RelationSortante succ : this.graphe.get(entite)) {
				s.append(succ.cible());
				s.append(", ");
			}
			s.append("}, ");
		}
		return s + "]";
	}

	@Override
	public Set<IEntite> entites() {
		return this.graphe.keySet();
	}

	@Override
	public Set<RelationSortante> relationsSortantes(IEntite source) {
		if (!this.graphe.containsKey(source)) {
			return Set.of();
		}
		return Set.copyOf(this.graphe.get(source));
	}

	@Override
	public Set<RelationEntrante> relationsEntrantes(IEntite cible) {
		Set<RelationEntrante> tmp = new HashSet<>();
		for (IEntite parent : this.entites()) {
			for (RelationSortante rel : this.relationsSortantes(parent)) {
				if (rel.cible().equals(cible)) {
					tmp.add(new RelationEntrante(parent, rel.nature()));
				}
			}
		}
		return Set.copyOf(tmp);
	}
}
