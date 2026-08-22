import java.util.HashSet;
import java.util.Set;

public class work1 {
    public static void main(String[] args) {
        //8月19日

        //LeetCode 3.无重复字符的最长子串

        
        //不懂可以看BV113411v7Ak
        

        /*窗口：[left , right]，窗口内保存没有重复字符的连续子串
          right（右指针）：循环不断向右走，负责扩大窗口，遍历每一个字符
          left（左指针）：只向右、不会回退；出现重复字符时，右移缩小窗口，消除重复*/


        //给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
        String s = "abcabcbb";

        //添加进set
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }


        int maxLength = 0;
        // left左指针，right右指针；right循环不断向右扩张窗口
        for (int left = 0, right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                // 不断移除窗口最左边字符，左指针右移，直到消除重复
                set.remove(s.charAt(left));
                left++;
            }
            // 把当前right字符加入窗口
            set.add(s.charAt(right));
            // 更新窗口最大长度 [left, right]
            maxLength = Math.max(maxLength, set.size());
        }
        System.out.println(maxLength);

    }
}
