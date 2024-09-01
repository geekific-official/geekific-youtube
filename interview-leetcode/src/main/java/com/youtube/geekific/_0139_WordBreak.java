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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Video Reference: https://youtu.be/I9bwnqbOd-0
 * LeetCode Reference: https://leetcode.com/problems/word-break/
 */
public class _0139_WordBreak {

    static class Solution_Recursion {
        public boolean wordBreak(String str, List<String> wordDict) {
            return wordBreak(str, wordDict, str.length() - 1);
        }

        private boolean wordBreak(String str, List<String> wordDict, int idx) {
            if (idx < 0) {
                return true;
            }
            for (String word : wordDict) {
                if (idx - word.length() + 1 < 0) {
                    continue;
                }
                if (str.substring(idx - word.length() + 1, idx + 1).equals(word) && wordBreak(str, wordDict, idx - word.length())) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Solution_Memoization {
        public boolean wordBreak(String str, List<String> wordDict) {
            Map<Integer, Boolean> cache = new HashMap<>();
            return wordBreak(str, wordDict, str.length() - 1, cache);
        }

        private boolean wordBreak(String str, List<String> wordDict, int idx, Map<Integer, Boolean> cache) {
            if (idx < 0) {
                return true;
            }
            if (cache.containsKey(idx)) {
                return cache.get(idx);
            }
            for (String word : wordDict) {
                if (idx - word.length() + 1 < 0) {
                    continue;
                }
                if (str.substring(idx - word.length() + 1, idx + 1).equals(word) && wordBreak(str, wordDict, idx - word.length(), cache)) {
                    cache.put(idx, true);
                    return true;
                }
            }
            cache.put(idx, false);
            return false;
        }
    }

    static class Solution_Tabulation {
        public boolean wordBreak(String str, List<String> wordDict) {
            boolean[] dp = new boolean[str.length()];
            for (int idx = 0; idx < str.length(); idx++) {
                for (String word : wordDict) {
                    if (idx < word.length() - 1) {
                        continue;
                    }
                    if ((idx == word.length() - 1 || dp[idx - word.length()]) && str.substring(idx - word.length() + 1, idx + 1).equals(word)) {
                        dp[idx] = true;
                        break;
                    }
                }
            }
            return dp[str.length() - 1];
        }
    }

}
