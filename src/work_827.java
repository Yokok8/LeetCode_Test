public class work_827 {
    public static void main(String[] args) {
        //LeetCode 198.打家劫舍
        //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
        //
        //给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

        int[] nums = {2,7,9,3,1};
        //dp[0]=2
        //dp[1]=max(2,7) = 7
        //dp[2]=max(7,2+9) = 11
        //dp[3]=max(9,7+3) = 10
        //dp[4]=max(12,9+1) = 12


        int[] dp = new int[nums.length];

        if (nums == null || nums.length == 0){
            System.out.println(0);
        }
        if (nums.length == 1){
            System.out.println(nums[0]);
        }


        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        System.out.println(dp[nums.length-1]);






    }
}
