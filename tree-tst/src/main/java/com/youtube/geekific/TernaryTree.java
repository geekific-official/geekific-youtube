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

public class TernaryTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public Tree<T> insert(String word, T value) {
        root = insert(root, word, value, 0);
        return this;
    }

    private Node<T> insert(Node<T> node, String word, T value, int index) {
        char character = word.charAt(index);
        if (node == null) {
            node = new Node<>(character);
        }
        if (character < node.getCharacter()) {
            node.setLeftChild(insert(node.getLeftChild(), word, value, index));
        } else if (character > node.getCharacter()) {
            node.setRightChild(insert(node.getRightChild(), word, value, index));
        } else if (index < word.length() - 1) {
            node.setMiddleChild(insert(node.getMiddleChild(), word, value, index + 1));
        } else if (index == word.length() - 1) {
            node.setValue(value);
        }
        return node;
    }

    @Override
    public boolean contains(String word) {
        Node<T> node = search(root, word, 0);
        return node != null && node.isEndOfWord();
    }

    @Override
    public T get(String word) {
        Node<T> node = search(root, word, 0);
        return node != null ? node.getValue() : null;
    }

    private Node<T> search(Node<T> node, String word, int index) {
        if (node == null) {
            return null;
        }
        char character = word.charAt(index);
        if (character < node.getCharacter()) {
            return search(node.getLeftChild(), word, index);
        } else if (character > node.getCharacter()) {
            return search(node.getRightChild(), word, index);
        } else if (index < word.length() - 1) {
            return search(node.getMiddleChild(), word, index + 1);
        }
        return node;
    }

    @Override
    public void softDelete(String word) {
        delete(root, word, 0);
    }

    private void delete(Node<T> node, String word, int index) {
        if (node == null) return;
        char character = word.charAt(index);
        if (character < node.getCharacter())
            delete(node.getLeftChild(), word, index);
        else if (character > node.getCharacter())
            delete(node.getRightChild(), word, index);
        else if (index < word.length() - 1)
            delete(node.getMiddleChild(), word, index + 1);
        else if (index == word.length() - 1 && node.isEndOfWord())
            node.setValue(null);
    }

}
