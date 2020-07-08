package LeetCode;

public class Array122 {

    //可以完成多次交易
    //只有后一天大于前一天，累加差值得到最大利润
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}
