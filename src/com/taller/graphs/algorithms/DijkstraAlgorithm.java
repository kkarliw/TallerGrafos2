package com.taller.graph.algorithms;

import com.taller.graph.core.Graph;
import com.taller.graph.core.Edge;
import java.util.*;

public class DijkstraAlgorithm {

    public void findShortestPaths(Graph graph, int startNode) {
        int[] distances = new int[graph.getVertices()];
        Map<Integer, Integer> predecessors = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;
        pq.add(new int[]{startNode, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (currentDist > distances[currentNode]) {
                continue;
            }

            for (Edge edge : graph.getNeighbors(currentNode)) {
                int neighbor = edge.destination;
                int newDist = distances[currentNode] + edge.weight;
                if (newDist < distances[neighbor]) {
                    distances[neighbor] = newDist;
                    predecessors.put(neighbor, currentNode);
                    pq.add(new int[]{neighbor, newDist});
                }
            }
        }

        printResults(startNode, distances, predecessors, graph.getVertices());
    }

    private void printResults(int startNode, int[] distances, Map<Integer, Integer> predecessors, int numVertices) {
        System.out.println("Distancia más corta desde el vértice " + startNode + " a todos los demás:");
        for (int i = 0; i < numVertices; i++) {
            if (i == startNode) continue;

            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("  - " + startNode + " -> " + i + ": Inalcanzable");
            } else {
                List<Integer> path = new ArrayList<>();
                Integer at = i;
                while (at != null) {
                    path.add(at);
                    at = predecessors.get(at);
                }
                Collections.reverse(path);
                System.out.println("  - " + startNode + " -> " + i + ": Distancia = " + distances[i] + ", Camino = " + path);
            }
        }
    }
}