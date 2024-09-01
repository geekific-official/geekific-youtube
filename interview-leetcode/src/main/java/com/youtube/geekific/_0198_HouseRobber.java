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
 * Video Reference: https://youtu.be/TILWk1pQ7oU
 * LeetCode Reference: https://leetcode.com/problems/house-robber/
 */
public class _0198_HouseRobber {

    public int rob_recursion(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return getMaxAmount(nums, nums.length - 1);
    }

    private int getMaxAmount(int[] nums, int n) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];
        if (n == 1) return Integer.max(nums[1], nums[0]);
        return Integer.max(nums[n] + getMaxAmount(nums, n - 2), getMaxAmount(nums, n - 1));
    }

    public int rob_dp_linearSpace(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Integer.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int rob_dp_constantSpace(int[] nums) {
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int curr = Math.max(num + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

}
