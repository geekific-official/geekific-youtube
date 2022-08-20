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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        root = insert(data, root);
    }

    private Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(data, node.getRightChild()));
        }
        return node;
    }

    @Override
    public List<T> getSortedElements() {
        List<T> list = new ArrayList<>();
        sort(root, list);
        return list;
    }

    private void sort(Node<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        sort(node.getLeftChild(), list);
        list.add(node.getData());
        sort(node.getRightChild(), list);
    }

    @Override
    public void printSortedElements() {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = root;
        while (!stack.empty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.getLeftChild();
            } else {
                Node<T> node = stack.pop();
                System.out.print(node.getData() + " - ");
                current = node.getRightChild();
            }
        }
        System.out.println();
    }

}
