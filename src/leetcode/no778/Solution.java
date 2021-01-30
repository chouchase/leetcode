package leetcode.no778;

import java.util.Arrays;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] isVisited = new boolean[n][n];
        int left = 0;
        int right = 0;
        for(int[] arr : grid){
            for(int e : arr){
                right = Math.max(right,e);
            }
        }
        while(left < right){
            int mid = left + ((right - left) >> 1);
            for(boolean[] arr : isVisited){
                Arrays.fill(arr,false);
            }
            if(dfs(grid,isVisited,0,0,mid,n)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean dfs(int[][] grid,boolean[][] isVisited, int x, int y, int t,int n){
        if(t < grid[x][y]){
            return false;
        }
        if(x == n - 1 && y == n - 1){
            return true;
        }
        isVisited[x][y] = true;
        int[] dif = {-1,1};
        for(int d : dif){
            int newX = x + d;
            int newY = y + d;
            if(isValid(newX,y,n) && !isVisited[newX][y]){
                if(dfs(grid,isVisited,newX,y,t,n)){
                    return true;
                }
            }
            if(isValid(x,newY,n) && !isVisited[x][newY]){
                if(dfs(grid,isVisited,x,newY,t,n)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValid(int r, int c, int n){
        return r >= 0 && r < n && c >= 0 && c < n;
    }

}
