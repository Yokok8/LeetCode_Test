public class work_917 {
    public static void main(String[] args){
        //LeetCode 443. 字符串压缩
        //给你一个字符数组 chars ，请使用下述算法压缩：
        //从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
        //如果这一组长度为 1 ，则将字符追加到 s 中。
        //否则，需要向 s 追加字符，后跟这一组的长度。
        //压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。
        // 需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
        //请在 修改完输入数组后 ，返回该数组的新长度。

        char [] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));

    }

    //读指针扫，数清楚一组有几个；写指针跟在后面，把字符和数字写回去。
    private static int compress(char[] chars) {
        int n = chars.length;
        int write = 0; // 写指针
        int read = 0;  // 读指针

        //外部循环，遍历数组中的每个字符
        while (read < n) {
            //当前字符
            char c = chars[read];
            int count = 0;

            // 统计连续相同字符的数量
            while (read < n && chars[read] == c) {
                read++;
                count++;
            }

            // 写入字符
            chars[write] = c;
            write++;

            // 写入数字（如果 count > 1）
            if (count > 1) {
                // String.valueOf(count)转换为字符串
                //toCharArray()将字符串转换为字符数组
                //这样两位数以上也可以处理成多个字符
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[write] = digit;
                    write++;
                }
            }
        }

        return write;


    }
}
