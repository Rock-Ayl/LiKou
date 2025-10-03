package easy41;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-10-03
 * 3697. 计算十进制表示
 * 算术评级: 2
 * 第 469 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1251
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 正整数 n。
 * <p>
 * 如果一个正整数可以表示为 1 到 9 的单个数字和 10 的非负整数次幂的乘积，则称这个整数是一个 10 进制分量。例如，500、30 和 7 是 10 进制分量 ，而 537、102 和 11 则不是。
 * <p>
 * 请将 n 表示为若干 仅由 10 进制分量组成的和，且使用的 10 进制分量个数 最少 。
 * <p>
 * 返回一个包含这些 10 进制分量 的数组，并按分量大小 降序 排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 537
 * <p>
 * 输出：[500,30,7]
 * <p>
 * 解释：
 * <p>
 * 我们可以将 537 表示为500 + 30 + 7。无法用少于 3 个 10 进制分量表示 537。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 102
 * <p>
 * 输出：[100,2]
 * <p>
 * 解释：
 * <p>
 * 我们可以将 102 表示为100 + 2。102 不是一个 10 进制分量，因此需要 2 个 10 进制分量。
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 6
 * <p>
 * 输出：[6]
 * <p>
 * 解释：
 * <p>
 * 6 是一个 10 进制分量。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 */
public class Code15 {

    public int[] decimalRepresentation(int n) {
        //结果
        List<Integer> result = new ArrayList<>();
        //如果大于这些
        while (n > 9) {
            //本次数字
            int number = n % 10;
            //记录本次
            result.add(number);
            //下一个
            n = n / 10;
        }
        //最后记录n
        result.add(n);
        //倍数
        int hit = 1;
        //循环
        for (int i = 0; i < result.size(); i++) {
            //乘以倍数
            result.set(i, result.get(i) * hit);
            //下一个
            hit = hit * 10;
        }
        //翻转
        Collections.reverse(result);
        //返回
        return result
                //流
                .stream()
                //拆箱
                .mapToInt(Integer::intValue)
                //过滤0
                .filter(p -> p != 0)
                //转为数组
                .toArray();
    }

    public static void main(String[] args) {
        int[] ints = new Code15().decimalRepresentation(537);
        System.out.println();
    }

}
