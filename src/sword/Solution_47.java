package sword;

public class Solution_47 {
    public static int getMaxVaule(int[][] data){
        if (data==null) return 0;
        int row = data.length,col = data[0].length;
        int[][] max_value = new int[row][col];
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                int left = 0,up = 0;
                if (i>0) up = max_value[i-1][j];
                if (j>0) left = max_value[i][j-1];
                max_value[i][j] = Math.max(up,left) + data[i][j];
            }
        }
        return max_value[row-1][col-1];
    }

    public static int getMaxVauleMini(int[][] data){
        if (data==null) return 0;
        int row = data.length,col = data[0].length;
        int[] max_value = new int[col];
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                int left = 0,up = 0;
                if (i>0) up = max_value[j];//本行j之前的值已经更新为本行的了,j到最后还没更新，依然是上一行的
                if (j>0) left = max_value[j-1];
                max_value[j] = Math.max(up,left) + data[i][j];
            }
        }
        return max_value[col-1];
    }

    public static void main(String[] args){
        int[][] data = {
                {1,10,3,8},
                {12,2,9,6},
                {5,7,4,11},
                {3,7,16,5}};
        System.out.println(getMaxVaule(data));
        System.out.println(getMaxVauleMini(data));
    }


}
