package leetcode.no803;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int times = 2;
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            if(grid[0][i] == times - 1){
                add(grid,times,list,0,i,m,n);
            }
        }
        times ++;
        int[] res = new int[hits.length];
        for(int i = 0; i < hits.length; i ++){
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y] == times - 1){
                grid[x][y] = 0;
                for(int j = 0; j < n; j ++){
                    if(grid[0][j] == times - 1){
                        dfs(grid,times,0,j,m,n);
                    }
                }
                for(int e : list){
                    int r = e / n;
                    int c = e % n;
                    if(grid[r][c] == times - 1){
                        res[i] ++;
                    }
                }
                times ++;

            }
        }
        return res;

    }
    private void add(int[][] grid,int times ,List<Integer> list, int x, int y,int m, int n){
        grid[x][y] = times;
        list.add(getIndex(x,y,n));
        int[] dif = {-1,1};
        for(int d : dif){
            int newX = x + d;
            int newY = y + d;
            if(isValid(x,newY,m,n) && grid[x][newY] == times - 1){
                add(grid,times,list,x,newY,m,n);
            }
            if(isValid(newX,y,m,n) && grid[newX][y] == times - 1){
                add(grid,times,list,newX,y,m,n);
            }
        }

    }
    private void dfs(int[][] grid, int times, int x, int y, int m, int n){
        grid[x][y] = times;
        int[] dif = {-1,1};
        for(int d : dif){
            int newX = x + d;
            int newY = y + d;
            if(isValid(x,newY,m,n) && grid[x][newY] == times - 1){
                dfs(grid,times,x,newY,m,n);
            }
            if(isValid(newX,y,m,n) && grid[newX][y] == times - 1){
                dfs(grid,times,newX,y,m,n);
            }
        }

    }
    private boolean isValid(int x, int y, int m, int n){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    private int getIndex(int x, int y, int n){
        return x * n + y;
    }

}
