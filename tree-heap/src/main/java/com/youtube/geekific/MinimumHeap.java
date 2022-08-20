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

public class MinimumHeap<T extends Comparable<T>> extends Heap<T> {

    protected void fixUpward() {
        int index = position;
        int parentIndex = (index - 1) / 2;
        while (parentIndex >= 0 && heap[index].compareTo(heap[parentIndex]) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    protected void fixDownward(int endIndex) {
        if (endIndex == -1) return;
        int index = 0;
        while (index <= endIndex) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            if (leftChildIndex > endIndex) break;

            int childToSwap = rightChildIndex > endIndex
                    ? leftChildIndex
                    : heap[leftChildIndex].compareTo(heap[rightChildIndex]) < 0
                        ? leftChildIndex
                        : rightChildIndex;

            if (heap[index].compareTo(heap[childToSwap]) < 0) break;
            swap(index, childToSwap);
            index = childToSwap;
        }
    }

}