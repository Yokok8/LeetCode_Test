import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class work_913 {
    public static void main(String[] args) {
        //LeetCode 2215.找出两数组的不同
        //给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
        //answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
        //answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
        //注意：列表中的整数可以按 任意 顺序返回。


        int []nums1 = {1,2,3,3};  //[1,2,3]
        int []nums2 = {1,1,2,2};  //[1,2]


        System.out.println(findDifference(nums1, nums2));


    }

    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //先去重
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        //如果num1里不包含num2里的数，就添加到数组中
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i : set1) {
            if (!set2.contains(i)) {
                list1.add(i);
            }
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i : set2) {
            if (!set1.contains(i)) {
                list2.add(i);
            }
        }

        //合并数组并返回
        return Arrays.asList(list1,list2);

    }
}
