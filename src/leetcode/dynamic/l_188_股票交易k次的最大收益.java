package leetcode.dynamic;

public class l_188_股票交易k次的最大收益 {
    public static int maxProfit(int k, int[] prices) {
        if (k==0) return 0;
        if (prices.length < 2) return 0;
        if (k>(prices.length/2)) k=prices.length/2 ;
        int[][] dp = new int[k+1][prices.length];
        for (int i = 0; i < prices.length ; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <=k; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= k ; i++) {
            for (int j = 1; j < prices.length ; j++) {
                System.out.println(i+"-"+j);
                if (prices[j]>prices[j-1]){
                    dp[i][j] = dp[i-1][j-1] + prices[j]-prices[j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[prices.length-1][k];

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2,new int[]{3,2,6,5,0,3}));
    }
}
