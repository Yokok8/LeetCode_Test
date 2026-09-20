public class work_920 {
    public static void main(String[] args) {
        //LeetCode 2390.从字符串中移除星号
        //给你一个包含若干星号 * 的字符串 s 。
        //在一步操作中，你可以：
        //选中 s 中的一个星号。
        //移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
        //返回移除 所有 星号之后的字符串。
        //注意：
        //生成的输入保证总是可以执行题面中描述的操作。
        //可以证明结果字符串是唯一的。

        String s = "leet**cod*e";
        System.out.println(removeStars(s));

    }

    private static String removeStars(String s) {

        //把 StringBuilder当栈用   ——  字母入栈，星号弹栈。
        //* 要删的是"左边最近的字符"，而这个字符永远是最后放进 sb 的、位于末尾的那个，属于"后进先出"，正好是栈的模型。

        StringBuilder sb = new StringBuilder();
        //遍历字符串
        for (char c : s.toCharArray()) {
            if (c != '*') {
                //如果为*，就添加到sb中
                sb.append(c);
            } else {
                //否则删除sb中最后一个元素
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
