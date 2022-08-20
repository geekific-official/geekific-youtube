/*
 * MIT License
 *
 * Copyright (c) 2022 Geekific (https://www.youtube.com/c/Geekific)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice, Geekific's channel link and this permission notice
 * shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.youtube.geekific;

import com.youtube.geekific.cycledetection.undirected.CycleDetection;

import java.util.*;
import java.util.stream.Stream;

public class KruskalAlgorithm<T> {

    private final int nbrOfVertices;
    private final List<Vertex<T>> vertices;
    private final PriorityQueue<Edge<T>> graph;

    public KruskalAlgorithm(List<Edge<T>> graph) {
        this.graph = new PriorityQueue<>(graph);
        vertices = getVerticesInGraph(graph);
        nbrOfVertices = vertices.size();
    }

    public void run() {
        List<Edge<T>> spanningTree = new ArrayList<>();
        do {
            Edge<T> edge = graph.poll();
            resetTree(Stream.concat(spanningTree.stream(), Stream.of(edge)).toList());
            if (!new CycleDetection<T>().hasCycle(vertices)) {
                spanningTree.add(edge);
            }
        } while (spanningTree.size() < nbrOfVertices - 1);
        printTreeInfo(spanningTree);
    }

    private List<Vertex<T>> getVerticesInGraph(List<Edge<T>> edges) {
        return Stream.concat(
                edges.stream().map(Edge::getSource),
                edges.stream().map(Edge::getDestination)
        ).distinct().toList();
    }

    private void resetTree(List<Edge<T>> spanningTree) {
        vertices.forEach(vertex -> {
            vertex.setVisited(false);
            vertex.setNeighbors(new HashSet<>());
        });
        spanningTree.forEach(edge -> {
            edge.getSource().addNeighbor(edge.getDestination());
            edge.getDestination().addNeighbor(edge.getSource());
        });
    }

    private void printTreeInfo(List<Edge<T>> spanningTree) {
        Integer min = spanningTree.stream()
                .map(Edge::getWeight)
                .reduce(0, Integer::sum);

        spanningTree.forEach(System.out::println);
        System.out.println("Minimum Weight: " + min);
    }

}
