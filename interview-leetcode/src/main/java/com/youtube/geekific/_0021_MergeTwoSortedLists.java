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
 * Video Reference: https://youtu.be/xtKYi9WaM0I
 * LeetCode Reference: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class _0021_MergeTwoSortedLists {

    public ListNode mergeTwoLists_iterative(ListNode head1, ListNode head2) {
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        while (head1 != null) {
            curr.next = head1;
            curr = curr.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            curr.next = head2;
            curr = curr.next;
            head2 = head2.next;
        }
        return sentinel.next;
    }

    public ListNode mergeTwoLists_recursive(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val < head2.val) {
            head1.next = mergeTwoLists_recursive(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists_recursive(head1, head2.next);
            return head2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
    }

}
