public class work_830 {
    public static void main(String[] args) {
        //LeetCode 1071. 字符串的最大公因子
        //对于字符串 s 和 t，只有在 s = t + t + t + ... + t + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
        //给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。



        String str1 = "ABCDABCD";
        String str2 = "ABCD";

        //先判断str1+str2和str2+str1是否相等
        if (!(str1 + str2).equals(str2 + str1)) {
            System.out.println("");
        }

        //如果相等，说明str1和str2有公因子
        //计算str1和str2的长度的最大公约数
        int gcdLen = gcd(str1.length(), str2.length());
        //从str1中截取前gcdLen个字符，就是最大公因子
        String gcdStr = str1.substring(0, gcdLen);
        System.out.println(gcdStr);




    }

    //计算最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
