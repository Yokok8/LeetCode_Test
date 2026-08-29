public class work_829 {
    public static void main(String[] args) {
        //LeetCode 1768.交替合并字符串
        //给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
        //返回 合并后的字符串 。

        String word1 = "ab";
        String word2 = "pqrs";



        //1.双指针
        //从 word1 开始，每次各取一个字符拼到结果里。当其中一个字符串用完，就把另一个剩余的部分直接追加。

        //String result = "";
        //可以用，但是效率低
        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                ans.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                ans.append(word2.charAt(j));
                j++;
            }
        }
        System.out.println(ans.toString());


    }
}
