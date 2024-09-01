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

import java.util.LinkedList;
import java.util.Queue;

/*
 * Video Reference: https://youtu.be/SFMRG3Kts8A
 * LeetCode Reference: https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
public class _1091_ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int shortestPath = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            shortestPath++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int column = cell[1];
                if (isInsideMatrix(grid, row, column) && isNotVisited(grid, row, column)) {
                    grid[row][column] = 1; // Mark cell as visited
                    if (row == grid.length - 1 && column == grid[0].length - 1) return shortestPath;
                    queue.add(new int[]{row - 1, column - 1});
                    queue.add(new int[]{row - 1, column});
                    queue.add(new int[]{row - 1, column + 1});
                    queue.add(new int[]{row, column - 1});
                    queue.add(new int[]{row, column + 1});
                    queue.add(new int[]{row + 1, column - 1});
                    queue.add(new int[]{row + 1, column});
                    queue.add(new int[]{row + 1, column + 1});
                }
            }
        }
        return -1;
    }

    private boolean isInsideMatrix(int[][] grid, int row, int column) {
        return row >= 0 && column >= 0 && row < grid.length && column < grid[0].length;
    }

    private boolean isNotVisited(int[][] grid, int row, int column) {
        return grid[row][column] == 0;
    }

}
