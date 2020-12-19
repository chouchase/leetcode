package leetcode.no48;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        if(n <= 1){
            return ;
        }
        int lx = 0;
        int ly = 0;
        int rx = n - 1;
        int ry = n - 1;
        while(lx < rx && ly < ry){
            rotate(matrix,lx,ly,rx,ry);
            lx ++;
            ly ++;
            rx --;
            ry --;
        }
    }
    private void rotate(int[][] matrix,int lx,int ly,int rx,int ry) {
        if (lx >= rx || ly >= ry) {
            return;
        }
        for (int i = ly; i < ry; i++) {
            int t = matrix[lx][i];
            int no = i - ly;
            matrix[lx][i] = matrix[rx - no][ly];
            matrix[rx - no][ly] = matrix[rx][ry - no];
            matrix[rx][ry - no] = matrix[lx + no][ry];
            matrix[lx + no][ry] = t;
        }
    }
}
