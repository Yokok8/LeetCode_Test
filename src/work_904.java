public class work_904 {
    public static void main(String[] args) {
        //LeetCode 605. 种花问题
        //假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

        //给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，
        //能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。

        int[] flowerbed = {1,0,1,0,1};
        int n = 1;

        int count = 0;          // 记录已经种了多少朵
        int i = 0;              // 指针，从花坛最左边开始
        int m = flowerbed.length;

        // 循环条件：还没遍历完，并且还没种够 n 朵
        while (i < m && count < n) {

            // 只有当前是空地，才需要判断左右
            if (flowerbed[i] == 0) {

                // 检查左边：要么是边界（i==0），要么左边那个是 0
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);

                // 检查右边：要么是边界（i==m-1），要么右边那个是 0
                boolean rightEmpty = (i == m - 1) || (flowerbed[i + 1] == 0);

                // 如果左右都满足，就种！
                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;   // 把空地变成花
                    count++;            // 种花数 +1
                    i += 2;             // 关键：种完后，下一格绝对不能再种，直接跳过去
                    continue;           // 跳到 while 下一轮
                }
            }

            // 如果不能种，或者当前位置本来就是 1，就老老实实往后移动一格
            i++;
        }

        // 如果最终种的数量 >= 需要的数量，就返回 true
        System.out.println(count >= n);
    }

    }

