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

@SuppressWarnings("unchecked")
public abstract class Heap<T extends Comparable<T>> implements IHeap<T> {

    protected T[] heap;
    protected int position = -1;

    public Heap() {
        heap = (T[]) new Comparable[2];
    }

    protected abstract void fixUpward();

    protected abstract void fixDownward(int endIndex);

    @Override
    public IHeap<T> insert(T data) {
        if (isFull()) {
            resize(2 * heap.length);
        }
        heap[++position] = data;
        fixUpward();
        return this;
    }

    @Override
    public T getRoot() {
        if (isEmpty()) {
            return null;
        }
        T result = heap[0];
        heap[0] = heap[position--];
        heap[position + 1] = null;
        fixDownward(position);
        return result;
    }

    @Override
    public void sort() {
        for (int i = 0; i <= position; i++) {
            swap(0, position - i);
            fixDownward(position - i - 1);
        }
        print();
    }

    public void print() {
        Arrays.stream(heap).forEach(item -> System.out.print(item + " -> "));
        System.out.println();
    }

    protected void swap(int firstIndex, int secondIndex) {
        T temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }

    private void resize(int capacity) {
        System.arraycopy(heap, 0, heap = (T[]) new Comparable[capacity], 0, position + 1);
    }

    private boolean isFull() {
        return position == heap.length - 1;
    }

    private boolean isEmpty() {
        return heap.length == 0;
    }

}
