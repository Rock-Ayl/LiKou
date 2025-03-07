package normal37;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-11-13
 * 2028. 找出缺失的观测数据
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 现有一份 n + m 次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份，你手上只拿到剩余 m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。
 * <p>
 * 给你一个长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。
 * <p>
 * 返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。如果存在多组符合要求的答案，只需要返回其中任意一组即可。如果不存在答案，返回一个空数组。
 * <p>
 * k 个数字的 平均值 为这些数字求和后再除以 k 。
 * <p>
 * 注意 mean 是一个整数，所以 n + m 次投掷的总和需要被 n + m 整除。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：rolls = [3,2,4,3], mean = 4, n = 2
 * 输出：[6,6]
 * 解释：所有 n + m 次投掷的平均值是 (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4 。
 * 示例 2：
 * <p>
 * 输入：rolls = [1,5,6], mean = 3, n = 4
 * 输出：[2,3,2,2]
 * 解释：所有 n + m 次投掷的平均值是 (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3 。
 * 示例 3：
 * <p>
 * 输入：rolls = [1,2,3,4], mean = 6, n = 4
 * 输出：[]
 * 解释：无论丢失的 4 次数据是什么，平均值都不可能是 6 。
 * 示例 4：
 * <p>
 * 输入：rolls = [1], mean = 3, n = 1
 * 输出：[5]
 * 解释：所有 n + m 次投掷的平均值是 (1 + 5) / 2 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == rolls.length
 * 1 <= n, m <= 105
 * 1 <= rolls[i], mean <= 6
 */
public class Code9 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        //需要的总量
        int need = (rolls.length + n) * mean - Arrays.stream(rolls).sum();
        //如果远超 or 不够 or 不存在
        if (need > n * 6 || need < n || need <= 0) {
            //空过
            return new int[]{};
        }
        //计算最小平均情况
        int min = need / n;
        //余数
        int other = need % n;
        //初始化结果
        int[] result = new int[n];
        //循环
        for (int i = 0; i < result.length; i++) {
            //本次结果
            result[i] = other-- > 0 ? min + 1 : min;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code9().missingRolls(new int[]{4, 2, 2, 5, 4, 5, 4, 5, 3, 3, 6, 1, 2, 4, 2, 1, 6, 5, 4, 2, 3, 4, 2, 3, 3, 5, 4, 1, 4, 4, 5, 3, 6, 1, 5, 2, 3, 3, 6, 1, 6, 4, 1, 3},
                2, 53);
        System.out.println();
    }

}
