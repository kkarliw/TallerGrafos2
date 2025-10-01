package com.taller.graph.algorithms;

import com.taller.graph.core.Graph;
import com.taller.graph.core.Edge;

public class WarshallAlgorithm { 
    public void findTransitiveClosure(Graph graph) {
        int numVertices = graph.getVertices();
        boolean[][] reach = new boolean[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            reach[i][i] = true;
        }
        for (int i = 0; i < numVertices; i++) {
            for (Edge edge : graph.getNeighbors(i)) {
                reach[edge.source][edge.destination] = true;
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    reach[i][j] = reach[i][j] || (reach[i][k] && reach[k][j]);
                }
            }
        }

        printReachabilityMatrix(reach, numVertices);
        checkStronglyConnected(reach, numVertices);
    } 
    
 reach, int numVertices) {
        System.out.println("Matriz de alcanzabilidad (Cierre Transitivo):");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print((reach[i][j] ? 1 : 0) + "\t");
            }
            System.out.println();
        }
    }

    private void checkStronglyConnected(boolean[][] reach, int numVertices) {
        boolean isStronglyConnected = true;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (!reach[i][j]) {
                    isStronglyConnected = false;
                    break;
                }
            }
            if (!isStronglyConnected) break;
        }

        System.out.println("\n¿Es el grafo fuertemente conexo?");
        if (isStronglyConnected) {
            System.out.println("Sí, todos los nodos son alcanzables desde cualquier otro nodo.");
        } else {
            System.out.println("No, existen nodos que no pueden alcanzar a otros.");
        }
    }

}
