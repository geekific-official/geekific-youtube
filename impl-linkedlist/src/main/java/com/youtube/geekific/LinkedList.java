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

public class LinkedList<T> implements List<T> {

    private Node<T> root;
    private int size;

    @Override
    public void insert(T data) {
        Node<T> node = new Node<>(data);
        node.setNextNode(root);
        root = node;
        size++;
    }

    @Override
    public void remove(T data) {
        if (root.getData().equals(data)) {
            root = root.getNextNode();
        } else {
            Node<T> previousNode = root;
            Node<T> currentNode = root.getNextNode();
            while (currentNode != null) {
                if (currentNode.getData().equals(data)) {
                    previousNode.setNextNode(currentNode.getNextNode());
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
        }
        size--;
    }

    @Override
    public void removeRecursively(T data) {
        if (root.getData().equals(data)) {
            root = root.getNextNode();
        } else {
            removeRecursively(data, root, root.getNextNode());
        }
        size--;
    }

    private void removeRecursively(T data, Node<T> previousNode, Node<T> currentNode) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.getData().equals(data)) {
            previousNode.setNextNode(currentNode.getNextNode());
            return;
        }
        removeRecursively(data, currentNode, currentNode.getNextNode());
    }

    @Override
    public void traverse() {
        if (isEmpty()) {
            System.out.println("List is empty!");
        }
        Node<T> currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    @Override
    public void traverseRecursively() {
        if (isEmpty()) {
            System.out.println("List is empty!");
        }
        traverse(root);
        System.out.println();
    }

    void traverse(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node);
        traverse(node.getNextNode());
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
