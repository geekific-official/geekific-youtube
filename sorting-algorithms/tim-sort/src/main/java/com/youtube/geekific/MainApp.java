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

import java.util.Arrays;

public class MainApp {

    /*
     * Video Reference: https://youtu.be/GhP5WbE4GYo
     */
    public static void main(String[] args) {

        Integer[] integers = { 10, 55, -5, 34, 7, 22, 19, 27, -87, 12, 9, 41, -67, -32, 92, 17, 23, 45, -22, 29 };
        String[] strings = { "Tyrion", "Arya", "Daenerys", "Sansa", "Cersei" };
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));

        new TimSort<>(integers).sort();
        new TimSort<>(strings).sort();
        System.out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));

    }

}
