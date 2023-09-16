/*
 * MIT License
 *
 * Copyright (c) 2023 Geekific (https://www.youtube.com/c/Geekific)
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

public class MainApp {

    /*
     * Video Reference: https://youtu.be/cYAZZt8GyUs
     */
    public static void main(String[] args) {

        List<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertAtHead(10);
        doublyLinkedList.insertAtHead(20);
        doublyLinkedList.insertAtHead(30);
        doublyLinkedList.insertAtHead(40);
        doublyLinkedList.traverseFromHead();
        doublyLinkedList.remove(20);
        doublyLinkedList.traverseRecursivelyFromHead();

        System.out.println("==========================================");

        doublyLinkedList.reverse();
        doublyLinkedList.traverseFromHead();
        doublyLinkedList.insertAtTail(50);
        doublyLinkedList.insertAtTail(60);
        doublyLinkedList.insertAtTail(70);
        doublyLinkedList.insertAtTail(80);
        doublyLinkedList.traverseFromHead();

        System.out.println("==========================================");

        doublyLinkedList.traverseFromTail();
        doublyLinkedList.remove(60);
        doublyLinkedList.traverseRecursivelyFromTail();
        doublyLinkedList.reverse();
        doublyLinkedList.traverseFromTail();
    }

}
