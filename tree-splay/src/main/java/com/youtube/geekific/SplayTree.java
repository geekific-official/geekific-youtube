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

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public Tree<T> insert(T data) {
        root = insert(root, new Node<>(data));
        return this;
    }

    private Node<T> insert(Node<T> node, Node<T> nodeToInsert) {
        if (node == null) {
            return nodeToInsert;
        }
        if (nodeToInsert.getData().compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(node.getLeftChild(), nodeToInsert));
            node.getLeftChild().setParent(node);
        } else if (nodeToInsert.getData().compareTo(node.getData()) > 0) {
            node.setRightChild(insert(node.getRightChild(), nodeToInsert));
            node.getRightChild().setParent(node);
        }
        return node;
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
    }

    private Node<T> delete(T data, Node<T> node) {
        if (node == null) return null;

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(data, node.getLeftChild()));
            if (node.getLeftChild() != null) node.getLeftChild().setParent(node);
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(data, node.getRightChild()));
            if (node.getRightChild() != null) node.getRightChild().setParent(node);
        } else {
            // One Child or Leaf Node (no children)
            if (node.getLeftChild() == null) return node.getRightChild();
            else if (node.getRightChild() == null) return node.getLeftChild();
            // Two Children
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
            if (node.getLeftChild() != null) node.getLeftChild().setParent(node);
        }
        return node;
    }

    @Override
    public Node<T> find(T data) {
        Node<T> node = root;
        while (node != null) {
            if (node.getData().compareTo(data) == 0) {
                splay(node);
                return node;
            }
            node = data.compareTo(node.getData()) < 0 ? node.getLeftChild() : node.getRightChild();
        }
        return null;
    }

    @Override
    public Node<T> findRecursively(T data) {
        return find(root, data);
    }

    public Node<T> find(Node<T> node, T data) {
        if (node != null) {
            if (node.getData().compareTo(data) == 0) {
                splay(node);
                return node;
            }
            Node<T> nextNode = data.compareTo(node.getData()) > 0 ? node.getRightChild() : node.getLeftChild();
            find(nextNode, data);
        }
        return null;
    }

    private void splay(Node<T> node) {
        while(node != root) {
            Node<T> parent = node.getParent();
            if (node.getGrandParent() == null) {
                if (node.isLeftChild()) {
                    rotateRight(parent);
                } else {
                    rotateLeft(parent);
                }
            } else if (node.isLeftChild() && parent.isLeftChild()) {
                rotateRight(node.getGrandParent());
                rotateRight(parent);
            } else if (node.isRightChild() && parent.isRightChild()) {
                rotateLeft(node.getGrandParent());
                rotateLeft(parent);
            } else if (node.isLeftChild() && parent.isRightChild()) {
                rotateRight(parent);
                rotateLeft(parent);
            } else {
                rotateLeft(parent);
                rotateRight(parent);
            }
        }
    }

    private void rotateRight(Node<T> node) {
        Node<T> leftNode = node.getLeftChild();
        node.setLeftChild(leftNode.getRightChild());
        if (node.getLeftChild() != null) {
            node.getLeftChild().setParent(node);
        }
        updateChildrenOfParentNode(node, leftNode);
        leftNode.setParent(node.getParent());
        leftNode.setRightChild(node);
        node.setParent(leftNode);
    }

    private void rotateLeft(Node<T> node) {
        Node<T> rightNode = node.getRightChild();
        node.setRightChild(rightNode.getLeftChild());
        if (node.getRightChild() != null) {
            node.getRightChild().setParent(node);
        }
        updateChildrenOfParentNode(node, rightNode);
        rightNode.setParent(node.getParent());
        rightNode.setLeftChild(node);
        node.setParent(rightNode);
    }

    private void updateChildrenOfParentNode(Node<T> node, Node<T> tempNode) {
        if (node.getParent() == null) {
            root = tempNode;
        } else if (node.isLeftChild()) {
            node.getParent().setLeftChild(tempNode);
        } else {
            node.getParent().setRightChild(tempNode);
        }
    }

    @Override
    public void traverse() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.println(node);
            traverseInOrder(node.getRightChild());
        }
    }

    @Override
    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    @Override
    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

}
