package sword;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 网易游戏1 {

    public static void sql(int[][] arr) {
        int[] count = new int[arr.length];
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++) {
            if(map1.containsKey(arr[i][2])) {
                int index = map1.get(arr[i][2]);
                count[index] ++;
            }else {
                map1.put(arr[i][2], i);
            }
        }

        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++) {
            if(map2.containsKey(arr[i][1])) {
                int index = map2.get(arr[i][1]);
                count[index] = 0;
            }else {
                map2.put(arr[i][1], i);
            }
        }

        for(int i =0; i<arr.length; i ++) {
            if(map1.containsKey(arr[i][2])) {
                int index = map1.get(arr[i][2]);
                count[i] = count[index];
            }
        }

        HashMap<Integer, Integer> map3 = new HashMap<Integer, Integer>();
        int[] key = new int[count.length];
        for(int i=0; i<count.length; i++) {
            if(count[i]>=1) {
                map3.put(arr[i][1], count[i]);
                key[i] = arr[i][1];
            }
        }
        Arrays.sort(key);
        for(int i=0; i<key.length; i++) {
            if(key[i]>=1) {
                System.out.println(key[i]+ " "+ map3.get(key[i]));
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        sql(arr);
        in.close();
    }
}
