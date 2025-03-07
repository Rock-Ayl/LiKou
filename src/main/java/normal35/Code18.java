package normal35;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-10-01
 * 3301. 高度互不相同的最大塔高和
 * 中等
 * 相关企业
 * 提示
 * 给你一个数组 maximumHeight ，其中 maximumHeight[i] 表示第 i 座塔可以达到的 最大 高度。
 * <p>
 * 你的任务是给每一座塔分别设置一个高度，使得：
 * <p>
 * 第 i 座塔的高度是一个正整数，且不超过 maximumHeight[i] 。
 * 所有塔的高度互不相同。
 * 请你返回设置完所有塔的高度后，可以达到的 最大 总高度。如果没有合法的设置，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：maximumHeight = [2,3,4,3]
 * <p>
 * 输出：10
 * <p>
 * 解释：
 * <p>
 * 我们可以将塔的高度设置为：[1, 2, 4, 3] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：maximumHeight = [15,10]
 * <p>
 * 输出：25
 * <p>
 * 解释：
 * <p>
 * 我们可以将塔的高度设置为：[15, 10] 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：maximumHeight = [2,2,1]
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * <p>
 * 无法设置塔的高度为正整数且高度互不相同。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= maximumHeight.length <= 105
 * 1 <= maximumHeight[i] <= 109
 */
public class Code18 {

    public long maximumTotalSum(int[] maximumHeight) {
        //排序
        Arrays.sort(maximumHeight);
        //当前和
        long sum = maximumHeight[maximumHeight.length - 1];
        //当前数字
        int num = maximumHeight[maximumHeight.length - 1];
        //循环
        for (int i = maximumHeight.length - 2; i >= 0; i--) {
            //最大可能
            int max = Math.min(maximumHeight[i], num - 1);
            //如果太小了
            if (max < 1) {
                //不可能
                return -1;
            }
            //叠加
            sum += max;
            //刷新
            num = max;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().maximumTotalSum(new int[]{2, 3, 4, 3}));
    }

}
