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

import java.util.ArrayList;
import java.util.List;

/*
 * Video Reference: https://youtu.be/fUib_XkvqVg
 * LeetCode Reference: https://leetcode.com/problems/subsets/
 */
public class _0078_Subsets {

    public List<List<Integer>> subsets_backtracking(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {
            backtrack(subsets, new ArrayList<>(), nums, k, 0);
        }
        return subsets;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> currentComb, int[] nums, int k, int start) {
        if (currentComb.size() == k) {
            combinations.add(new ArrayList<>(currentComb));
            return;
        }
        for (int currIndex = start; currIndex < nums.length; currIndex++) {
            currentComb.add(nums[currIndex]);
            backtrack(combinations, currentComb, nums, k, currIndex + 1);
            currentComb.remove(currentComb.size() - 1);
        }
    }

    public List<List<Integer>> subsets_cascading(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : allSubsets) {
                newSubsets.add(new ArrayList<>(curr) {{
                    add(num);
                }});
            }
            allSubsets.addAll(newSubsets);
        }
        return allSubsets;
    }

}
