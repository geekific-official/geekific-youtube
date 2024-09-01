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

import java.util.Deque;
import java.util.LinkedList;

/*
 * Video Reference: https://youtu.be/dGv0QeJf5F8
 * LeetCode Reference: https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class _0232_ImplementQueueUsingStacks {

    public static class Queue<T> {
        Deque<T> stack1 = new LinkedList<>();
        Deque<T> stack2 = new LinkedList<>();

        public void enqueue(T value) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(value); // stack2 also works!
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public T dequeue() {
            if (stack1.isEmpty()) {
                return null;
            }
            return stack1.pop();
        }

        public T peek() {
            if (stack1.isEmpty()) {
                return null;
            }
            return stack1.peek();
        }

        public boolean isEmpty() {
            return stack1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println("==========================================");

        Queue<Integer> myQueue = new Queue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }

}
