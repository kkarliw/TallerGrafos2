package com.taller.graph.algorithms;

import com.taller.graph.core.Graph;
import com.taller.graph.core.Edge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshallAlgorithm {
    private static final int INF = Integer.MAX_VALUE / 2;

    public void findAllShortestPaths(Graph graph) {
        int numVertices = graph.getVertices();
        int[][] dist = new int[numVertices][numVertices];
        int[][] next = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
                next[i][j] = -1;
            }
        }

        for (int i = 0; i < numVertices; i++) {
            for (Edge edge : graph.getNeighbors(i)) {
                dist[edge.source][edge.destination] = edge.weight;
                next[edge.source][edge.destination] = edge.destination;
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        
        printDistanceMatrix(dist, numVertices);
        System.out.println("\n--- Camino Mínimo Específico ---");
        printPath(dist, next, 0, 3);
    }

    private void printDistanceMatrix(int[][] dist, int numVertices) {
        System.out.println("Matriz de distancias resultante (Floyd-Warshall):");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (dist[i][j] >= INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    private void printPath(int[][] dist, int[][] next, int u, int v) {
        if (next[u][v] == -1) {
            System.out.println("No existe camino de " + u + " -> " + v);
            return;
        }

        List<Integer> path = new ArrayList<>();
        path.add(u);
        int current = u;
        while (current != v) {
            current = next[current][v];
            path.add(current);
        }

        System.out.println("El camino mínimo de " + u + " -> " + v + " es: " + path);
        System.out.println("Distancia total: " + dist[u][v]);
    }
}
