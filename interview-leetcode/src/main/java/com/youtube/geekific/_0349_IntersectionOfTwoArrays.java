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
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Video Reference: https://youtu.be/VrYRHIG1nDY & https://youtu.be/SrkBi9aZJOw
 * LeetCode Reference: https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class _0349_IntersectionOfTwoArrays {

    public int[] intersection_bruteForce(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                if (n1 == n2) {
                    result.add(n1);
                    break;
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection_linear(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n1 : nums1) {
            set.add(n1);
        }
        Set<Integer> result = new HashSet<>();
        for (int n2 : nums2) {
            if (set.contains(n2)) {
                result.add(n2);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection_usingRetainAll(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2); // OR set2.retainAll(set1);
        return set1.stream().mapToInt(Integer::intValue).toArray(); // OR set2.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection_binarySearch(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> result = new HashSet<>();
        for (int n2 : set2) {
            if (binarySearch(nums1, n2)) {
                result.add(n2);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
