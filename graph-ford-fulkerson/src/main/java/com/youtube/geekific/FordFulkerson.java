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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FordFulkerson<T> {

    private final List<List<Vertex<T>>> paths = new ArrayList<>();

    public int run(Vertex<T> source, Vertex<T> destination) {
        findAllPaths(source, destination, new ArrayList<>(Collections.singleton(source)));
        AtomicInteger maxFlow = new AtomicInteger();
        paths.stream()
                .sorted(Comparator.comparingInt(this::getMinFlowInPath).reversed())
                .forEach(path -> {
                    Integer minimum = getMinFlowInPath(path);
                    IntStream.range(0, path.size() - 1)
                            .forEach(vertexIdx -> removeMinFlowFromVerticesInPath(path, minimum, vertexIdx));
                    maxFlow.addAndGet(minimum);
                });
        return maxFlow.get();
    }

    private Integer getMinFlowInPath(List<Vertex<T>> path) {
        return IntStream.range(0, path.size() - 1)
                .mapToObj(vertexIdx -> getNeighborEdgeWeight(path, vertexIdx))
                .min(Integer::compareTo).orElse(0);
    }

    private void removeMinFlowFromVerticesInPath(List<Vertex<T>> path, Integer min, int vertexIdx) {
        path.get(vertexIdx).getNeighbors().put(
                path.get(vertexIdx + 1),
                getNeighborEdgeWeight(path, vertexIdx) - min
        );
    }

    private Integer getNeighborEdgeWeight(List<Vertex<T>> path, int vertexIdx) {
        return path.get(vertexIdx).getNeighbors().get(path.get(vertexIdx + 1));
    }

    private void findAllPaths(Vertex<T> current, Vertex<T> destination, List<Vertex<T>> currentPath) {
        if (current.equals(destination)) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }
        current.setVisited(true);
        current.getNeighbors().keySet().stream()
                .filter(neighbor -> !neighbor.isVisited())
                .forEach(neighbor -> {
                    currentPath.add(neighbor);
                    findAllPaths(neighbor, destination, currentPath);
                    currentPath.remove(neighbor);
                });
        current.setVisited(false);
    }

}
