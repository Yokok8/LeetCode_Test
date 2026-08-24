public class work_824 {
    public static void main(String[] args) {
        //LeetCode 42. 接雨水
        //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        //1.动态规划dp
        //先从左到右遍历，如果上一个数大于当前数，则将当前数加到dp数组中
        //从右往左也差不多，创建两个数组。
        //最后同时遍历数组，计算每个位置的雨水量（两个数组中的较小值减去当前height[i]的值），返回总和。
        /*int len = height.length;
        if(len<3){
            System.out.println(0);
        }
        int sum = 0;
        //初始化dp数组
        int[] dp_left = new int[len];
        int[] dp_right = new int[len];
        dp_left[0] = height[0];
        dp_right[len-1] = height[len-1];

        //从左到右遍历
        for(int i = 1; i < len; i++){
            dp_left[i] = Math.max(dp_left[i-1], height[i]);
        }
        //从右往左遍历
        for(int i = len-2; i >= 0; i--){
            dp_right[i] = Math.max(dp_right[i+1], height[i]);
        }
        //遍历数组，计算每个位置的雨水量
        for(int i = 0; i < len; i++){
            sum += Math.min(dp_left[i], dp_right[i]) - height[i];
        }
        System.out.println(sum);*/


        //2.双指针
        /*左右夹击：左指针从最左出发，右指针从最右出发。

        实时记录：分别维护左侧扫过的最高墙（leftMax）和右侧扫过的最高墙（rightMax）。

        “矮子”先动：比较当前左墙和当前右墙的高度。

        如果左墙更矮：说明左侧存水上限由leftMax决定，当前位置存水 = leftMax - 当前高度，加完后左指针向右移动。

        如果右墙更矮或相等：说明右侧存水上限由rightMax决定，当前位置存水 = rightMax - 当前高度，加完后右指针向左移动。

        重复直至相遇：两指针碰头时，所有凹槽的水量累加完毕（ans），返回结果。

        一句话核心：哪边柱子矮，就先计算哪边当前格子的水量，并往中间收缩。*/

        //定义左右指针
        int left = 0;
        int right = height.length - 1;
        //初始化leftMax和rightMax，用来记录左侧扫过的最高墙和右侧扫过的最高墙
        int leftMax = 0;
        int rightMax = 0;
        //初始化ans，用来记录总和
        int ans = 0;
        //遍历数组
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
                right--;
            }
        }
        System.out.println(ans);



    }
}
