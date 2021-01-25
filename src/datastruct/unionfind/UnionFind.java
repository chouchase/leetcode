package datastruct.unionfind;

import leetcode.no189.Solution;

import java.util.Arrays;

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
    public int getSetSize(){
        int size = 0;
        for(int i = 0; i < parent.length; i ++){
            if(parent[i] == i){
                size ++;
            }
        }
        return size;
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
