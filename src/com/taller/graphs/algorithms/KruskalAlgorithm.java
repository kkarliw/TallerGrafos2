package com.taller.graph.algorithms;

import com.taller.graph.core.Edge;
import com.taller.graph.core.Graph;
import com.taller.graph.utils.UnionFind;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {

    public void findMST(Graph graph) {
        List<Edge> allEdges = new ArrayList<>(graph.getAllEdges());
        Collections.sort(allEdges, (a, b) -> a.weight - b.weight);
        UnionFind uf = new UnionFind(graph.getVertices());
        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;
        int discardedEdges = 0;

        System.out.println("Aristas seleccionadas (Algoritmo de Kruskal):");
        for (Edge edge : allEdges) {
            int u = edge.source;
            int v = edge.destination;
            if (uf.find(u) != uf.find(v)) {
                uf.union(u, v);
                mstEdges.add(edge);
                totalCost += edge.weight;
                System.out.println("  - Arista aceptada: " + edge);
            } else {
                discardedEdges++;
            }
        }
        System.out.println("\nCosto total del Árbol de Expansión Mínima (MST): " + totalCost);
        System.out.println("Número de aristas descartadas por formar ciclo: " + discardedEdges);
    }
}