package leetcode.no947;

import datastruct.unionfind.UnionFind;

import java.util.*;

public class Solution {
    public class UnionFind {
        private int[] parent;
        private int[] rank;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(rank,1);
            for(int i = 0; i < n; i ++){
                parent[i] = i;
            }
        }
        public int getParent(int i){
            if(parent[i] == i){
                return i;
            }
            return parent[i] = getParent(parent[i]);
        }
        public void union(int x, int y){
            int px = getParent(x);
            int py = getParent(y);
            if(px == py){
                return;
            }
            if(rank[px] > rank[py]){
                parent[py] = px;
                rank[px] += rank[py];
            }else{
                parent[px] = py;
                rank[py] += rank[px];
            }
        }
        public boolean find(int x, int y){
            return getParent(x) == getParent(y);
        }

    }

    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> horizon = new HashMap<>();
        Map<Integer,List<Integer>> vertical = new HashMap<>();
        for(int i = 0; i < stones.length; i ++){
            int x = stones[i][0];
            int y = stones[i][1];
            if(!horizon.containsKey(x)){
                horizon.put(x,new ArrayList<>());
            }
            if(!vertical.containsKey(y)){
                vertical.put(y,new ArrayList<>());
            }
            horizon.get(x).add(i);
            vertical.get(y).add(i);
        }
        UnionFind uf = new UnionFind(stones.length);
        for(List<Integer> list : horizon.values()){
            for(int i = 1; i < list.size(); i ++){
                uf.union(list.get(i),list.get(i - 1));
            }
        }
        for(List<Integer> list : vertical.values()){
            for(int i = 1; i < list.size(); i ++){
                uf.union(list.get(i),list.get(i - 1));
            }
        }
        int cnt = 0;
        for(int i = 0; i < uf.parent.length; i ++){
            if(uf.parent[i] == i){
                cnt ++;
            }
        }
        return stones.length - cnt;

    }
}
