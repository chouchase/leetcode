package leetcode.no1319;

import datastruct.unionfind.UnionFind;

public class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n == 1){
            return 0;
        }
        if(connections.length < n - 1){
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for(int[] con : connections){
            uf.union(con[0],con[1]);
        }
        int setSize = uf.getSetSize();
        return setSize - 1;
    }
}
