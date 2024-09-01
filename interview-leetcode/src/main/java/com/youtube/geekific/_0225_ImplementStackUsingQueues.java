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
 * Video Reference: https://youtu.be/N7RykWhHogk
 * LeetCode Reference: https://leetcode.com/problems/implement-stack-using-queues/
 */
public class _0225_ImplementStackUsingQueues {

    public static class Stack<T> {
        Deque<T> queue1 = new LinkedList<>();
        Deque<T> queue2 = new LinkedList<>();

        public void push(T value) {
            queue2.add(value);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
            Deque<T> q = queue1;
            queue1 = queue2;
            queue2 = q;
        }

        public T pop() {
            if (queue1.isEmpty()) {
                return null;
            }
            return queue1.remove();
        }

        public T peek() {
            if (queue1.isEmpty()) {
                return null;
            }
            return queue1.peek();
        }

        public boolean isEmpty() {
            return queue1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("==========================================");

        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }


}
