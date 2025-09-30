package com.taller.graph.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final int vertices;
    private final Map<Integer, List<Edge>> adjacencyList;
    private final List<Edge> allEdges = new ArrayList<>();

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.get(source).add(edge);
        adjacencyList.get(destination).add(new Edge(destination, source, weight));
        allEdges.add(edge);
    }

    public void addUnweightedEdge(int source, int destination) {
        addEdge(source, destination, 1);
    }

    public void addDirectedEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.get(source).add(edge);
        allEdges.add(edge);
    }

    public int getVertices() {
        return vertices;
    }

    public List<Edge> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    public List<Edge> getAllEdges() {
        return allEdges;
    }
}