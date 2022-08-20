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
import java.util.Map;

public class Trie implements Tree {

    private final Node root;

    public Trie() {
        root = new Node(' ');
    }

    @Override
    public Tree insert(String word) {
        Node currentNode = root;
        Map<Character, Node> children = root.getChildren();
        for (char c : word.toCharArray()) {
            if (children.containsKey(c)) {
                currentNode = children.get(c);
            } else {
                currentNode = new Node(c);
                children.put(c, currentNode);
            }
            children = currentNode.getChildren();
        }
        currentNode.setEndOfWord(true);
        return this;
    }

    @Override
    public boolean contains(String word) {
        Node lastPresentNode = search(word);
        return lastPresentNode != null && lastPresentNode.isEndOfWord();
    }

    @Override
    public boolean containsPrefix(String prefix) {
        return search(prefix) != null;
    }

    private Node search(String str) {
        Node currentNode = null;
        Map<Character, Node> children = root.getChildren();
        for (char c : str.toCharArray()) {
            if (!children.containsKey(c)) {
                return null;
            }
            currentNode = children.get(c);
            children = currentNode.getChildren();
        }
        return currentNode;
    }

    @Override
    public List<String> wordsWithPrefix(String prefix) {
        List<String> words = new ArrayList<>();
        Node prefixNode = search(prefix);
        if (prefixNode != null) {
            addWords(prefixNode, prefix, words);
        }
        return words;
    }

    private void addWords(Node node, String word, List<String> wordList) {
        if (node.isEndOfWord()) {
            wordList.add(word);
        }
        node.getChildren().values().forEach(child -> {
            String character = String.valueOf(child.getCharacter());
            addWords(child, word.concat(character), wordList);
        });
    }

    @Override
    public void delete(String word) {
        List<Node> list = new ArrayList<>();
        Map<Character, Node> children = root.getChildren();
        for (char c : word.toCharArray()) {
            if (!children.containsKey(c)) {
                break;
            }
            Node currentNode = children.get(c);
            children = currentNode.getChildren();
            list.add(currentNode);
        }
        if (list.isEmpty() || list.size() != word.length()) {
            return;
        }
        list.get(list.size() - 1).setEndOfWord(false);
        for (int i = list.size() - 1; i > 0; i--) {
            Node current = list.get(i);
            if (current.isEndOfWord()) {
                break;
            } else if (current.getChildren().isEmpty()) {
                list.get(i - 1).getChildren().remove(current.getCharacter());
            }
        }
    }

}
