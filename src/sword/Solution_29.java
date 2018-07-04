package sword;

import java.util.ArrayList;

public class Solution_29 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix==null ||matrix.length==0||matrix[0].length==0) return null;
        ArrayList<Integer> a = new ArrayList<>();
        int rows = matrix.length,cols = matrix[0].length;
        int start = 0;
        while (start*2 < rows && start*2<cols){
            ArrayList<Integer> b = new ArrayList<>();
            b = PrintMatrixInCirecle(matrix,rows,cols,start);
            for (int i : b){
                a.add(i);
            }
            start++;
        }
        for (int i:a) System.out.print(i+"-");
        System.out.println();
        return a;
    }

    public static ArrayList<Integer> PrintMatrixInCirecle(int[][] matrix,int rows,int cols,int start){
        ArrayList<Integer> c = new ArrayList<>();
        int endX = cols - start -1;
        int endY = rows - start -1;
        for (int i = start;i<=endX;i++) c.add(matrix[start][i]); //不管是只有一个数，只有一行，只有一列都要
        if (endY>start){
            for (int i = start+1;i<=endY;i++) c.add(matrix[i][endX]);
        }
        if (endY>start && endX>start){//至少两行两列
            for (int i = endX-1;i>=start;i--) c.add(matrix[endY][i]);
        }
        if (endY-1>start && endX>start){//至少三行两列
            for (int i = endY-1;i>=start+1;i--) c.add(matrix[i][start]);
        }
        return c;
    }

    public static void main(String[] args){
        int[][] data1={
                {1},
                {2},
                {3},
                {4},
                {5}
        };
//        int[][] data2={
//                {1,2,3,4},
//                {10,11,12,5},
//                {9,8,7,6},
//        };
//        int[][] data3={
//                {1,2,3},
//                {10,11,4},
//                {9,12,5},
//                {8,7,6},
//        };
//        int[][] data4={
//                {1,2,3},
//                {8,9,4},
//                {7,6,5},
//        };
        printMatrix(data1);
//        printMatrix(data2);
//        printMatrix(data3);
//        printMatrix(data4);
    }


}
