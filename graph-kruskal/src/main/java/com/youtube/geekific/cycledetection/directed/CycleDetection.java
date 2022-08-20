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

package com.youtube.geekific.cycledetection.directed;

import com.youtube.geekific.Vertex;

import java.util.Arrays;
import java.util.List;

public class CycleDetection<T> {

    public boolean hasCycle(List<Vertex<T>> vertices) {
        for (Vertex<T> vertex : vertices) {
            if (!vertex.isVisited() && hasCycle(vertex)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Vertex<T> sourceVertex) {
        sourceVertex.setBeingVisited(true);
        for (Vertex<T> neighbor : sourceVertex.getNeighbors()) {
            if (neighbor.isBeingVisited() || !neighbor.isVisited() && hasCycle(neighbor)) {
                return true;
            }
        }
        sourceVertex.setBeingVisited(false);
        sourceVertex.setVisited(true);
        return false;
    }

    /*
     * Video Reference: https://youtu.be/Te9Fr9SHDqc
     */
    public static void main(String[] args) {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");
        Vertex<String> vertexF = new Vertex<>("F");

        vertexA.addNeighbor(vertexB);
        vertexA.addNeighbor(vertexC);
        vertexB.addNeighbor(vertexC);
        vertexB.addNeighbor(vertexD);
        vertexB.addNeighbor(vertexE);
        vertexC.addNeighbor(vertexD);
        vertexD.addNeighbor(vertexE);
        vertexE.addNeighbor(vertexF);
        vertexF.addNeighbor(vertexD);

        List<Vertex<String>> graph = Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF);
        System.out.println(new CycleDetection<String>().hasCycle(graph)); // true
    }

}
