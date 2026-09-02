import java.util.ArrayList;
import java.util.List;

public class work_902 {
    public static void main(String[] args) {
        //LeetCode 1431.拥有最多糖果的孩子数
        //有 n 个有糖果的孩子。给你一个数组 candies，其中 candies[i] 代表第 i 个孩子拥有的糖果数目，
        //和一个整数 extraCandies 表示你所有的额外糖果的数量。
        //返回一个长度为 n 的布尔数组 result，如果把所有的 extraCandies 给第 i 个孩子之后，
        //他会拥有所有孩子中 最多 的糖果，那么 result[i] 为 true，否则为 false。
        //注意，允许有多个孩子同时拥有 最多 的糖果数目。

        int candies[] = {2,3,5,1,3};

        int extraCandies = 3;

        //创建一个布尔数组result
        ArrayList<Boolean> result = new ArrayList<>();

        //找到所有孩子中糖果最多的数量
        //定义一个变量max，初始值为第一个孩子的糖果数量
        int max= candies[0];
        for (int i = 1; i < candies.length; i++) {
            max= Math.max(candies[i], max);
        }

        //遍历所有孩子
        //如果当前孩子加上额外糖果数量大于等于max，就将true添加到result中
        //否则将false添加到result中
        for (int j = 0; j < candies.length; j++) {
            if (candies[j]+extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        //返回result
        System.out.println(result);
    }
}
