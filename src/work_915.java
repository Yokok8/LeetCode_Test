import java.util.HashMap;
import java.util.HashSet;

public class work_915 {
    public static void main(String[] args) {
        //LeetCode 1207.独一无二的出现次数
        //给你一个整数数组 arr，如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

        int[] arr = {2,1,3};

        //用哈希表记录每个数的值和他出现次数，再把值添加到HashSet中，进行比较
        //如果HashSet的大小等于map的大小，说明每个数的出现次数都是独一无二的，返回true
        //因为HashSet不允许重复，所以如果HashSet的大小等于map的大小，说明每个数的出现次数都是独一无二的


        //先定义哈希表，记录每个数的出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        //遍历arr，把arr中的数和数的出现次数放入Map中
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        //定义HashSet，把map的值添加到HashSet中
        HashSet<Integer> set = new HashSet<>();
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            set.add(entry.getValue());
        }

        //判断HashSet的大小是否等于map的大小
        if (set.size() == map.size()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
