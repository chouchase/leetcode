package leetcode.no1202;

import datastruct.unionfind.UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> pair : pairs){
            uf.union(pair.get(0),pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            int parent = uf.getParent(i);
            if(!map.containsKey(parent)){
                map.put(parent,new PriorityQueue<>());
            }
            map.get(parent).add(s.charAt(i));
        }
        char[] chas = new char[s.length()];
        for(int i = 0; i < chas.length; i ++){
            int parent = uf.getParent(i);
            chas[i] = map.get(parent).poll();
        }
        return new String(chas);
    }
}