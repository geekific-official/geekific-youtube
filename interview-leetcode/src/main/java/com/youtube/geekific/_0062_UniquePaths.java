/*
 * MIT License
 *
 * Copyright (c) 2024 Geekific (https://www.youtube.com/c/Geekific)
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

/*
 * Video Reference: https://youtu.be/JaFmtaJQbR0
 * LeetCode Reference: https://leetcode.com/problems/unique-paths/
 */
public class _0062_UniquePaths {

    public int uniquePaths_Recursive(int m, int n) {
        return numPaths(m - 1, n - 1);
    }

    private int numPaths(int i, int j) {
        if (i == 0 || j == 0) {
            return 1;
        }
        return numPaths(i - 1, j) + numPaths(i, j - 1);
    }

    public int uniquePaths_DP_2DArray(int m, int n) {
        int[][] nbrOfPaths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    nbrOfPaths[i][j] = 1;
                } else {
                    nbrOfPaths[i][j] = nbrOfPaths[i][j - 1] + nbrOfPaths[i - 1][j];
                }
            }
        }
        return nbrOfPaths[m - 1][n - 1];
    }

    public int uniquePaths_DP_1DArray(int m, int n) {
        int[] nbrOfPaths = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    nbrOfPaths[j] = 1;
                } else {
                    nbrOfPaths[j] += nbrOfPaths[j - 1];
                }
            }
        }
        return nbrOfPaths[n - 1];
    }

}
