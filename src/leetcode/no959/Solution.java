package leetcode.no959;

import datastruct.unionfind.UnionFind;

public class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int num = n * n;
        UnionFind uf = new UnionFind(num * 4);
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                char c = grid[i].charAt(j);
                int cur = (i * n + j) * 4;
                int up = cur;
                int down = cur + 2;
                int right = cur + 1;
                int left = cur + 3;
                if(c == ' '){
                    uf.union(up,right);
                    uf.union(up,left);
                    uf.union(up,down);
                }else if(c == '/'){
                    uf.union(up,left);
                    uf.union(down,right);
                }else{
                    uf.union(up,right);
                    uf.union(down,left);
                }
                if(i > 0){
                    int upDown = ((i - 1) * n + j) * 4 + 2;
                    uf.union(up,upDown);
                }
                if(j > 0){
                    int leftRight = (i * n + j - 1) * 4 + 1;
                    uf.union(left,leftRight);
                }
            }
        }
        return uf.getSetSize();
    }

    public static void main(String[] args) {
        String[] grid = {" /","/ "};
        new Solution().regionsBySlashes(grid);
    }
}
