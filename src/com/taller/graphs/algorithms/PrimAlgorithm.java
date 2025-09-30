package com.taller.graph.algorithms;

import com.taller.graph.core.Edge;
import com.taller.graph.core.Graph;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimAlgorithm {

    public void findMST(Graph graph, int startVertex) {
        boolean[] inMST = new boolean[graph.getVertices()];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;
        inMST[startVertex] = true;
        for (Edge edge : graph.getNeighbors(startVertex)) {
            pq.add(edge);
        }
        System.out.println("Orden en que se seleccionan las aristas (Algoritmo de Prim):");

        while (!pq.isEmpty() && mstEdges.size() < graph.getVertices() - 1) {
            Edge minEdge = pq.poll();
            if (inMST[minEdge.destination]) {
                continue;
            }
            inMST[minEdge.destination] = true;
            mstEdges.add(minEdge);
            totalCost += minEdge.weight;
            System.out.println("  - Arista seleccionada: " + minEdge);

            for (Edge edge : graph.getNeighbors(minEdge.destination)) {
                if (!inMST[edge.destination]) {
                    pq.add(edge);
                }
            }
        }
        System.out.println("\nCosto total del Árbol de Expansión Mínima (MST): " + totalCost);
    }
}