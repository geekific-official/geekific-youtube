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

import java.util.*;

/*
 * Video Reference: https://youtu.be/oadXC05mVFM
 * LeetCode Reference: https://leetcode.com/problems/3sum/
 */
public class _15_ThreeSum {

    public List<Integer> threeSum_bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        return List.of(nums[i], nums[j], nums[k]);
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    public List<Integer> threeSum_usingTwoSum_oneSolutionExists(int[] nums, int target) {
        for (int start = 0; start < nums.length; start++) {
            List<Integer> result = twoSum(nums, target - nums[start], start + 1);
            if (!result.isEmpty()) {
                return List.of(result.get(0), result.get(1), nums[start]);
            }
        }
        return Collections.emptyList();
    }

    private List<Integer> twoSum(int[] nums, int target, int start) {
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                return List.of(target - nums[i], nums[i]);
            }
            set.add(nums[i]);
        }
        return Collections.emptyList();
    }

    public List<Integer> threeSum_oneSolutionExists(int[] nums, int target) {
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 2; left++) {
            int middle = left + 1;
            int right = nums.length - 1;
            while (middle < right) {
                int sum = nums[middle] + nums[right] + nums[left];
                if (sum == target) {
                    return List.of(nums[left], nums[middle], nums[right]);
                }
                if (sum > target) {
                    do right--; while (middle < right && nums[right] == nums[right + 1]);
                } else {
                    do middle++; while (middle < right && nums[middle] == nums[middle - 1]);
                }
            }
        }
        return Collections.emptyList();
    }

    public List<List<Integer>> threeSum_leetCode_manySolutionsExist(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int left = 0; left < nums.length - 2; left++) {
            int middle = left + 1;
            int right = nums.length - 1;
            while (middle < right) {
                int sum = nums[middle] + nums[right] + nums[left];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[left], nums[middle], nums[right]));
                }
                if (sum > 0) {
                    do right--; while (middle < right && nums[right] == nums[right + 1]);
                } else {
                    do middle++; while (middle < right && nums[middle] == nums[middle - 1]);
                }
            }
        }
        return result.stream().toList();
    }

}
