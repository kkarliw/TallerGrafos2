package com.taller.graph.app;

import com.taller.graph.algorithms.BfsAlgorithm;
import com.taller.graph.core.Graph;
import java.util.Scanner;

public class NetworkSimulator {
    private final Graph network;
    private final Scanner scanner;
    private final BfsAlgorithm bfs;

    public NetworkSimulator() {
        this.network = new Graph(6); 
        this.scanner = new Scanner(System.in);
        this.bfs = new BfsAlgorithm();

        network.addUnweightedEdge(0, 1);
        network.addUnweightedEdge(1, 2);
        network.addUnweightedEdge(1, 3);
        network.addUnweightedEdge(3, 4);
        network.addUnweightedEdge(4, 5);
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Simulador de Red de Computadoras ===");
            System.out.println("Nodos en la red: 0, 1, 2, 3, 4, 5");
            System.out.println("1. Agregar una conexión entre dos nodos");
            System.out.println("2. Mostrar si un nodo puede comunicarse con otro");
            System.out.println("3. Encontrar el camino más corto (en saltos)");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: addConnection(); break;
                case 2: checkCommunication(); break;
                case 3: findShortestPath(); break;
                case 0: running = false; break;
                default: System.out.println("Opción no válida.");
            }
        }
    }

    private void addConnection() {
        System.out.print("Ingrese el primer nodo (0-5): ");
        int u = scanner.nextInt();
        System.out.print("Ingrese el segundo nodo (0-5): ");
        int v = scanner.nextInt();

        if (u >= 0 && u < 6 && v >= 0 && v < 6) {
            network.addUnweightedEdge(u, v);
            System.out.println("Conexión agregada entre " + u + " y " + v);
        } else {
            System.out.println("Nodos no válidos.");
        }
    }

    private void checkCommunication() {
        System.out.print("Ingrese el nodo de origen (0-5): ");
        int u = scanner.nextInt();
        System.out.print("Ingrese el nodo de destino (0-5): ");
        int v = scanner.nextInt();

        if (u >= 0 && u < 6 && v >= 0 && v < 6) {
            System.out.println("Verificando comunicación...");
            bfs.findShortestPath(network, u, v);
        } else {
            System.out.println("Nodos no válidos.");
        }
    }

    private void findShortestPath() {
        checkCommunication();
    }
}
