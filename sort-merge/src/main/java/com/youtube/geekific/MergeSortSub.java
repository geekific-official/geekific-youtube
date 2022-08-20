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

/*
    This implementation creates two sub-arrays
 */
@SuppressWarnings("unchecked")
public record MergeSortSub<T extends Comparable<T>>(T[] arr) implements MergeSort {

    @Override
    public void sort() {
        mergesort(0, arr.length - 1);
    }

    private void mergesort(int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        mergesort(low, middle);
        mergesort(middle + 1, high);
        merge(low, middle, high);
    }

    private void merge(int low, int middle, int high) {

        T[] leftArray = (T[]) new Comparable[middle - low + 1];
        T[] rightArray = (T[]) new Comparable[high - middle];

        System.arraycopy(arr, low, leftArray, 0, leftArray.length);
        System.arraycopy(arr, middle + 1, rightArray, 0, rightArray.length);

        int leftSubArrCounter = 0;
        int rightSubArrCounter = 0;
        int arrCounter = low;
        while (leftSubArrCounter < leftArray.length && rightSubArrCounter < rightArray.length) {
            arr[arrCounter++] = leftArray[leftSubArrCounter].compareTo(rightArray[rightSubArrCounter]) <= 0
                    ? leftArray[leftSubArrCounter++]
                    : rightArray[rightSubArrCounter++];
        }

        while (leftSubArrCounter < leftArray.length) {
            arr[arrCounter++] = leftArray[leftSubArrCounter++];
        }

        while (rightSubArrCounter < rightArray.length) {
            arr[arrCounter++] = rightArray[rightSubArrCounter++];
        }

    }

}
