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

import static com.youtube.geekific.FloydWarshall.INF;

public class MainApp {

    /*
     * Video Reference:
     */
    public static void main(String[] args) throws Exception {

        int[][] weightsMatrix = {
                {0, 3, 2, INF, INF},
                {INF, 0, INF, 7, INF},
                {INF, INF, 0, INF, 4},
                {INF, INF, INF, 0, 6},
                {INF, 4, 5, INF, 0}
        };
        String[][] successorsMatrix = {
                {"-", "B", "C", "-", "-"},
                {"-", "-", "-", "D", "-"},
                {"-", "-", "-", "-", "E"},
                {"-", "-", "-", "-", "E"},
                {"-", "B", "C", "-", "-"}
        };
        new FloydWarshall(weightsMatrix, successorsMatrix).run();

    }

}
