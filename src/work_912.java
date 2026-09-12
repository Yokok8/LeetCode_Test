public class work_912 {
    public static void main(String[] args) {
        //LeetCode 1732. 找到最高海拔
        //有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
        //给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。
        // 请你返回 最高点的海拔。

        int[] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }
    //边走边加、边加边记最大值。
    private static int largestAltitude(int[] gain) {
        //max记录最大海拔，cur记录当前海拔
        int max = 0;
        int cur = 0;
        //遍历数组，边加边记最大值
        for (int i = 0; i < gain.length; i++) {
            //当前海拔加上当前点的海拔高度差，就是下一个点的海拔
            cur = cur + gain[i];
            //更新最大海拔
            max = Math.max(max, cur);
        }
        //返回最大海拔
        return max;



    }
}
