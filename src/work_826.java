public class work_826 {
    public static void main(String[] args) {
        //LeetCode 121. 买卖股票的最佳时机


        //给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
        //你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
        //返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

        //1.动态规划
        //始终记录最小价格，每次计算利润时，用当前价格减去最小价格，得到当前利润，取最大值

        int[] prices = {7, 1, 5, 3, 6, 4};

        //初始化minPrice和maxProfit为第一个元素和0
        int minPrice = prices[0];
        int maxProfit = 0;

        //遍历数组，更新minPrice和maxProfit
        for (int p : prices) {
            //如果当前价格小于minPrice，更新minPrice-------始终记录最小价格
            if (p < minPrice) {
                minPrice = p;
            } else {
                //如果当前价格大于等于minPrice，更新maxProfit-----记录更新最大利润
                maxProfit = Math.max(maxProfit, p - minPrice);
            }
        }

        //如果maxProfit小于等于0，说明没有利润，返回0
        if (maxProfit <= 0) {
            System.out.println(0);
        } else {
            System.out.println(maxProfit);
        }


    }
}
