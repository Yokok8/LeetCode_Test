public class work_905 {
    public static void main(String[] args) {
        //LeetCode 345. 反转字符串中的元音字符
        //给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
        //元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。

        String s = "leetcode";

        //1.双指针
        //从字符串的开头和结尾开始，每次各取一个字符，如果是元音，就交换它们的位置。

        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        //创建一个元音字母的字符串
        String vowels = "aeiouAEIOU";

        while (left < right) {
            if (vowels.indexOf(chars[left]) == -1) {
                left++;
            } else if (vowels.indexOf(chars[right]) == -1) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        System.out.println(new String(chars));






    }
}
