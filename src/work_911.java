import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class work_911 {
    //LeetCode 1679.K和数对的最大数目
    //给你一个整数数组 nums 和一个整数 k 。
    //每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
    //返回你可以对数组执行的最大操作数。

    public static void main(String[] args) {

        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;

//        //双指针法--思路：先把队伍排好，再从两头往中间「夹逼」。
//        //先排序
//        Arrays.sort(nums);
//        //定义双指针
//        int left = 0;
//        int right = nums.length - 1;
//
//        //定义计数器
//        int count = 0;
//
//        //遍历数组,开始循环
//        while (left < right) {
//            //如果双指针指向的两个数的和等于k，说明找到一个数对
//            //将双指针指向的两个数从数组中移除
//            //将计数器加1
//            //将双指针向中间移动
//            if (nums[left] + nums[right] == k) {
//                left++;
//                right--;
//                count++;
//            } else if (nums[left] + nums[right] < k) {
//                //如果双指针指向的两个数的和小于k，说明双指针指向的两个数的和太小
//                //将左指针向右移动
//                left++;
//            } else if (nums[left] + nums[right] > k) {
//                //如果双指针指向的两个数的和大于k，说明双指针指向的两个数的和太大
//                //将右指针向左移动
//                right--;
//            }
//        }
//        //输出结果
//        System.out.println(count);


        //HashMap法--不排序，一边走一边「挂失招领」。

        //定义HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        //定义计数器
        int count = 0;

        //遍历数组,开始循环
        for (int num : nums) {
            //计算需要的数
            int need = k - num;
            //如果需要的数在HashMap中，且需要的数的数量大于0，说明找到一个数对
            if (map.containsKey(need) && map.get(need) > 0) {
                //将需要的数从HashMap中移除
                map.put(need, map.get(need) - 1);
                //将计数器加1
                count++;
            } else {
                //如果需要的数不在HashMap中，说明当前数是需要的数
                if (map.containsKey(num)) {
                    //将当前数的数量加1
                    map.put(num, map.get(num) + 1);
                } else {
                    //将当前数加入HashMap
                    map.put(num, 1);
                }
            }
        }

        System.out.println(count);


    }
}
