package leetcode.dynamic;

public class l_188_股票交易k次的最大收益 {
    public static int maxProfit(int k, int[] prices) {
        if (k==0) return 0;
        if (prices.length < 2) return 0;
        if (k>(prices.length/2)) k=prices.length/2;
        int[][] dp = new int[k+1][prices.length];
        // 下面都不用，初始化本来就是0
//        for (int i = 0; i < prices.length ; i++) {
//            dp[0][i] = 0;
//        }
//        for (int i = 0; i <=k; i++) {
//            dp[i][0] = 0;
//        }

        for (int i = 1; i <= k ; i++) {
            for (int j = 1; j < prices.length ; j++) {
                int local_max = -999;
                for (int l = 0; l < j ; l++) {
                    local_max = Math.max(dp[i-1][l] + prices[j]-prices[l],dp[i][j-1]);
                    dp[i][j] = Math.max(dp[i][j],local_max);
                }
            }
        }
        return dp[k][prices.length-1];

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2,new int[]{1,2,4}));
    }
}
