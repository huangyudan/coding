package leetcode.DFS;
//Input:
//        [[1,1,0],
//        [1,1,0],
//        [0,0,1]]
//        Output: 2
//        Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
//        The 2nd student himself is in a friend circle. So return 2.


//
//        [[1,0,0,1],
//        [0,1,1,0],
//        [0,1,1,1],
//        [1,0,1,1]]
//        Output: 1 而不是4

public class l_547_好友圈个数 {
    private int n;
    public int findCircleNum(int[][] M) {
        n=M.length;
        int circleCount=0;
        boolean[] inCircle = new boolean[n];
        for (int i = 0; i < n ; i++) {
            if (!inCircle[i]){ //不在圈里
                dfs(M,inCircle,i); //所有和我有link的人去哪都在inCircle里纳入我的圈
                circleCount++;  //圈数加1
            }
        }
        return circleCount;
    }

    private void dfs(int[][] m, boolean[] inCircle, int i) {
        if (i<0 || i>m.length || inCircle[i]) return;
        inCircle[i] = true;
        for (int j = 0; j <m.length ; j++) {
            if (m[i][j] == 1) dfs(m,inCircle,j);
        }
    }
}
