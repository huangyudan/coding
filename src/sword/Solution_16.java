package sword;

public class Solution_16{
    static boolean invalidInput = false;
    public static double power(double base,int exponent){
        //0的0次方在数学上没有意义，为了方便也返回1，也可特殊处理
        if(exponent==0)
            return 1;
        if(exponent<0){
            if(equal(base,0)){
               //通过全局变量报错
                invalidInput = true;
                return 0;
            }
            else
                return 1.0/powerWithPositiveExponent(base,-1*exponent);
        }
        else
            return powerWithPositiveExponent(base,exponent);
    }
    public static boolean equal(double x,double y){
       return -0.00001<x-y && x-y<0.00001;
    }
    public static double powerWithPositiveExponent(double base,int exponent){
        if(exponent==0)
            return 1;
        else if((exponent&1)==0){
            double temp = powerWithPositiveExponent(base,exponent>>1);
            return temp*temp;
        }
        else{
            double temp = powerWithPositiveExponent(base,exponent-1);
            return base*temp;
        }
    }
    public static void main(String[] args){
        System.out.println("2^3="+power(2,3)+"\t是否报错:"+invalidInput);
        System.out.println("2^-3="+power(2,-3)+"\t是否报错:"+invalidInput);
        System.out.println("0^3="+power(0,3)+"\t是否报错:"+invalidInput);
        System.out.println("0^-3="+power(0,-3)+"\t是否报错:"+invalidInput);
    }
}

