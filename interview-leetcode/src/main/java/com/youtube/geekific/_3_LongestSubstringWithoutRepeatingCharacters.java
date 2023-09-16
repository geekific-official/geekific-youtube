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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Video Reference: https://youtu.be/y-oxz75mohQ
 * LeetCode Reference: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring_bruteForce(String s) {
        int max = 0;
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                Set<Character> chars = new HashSet<>();
                for (int k = start; k <= end; k++) {
                    chars.add(s.charAt(k));
                }
                if (chars.size() == end - start + 1) {
                    max = Math.max(max, chars.size());
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring_linear(String s) {
        int max = 0, left = 0, right = 0;
        Set<Character> chars = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (chars.contains(c)) {
                chars.remove(s.charAt(left));
                left++;
            } else {
                chars.add(c);
                max = Math.max(max, chars.size());
                right++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring_optimal(String s) {
        int max = 0, left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                max = Math.max(max, right - left);
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            right++;
        }
        return Math.max(max, right - left);
    }

}
