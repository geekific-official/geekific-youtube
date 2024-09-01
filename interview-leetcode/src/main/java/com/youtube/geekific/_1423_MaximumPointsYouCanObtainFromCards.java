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

/*
 * Video Reference: https://youtu.be/dvkRZz_g71w
 * LeetCode Reference: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class _1423_MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int total = 0;
        int window = cardPoints.length - k;
        for (int i = 0; i < cardPoints.length; i++) {
            total += cardPoints[i];
            if (i < window) sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = 1; i < cardPoints.length - window + 1; i++) {
            sum = sum - cardPoints[i - 1] + cardPoints[i + window - 1];
            minSum = Math.min(sum, minSum);
        }
        return total - minSum;
    }

}
