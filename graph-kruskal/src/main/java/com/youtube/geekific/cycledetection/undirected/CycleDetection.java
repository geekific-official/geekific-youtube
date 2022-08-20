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

package com.youtube.geekific.cycledetection.undirected;

import com.youtube.geekific.Vertex;

import java.util.Arrays;
import java.util.List;

public class CycleDetection<T> {

    public boolean hasCycle(List<Vertex<T>> vertices) {
        for (Vertex<T> vertex : vertices) {
            if (!vertex.isVisited() && hasCycle(null, vertex)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Vertex<T> caller, Vertex<T> current) {
        current.setVisited(true);
        for (Vertex<T> neighbor : current.getNeighbors()) {
            if (neighbor.isVisited() && !neighbor.equals(caller) || !neighbor.isVisited() && hasCycle(current, neighbor)) {
                return true;
            }
            /*
                Equivalent Code:
                ----------------
                if (neighbor.isVisited()) {
                    if (current.equals(neighbor) || !neighbor.equals(caller)) {
                        return true;
                    }
                } else if (hasCycle(current, neighbor)) {
                    return true;
                }
            */
        }
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
        vertexB.addNeighbor(vertexA);

        vertexA.addNeighbor(vertexC);
        vertexC.addNeighbor(vertexA);

        vertexB.addNeighbor(vertexE);
        vertexE.addNeighbor(vertexB);

        vertexC.addNeighbor(vertexD);
        vertexD.addNeighbor(vertexC);

        vertexD.addNeighbor(vertexE);
        vertexE.addNeighbor(vertexD);

        vertexE.addNeighbor(vertexF);
        vertexF.addNeighbor(vertexE);

        List<Vertex<String>> graph = Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF);
        System.out.println(new CycleDetection<String>().hasCycle(graph));

    }

}
