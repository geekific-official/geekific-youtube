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
 * Video Reference: https://youtu.be/fUib_XkvqVg
 * LeetCode Reference: https://leetcode.com/problems/subsets-ii/
 */
public class _90_SubsetsII {

    public List<List<Integer>> subsetsWithDup_cascading(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> allSubsets = new HashSet<>();
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
        return new ArrayList<>(allSubsets);
    }

    public List<List<Integer>> subsetsWithDup_bitmaskGeneration(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());
        int size = 0;
        for (int i = 0; i < num.length; i++) {
            int startIndex = (i >= 1 && num[i] == num[i - 1]) ? size : 0;
            size = allSubsets.size();
            for (int j = startIndex; j < size; j++) {
                List<Integer> newSubset = new ArrayList<>(allSubsets.get(j));
                newSubset.add(num[i]);
                allSubsets.add(newSubset);
            }
        }
        return allSubsets;
    }

}
