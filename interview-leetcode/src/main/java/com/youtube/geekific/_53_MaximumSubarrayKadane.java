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

/*
 * Video Reference: https://youtu.be/cOYfwgtQ1kg
 * LeetCode Reference: https://leetcode.com/problems/maximum-subarray/
 */
public class _53_MaximumSubarrayKadane {

    public int maxSubArray_bruteForce(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int globalMaximum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int localMaximum = 0;
            for (int j = i; j < nums.length; j++) {
                localMaximum += nums[j];
                globalMaximum = Math.max(globalMaximum, localMaximum);
            }
        }
        return globalMaximum;
    }


    public int maxSubArray_leetCode_optimal(int[] nums) {
        int localMaximum = 0;
        int globalMaximum = Integer.MIN_VALUE;
        for (int num : nums) {
            localMaximum = Math.max(num, num + localMaximum);
            globalMaximum = Math.max(localMaximum, globalMaximum);
        }
        return globalMaximum;
    }

}
