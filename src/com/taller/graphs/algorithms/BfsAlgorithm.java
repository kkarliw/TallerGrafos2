package com.taller.graph.algorithms;

import com.taller.graph.core.Graph;
import java.util.*;

public class BfsAlgorithm {

    public void findShortestPath(Graph graph, int startNode, int endNode) {
        // Cola para los nodos a visitar
        Queue<Integer> queue = new LinkedList<>();
        // Mapa para reconstruir el camino, guarda: <Nodo, Nodo Predecesor>
        Map<Integer, Integer> predecessors = new HashMap<>();
        // Conjunto para no visitar nodos más de una vez
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);
        predecessors.put(startNode, null); // El nodo inicial no tiene predecesor

        boolean found = false;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == endNode) {
                found = true;
                break; // Encontramos el destino
            }

            // getNeighbors() nos da las aristas, necesitamos el vértice destino de cada una
            graph.getNeighbors(currentNode).forEach(edge -> {
                int neighbor = edge.destination;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    predecessors.put(neighbor, currentNode);
                }
            });
        }

        // Reconstruir y mostrar el camino
        if (found) {
            List<Integer> path = new ArrayList<>();
            Integer at = endNode;
            while (at != null) {
                path.add(at);
                at = predecessors.get(at);
            }
            Collections.reverse(path); // Lo invertimos para tenerlo desde el inicio al fin
            System.out.println("Salida esperada: Camino más corto -> " + path);
        } else {
            System.out.println("No se encontró un camino desde " + startNode + " hasta " + endNode);
        }
    }
}