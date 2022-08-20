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

public class MainApp {

    /*
     * Video Reference: https://youtu.be/b6VAlM0-RaE
     */
    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Initial state of the Queue. Head: " + queue.peek() + ", Size: " + queue.getSize() + ", Queue: " + queue);

        System.out.println("Dequeued " + queue.dequeue() + " from the Queue");

        System.out.println("New head of the Queue: " + queue.peek() + ", New Size: " + queue.getSize() + ", Queue: " + queue);

        System.out.println("Inserting 50 and 60 to the Queue");
        queue.enqueue(50);
        queue.enqueue(60);

        System.out.println("New head of the Queue: " + queue.peek() + ", New Size: " + queue.getSize() + ", Queue: " + queue);

    }

}
