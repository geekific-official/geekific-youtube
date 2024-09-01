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
 * Video Reference: https://youtu.be/uiPkXigxxFY
 * LeetCode Reference: https://leetcode.com/problems/number-of-islands/
 */
public class _0200_NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    traverse(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void traverse(int row, int col, char[][] grid) {
        if (isNotValid(row, col, grid)) return;
        grid[row][col] = '0'; // Mark cell as visited
        traverse(row + 1, col, grid); // Right
        traverse(row - 1, col, grid); // Left
        traverse(row, col + 1, grid); // Top
        traverse(row, col - 1, grid); // Bottom
    }

    private boolean isNotValid(int row, int col, char[][] grid) {
        return row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == '0';
    }

}
