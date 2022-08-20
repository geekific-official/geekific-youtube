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

import java.util.stream.IntStream;

public record InsertionSort<T extends Comparable<T>>(T[] arr) {

    public void sort() {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                T temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public void sortWithStreams() {
        IntStream.range(1, arr.length)
                .forEach(i ->
                        IntStream.iterate(i, j -> j > 0 && arr[j].compareTo(arr[j - 1]) < 0, j -> j - 1)
                                .forEach(j -> {
                                    T temp = arr[j];
                                    arr[j] = arr[j - 1];
                                    arr[j - 1] = temp;
                                })
                );
    }

    public void sortRecursively() {
        IntStream.range(1, arr.length).forEach(this::sort);
    }

    private void sort(int index) {
        if (index > 0 && arr[index].compareTo(arr[index - 1]) < 0) {
            T temp = arr[index];
            arr[index] = arr[index - 1];
            arr[index - 1] = temp;
            sort(index - 1);
        }
    }

}
