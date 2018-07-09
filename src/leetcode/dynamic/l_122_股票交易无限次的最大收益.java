package leetcode.dynamic;
//题目描述：一次股票交易包含买入和卖出，多个交易之间不能交叉进行。
//对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。而 d - a = (d - c) + (c - b) + (b - a) ，因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中，从而在局部最优的情况下也保证全局最优。
public class l_122_股票交易无限次的最大收益 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length ; i++) {
            if (prices[i] > prices[i-1]) profit += prices[i]-prices[i-1];
        }
        return profit;
    }

    public static int maxProfit2(int[] prices) {
        if (prices.length<2) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        dp[1] = prices[1]>prices[0]?(prices[1]-prices[0]):0;
        for (int i = 2; i < prices.length ; i++) {
            if (prices[i]>prices[i-1]){
                dp[i] = dp[i-1]+prices[i]-prices[i-1];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[prices.length-1];
    }
}
