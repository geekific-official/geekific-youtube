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

import java.util.Collection;
import java.util.List;

import static java.util.Comparator.comparingInt;

public record Prim<T>(List<Vertex<T>> graph) {

    public void run() {
        if (!graph.isEmpty()) graph.get(0).setVisited(true);
        while (graph.stream().anyMatch(vertex -> !vertex.isVisited())) {
            graph.stream().filter(Vertex::isVisited)
                    .map(Vertex::getNeighbors)
                    .flatMap(Collection::stream)
                    .filter(neighbor -> !neighbor.isVisited())
                    .min(comparingInt(n -> n.getEdge().getWeight()))
                    .ifPresent(candidate -> {
                        candidate.getVertex().setVisited(true);
                        candidate.getEdge().setIncluded(true);
                    });
        }
        graph.forEach(System.out::println);
    }

}
