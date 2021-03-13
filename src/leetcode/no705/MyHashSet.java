package leetcode.no705;

import java.util.TreeSet;

public class MyHashSet {
    private TreeSet<Integer>[] table;
    private static final int N = 25536;
    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new TreeSet[N];
        for(int i = 0; i < N; i ++){
            table[i] = new TreeSet<>();
        }
    }

    public void add(int key) {
        table[key % N].add(key);
    }

    public void remove(int key) {
        table[key % N].remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return table[key % N].contains(key);
    }
}
