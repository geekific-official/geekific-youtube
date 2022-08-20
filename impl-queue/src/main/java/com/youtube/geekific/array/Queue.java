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

package com.youtube.geekific.array;

import java.util.Arrays;

import static java.lang.reflect.Array.newInstance;

@SuppressWarnings("unchecked")
public class Queue<T> {

    private final T[] queue;
    private final int capacity;

    private int head;
    private int tail;
    private int size;

    public Queue(int capacity) {
        queue = (T[]) newInstance(Object.class, capacity);
        this.capacity = capacity;
        head = 0;
        size = 0;
        tail = -1;
    }

    public void enqueue(T data) {
        if (isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        tail = (tail + 1) % capacity;
        queue[tail] = data;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        }
        T dataToRemove = queue[head];
        head = (head + 1) % capacity;
        size--;
        return dataToRemove;
    }

    public T peek() {
        return queue[head];
    }

    public int getSize() {
        return size;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
