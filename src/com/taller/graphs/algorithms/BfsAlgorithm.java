package com.taller.graph.algorithms;

import com.taller.graph.core.Graph;
import java.util.*;

public class BfsAlgorithm {

    public void findShortestPath(Graph graph, int startNode, int endNode) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> predecessors = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);
        predecessors.put(startNode, null);

        boolean found = false;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == endNode) {
                found = true;
                break;
            }

            graph.getNeighbors(currentNode).forEach(edge -> {
                int neighbor = edge.destination;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    predecessors.put(neighbor, currentNode);
                }
            });
        }

        if (found) {
            List<Integer> path = new ArrayList<>();
            Integer at = endNode;
            while (at != null) {
                path.add(at);
                at = predecessors.get(at);
            }
            Collections.reverse(path); 
            System.out.println("Salida esperada: Camino más corto -> " + path);
        } else {
            System.out.println("No se encontró un camino desde " + startNode + " hasta " + endNode);
        }
    }
}
