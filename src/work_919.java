public class work_919 {
    public static void main(String[] args) {
        //LeetCode 724.寻找数组的中心下标
        //给你一个整数数组 nums ，请计算数组的 中心下标 。
        //数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
        //如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
        //如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。

        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    private static int pivotIndex(int[] nums) {
        int n = nums.length;
        //定义左边的和
        int leftsum = 0;
        //定义数组的总和
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        //开始遍历数组
        for (int i = 0; i < n - 1; i++) {
            //如果左边的和等于右边的和，返回当前下标
            //左边的和 = 总和 - 右边的和 - 当前数字
            if (leftsum == total - leftsum - nums[i]) {
                return i;
            }
            //如果左边的和不等于右边的和，继续遍历，更新左边的和
            leftsum += nums[i];
        }
        //如果遍历完数组，都没有找到中心下标，返回-1
        return -1;
    }
}
