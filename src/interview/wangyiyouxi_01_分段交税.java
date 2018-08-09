package interview;
import java.util.ArrayList;
import java.util.Scanner;
public class wangyiyouxi_01_分段交税 {
    public static long tax(long s){
        double result = 0;
        if (s<=3000){
            result = s * 0.03;
        }
        else if (s>3000 && s<=12000){
            result = 3000*0.03 + (s-3000)*0.1;
        }
        else if (s>12000 && s<=25000){
            result = 3000*0.03 + (12000-3000)*0.1 +(s-12000)*0.2;
        }
        else if (s>25000 && s<=35000){
            result = 3000*0.03 + (12000-3000)*0.1 +(25000-12000)*0.2 + (s-25000)*0.25;
        }
        else if (s>35000 && s<=55000){
            result = 3000 * 0.03 + (12000 - 3000) * 0.1 + (25000 - 12000) * 0.2 + (35000 - 25000) * 0.25 + (s-35000)*0.3;
        }
        else if (s>55000 && s<=80000){
            result = 3000 * 0.03 + (12000 - 3000) * 0.1 + (25000 - 12000) * 0.2 + (35000 - 25000) * 0.25 + (55000 - 35000) * 0.3
            +(s-55000)* 0.35;
        }
        else if (s>80000){
            result = 3000 * 0.03 + (12000 - 3000) * 0.1 + (25000 - 12000) * 0.2 + (35000 - 25000) * 0.25 + (55000 - 35000) * 0.3
            +(80000-55000)*0.35+ (s-80000)* 0.45;
        }
        return (long)result;

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> input = new ArrayList<>();
        while(sc.hasNext()){
            input.add(sc.nextLong());
        }

        for (int i = 0; i < input.get(0) ; i++) {
            long salary = input.get(i+1);
            if (salary<=5000) System.out.println(0);
            else{
                System.out.println(tax(salary-5000));
            }
        }
    }
}
