public class work_916 {
    public static void main(String[] args) {
        //LeetCode 334. 递增的三元子序列
        //给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
        //如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，
        //使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。

        int[] nums = {2,1,5,0,4,6};

        //1.枚举中间点	对每个 j，看「左边最小值 < nums[j] 且右边最大值 > nums[j]」
        //固定中间那个数，左边找最小、右边找最大。

        int n = nums.length;
        int [] leftMin = new int[n];
        int [] rightMin = new int[n];

        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i-1], nums[i]);
        }

        rightMin[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMin[i] = Math.max(rightMin[i+1], nums[i]);
        }

        for (int i = 1; i < n-1; i++) {
            if (leftMin[i-1] < nums[i] && nums[i] < rightMin[i+1]) {
                System.out.println(true);
            }
        }

        /*//2.贪心
        //定义frist和second,
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        //遍历数组
        for(int num:nums){
            if(num<=first){
                //如果num小于first，first就记录当前数字
                first = num;
            }else if(num<=second){
                //如果num大于first而且小于second，second就记录当前数字
                second = num;
            }else{
                //运行到这说明，遍历到三个数符合题目要求，返回true；
                return true;
            }

        }
        return false;*/


    }
}
