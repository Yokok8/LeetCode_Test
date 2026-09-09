public class work_909 {
    public static void main(String[] args) {
        //LeetCode 643. 子数组的最大平均数 I
        //给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
        //请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
        //任何误差小于 10-5 的答案都将被视为正确答案。

        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;

        //先计算第一个长度为 k 的窗口和
        //然后向右滑动窗口（每次减去左侧移出元素并加入右侧新元素）
        //实时更新窗口和的最大值，最后除以 k 得到最大平均数。

        double sum = 0;

        //先算第一个窗口的平均数
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        double maxAvg = sum / k;

        // 滑动窗口
        // 每次移动一个元素，更新sum和maxAvg
        //sum先减去前面元素，再加上后面元素，然后算平均数并比较是否大于maxAvg
        //如果大于，更新maxAvg
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxAvg = Math.max(maxAvg, sum / k);
        }
        System.out.println(maxAvg);







    }
}
