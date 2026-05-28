/*
 * MIT License
 *
 * Copyright (c) 2025 Geekific (https://www.youtube.com/c/Geekific)
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
 * Video Reference: https://youtu.be/BYhJYhHCKPM
 * LeetCode Reference: https://leetcode.com/problems/merge-sorted-array/
 */
public class _0088_MergeSortedArray {

    public void merge_Sorting(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; j < n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    public void merge_TwoPointers(int[] nums1, int m, int[] nums2, int n) {
        int nums1Tail = m - 1;
        int nums2Tail = n - 1;
        int combinedTail = m + n - 1;

        while (nums1Tail >= 0 && nums2Tail >= 0) {
            if (nums1[nums1Tail] > nums2[nums2Tail]) {
                nums1[combinedTail] = nums1[nums1Tail];
                nums1Tail--;
            } else {
                nums1[combinedTail] = nums2[nums2Tail];
                nums2Tail--;
            }
            combinedTail--;
        }

        while (nums2Tail >= 0) {
            nums1[combinedTail--] = nums2[nums2Tail--];
        }
    }

    public void merge_TwoPointersSimplified(int[] nums1, int m, int[] nums2, int n) {
        int nums1Tail = m - 1;
        int nums2Tail = n - 1;
        int combinedTail = m + n - 1;

        while (nums1Tail >= 0 && nums2Tail >= 0) {
            nums1[combinedTail--] = (nums1[nums1Tail] > nums2[nums2Tail]) ? nums1[nums1Tail--] : nums2[nums2Tail--];
        }

        while (nums2Tail >= 0) {
            nums1[combinedTail--] = nums2[nums2Tail--];
        }
    }

}
