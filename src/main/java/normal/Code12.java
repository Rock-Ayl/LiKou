package normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-03-17
 * 1447. 最简分数
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 * 示例 4：
 * <p>
 * 输入：n = 1
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 */
public class Code12 {

    public static List<String> simplifiedFractions(int n) {
        //缓存
        Set<Double> set = new HashSet<>();
        //初始化结果
        List<String> result = new ArrayList<>();
        //份子
        int i = 1;
        //分母
        int j = 2;
        //循环
        while (i < n) {
            //如果小于1
            if (j <= n) {
                //分分数大小
                double mul = (double) j / (double) i;
                //组装分数
                String str;
                //如果不存在这个倍数
                if (!set.contains(mul)) {
                    //直接组装
                    str = i + "/" + j;
                    //记录返回值
                    result.add(str);
                    //记录已经存在
                    set.add(mul);
                }
                //分子递增
                j++;
            } else {
                //分子+1
                i = i + 1;
                //分母重置
                j = i + 1;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (String simplifiedFraction : simplifiedFractions(6)) {
            System.out.println(simplifiedFraction);
        }
    }
}
