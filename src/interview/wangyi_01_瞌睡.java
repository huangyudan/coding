package interview;

import java.util.Scanner;

//已知课程时间，被叫醒能持续清醒时间，每分钟清醒能得多少分，以及不叫的情况下每分钟是否在睡觉（1醒着，0睡觉）
//问：只能叫醒小明一次，最多能得多少分？
//    6 3
//    1 3 5 2 5 4
//    1 1 0 1 0 0
//    16

//
//首先对示例进行分析，输出16是在第3分钟将小易唤醒。所以小易的分值为1+3+5+2+5 = 16。
//其次我们可以考虑一种比较暴力的解法，即我们先把醒着的分值和sum计算出来，然后我们再遍历每分钟是否醒着，如果为0，那么我们就遍历接下来k个值，把这k个值未醒着的分值加到前面的sum上，然后再去与最大值进行比较更新，直到遍历结束。不过这样由于超时只能过90%的测试用例。

public class wangyi_01_瞌睡 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        int[] sleep = new int[n];
        for (int i = 0; i < n; i++) {
            sleep[i] = sc.nextInt();
        }
        int sum = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (sleep[i] == 1) {
                sum += scores[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (sleep[i] == 0) {
                int temp = sum;
                for (int j = i; j < Math.min(i + k, n); j++) {
                    if (sleep[j] == 0) {
                        temp += scores[j];
                    }
                }
                if (temp > max) {
                    max = temp;
                }
            }
        }
        System.out.println(max);
    }
}
