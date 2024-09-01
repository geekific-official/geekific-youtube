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
 * Video Reference: https://youtu.be/mVkyZzmuQmg
 * LeetCode Reference: https://leetcode.com/problems/container-with-most-water/
 */
public class _0011_ContainerWithMostWater {

    public int maxArea_bruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int localArea = Math.abs(i - j) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, localArea);
            }
        }
        return maxArea;
    }

    public int maxArea_optimal(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int localArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, localArea);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

}
