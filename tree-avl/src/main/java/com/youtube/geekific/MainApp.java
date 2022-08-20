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
     * Video Reference: https://youtu.be/Jj9Mit24CWk
     */
    public static void main(String[] args) {

        Tree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(10).insert(2).insert(6).insert(8).insert(25).insert(18).insert(35).insert(15).insert(22).insert(42)
                .insert(30).insert(40).insert(12).insert(17).insert(19).insert(24).insert(28).insert(33).insert(38);

        avlTree.traverse();

        System.out.println("Max is: " + avlTree.getMax());
        System.out.println("Min is: " + avlTree.getMin());

        System.out.println("Deleting 42 from Tree");
        avlTree.delete(42);

        System.out.println("New Max is: " + avlTree.getMax());

        avlTree.traverse();

    }

}
