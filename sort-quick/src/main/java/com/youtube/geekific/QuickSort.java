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

public record QuickSort<T extends Comparable<T>>(T[] arr) {

    public void sort() {
        quicksort(0, arr.length - 1);
    }

    private void quicksort(int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(low, high);
        quicksort(low, pivot - 1);
        quicksort(pivot + 1, high);
    }

    private int partition(int low, int high) {
        int pivotIndex = (low + high) / 2;
        swap(pivotIndex, high);
        int pivotIndexCounter = low;
        for (int i = low; i < high; i++) {
            if (arr[i].compareTo(arr[high]) <= 0) swap(pivotIndexCounter++, i);
        }
        swap(pivotIndexCounter, high);
        return pivotIndexCounter;
    }

    private void swap(int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            T temp = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = temp;
        }
    }

}
