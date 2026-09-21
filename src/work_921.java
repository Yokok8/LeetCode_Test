public class work_921 {
    public static void main(String[] args) {
        //LeetCode 1004. 最长连续1的个数III
        //给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int K = 2;

        System.out.println(longestOnes(nums, K));


    }

    private static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int left = 0;
        int right = 0;
        int zeroCount = 0;

        for(right = 0; right < n; right++){
            //① right 右移，新元素进来
            if(nums[right] == 0){
                zeroCount++;
            }

            //② 窗口内 0 太多，左边收缩直到合法
            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            // ③ 此时窗口一定合法，更新答案
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
