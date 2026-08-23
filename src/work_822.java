import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class work_822 {
    public static void main(String[] args) {
        //LeetCode 15. 三数之和
        //给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
        //同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
        //注意：答案中不可以包含重复的三元组。

        //排序定序，固定一个，双指针左右夹逼，找到后邻位跳过去重。

        //外部去重：因为题目要求返回 “不重复” 的三元组，如果不跳过重复的固定元素，遍历后会得到重复的三元组。
        //外部nums[i] == nums[i - 1]：先保留第一个，跳过后面的重复值，防止错过正确答案

        //内部去重：在固定元素后，左右指针指向的元素，需要跳过重复的元素，否则会得到重复的三元组。
        //内部nums[left] == nums[left + 1]：先跳过重复的左指针元素，防止得到重复的三元组
        //内部nums[right] == nums[right - 1]：先跳过重复的右指针元素

        int[] nums = {-1, 0, 1, 2, -1, -4};

        //先排序，方便后续去重
        Arrays.sort(nums);  //-4,-1,-1,0,1,2,
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // 固定第一个元素，i < n - 2防止越界
        for (int i = 0; i < n - 2; i++) {
            // 跳过重复的固定元素,外部去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //初始化左指针和右指针
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    //内部去重
                    // 跳过重复的左指针元素
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // 跳过重复的右指针元素
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(result);


    }

}





