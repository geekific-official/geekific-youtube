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

package com.youtube.geekific.probing;

import static java.lang.reflect.Array.newInstance;

@SuppressWarnings("unchecked")
public class HashTable<K, V> {

    private static final int MAX_MAP_LENGTH = 5;

    private HashItem<K, V>[] hashTable;
    private int size;
    private int capacity;

    public HashTable() {
        capacity = MAX_MAP_LENGTH;
        hashTable = (HashItem<K, V>[]) newInstance(HashItem.class, MAX_MAP_LENGTH);
    }

    private HashTable(int capacity) {
        this.capacity = capacity;
        hashTable = (HashItem<K, V>[]) newInstance(HashItem.class, capacity);
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        if (size >= capacity * 0.75) {
            resize(2 * capacity);
        }
        int index = hash(key);
        while (hashTable[index] != null) {
            if (hashTable[index].getKey().equals(key)) {
                hashTable[index].setValue(value);
                return;
            }
            index = (index + 1) % capacity;
        }
        hashTable[index] = new HashItem<>(key, value);
        size++;
    }

    private void resize(int newCap) {
        HashTable<K, V> tempMap = new HashTable<>(newCap);
        for (int i = 0; i < capacity; i++) {
            if (hashTable[i] != null) {
                tempMap.put(hashTable[i].getKey(), hashTable[i].getValue());
            }
        }
        hashTable = tempMap.getHashTable();
        capacity = newCap;
    }

    public V get(K key) {
        int index = hash(key);
        while (hashTable[index] != null) {
            if (hashTable[index].getKey().equals(key)) {
                return hashTable[index].getValue();
            }
            index = (index + 1) % capacity;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        while (!hashTable[index].getKey().equals(key)) {
            index = (index + 1) % capacity;
        }
        V toReturn = hashTable[index].getValue();
        hashTable[index] = null;
        size--;
        while (hashTable[index = (index + 1) % capacity] != null) {
            HashItem<K, V> nextItem = hashTable[index];
            hashTable[index] = null;
            size--;
            put(nextItem.getKey(), nextItem.getValue());
        }
        return toReturn;
    }

    private HashItem<K, V>[] getHashTable() {
        return hashTable;
    }

    public int getSize() {
        return size;
    }
}
