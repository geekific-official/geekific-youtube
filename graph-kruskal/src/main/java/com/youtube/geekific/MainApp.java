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
import java.util.List;

public class MainApp {

    /*
     * Video Reference: https://youtu.be/JptKmWQSerU
     */
    public static void main(String[] args) {

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");
        Vertex<String> vertexF = new Vertex<>("F");
        Vertex<String> vertexG = new Vertex<>("G");

        List<Edge<String>> graph1 = Arrays.asList(
                new Edge<>(vertexA, vertexB, 4),
                new Edge<>(vertexA, vertexC, 4),
                new Edge<>(vertexB, vertexC, 2),
                new Edge<>(vertexC, vertexD, 3),
                new Edge<>(vertexC, vertexF, 4),
                new Edge<>(vertexC, vertexE, 2),
                new Edge<>(vertexD, vertexF, 3),
                new Edge<>(vertexE, vertexF, 3)
        );

        List<Edge<String>> graph2 = Arrays.asList(
                new Edge<>(vertexA, vertexB, 7),
                new Edge<>(vertexA, vertexD, 5),
                new Edge<>(vertexB, vertexC, 8),
                new Edge<>(vertexB, vertexE, 7),
                new Edge<>(vertexB, vertexD, 9),
                new Edge<>(vertexC, vertexE, 5),
                new Edge<>(vertexD, vertexE, 15),
                new Edge<>(vertexD, vertexF, 6),
                new Edge<>(vertexE, vertexF, 8),
                new Edge<>(vertexE, vertexG, 9),
                new Edge<>(vertexF, vertexG, 11)
        );

        List<Edge<String>> graph3 = Arrays.asList(
                new Edge<>(vertexA, vertexB, 5),
                new Edge<>(vertexA, vertexC, 2),
                new Edge<>(vertexB, vertexC, 3),
                new Edge<>(vertexB, vertexD, 8),
                new Edge<>(vertexB, vertexE, 7),
                new Edge<>(vertexD, vertexE, 6),
                new Edge<>(vertexC, vertexE, 3)
        );

        List<Edge<String>> graph4 = Arrays.asList(
                new Edge<>(vertexA, vertexB, 5),
                new Edge<>(vertexA, vertexC, 2),
                new Edge<>(vertexB, vertexC, 4),
                new Edge<>(vertexB, vertexD, 8),
                new Edge<>(vertexB, vertexE, 7),
                new Edge<>(vertexD, vertexE, 2),
                new Edge<>(vertexC, vertexE, 3)
        );

        new KruskalAlgorithm<>(graph1).run();
        new KruskalAlgorithm<>(graph2).run();
        new KruskalAlgorithm<>(graph3).run();
        new KruskalAlgorithm<>(graph4).run();

    }

}
