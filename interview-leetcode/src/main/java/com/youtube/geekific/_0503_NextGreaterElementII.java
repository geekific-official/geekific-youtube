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

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

/*
 * Video Reference: https://youtu.be/49zDjEj3kYg
 * LeetCode Reference: https://leetcode.com/problems/next-greater-element-ii/
 */
public class _0503_NextGreaterElementII {

    public int[] nextGreaterElements_monotonicStacks(int[] nums) {
        int[] result = IntStream.generate(() -> -1).limit(nums.length).toArray();
        Deque<Integer> stack = new LinkedList<>();
        for (int k = 0; k < nums.length; k++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[k]) {
                result[stack.pop()] = nums[k];
            }
            stack.push(k);
        }
        for (int num : nums) {
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
        }
        return result;
    }

    public static int[] nextGreaterElements_maxApproach(int[] nums) {
        int[] result = new int[nums.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int k = 0; k < nums.length; k++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[k]) {
                result[stack.pop()] = nums[k];
            }
            stack.push(k);
        }
        int max = stack.stream().map(o -> nums[o]).max(Comparator.naturalOrder()).get();
        int j = 0;
        while (!stack.isEmpty()) {
            if (nums[stack.peek()] == max) {
                result[stack.pop()] = -1;
                continue;
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
                result[stack.pop()] = nums[j];
            }
            j++;
        }
        return result;
    }

}
