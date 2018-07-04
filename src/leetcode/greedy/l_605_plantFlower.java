package leetcode.greedy;

public class l_605_plantFlower {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n<=0) return true;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if (flowerbed[i] == 0 && pre ==0 && next ==0){
                count++;
                flowerbed[i] = 1;
            }
        }
        if (count>=n) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,0,0,0,1};
        System.out.println(canPlaceFlowers(a,2));
    }
}
