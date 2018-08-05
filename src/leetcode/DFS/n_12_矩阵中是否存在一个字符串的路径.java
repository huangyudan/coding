package leetcode.DFS;

public class n_12_矩阵中是否存在一个字符串的路径 {
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private static int rows;
    private static int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0)
            return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (backtracking(matrix,marked,i,j,str,0))
                    return true;
        return false;
    }


    public static boolean backtracking(char[][] matrix,boolean[][] marked,int r, int c, char[] str,int start){
        if (start == str.length) return true;
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[start] || marked[r][c])
            return false;
        marked[r][c] = true;
        for (int[] n :next){
            if (backtracking(matrix,marked,r+n[0],c+n[1],str,start+1)){
                return true;
            }
        }
        marked[r][c] = false;
        return false;
    }


    private static char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0, idx = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = array[idx++];
        return matrix;
    }

    public static void main(String[] args) {
        n_12_矩阵中是否存在一个字符串的路径 a = new n_12_矩阵中是否存在一个字符串的路径();
        char[] input = new char[]{'a','b','t','g','c','f','c','s','j','d','e','h'};
        System.out.println(a.hasPath(input, 3, 4, "bfce".toCharArray()));

    }
}
