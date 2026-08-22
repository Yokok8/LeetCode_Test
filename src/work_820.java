public class work2 {
    public static void main(String[] args) {
        //8月20日
        //LeetCode 209.长度最小的子数组
        //给定一个含有 n 个正整数的数组和一个正整数 target 。
        //找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr]
        //并返回其长度。如果不存在符合条件的子数组，返回 0


        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int result = 0;
        // 初始设一个很大的值，方便后续取最小值
        int minLen = 100;

        // right右指针不断扩张窗口
        for (int right = 0, left = 0; right < nums.length; right++) {
            result = result + nums[right];
            // 条件满足，开始收缩左边界
            while (result >= target) {
                // 更新最小窗口长度
                minLen = Math.min(minLen,right- left +1);
                // 左边移出窗口
                result = result - nums[left];
                // 左指针右移
                left++;
            }
        }
        System.out.println(minLen);

    }
}
