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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record RadixSort(int[] arr) {

    public void sort() {
        Map<Boolean, List<Integer>> splitArray = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i < 0));
        int[] negativeInts = radixSort(splitArray.get(true).stream().mapToInt(Integer::intValue).map(Math::abs).toArray());
        int[] positiveInts = radixSort(splitArray.get(false).stream().mapToInt(Integer::intValue).toArray());
        for (int i = negativeInts.length - 1, j = 0; i >= 0; i--, j++) arr[j] = -negativeInts[i];
        System.arraycopy(positiveInts, 0, arr, negativeInts.length, positiveInts.length);
    }

    public int[] radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(exp, arr);
        }
        return arr;
    }

    private void countSort(int exp, int[] arr) {

        int[] output = new int[arr.length];
        int[] countArray = new int[10];

        // Store count of occurrences in countArray[]
        for (int value : arr) {
            countArray[(value / exp) % 10]++;
        }

        // Change countArray[i] so that countArray[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            int positionInArray = countArray[(current / exp) % 10] - 1;
            output[positionInArray] = current;
            countArray[(current / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);

    }

}
