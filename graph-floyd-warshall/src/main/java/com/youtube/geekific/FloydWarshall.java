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

import java.util.stream.IntStream;

public class FloydWarshall {

    private final int nbrOfVertices;
    private final int[][] weightsMatrix;
    private final String[][] successorsMatrix;
    public final static int INF = Integer.MAX_VALUE;

    public FloydWarshall(int[][] weightsMatrix, String[][] successorsMatrix) {
        this.weightsMatrix = weightsMatrix;
        this.successorsMatrix = successorsMatrix;
        nbrOfVertices = weightsMatrix[0].length;
    }

    public void run() throws Exception {
        IntStream.range(0, nbrOfVertices).forEach(intermediate ->
                IntStream.range(0, nbrOfVertices).forEach(start ->
                        IntStream.range(0, nbrOfVertices).forEach(end -> {
                            int weight = getWeightViaInterNode(weightsMatrix, start, intermediate, end);
                            if (weight < weightsMatrix[start][end]) {
                                weightsMatrix[start][end] = weight;
                                successorsMatrix[start][end] = successorsMatrix[start][intermediate];
                            }
                        })
                )
        );
        for (int i = 0; i < nbrOfVertices; i++) {
            if (weightsMatrix[i][i] < 0) {
                throw new Exception("Graph has a negative cycle!!");
            }
        }
        print(weightsMatrix);
        print(successorsMatrix);
    }

    private int getWeightViaInterNode(int[][] matrix, int start, int intermediate, int end) {
        return matrix[start][intermediate] == INF || matrix[intermediate][end] == INF
                ? INF : matrix[start][intermediate] + matrix[intermediate][end];
    }

    public void print(int[][] matrix) {
        IntStream.range(0, nbrOfVertices).forEach(i -> {
            IntStream.range(0, nbrOfVertices).forEach(j ->
                    System.out.print(matrix[i][j] == INF ? "∞  " : matrix[i][j] + "  ")
            );
            System.out.println();
        });
        System.out.println();
    }

    public void print(String[][] matrix) {
        IntStream.range(0, nbrOfVertices).forEach(i -> {
            IntStream.range(0, nbrOfVertices).forEach(j ->
                    System.out.print(matrix[i][j] + "  ")
            );
            System.out.println();
        });
        System.out.println();
    }

}