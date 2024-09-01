/*
 * MIT License
 *
 * Copyright (c) 2024 Geekific (https://www.youtube.com/c/Geekific)
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

public class DoublyLinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;

    @Override
    public void insertAtHead(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
    }

    @Override
    public void insertAtTail(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
    }

    @Override
    public void remove(T data) {
        if (isEmpty()) {
            System.out.println("List is empty!");
        } else if (head.getData().equals(data)) {
            head = head.getNext();
        } else if (tail.getData().equals(data)) {
            tail = tail.getPrevious();
        } else {
            Node<T> currentNode = head.getNext();
            while (currentNode != null) {
                if (currentNode.getData().equals(data)) {
                    currentNode.getPrevious().setNext(currentNode.getNext());
                    currentNode.getNext().setPrevious(currentNode.getPrevious());
                    break;
                }
                currentNode = currentNode.getNext();
            }
        }
    }

    @Override
    public void traverseFromHead() {
        if (isEmpty()) {
            System.out.println("List is empty!");
        }
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    @Override
    public void traverseFromTail() {
        if (isEmpty()) {
            System.out.println("List is empty!");
        }
        Node<T> currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.getPrevious();
        }
        System.out.println();
    }

    @Override
    public void traverseRecursivelyFromHead() {
        if (isEmpty()) {
            System.out.println("List is empty!");
        }
        traverseHead(head);
        System.out.println();
    }

    void traverseHead(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node);
        traverseHead(node.getNext());
    }

    @Override
    public void traverseRecursivelyFromTail() {
        if (isEmpty()) {
            System.out.println("List is empty!");
        }
        traverseTail(tail);
        System.out.println();
    }

    void traverseTail(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node);
        traverseTail(node.getPrevious());
    }

    @Override
    public void reverse() {
        Node<T> temp = null;
        Node<T> oldHead = head;
        Node<T> currentNode = head;
        while (currentNode != null) {
            temp = currentNode.getPrevious();
            currentNode.setPrevious(currentNode.getNext());
            currentNode.setNext(temp);
            currentNode = currentNode.getPrevious();
        }
        if (temp != null) head = temp.getPrevious();
        tail = oldHead;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

}
