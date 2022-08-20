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
    This implementation creates one temporary array
 */
@SuppressWarnings("unchecked")
public class MergeSortTemp<T extends Comparable<T>> implements MergeSort {

    private final T[] arr;
    private final T[] tempArr;

    public MergeSortTemp(T[] arr) {
        this.arr = arr;
        tempArr = (T[]) new Comparable[arr.length];
    }

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

        if (high + 1 - low >= 0) {
            System.arraycopy(arr, low, tempArr, low, high + 1 - low);
        }

        int firstSubArrCounter = low;
        int secondSubArrCounter = middle + 1;
        int arrCounter = low;
        while (firstSubArrCounter <= middle && secondSubArrCounter <= high) {
            arr[arrCounter++] = (tempArr[firstSubArrCounter].compareTo(tempArr[secondSubArrCounter]) <= 0)
                    ? tempArr[firstSubArrCounter++]
                    : tempArr[secondSubArrCounter++];
        }

        while (firstSubArrCounter <= middle) {
            arr[arrCounter++] = tempArr[firstSubArrCounter++];
        }

        while (secondSubArrCounter <= high) {
            arr[arrCounter++] = tempArr[secondSubArrCounter++];
        }

    }

}
