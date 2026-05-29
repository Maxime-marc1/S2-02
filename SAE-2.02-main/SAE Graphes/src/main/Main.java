package main;

import graphe.*;
import matrice.*;

public class Main {
	public static void main(String [] args) {
		Graphe g = new Graphe();
		Noeud a = new Noeud("A");
		Noeud b = new Noeud("B");
		System.out.println(g);
		System.out.println(a);
		System.out.println(b);
		
		g.ajouterNoeud(a);
		System.out.println(g);
		g.ajouterNoeud(b);
		System.out.println(g);
		
		Arc ab = new Arc(a,b);
		g.ajouterArc(ab);
		System.out.println(g);
		
		/**
		Noeud a2 = new Noeud("A");
		g.ajouterNoeud(a2);
		System.out.println(g); Ne doit pas fonctionner
		**/
		
		Matrice m = new Matrice();
		System.out.println(m);
		m.ajouterNoeud("A");
		System.out.println(m);
		m.ajouterNoeud("B");
		System.out.println(m);
		//m.ajouterNoeud("A"); Ne doit pas fonctionner
		m.ajouterArc("A", "B", "OK");
		System.out.println(m);
		//m.ajouterArc("Inexistant", "A", "erreur"); Ne doit pas fonctionner
	}
}
