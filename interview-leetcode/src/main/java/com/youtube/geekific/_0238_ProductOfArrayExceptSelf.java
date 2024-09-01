/*
 * MIT License
 *
 * Copyright (c) 2024 Geekific (https://www.youtube.com/c/Geekific)
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

/*
 * Video Reference: https://youtu.be/DYwBZIFMoTk
 * LeetCode Reference: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class _0238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        int left = 1, right = 1;
        for (int i = len - 1; i >= 0; i--) {
            answer[i] = right;
            right *= nums[i];
        }
        for (int j = 0; j < len; j++) {
            answer[j] *= left;
            left *= nums[j];
        }
        return answer;
    }

    public int[] productExceptSelf_SingleLoop(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        int left = 1, right = 1;
        for (int i = 0; i < n; i++) {
            answer[i] *= left;
            left *= nums[i];
            answer[n - i - 1] *= right;
            right *= nums[n - i - 1];
        }
        return answer;
    }

}
