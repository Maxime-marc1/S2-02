package graphe;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*; 


import org.junit.jupiter.api.Test;



class GrapheTest {

	@Test
	void test() {
		Graphe g = new Graphe();
		Noeud a = new Noeud("A");
		Noeud b = new Noeud("B");

		//test relatif aux noeuds
		
		g.ajouterNoeud(a);
		g.ajouterNoeud(b);
		assertTrue(g.contientNoeud(a));
		assertTrue(g.contientNoeud(b));
		assertFalse(g.contientNoeud(new Noeud("C")));
		assert(g.noeuds().contains(a)&& g.noeuds().contains(b));
		Noeud a2 = new Noeud("A");
		assertThrows(IllegalArgumentException.class, () -> {g.ajouterNoeud(a2);});
		assertEquals(g.ordre(),2);
		
		//-------------------------------------------

		//test arc
		Arc ab = new Arc(a,b);
		g.ajouterArc(ab);
		assertTrue(g.arcs().contains(ab));
		Arc ac=new Arc(a,new Noeud("C"));
		assertFalse(g.arcs().contains(ac));
		
		
		
		
	
	}

}
