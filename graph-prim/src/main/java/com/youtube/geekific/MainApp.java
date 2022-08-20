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

import java.util.Arrays;
import java.util.stream.Stream;

public class MainApp {

    /*
     * Video Reference:
     */
    public static void main(String[] args) {

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");
        Vertex<String> vertexF = new Vertex<>("F");

        Edge edgeAB = new Edge(4);
        Edge edgeAC = new Edge(4);
        Edge edgeBC = new Edge(2);
        Edge edgeCD = new Edge(3);
        Edge edgeCF = new Edge(4);
        Edge edgeCE = new Edge(2);
        Edge edgeDF = new Edge(3);
        Edge edgeEF = new Edge(3);

        vertexA.addNeighbor(vertexB, edgeAB);
        vertexA.addNeighbor(vertexC, edgeAC);

        vertexB.addNeighbor(vertexA, edgeAB);
        vertexB.addNeighbor(vertexC, edgeBC);

        vertexC.addNeighbor(vertexA, edgeAC);
        vertexC.addNeighbor(vertexB, edgeBC);
        vertexC.addNeighbor(vertexE, edgeCE);
        vertexC.addNeighbor(vertexD, edgeCD);
        vertexC.addNeighbor(vertexF, edgeCF);

        vertexD.addNeighbor(vertexC, edgeCD);
        vertexD.addNeighbor(vertexF, edgeDF);

        vertexE.addNeighbor(vertexC, edgeCE);
        vertexE.addNeighbor(vertexF, edgeEF);

        vertexF.addNeighbor(vertexD, edgeDF);
        vertexF.addNeighbor(vertexC, edgeCF);
        vertexF.addNeighbor(vertexE, edgeEF);

        new Prim<>(Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF)).run();

        Integer minimum = Stream.of(edgeAB, edgeAC, edgeBC, edgeCD, edgeCF, edgeCE, edgeDF, edgeEF)
                .filter(Edge::isIncluded).map(Edge::getWeight).reduce(0, Integer::sum);
        System.out.println("Minimum Weight: " + minimum);

    }


}
