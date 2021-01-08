package leetcode.no547;

public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        for(int i = 0; i < n; i ++){
            if(!isVisited[i]){
                dfs(i,isVisited,isConnected);
                cnt ++;
            }
        }
        return cnt;
    }
    private void dfs(int no, boolean[] isVisited,int[][] isConnected){
        isVisited[no] = true;
        for(int i = 0; i < isConnected.length; i ++){
            if(isConnected[i][no] == 1 && !isVisited[i]){
                dfs(i,isVisited,isConnected);
            }
        }
    }
}
