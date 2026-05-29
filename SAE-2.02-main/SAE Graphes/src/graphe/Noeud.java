package graphe;

import java.util.ArrayList;

public class Noeud {
	private String nom;
	private ArrayList<Noeud> succ;
	
	public Noeud (String nom) {
		this.nom = nom;
		this.succ = new ArrayList<Noeud>();
	}
	
	public void ajouterSucc(Noeud n) {
		this.succ.add(n);
	}
	
	public ArrayList<Noeud> succ(){
		return succ;
	}
	
	public String nom() { // Pour l'accès sans préciser toString
		return nom;
	}
	public String toString() {
		return nom;
	}
}
