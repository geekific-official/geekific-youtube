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

public record DualPivotQuickSort<T extends Comparable<T>>(T[] arr) {

    public record Pivot(int left, int right) {
    }

    public void sort() {
        dualPivotQuicksort(0, arr.length - 1);
    }

    private void dualPivotQuicksort(int low, int high) {
        if (low >= high) {
            return;
        }
        Pivot pivot = partition(low, high);
        dualPivotQuicksort(low, pivot.left() - 1);
        dualPivotQuicksort(pivot.left() + 1, pivot.right() - 1);
        dualPivotQuicksort(pivot.right() + 1, high);
    }

    private Pivot partition(int low, int high) {
        if (arr[low].compareTo(arr[high]) > 0) swap(low, high);

        int leftPivotIndex = low + 1;
        int rightPivotIndex = high - 1;

        int iterator = low + 1;
        while (iterator <= rightPivotIndex) {
            if (arr[iterator].compareTo(arr[low]) < 0) {
                swap(iterator++, leftPivotIndex++);
            } else if (arr[iterator].compareTo(arr[high]) > 0) {
                swap(iterator, rightPivotIndex--);
            } else {
                iterator++;
            }
        }

        swap(low, --leftPivotIndex);
        swap(high, ++rightPivotIndex);
        return new Pivot(leftPivotIndex, rightPivotIndex);

    }

    private void swap(int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            T temp = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = temp;
        }
    }

}
