import java.util.Arrays;

public class work_923 {
    public static void main(String[] args) {
        //LeetCode 735.小行星碰撞
        //给定一个整数数组 asteroids，表示在同一行的小行星。
        //数组中小行星的索引表示它们在空间中的相对位置。
        //对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。
        //每一颗小行星以相同的速度移动。
        //找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。
        //如果两颗小行星大小相同，则两颗小行星都会爆炸。
        //两颗移动方向相同的小行星，永远不会发生碰撞。


        int[] asteroids = {8,-8};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));



    }

    private static int[] asteroidCollision(int[] asteroids) {
        //- 历每颗小行星
        //- 如果当前小行星 向右（正数） → 直接入栈
        //- 如果当前小行星 向左（负数） → 不断和栈顶比较：
        //- 栈顶更小 → 栈顶爆炸（弹出），继续比较下一个栈顶
        //- 栈顶更大 → 当前小行星爆炸（不入栈）
        //- 一样大 → 两者都爆炸（弹出栈顶，当前也不入）
        int n = asteroids.length;
        int st[] = new int[n];
        int top = -1; //栈顶指针
        boolean islive = true; //是否存活

        //遍历所有行星
        for (int s : asteroids) {
            //如果大于0，行星向右
            if (s > 0) {
                //直接进入栈顶
                top++;
                st[top] = s;
            } else {
                //否则小于0，行星向左
                //判断是否碰撞,即当前不住栈顶且上个数为正数
                while (top >= 0 && st[top] > 0) {
                    //判断大小，比上一个大，去掉上一个并继续判断
                    if (-s > st[top]) {
                        top--;
                    } else if (-s == st[top]) {
                        //跟上一个相等，把上一个去掉,
                        top--;
                        islive = false;
                        break;
                    } else {
                        //比上一个小，不入栈
                        islive = false;
                        break;
                    }
                }
                //碰撞结束，前面没有可以撞的，或前面同方向,入栈
                if (islive) {
                    top++;
                    st[top] = s;
                }
            }
            islive = true;
        }
        return Arrays.copyOf(st, top + 1);



    }
}
