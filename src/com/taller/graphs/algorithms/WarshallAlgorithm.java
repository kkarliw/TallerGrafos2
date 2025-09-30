package com.taller.graph.algorithms;

import com.taller.graph.core.Graph;
import com.taller.graph.core.Edge;

public class WarshallAlgorithm { // <-- La clase empieza aquí

    // Este es el método principal del algoritmo
    public void findTransitiveClosure(Graph graph) {
        int numVertices = graph.getVertices();
        boolean[][] reach = new boolean[numVertices][numVertices];

        // --- ESTRUCTURA CORREGIDA ---
        // Los pasos ahora están uno después del otro, no anidados.

        // PASO 1: Inicializar la matriz. Un nodo siempre se alcanza a sí mismo.
        for (int i = 0; i < numVertices; i++) {
            reach[i][i] = true;
        }

        // PASO 2: Añadir las conexiones directas del grafo.
        for (int i = 0; i < numVertices; i++) {
            for (Edge edge : graph.getNeighbors(i)) {
                reach[edge.source][edge.destination] = true;
            }
        }

        // PASO 3: Algoritmo de Warshall (lógica principal).
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    reach[i][j] = reach[i][j] || (reach[i][k] && reach[k][j]);
                }
            }
        }

        // PASO 4: Mostrar los resultados (UNA SOLA VEZ, al final).
        printReachabilityMatrix(reach, numVertices);
        checkStronglyConnected(reach, numVertices);
    } // <-- El método findTransitiveClosure TERMINA AQUÍ.


    // --- ESTRUCTURA CORREGIDA ---
    // Los métodos de ayuda ahora están FUERA de findTransitiveClosure,
    // pero DENTRO de la clase WarshallAlgorithm.

    private void printReachabilityMatrix(boolean[][] reach, int numVertices) {
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