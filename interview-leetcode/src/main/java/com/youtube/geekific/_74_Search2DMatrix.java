/*
 * MIT License
 *
 * Copyright (c) 2023 Geekific (https://www.youtube.com/c/Geekific)
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
 * Video Reference: https://youtu.be/6nY2yDRwjxY
 * LeetCode Reference: https://leetcode.com/problems/search-a-2d-matrix/
 */
public class _74_Search2DMatrix {

    public boolean searchMatrix_naive(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int col : row) {
                if (col == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix_binarySearchRow(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (row[0] <= target && target <= row[row.length - 1]) {
                return find(row, target);
            }
        }
        return false;
    }

    public boolean searchMatrix_binarySearchRowAndColumn(int[][] matrix, int target) {
        int[] myRow = getRow(matrix, target);
        return myRow != null && find(myRow, target);
    }

    private int[] getRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < matrix[mid][0]) {
                high = mid - 1;
            } else if (target > matrix[mid][matrix[0].length - 1]) {
                low = mid + 1;
            } else {
                return matrix[mid];
            }
        }
        return null;
    }

    // Classic Binary Search
    public boolean find(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
