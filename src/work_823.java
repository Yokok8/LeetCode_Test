public class work_823 {
    public static void main(String[] args) {
        //LeetCode 53. 最大子数组和
        //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
        //子数组是数组中的一个连续部分。

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        //1.暴力法---时间复杂度O(n^2)会超时
        //列出所有子数组，计算每个子数组的和，返回最大的和
        /*int maxSum = Integer.MIN_VALUE;//初始化成最小的值
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);*/


        //2.贪心丢弃
        //若当前指针所指元素之前的和小于 0，则丢弃当前元素之前的数列
        //https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
        //不懂看题解

        /*int maxSum = nums[0];//初始化成第一个元素
        int currentSum = 0;//当前 子数列 的和

        //遍历数组
        for (int num : nums) {
            //若当前指针所指元素之前的和小于 0，则丢弃当前元素之前的数列
            if (currentSum < 0) {
                currentSum = 0;
            }
            //否则当前指针所指元素之前的和大于等于 0，则继续累加当前元素
            currentSum += num;
            //记录最大和
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println(maxSum);*/


        //3.动态规划dp
        //如果前一个元素大于 0，则将其加到当前元素上

        int[] dp = new int[nums.length];//初始化dp数组
        int maxsum =0;
        //遍历数组
        for(int i = 0; i < nums.length; i++){
            dp[i] = nums[i];
            if(i > 0 && dp[i-1] > 0){
                dp[i] += dp[i-1];
            }
            maxsum = Math.max(maxsum, dp[i]);
        }
        System.out.println(maxsum);

    }
}
