    public class work_918 {
        public static void main(String[] args) {
            //LeetCode 1456.定长字串中元音的最大数量
            //给你字符串 s 和整数 k 。
            //请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
            //英文中的 元音字母 为（a, e, i, o, u）。


            String s = "abciiidef";
            int k = 3;

            System.out.println(maxVowels(s, k));

        }

        private static int maxVowels(String s, int k) {
            //滑动窗口
            //定义指针
            int left = 0;
            int max = 0; //最大元音字母数量
            int count = 0; //当前窗口元音字母数量
            //遍历字符串
            for(int right = 0; right < s.length(); right++) {
                //当前字符
                char ch = s.charAt(right);
                //如果是元音字母，count++
                if(isVowel(ch)){
                    count++;
                }

                //如果窗口大小大于k，左指针右移，收缩窗口
                if(right - left + 1 > k){
                    //如果左指针指向的是元音字母，count--
                    char ch1 = s.charAt(left);
                    if(isVowel(ch1)){
                        count--;
                    }
                    left++;
                }
                //更新最大元音字母数量
                max = Math.max(max, count);
            }
            //返回最大元音字母数量
            return max;

    }

        private static boolean isVowel(char c) {
            return "aeiou".indexOf(c) != -1;
        }
    }



