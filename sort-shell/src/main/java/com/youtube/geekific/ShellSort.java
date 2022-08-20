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

public record ShellSort<T extends Comparable<T>>(T[] arr) {

    public void sort() {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j >= gap && arr[j].compareTo(arr[j - gap]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                    j -= gap;
                }
            }
        }
    }

    public void sortRecursively() {
        IntStream.iterate(arr.length / 2, gap -> gap > 0, gap -> gap / 2).forEach(gap ->
                IntStream.range(gap, arr.length).forEach(index -> sort(index, gap))
        );
    }

    private void sort(int index, int gap) {
        if (index >= gap && arr[index].compareTo(arr[index - gap]) < 0) {
            T temp = arr[index];
            arr[index] = arr[index - 1];
            arr[index - 1] = temp;
            sort(index - gap, gap);
        }
    }

}
