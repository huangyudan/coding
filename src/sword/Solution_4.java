package sword;

public class Solution_4 {
    public static boolean Find(int [][] array,int target) {
        boolean found =false;
        int rows = array.length;
        int columns = array[0].length;
        int row = 0;
        int col = columns - 1;
        while (array!=null && row < rows && col >= 0){
            if (array[row][col] == target) {
                found = true;
                break;
            }
            else if (array[row][col]>target) {
                    col--;
                }
            else{
                    row++;
                }
    	}
    	return found;
    }

    public static void main(String[] args) {
        int[][] data = {{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        System.out.println(Find(data, 10));
        System.out.println(Find(data, 5));
    }



}