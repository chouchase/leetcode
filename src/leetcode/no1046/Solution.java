package leetcode.no1046;

import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            return o2 - o1;
        }));
        for(int e : stones){
            pq.add(e);
        }
        while(pq.size() >= 2){
            int x = pq.poll();
            int y = pq.poll();
            int left = Math.abs(x - y);
            if(left != 0){
                pq.add(left);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
