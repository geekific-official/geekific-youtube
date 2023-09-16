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

public record TimSort<T extends Comparable<T>>(T[] arr) {

    private static final int MIN_RUN_SIZE = 4;

    public void sort() {
        // Sort each run with Insertion Sort
        for (int start = 0; start < arr.length; start += MIN_RUN_SIZE) {
            int end = Math.min((start + MIN_RUN_SIZE - 1), (arr.length - 1));
            new InsertionSort<>(arr).sort(start, end);
        }

        // Merge the sorted runs with the help of MergeSort
        for (int runSize = MIN_RUN_SIZE; runSize < arr.length; runSize *= 2) {
            for (int left = 0; left < arr.length; left += 2 * runSize) {
                int mid = left + runSize - 1;
                int right = Math.min((left + 2 * runSize - 1), (arr.length - 1));
                if (mid < right) new MergeSort<>(arr).merge(left, mid, right);
            }
        }
    }

}
