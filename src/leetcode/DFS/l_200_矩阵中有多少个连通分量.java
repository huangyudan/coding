package leetcode.DFS;

//Input:
//        11000
//        11000
//        00100
//        00011

//Output: 3
public class l_200_矩阵中有多少个连通分量 {
    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0) return 0;
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] d : direction) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
