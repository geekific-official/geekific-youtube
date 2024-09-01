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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Video Reference: https://youtu.be/CZQoZB6-xhc
 * LeetCode Reference: https://leetcode.com/problems/find-the-difference/
 */
public class _0389_FindTheDifference {

    public char findTheDifference_Sorting(String s, String t) {
        char[] schars = s.toCharArray();
        Arrays.sort(schars);
        s = new String(schars);

        char[] tchars = t.toCharArray();
        Arrays.sort(tchars);
        t = new String(tchars);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) return t.charAt(i);
        }

        return t.charAt(t.length() - 1);
    }

    public char findTheDifference_Maps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : s.toCharArray()) {
            map.put(c, map.get(c) - 1);
        }
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('-');
    }

    public char findTheDifference_XOR(String s, String t) {
        char c = 0;
        for(char cs : s.toCharArray()) c ^= cs;
        for(char ct : t.toCharArray()) c ^= ct;
        return c;
    }

}
