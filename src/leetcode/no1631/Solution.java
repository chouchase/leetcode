package leetcode.no1631;

import java.util.Arrays;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int min = 0;
        int max = 0x80000000;
        for(int[] arr : heights){
            for(int e : arr){
                max = Math.max(max,e);
            }
        }
        boolean[][] isVisited = new boolean[heights.length][heights[0].length];

        while(min < max){
            for(boolean[] arr : isVisited){
                Arrays.fill(arr, false);
            }
            int mid = min + ((max - min) >> 1);
            if(dfs(heights,isVisited,0,0,mid)){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return min;

    }
    private boolean dfs(int[][] heights, boolean[][] isVisited, int x, int y, int value){
        if(x == heights.length - 1 && y == heights[0].length - 1){
            return true;
        }
        isVisited[x][y] = true;
        int[] dif = {-1,1};
        for(int d : dif){
            int newX = x + d;
            int newY = y + d;
            if(isValid(newX,y,heights,isVisited)){
                if(Math.abs(heights[newX][y] - heights[x][y]) <= value && dfs(heights,isVisited,newX,y,value)){
                    return true;
                }
            }
            if(isValid(x,newY,heights,isVisited)){
                if(Math.abs(heights[x][newY] - heights[x][y]) <= value && dfs(heights,isVisited,x,newY,value)){
                    return true;
                }
            }
        }
        return false;

    }
    private boolean isValid(int x, int y, int[][] heights,boolean[][] isVisited){
        return x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !isVisited[x][y];
    }
}