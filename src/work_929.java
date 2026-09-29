import java.util.*;

public class work_929 {
    public static void main(String[] args) {
        //LeetCode 1657. 两个字符串是否接近
        //如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
        //操作 1：交换任意两个 现有 字符。
        //例如，abcde -> aecdb
        //操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
        //例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
        //你可以根据需要对任意一个字符串多次使用这两种操作。
        //给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false


        String word1 = "cabbba", word2 = "abbccc";
        System.out.println(closeStrings(word1, word2));
    }

    private static boolean closeStrings(String word1, String word2) {
        //1.如果两个字符串的长度不同，直接返回false
        if(word1.length()!=word2.length()){
            return false;
        }

        // 2. 用 HashMap 统计每个字符的出现频率
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(char c:word1.toCharArray()){
            //map1.put(c, map1.getOrDefault(c, 0) + 1);

            //看map中是否有c字符，如果没有，就初始化为1
            if(!map1.containsKey(c)){
                map1.put(c, 1);
            }
            map1.put(c, map1.get(c) + 1);
        }
        for(char c:word2.toCharArray()){
            //map2.put(c, map2.getOrDefault(c, 0) + 1);
            if(!map2.containsKey(c)){
                map2.put(c, 1);
            }
            map2.put(c, map2.get(c) + 1);
        }

        // 2. 用数组统计每个字符的出现频率(另一种方法)
        /*int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }*/



        //3. 检查两个字符集合是否完全相同
        if (!map1.keySet().equals(map2.keySet())){
            return false;
        }

        //4. 把频率值取出来，排序后比较是否相同
        ArrayList<Integer> i1 = new ArrayList<>(map1.values());
        ArrayList<Integer> i2 = new ArrayList<>(map2.values());

        Collections.sort(i1);
        Collections.sort(i2);

        return i1.equals(i2);


    }
}
