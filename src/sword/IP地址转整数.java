package sword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IP地址转整数 {
    public static List<Integer> ten_to_two(int x){
        List res = new ArrayList();
        while(x!=0){
            res.add(x%2);
            x =  x / 2;
        }
        return res;
    }


    public static void main(String[] args) {
        String ip_address = "10.0.3.193";
        String[] arr = ip_address.split("\\.");
        long n=Long.parseLong(arr[0]);

        for(int i=1;i<arr.length;i++){
            n=n<<8;
            n=n+Long.parseLong(arr[i]);
        }

        System.out.println(n);
        System.out.println(Integer.parseInt("1001",2)); //二进制转十进制
        System.out.println(Integer.toBinaryString(3)); //十进制转二进制
        List res = ten_to_two(12);
        Collections.reverse(res);
        for (Object i : res){
            System.out.println(i);
        }
    }
}


