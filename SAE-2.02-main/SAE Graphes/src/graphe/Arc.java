package graphe;

public class Arc {
	private Noeud pred;
	private Noeud succ;
	private String valeur;

	public Arc(Noeud pred, Noeud succ) {
		this.pred = pred;
		this.succ = succ;
	}
	public Arc (Noeud pred, Noeud succ, String valeur) {
		this(pred, succ);
		this.valeur = valeur;
	}
	
	public String toString() {
		return pred + " -> " + succ + " [" + valeur + "]";
	}
}
