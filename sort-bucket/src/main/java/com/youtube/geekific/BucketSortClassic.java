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
import java.util.Collections;
import java.util.List;

public class BucketSortClassic {

    void sort(float[] arr) {
        if (arr.length == 0) return;

        // 1) Create max empty buckets
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            buckets.add(new ArrayList<>());
        }

        // 2) Put elements in different buckets
        for (float item : arr) {
            int index = (int) item * arr.length;
            buckets.get(index).add(item);
        }

        // 3) Sort individual buckets
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 4) Concatenate all buckets back into arr[]
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (Float item : bucket) {
                arr[index++] = item;
            }
        }
    }

}
