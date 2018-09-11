package interview;

import java.util.*;
// 长度为 n的0-1数组，可以添加k个1，问，最长连续1有多长
// 输入 10 5
// 1,0,0,1,0,1,0,1,0,1
// 输出 5
public class meituan_02 {
    public static int longest_one(int[] input,int fill_num){
        int res = 0;
        for (int i = 0; i < input.length ; i++) {
            int res_this = 0;
            int count_0 = 0;
            int j = i;
            while (count_0<fill_num){
                if (j>=input.length) break;
                if (count_0==fill_num) break;
                if (input[j]==0){
                    count_0++;
                }
                j++;
            }
            res_this = j-i+1;
            res = Math.max(res_this,res);
        }
        return res;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int fill_num = sc.nextInt();
//        sc.close();
        int[] input = new int[]{1,0,0,1,0,1,0,1,0,1};
        System.out.println(longest_one(input,2));
//        System.out.println(n);
//        System.out.println(fill_num);
//        int[] input = new int[n];
//        for (int i = 0; i < n; i++) {
//            input[i] = sc.nextInt();
//        }
//        String input_line = sc.nextLine();
//        String[] input = input_line.split(" ");
//        int[] input = new int[n];
////        ArrayList<Integer> input = new ArrayList<>();
//        for (int i = 0; i < n ; i++) {
//            int a = sc.nextInt();
//            System.out.println(a);
//            input.add(a);
//        }
//        for (int i : input){
//            System.out.println(i);
//        }
    }

}
