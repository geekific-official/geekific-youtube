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

public record CountingSort(int[] arr) {

    public void sort() {
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        int[] countArray = new int[max - min + 1];
        for (int value : arr) {
            countArray[value - min]++;
        }

        int arrayIndex = 0;
        for (int i = max - min; i >= 0; i--) {
            while (countArray[i] > 0) {
                arr[arrayIndex] = i + min;
                countArray[i]--;
                arrayIndex++;
            }
        }
    }

    public void countingSort() {
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        int[] countArray = new int[max - min + 1];
        for (int value : arr) {
            countArray[value - min]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            int positionInArray = countArray[current - min] - 1;
            output[positionInArray] = current;
            countArray[current - min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

}