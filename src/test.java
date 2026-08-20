class test {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int left = 0;
        int sum = 0;
        // 初始设一个很大的值
        int minLen = 100;

        // right右指针不断扩张窗口
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            // 条件满足，开始收缩左边界
            while(sum >= target){
                // 更新最小窗口长度
                minLen = Math.min(minLen, right - left + 1);
                // 左边移出窗口
                sum -= nums[left];
                left++;
            }
        }
        // 如果没找到，返回0
        System.out.println(minLen);
    }
}
