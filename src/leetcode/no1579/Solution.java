package leetcode.no1579;

import datastruct.unionfind.UnionFind;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind Alice = new UnionFind(n);
        UnionFind Bob = new UnionFind(n);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o2[0] - o1[0];
        });
        pq.addAll(Arrays.asList(edges));
        int cnt = 0;
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int n1 = edge[1] - 1;
            int n2 = edge[2] - 1;
            int type = edge[0];
            if(type == 3){
                if(!Bob.find(n1,n2)){
                    Bob.union(n1,n2);
                    Alice.union(n1,n2);
                }else{
                    cnt ++;
                }
            }else if (type == 2){
                if(!Bob.find(n1,n2)){
                    Bob.union(n1,n2);
                }else{
                    cnt ++;
                }
            }else{
                if(!Alice.find(n1,n2)){
                    Alice.union(n1,n2);
                }else{
                    cnt ++;
                }
            }
        }
        return Bob.getSetSize() == 1 && Alice.getSetSize() == 1 ? cnt : -1;
    }
}
