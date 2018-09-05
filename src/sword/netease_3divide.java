package sword;

import java.util.Scanner;

public class netease_3divide {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        int l = 12;//in.nextInt();
        int r = 14;//in.nextInt();
        long result = 0;
        for (int i = 1; i <= l; ++i) {
            String str = String.valueOf(i);
            int size = str.length();
            for (int j = 0; j < size; ++j) {
                result += str.charAt(j) - '0';
            }
        }
        int totalNumber = result % 3 == 0 ? 1 : 0;
        for (int i = l+1; i <= r; ++i) {
            String str = String.valueOf(i);
            int size = str.length();
            int sum = 0;
            for (int j = 0; j < size; ++j) {
                sum += str.charAt(j) - '0';
            }
            result += sum;
            totalNumber = result % 3 == 0 ? (totalNumber+1) : totalNumber;
        }
        System.out.println(totalNumber);
    }
}
