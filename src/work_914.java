import java.util.Arrays;

public class work_914 {
    public static void main(String[] args) {
        //LeetCode  238.除自身以外数组的乘积
        //给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。
        //题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
        //请不要使用除法，且在 O(n) 时间复杂度内完成此题。

        int[] nums = {1, 2, 3, 4};
        int[] answer = productExceptSelf(nums);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] productExceptSelf(int[] nums) {
        //利用索引左侧所有数字的乘积和右侧所有数字的乘积（即前缀与后缀）相乘得到答案。

        //优化：可以在计算前缀乘积和后缀乘积时，直接计算answer。把算数的结果存储在前缀乘积数组中，这样少一个数组。

        int[] answer = new int[nums.length];
        //计算前缀乘积
        int[] qian = new int[nums.length];
        qian[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            qian[i] = qian[i - 1] * nums[i - 1];
        }
        //计算后缀乘积
        int[] hou = new int[nums.length];
        hou[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            hou[i] = hou[i + 1] * nums[i + 1];
        }
        //计算answer
        for (int i = 0; i < nums.length; i++) {
            answer[i] = qian[i] * hou[i];
        }
        return answer;

    }
}
