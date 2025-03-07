package normal3;

/**
 * Created By Rock-Ayl on 2021-05-03
 * 1014. 最佳观光组合
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 示例 2：
 * <p>
 * 输入：values = [1,2]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= values.length <= 5 * 104
 * 1 <= values[i] <= 1000
 */
public class Code11 {

    public int maxScoreSightseeingPair(int[] values) {
        //默认位置
        int i = 0;
        int j = 1;
        //最高评分
        int rank = values[i] + values[j] + i - j;
        //循环
        for (int k = 2; k < values.length; k++) {
            //如果更新了i
            if ((values[j] + j) > (values[i] + i)) {
                //更新
                i = j;
            }
            //更新k
            j = k;
            //计算分
            int newRank = values[i] + values[j] + i - j;
            //如果分数更新了
            if (newRank > rank) {
                //更新分
                rank = newRank;
            }
        }
        //返回
        return rank;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }
}
