package leetcode.no684;

import datastruct.unionfind.UnionFind;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(uf.find(edge[0],edge[1])){
                if(edge[0] > edge[1]){
                    int t = edge[0];
                    edge[0] = edge[1];
                    edge[1] = t;
                }
                return edge;
            }else{
                uf.union(edge[0],edge[1]);
            }
        }
        return null;
    }
}
