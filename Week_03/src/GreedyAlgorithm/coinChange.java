package GreedyAlgorithm;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class coinChange {

    public void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        //排序，升序
        Arrays.sort(coins);
        //传最大数dfs处理
        _mincoin(0, coins, amount, coins.length - 1);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void _mincoin(int level, int[] coins, int amount, int max) {
        if (amount == 0) {
            res = Math.min(res, level);
            return;
        }

        if (max < 0) {
            return;
        }
        //计算最大能投几个   减去扔了 k 个硬币    level加 k 个硬币
        //如果因为丢多了导致最后无法凑出总额，再回溯减少大硬币数量
        for (int i = amount / coins[max]; i >= 0 && i + level < res; i--) {
            _mincoin(level + i, coins, amount - (i * coins[max]), max - 1);
        }
    }

    //超时
    public int coinChangeOne(int[] coins, int amount) {

        if (coins.length == 0) {
            return -1;
        }
        _findWay(0, coins, amount);
        //说明没有找到
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    //递归使用做减法，直到值小于0 或者等于0
    private void _findWay(int level, int[] coins, int amount) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            //说明找到了
            res = Math.min(res, level);
        }

        for (int i = 0; i < coins.length; i++) {
            _findWay(level + 1, coins, amount - coins[i]);
        }
    }
}
