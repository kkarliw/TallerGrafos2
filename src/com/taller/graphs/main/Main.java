package com.taller.graph.main;

import com.taller.graph.algorithms.*;
import com.taller.graph.app.NetworkSimulator;
import com.taller.graph.core.Graph;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENÚ TALLER DE GRAFOS =====");
            System.out.println("1. Problemas 1, 2 y 3 (MST con Prim y Kruskal)");
            System.out.println("2. Problema 4 (Camino más Corto con BFS)");
            System.out.println("3. Problema 5 (Camino más Corto con Dijkstra)");
            System.out.println("4. Problema 6 (Todos los Caminos con Floyd-Warshall)");
            System.out.println("5. Problema 7 (Alcanzabilidad con Warshall)");
            System.out.println("6. Problema 8 (Simulación de Red)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: runMstAlgorithms(); break;
                case 2: runBfsAlgorithm(); break;
                case 3: runDijkstraAlgorithm(); break;
                case 4: runFloydWarshallAlgorithm(); break;
                case 5: runWarshallAlgorithm(); break;
                case 6: runNetworkSimulator(); break;
                case 0:
                    running = false;
                    System.out.println("¡Chaito!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    public static void runMstAlgorithms() {
        System.out.println("\n--- [Problema 1, 2 y 3] Ejecutando Algoritmos MST ---");
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 6);
        graph.addEdge(3, 5, 4);
        graph.addEdge(4, 5, 3);

        System.out.println("\n--- Ejecutando Algoritmo de Prim (Problema 2) ---");
        new PrimAlgorithm().findMST(graph, 0);

        System.out.println("\n--- Ejecutando Algoritmo de Kruskal (Problema 3) ---");
        new KruskalAlgorithm().findMST(graph);

        System.out.println("\n--- Comparación (Problema 1) ---");
        System.out.println("Ambos algoritmos dan el mismo costo total para el MST.");
    }

    public static void runBfsAlgorithm() {
        System.out.println("\n--- [Problema 4] Ejecutando Búsqueda en Anchura (BFS) ---");
        Graph graph = new Graph(6);
        graph.addUnweightedEdge(0, 1);
        graph.addUnweightedEdge(0, 2);
        graph.addUnweightedEdge(1, 3);
        graph.addUnweightedEdge(2, 3);
        graph.addUnweightedEdge(3, 4);
        graph.addUnweightedEdge(4, 5);
        int origen = 0, destino = 5;
        System.out.println("Entrada: origen = " + origen + ", destino = " + destino);
        new BfsAlgorithm().findShortestPath(graph, origen, destino);
    }

    public static void runDijkstraAlgorithm() {
        System.out.println("\n--- [Problema 5] Ejecutando Algoritmo de Dijkstra ---");
        Graph graph = new Graph(5);
        graph.addDirectedEdge(0, 1, 10);
        graph.addDirectedEdge(0, 4, 3);
        graph.addDirectedEdge(1, 2, 2);
        graph.addDirectedEdge(1, 4, 4);
        graph.addDirectedEdge(2, 3, 9);
        graph.addDirectedEdge(3, 2, 7);
        graph.addDirectedEdge(4, 1, 1);
        graph.addDirectedEdge(4, 2, 8);
        graph.addDirectedEdge(4, 3, 2);
        new DijkstraAlgorithm().findShortestPaths(graph, 0);
    }

    public static void runFloydWarshallAlgorithm() {
        System.out.println("\n--- [Problema 6] Ejecutando Algoritmo de Floyd-Warshall ---");
        Graph graph = new Graph(5);
        // ... (código para añadir aristas igual que en Dijkstra)
        graph.addDirectedEdge(0, 1, 10);
        graph.addDirectedEdge(0, 4, 3);
        graph.addDirectedEdge(1, 2, 2);
        graph.addDirectedEdge(1, 4, 4);
        graph.addDirectedEdge(2, 3, 9);
        graph.addDirectedEdge(3, 2, 7);
        graph.addDirectedEdge(4, 1, 1);
        graph.addDirectedEdge(4, 2, 8);
        graph.addDirectedEdge(4, 3, 2);
        new FloydWarshallAlgorithm().findAllShortestPaths(graph);
    }

    public static void runWarshallAlgorithm() {
        System.out.println("\n--- [Problema 7] Ejecutando Algoritmo de Warshall ---");
        Graph graph = new Graph(4);
        graph.addDirectedEdge(0, 1, 1);
        graph.addDirectedEdge(1, 2, 1);
        graph.addDirectedEdge(2, 0, 1);
        graph.addDirectedEdge(2, 3, 1);
        new WarshallAlgorithm().findTransitiveClosure(graph);
    }

    public static void runNetworkSimulator() {
        System.out.println("\n--- [Problema 8] Iniciando Simulador de Red ---");
        NetworkSimulator simulator = new NetworkSimulator();
        simulator.run();
    }
}