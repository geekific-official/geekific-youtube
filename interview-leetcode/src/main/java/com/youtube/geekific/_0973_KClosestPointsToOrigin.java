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

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/*
 * Video Reference: https://youtu.be/aWobyJruJK4
 * LeetCode Reference: https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class _0973_KClosestPointsToOrigin {

    public int[][] kClosest_Sorting(int[][] points, int k) {
        return IntStream.range(0, points.length)
                .mapToObj(i -> new Point(squaredDistance(points[i]), i))
                .sorted(Comparator.comparingDouble(p -> p.distance))
                .limit(k)
                .map(p -> points[p.index])
                .toArray(int[][]::new);
    }

    public int[][] kClosest_PriorityQueue(int[][] points, int k) {
        Queue<Point> maxPQ = new PriorityQueue<>((a, b) -> b.distance - a.distance);
        for (int i = 0; i < points.length; i++) {
            Point point = new Point(squaredDistance(points[i]), i);
            if (maxPQ.size() < k) {
                maxPQ.add(point);
            } else if (maxPQ.peek() != null && point.distance < maxPQ.peek().distance) {
                maxPQ.poll();
                maxPQ.add(point);
            }
        }

        int[][] answer = new int[k][2];
        for (int i = 0; i < k && maxPQ.peek() != null; i++) {
            int entryIndex = maxPQ.poll().index;
            answer[i] = points[entryIndex];
        }
        return answer;
    }

    private int squaredDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    static class Point {
        int distance;
        int index;

        Point(int d, int i) {
            distance = d;
            index = i;
        }
    }

}
