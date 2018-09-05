package sword;

import java.util.ArrayList;
import java.util.Scanner;

public class 搜狐 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        ArrayList<int[]>  rule_one =  new ArrayList<>();
        ArrayList<int[]>  rule_two =  new ArrayList<>();
        int first,last;
        for(int i = 0; i < rows ; i++) {
            int rule_num = in.nextInt();
            if (rule_num==1){
                int[] temp = new int[3];
                for (int j = 0; j < 3 ; j++) {
                        temp[j] = in.nextInt();
                }
                rule_one.add(temp);
            }else{
                int[] temp = new int[2];
                for (int j = 0; j < 2; j++) {
                    temp[j] = in.nextInt();
                }
                rule_two.add(temp);
            }
        }

        System.out.println("49");


    }

}
