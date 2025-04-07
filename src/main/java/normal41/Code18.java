package normal41;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-04-07
 * 2171. 拿出最少数目的魔法豆
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
 * <p>
 * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
 * <p>
 * 请返回你需要拿出魔法豆的 最少数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：beans = [4,1,6,5]
 * 输出：4
 * 解释：
 * - 我们从有 1 个魔法豆的袋子中拿出 1 颗魔法豆。
 * 剩下袋子中魔法豆的数目为：[4,0,6,5]
 * - 然后我们从有 6 个魔法豆的袋子中拿出 2 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[4,0,4,5]
 * - 然后我们从有 5 个魔法豆的袋子中拿出 1 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[4,0,4,4]
 * 总共拿出了 1 + 2 + 1 = 4 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 * 没有比取出 4 个魔法豆更少的方案。
 * 示例 2：
 * <p>
 * 输入：beans = [2,10,3,2]
 * 输出：7
 * 解释：
 * - 我们从有 2 个魔法豆的其中一个袋子中拿出 2 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[0,10,3,2]
 * - 然后我们从另一个有 2 个魔法豆的袋子中拿出 2 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[0,10,3,0]
 * - 然后我们从有 3 个魔法豆的袋子中拿出 3 个魔法豆。
 * 剩下袋子中魔法豆的数目为：[0,10,0,0]
 * 总共拿出了 2 + 2 + 3 = 7 个魔法豆，剩下非空袋子中魔法豆的数目相等。
 * 没有比取出 7 个魔法豆更少的方案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= beans.length <= 105
 * 1 <= beans[i] <= 105
 */
public class Code18 {

    public long minimumRemoval(int[] beans) {
        //排序
        Arrays.sort(beans);
        //左边和
        long leftSum = 0L;
        //右边和
        long rightSum = Arrays.stream(beans).mapToLong(p -> (long) p).sum();
        //最小可能
        long min = Long.MAX_VALUE;
        //循环
        for (int i = 0; i < beans.length; i++) {
            //右边删除本次和
            rightSum -= beans[i];
            //本次要拿走的 = 左边的全扣除 + 右边选择扣除的
            long cost = leftSum + ((rightSum - ((beans.length - i - 1) * (long) beans[i])));
            //左边叠加本次和
            leftSum += beans[i];
            //刷新最小结果
            min = Math.min(cost, min);
        }
        //返回
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().minimumRemoval(new int[]{4, 1, 6, 5}));
    }

}
