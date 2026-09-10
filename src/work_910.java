import com.sun.jdi.Value;

public class work_910 {
    public static void main(String[] args) {
        //LeetCode 11. 盛最多水的容器
        //给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
        //找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
        //返回容器可以储存的最大水量。
        //说明：你不能倾斜容器。

        int []height = {1,8,6,2,5,4,8,3,7};
        int maxArea = 0;


        //双指针法
        //左右两指针相向而行，每次只移动「短板」那一端，沿途不断更新最大面积。
        int left = 0;
        int right = height.length - 1;
        //当left指针小于right指针时，才继续循环
        while (left < right) {
            //计算当前容器的面积
            int area = Math.min(height[left], height[right]) * (right - left);
            //更新最大面积
            maxArea = Math.max(maxArea, area);
            //如果left指针指向的线更短，就将left指针向右移动
            if (height[left] < height[right]) {
                left++;
            } else {
                //如果right指针指向的线更短，就将right指针向左移动
                right--;
            }
        }

        System.out.println(maxArea);


    }
}
