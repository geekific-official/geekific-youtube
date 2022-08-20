/*
 * MIT License
 *
 * Copyright (c) 2022 Geekific (https://www.youtube.com/c/Geekific)
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

package com.youtube.geekific.chaining;

import static java.lang.reflect.Array.newInstance;

@SuppressWarnings("unchecked")
public class HashTable<K, V> {

    private static final int MAX_MAP_SIZE = 5;

    private int size;
    private final HashItem<K, V>[] hashTable;

    public HashTable() {
        hashTable = (HashItem<K, V>[]) newInstance(HashItem.class, MAX_MAP_SIZE);
    }

    private int hash(K key) {
        return key.hashCode() % MAX_MAP_SIZE;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashItem<K, V> item = hashTable[index];
        while (item != null) {
            if (item.getKey().equals(key)) {
                item.setValue(value);
                return;
            }
            item = item.getNextHashItem();
        }
        HashItem<K, V> hashItem = new HashItem<>(key, value);
        hashItem.setNextHashItem(hashTable[index]);
        hashTable[index] = hashItem;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashItem<K, V> item = hashTable[index];
        while (item != null) {
            if (item.getKey().equals(key)) {
                return item.getValue();
            }
            item = item.getNextHashItem();
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashItem<K, V> item = hashTable[index];
        HashItem<K, V> prev = null;
        while (item != null) {
            if (item.getKey().equals(key)) break;
            prev = item;
            item = item.getNextHashItem();
        }
        if (item == null) return null;
        if (prev == null) hashTable[index] = item.getNextHashItem();
        else prev.setNextHashItem(item.getNextHashItem());
        size--;
        return item.getValue();
    }

    public int getSize() {
        return size;
    }

}
