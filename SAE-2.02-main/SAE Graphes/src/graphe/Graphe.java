package graphe;

import java.util.ArrayList;

public class Graphe {
	private ArrayList<Noeud> noeuds;
	private ArrayList<Arc> arcs;
	
	public Graphe() {
		this.noeuds = new ArrayList<Noeud>();
		this.arcs = new ArrayList<Arc>();
	}
	
	public ArrayList<Noeud> noeuds() {
		return noeuds;
	}
	public ArrayList<Arc> arcs() {
		return arcs;
	}
	
	public void ajouterNoeud(Noeud n) 
	throws IllegalArgumentException {
		if (this.contientNoeud(n)) {
			throw new IllegalArgumentException("Ce noeud est déjà dans le graphe.");
		}
		this.noeuds.add(n);
	}
	public void ajouterArc(Arc a) {
		this.arcs.add(a);
	}
	
	public int ordre() {
		return noeuds.size();
	}
	
	public String toString() {
		String sommets = "Noeuds :\n";
		for (Noeud n : this.noeuds()) {
			sommets += n.toString();
			sommets += " ; ";
		}
		String liens = "\nliens :\n";
		for (Arc a : this.arcs()){
			liens += "(";
			liens += a.toString();
			liens += ") ; ";
		}
		return sommets + liens;
	}
	
	public boolean contientNoeud(Noeud n) {
		for (Noeud sommet : this.noeuds()) {
			if (sommet.nom() == n.nom()) {
				return true;
			}
		}
		return false;
	}
}
