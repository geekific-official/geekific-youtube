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
import java.util.Map;

/*
 * Video Reference: https://youtu.be/IjpoE28Ii34
 * LeetCode Reference: https://leetcode.com/problems/fibonacci-number/
 */
public class _0509_FibonacciNumber {

    public int fibonacci_classic(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci_classic(n - 1) + fibonacci_classic(n - 2);
    }

    Map<Integer, Integer> cache = new HashMap<>();

    public int fibonacci_memoization(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (cache.containsKey(n)) return cache.get(n);
        cache.put(n, fibonacci_memoization(n - 1) + fibonacci_memoization(n - 2));
        return cache.get(n);
    }

    public int fibonacci_tabulation(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public int fibonacci_tabulation_optimal_space(int n) {
        if (n < 2) return n;
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

}
