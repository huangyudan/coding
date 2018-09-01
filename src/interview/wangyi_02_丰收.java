package interview;

import java.util.Scanner;

//
//    又到了丰收的季节，恰好小易去牛牛的果园里游玩。 牛牛常说他多整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。 在果园里有N堆苹果，每堆苹果的数量为ai,小易希望知道从左往右数第x个苹果是属于哪一堆的。 牛牛觉得问题太简单了，所以希望你来替他回答。
//
//    输入描述
//    第一行 一个数 n (1<= n <= $10^5$)
//    第二行 n个数 $a{i}$ (1<=$a{i}$<=1000),表示从左往右数第i堆有多少苹果
//    第三行 一个数m (1<= m <= $10^5$),表示有m次询问
//    第四行 m个数$q{i}$, 表示小易希望知道第$q{i}$个苹果属于哪一堆。
//
//    输出描述
//    m行，第i行输出第$q_{i}$个苹果属于哪一堆。
//输入
//5
//2 7 3 4 9
//3
//1 25 11
//输出
//
//1
//5
//3
public class wangyi_02_丰收 {
    public static int dui_number(int[] apple_num,int n){
        int sum = 0;
        for (int i = 0; i < n ; i++) {
            sum += apple_num[i];
            if (n <= sum){
                return i+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] apple_num = new int[n];
        for (int i = 0; i < n; i++) {
            apple_num[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] query = new int[k];
        for (int i = 0; i < k; i++) {
            query[i] = sc.nextInt();
        }
        for (int i : query){
            System.out.println(dui_number(apple_num,i));
        }

    }
}
