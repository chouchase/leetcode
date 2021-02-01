package leetcode.no888;

import java.util.Arrays;

public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for(int e : A){
            sumA += e;
        }
        for(int e : B){
            sumB += e;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int gap = (sumB - sumA) >> 1;
        for(int i = 0; i < A.length; i ++){
            int index = Arrays.binarySearch(B,gap + A[i]);
            if(index > 0){
                return new int[]{A[i],B[index]};
            }
        }
        return null;
    }
}
