package sword;

public class Solution_12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean[] sign = new boolean[matrix.length];
        System.out.println(matrix.length);
        for (int i = 0;i<sign.length;i++){
            sign[i] = false;
        }
        int number = 0;
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                if (has(matrix,rows,cols,i,j,sign,str,number)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean has(char[] matrix,int rows,int cols,int i,int j,boolean[] sign,char[] str,int number){
        boolean result = false;
        if (number == str.length) return true;
        if (i>=0 && i<rows && j>=0 && j<cols && !sign[i*cols+j] && matrix[i*cols+j]==str[number]){
            number++;
            sign[i*cols+j]=true;
            result = has(matrix,rows,cols,i,j-1,sign,str,number) || has(matrix,rows,cols,i,j+1,sign,str,number)
                || has(matrix,rows,cols,i-1,j,sign,str,number)|| has(matrix,rows,cols,i+1,j,sign,str,number);
            if (!result){
            sign[i*cols+j] = false;
            number--;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution_12 s = new Solution_12();
        char[] test = new char[]{'A','B','C','E','S','F','C','S','A','D','E','E'};
        int rows= 3;
        int cols = 4;
        char[] sub = new char[]{'A','B','C','C','E','D'};
        boolean result = s.hasPath(test,rows,cols,sub);
        System.out.println(result);
    }


}