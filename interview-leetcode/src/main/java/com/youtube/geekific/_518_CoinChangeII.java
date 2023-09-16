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

/*
 * Video Reference:
 * LeetCode Reference: https://leetcode.com/problems/coin-change-ii/
 */
public class _518_CoinChangeII {

    public int change_quadraticSpace(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= amount; i++) {
            dp[i][0] = i < coins[0] ? 0 : dp[i - coins[0]][0];
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j < coins.length; j++) {
                dp[i][j] = i < coins[j] ? dp[i][j - 1] : dp[i][j - 1] + dp[i - coins[j]][j];
            }
        }
        return dp[amount][coins.length - 1];
    }

    public int change_linearSpace(int amount, int[] coins) {
        int[] prev = new int[amount + 1];
        prev[0] = 1;
        for (int i = 1; i <= amount; i++) {
            prev[i] = (i < coins[0]) ? 0 : prev[i - coins[0]];
        }
        for (int j = 1; j < coins.length; j++) {
            int[] next = new int[amount + 1];
            next[0] = 1;
            for (int i = 1; i <= amount; i++) {
                next[i] = i < coins[j] ? prev[i] : prev[i] + next[i - coins[j]];
            }
            prev = next;
        }
        return prev[amount];
    }

    public int change_optimal(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
