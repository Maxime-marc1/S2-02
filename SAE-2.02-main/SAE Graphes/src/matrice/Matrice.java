package matrice;

public class Matrice {
	private String[][] matrice;
	
	public Matrice() {
		this(0);
	}
	public Matrice(int taille) { // pour la copie
		this.matrice = new String[taille+1][taille+1];
		matrice[0][0] = " ";
	}
	
	public void ajouterNoeud(String n)
	throws IllegalArgumentException {
		if (this.contientNoeud(n) != 0) {
			throw new IllegalArgumentException("Ce noeud est déjà dans le graphe.");
		}
		Matrice tmp = new Matrice(this.matrice.length);
		tmp.copie(this);
		tmp.matrice[0][tmp.matrice.length-1] = n;
		tmp.matrice[tmp.matrice.length-1][0] = n;
		this.matrice = tmp.matrice;
	}

	public void ajouterArc(String pred, String succ, String val) {
		int i = this.contientNoeud(pred);
		if (i == 0) {
			throw new IllegalArgumentException("Le noeud " + pred + " n'est pas dans la matrice.");
		}
		int j = this.contientNoeud(succ);
		if (j == 0) {
			throw new IllegalArgumentException("Le noeud " + succ + " n'est pas dans la matrice.");
		}
		this.matrice[i][j] = val;
	}
	
	public void copie(Matrice m) {
		for (int i = 0; i < m.matrice.length ; ++i) {
			for (int j = 0; j < m.matrice[0].length ; ++j) {
				this.matrice[i][j] = m.matrice[i][j];
			}
		}
	}
	
	/**Renvoie l'indice du noeud n s'il est dans la matrice, 0 sinon.
	 * @param n le noeud cherché (String)
	 * @return int si dans la matrice, 0 sinon
	 */
	public int contientNoeud(String n) {
		for (int i=1; i<matrice[0].length; ++i) {
			if (matrice[0][i] == n) {
				return i;
			}
		}
		return 0; // Possible car matrice[0][0] ne contient pas de noeud mais une chaîne vide
	}
	
	public String toString() {
		String m = "";
		for (int i = 0; i < matrice.length ; ++i) {
			m += "[ ";
			for (int j = 0; j < matrice.length ; ++j) {
				m += matrice[i][j];
				m += " ; ";
			}
			m += "]\n";
		}
		return m;
	}
}
