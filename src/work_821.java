import java.util.Arrays;

public class work_821 {
    public static void main(String[] args) {
        //LeetCode 283. 移动零
        /*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        请注意 ，必须在不复制数组的情况下原地对数组进行操作。*/

        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //方法1：双指针法
    public void moveZeroes2(int[] nums) {
        //定义左指针
        int left = 0;
        //定义右指针，向右遍历
        for(int right = 0 ; right<nums.length;right++){
            //如果右指针指向的元素不是0，就交换左指针和右指针指向的元素
            if(nums[right]!=0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                //左指针向右移动
                left++;
            }
        }
    }

    //差不多，遇到非0直接换，最后再补零
    public static void moveZeroes(int[] nums) {
        int insertPos = 0; // 记录非零元素应该放入的位置
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        // 剩余位置补零
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }


}
