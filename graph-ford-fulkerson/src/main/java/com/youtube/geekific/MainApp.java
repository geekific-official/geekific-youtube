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

import java.util.HashMap;
import java.util.Map;

public class MainApp {

    /*
     * Video Reference: https://youtu.be/sT9dpVRKrQY
     */
    public static void main(String[] args) {

        Vertex<String> S = new Vertex<>("S");
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> T = new Vertex<>("T");

        S.setNeighbors(new HashMap<>(Map.of(A, 15, B, 12)));
        A.setNeighbors(new HashMap<>(Map.of(B, 10, C, 12, D, 1)));
        B.setNeighbors(new HashMap<>(Map.of(D, 14)));
        C.setNeighbors(new HashMap<>(Map.of(T, 25)));
        D.setNeighbors(new HashMap<>(Map.of(C, 10, T, 4)));

        System.out.print("The Max Flow is: ");
        System.out.println(new FordFulkerson<String>().run(S, T));

    }

}
