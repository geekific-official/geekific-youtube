/*
 * MIT License
 *
 * Copyright (c) 2025 Geekific (https://www.youtube.com/c/Geekific)
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
 * Video Reference: https://youtu.be/fhU039S8DDQ
 * LeetCode Reference: https://leetcode.com/problems/keys-and-rooms/
 */
public class _0841_KeysAndRooms {

    public boolean canVisitAllRooms_BFS(List<List<Integer>> rooms) {
        if (rooms == null || rooms.isEmpty()) return true;

        Set<Integer> keys = new HashSet<>() {{
            add(0);
        }};
        Deque<Integer> queue = new LinkedList<>() {{
            addAll(rooms.get(0));
        }};

        while (!queue.isEmpty()) {
            Integer key = queue.poll();
            if (!keys.contains(key)) {
                keys.add(key);
                queue.addAll(rooms.get(key));
            }
        }

        return keys.size() == rooms.size();
    }

    public boolean canVisitAllRooms_DFS(List<List<Integer>> rooms) {
        boolean[] openedRooms = new boolean[rooms.size()];
        openedRooms[0] = true;

        openDoors(rooms, openedRooms, 0);

        for (boolean room : openedRooms) {
            if (!room) return false;
        }
        return true;
    }

    private void openDoors(List<List<Integer>> rooms, boolean[] openedRooms, Integer room) {
        for (Integer key : rooms.get(room)) {
            if (!openedRooms[key]) {
                openedRooms[key] = true;
                openDoors(rooms, openedRooms, key);
            }
        }
    }

}
