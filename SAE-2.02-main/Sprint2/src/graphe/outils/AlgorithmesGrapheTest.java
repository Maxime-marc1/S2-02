package graphe.outils;

import graphe.modele.IGraphe;

public class AlgorithmesGrapheTest extends AbstractAlgorithmesGrapheTest {

    @Override
    protected IGraphe creerGrapheVide() {
        return new Graphe();
    }
}