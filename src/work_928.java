public class work_928 {
    public static void main(String[] args) {
        //LeetCode 1483.删掉一个元素以后全为1的最长子数组
        //给你一个二进制数组 nums ，你需要从中删掉一个元素。
        //请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
        //如果不存在这样的子数组，请返回 0 。

        int [] nums = {0,1,1,1,0,1,1,0,1};
        //输出：5
        //解释：删掉位置为 4 的元素后，最长的全 1 子数组为 [1,1,1,1,1]。
        //长度为 5 。

        System.out.println(longestSubarray(nums));
        //找一个最多包含 1 个 0 的最长窗口，删掉那个 0（没有 0 就删一个 1），答案就是窗口长度减 1。
    }

    private static int longestSubarray(int[] nums) {
        int n = nums.length;
        //定义左右边界
        int left = 0;
        int right = 0;

        //定义记录0的个数
        int zeroCount = 0;

        //定义最大长度和当前长度
        int max = 0;
        int count = 0;

        //遍历数组
        while(right<n-1){
            //如果当前元素为1，count++，right++
            //如果当前元素为0，zeroCount++
            if(nums[right]==0){
                zeroCount++;
            }else{
                count++;
            }
            //无论是否为0，都扩张右边界
            right++;

            //如果0的个数>1，收缩左边界
            while(zeroCount>1){
                //如果是0，减少0的个数；如果是1，减少当前长度。然后收缩左边界
                if(nums[left]==0){
                    zeroCount--;
                }else{
                    count--;
                }
                left++;
            }
            //更新max
            // 修复2: 全1时必须删一个1，有0时删0不用减
            //也可以直接right-left
            int effective = (zeroCount == 0 ) ? count - 1 : count;
            if (effective < 0 ) effective = 0 ; // 边界: [0] 或 [1]
            max = Math.max(max,effective);
        }
        return max;
    }

}
