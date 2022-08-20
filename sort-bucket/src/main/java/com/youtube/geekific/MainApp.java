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

import java.util.Arrays;
import java.util.List;

public class MainApp {

    /*
     * Video Reference: https://youtu.be/ROnYubH_spM
     */
    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(42, 32, 63, 82, 37, 17, 51, 21, 22, 75);
        System.out.println(new BucketSort<Integer>().sort(ints, (item, size) -> item / size));

        List<Float> floats = Arrays.asList(0.42F, 0.32F, 0.63F, 0.82F, 0.37F, 0.17F, 0.51F, 0.21F, 0.22F, 0.75F);
        System.out.println(new BucketSort<Float>().sort(floats, (item, size) -> (int) (item * size)));

        float[] array = new float[]{0.42F, 0.32F, 0.63F, 0.82F, 0.37F, 0.17F, 0.51F, 0.21F, 0.22F, 0.75F};
        new BucketSortClassic().sort(array);
        System.out.println(Arrays.toString(array));

    }

}
