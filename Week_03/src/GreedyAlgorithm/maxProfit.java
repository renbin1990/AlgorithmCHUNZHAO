package GreedyAlgorithm;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 最佳题解https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
 */
public class maxProfit {
    public static void main(String[] args) {

    }
    //对于 「今天的股价 - 昨天的股价」，得到的结果有 3 种可能：① 正数，② 00，③负数。贪心算法的决策是： 只加正数 。
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length<2){
            return 0;
        }

        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff>0){
                total+=diff;
            }
        }
        return total;
    }
}
