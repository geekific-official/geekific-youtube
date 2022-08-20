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

public class MainApp {

    /*
     * Video Reference: https://youtu.be/L3hfc7Hvirw
     */
    public static void main(String[] args) {

        Heap<Integer> maximumHeap = new MaximumHeap<>();
        maximumHeap.insert(50).insert(40).insert(60).insert(30).insert(70).insert(20).insert(100);
        maximumHeap.print();

        System.out.println(maximumHeap.getRoot());
        maximumHeap.print();

        maximumHeap.sort();

        System.out.println("==========================================");

        Heap<Integer> minimumHeap = new MinimumHeap<>();
        minimumHeap.insert(50).insert(40).insert(60).insert(30).insert(70).insert(20).insert(100);
        minimumHeap.print();

        System.out.println(minimumHeap.getRoot());
        minimumHeap.print();

        minimumHeap.sort();

    }

}
