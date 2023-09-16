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
 * Video Reference: https://youtu.be/ubxGZC7Di_U
 * LeetCode Reference: https://leetcode.com/problems/partition-list/
 */
public class _86_PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode sentinelLo = new ListNode();
        ListNode sentinelHi = new ListNode();
        ListNode currLo = sentinelLo;
        ListNode currHi = sentinelHi;
        while (head != null) {
            if (head.val < x) {
                currLo.next = head;
                currLo = currLo.next;
            } else {
                currHi.next = head;
                currHi = currHi.next;
            }
            head = head.next;
        }
        currLo.next = sentinelHi.next;
        currHi.next = null;
        return sentinelLo.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

}
