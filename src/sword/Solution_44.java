package sword;

public class Solution_44 {
    public static int digitAtIndex(int index){
        if (index<0) return -1;
        int digits = 1;
        while (true){
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits){
                return digitAtIndex(index,digits);
            }
            index -= numbers*digits;
            digits++;
        }
    }

    public static int countOfIntegers(int digits){
        if (digits==1) return 10;
        else return (int) (9*Math.pow(10,digits-1));
    }

    public static int digitAtIndex(int index,int digits){
        int number = beginNumber(digits) + index/digits;
        int indexFromLeft = index % digits;
        int p = digits - indexFromLeft;
        return (int) (number%Math.pow(10,p)/Math.pow(10,p-1));
    }

    public static int beginNumber(int digits){
        if (digits==1) return 0;
        else return (int) Math.pow(10,digits-1);
    }

    public static void main(String[] args) {
        System.out.println(digitAtIndex(1001));
        for (int i = 9; i < 16; i++) {
            System.out.println(digitAtIndex(i));
        }
    }
}
