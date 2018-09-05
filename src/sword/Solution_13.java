package sword;

public class Solution_13 {
    public int movingCount(int threshold, int rows, int cols){
        boolean[] reached = new boolean[rows*cols];
        for (int i = 0;i<rows*cols;i++){
            reached[i] = false;
        }
        int count = movingCount(threshold,rows,cols,0,0,reached);
        return count;
    }
    
    public int movingCount(int threshold,int rows ,int cols,int i,int j,boolean[] reached){
        int count = 0;
        if (check(threshold,rows,cols,i,j,reached)){
            reached[i*cols+j] = true;
            count = 1 + movingCount(threshold,rows,cols,i+1,j,reached)+movingCount(threshold,rows,cols,i-1,j,reached)
                +movingCount(threshold,rows,cols,i,j+1,reached)+movingCount(threshold,rows,cols,i,j-1,reached);
        }
        return count;
    }
    
    public boolean check(int threshold,int rows ,int cols,int i,int j,boolean[] reached){
        if (i>=0 && i<rows && j>=0 && j < cols && (getDigitSum(i)+getDigitSum(j)<=threshold) && !reached[i*cols+j]){
            return true;
        }
        return false;
    }
    
    public int getDigitSum(int number){
        int sum = 0;
        while (number>0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
}
