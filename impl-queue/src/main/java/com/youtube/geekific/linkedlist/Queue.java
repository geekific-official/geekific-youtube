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

package com.youtube.geekific.linkedlist;

public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() {
        head = tail = null;
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.setNextNode(node);
            tail = node;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T removedData = head.getData();
        head = head.getNextNode();
        size--;
        return removedData;
    }

    public T peek() {
        return !isEmpty() ? head.getData() : null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0; // or we can check if head is null or if tail is null
    }

    @Override
    public String toString() {
        return head.toString();
    }
}
