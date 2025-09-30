package com.taller.graph.core;

public class Edge {
    public final int source;
    public final int destination;
    public final int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%d - %d (%d)", source, destination, weight);
    }
}