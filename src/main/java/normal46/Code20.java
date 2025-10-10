package normal46;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-10-10
 * 3457. 吃披萨
 * 算术评级: 4
 * 第 437 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1704
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 pizzas，其中 pizzas[i] 表示第 i 个披萨的重量。每天你会吃 恰好 4 个披萨。由于你的新陈代谢能力惊人，当你吃重量为 W、X、Y 和 Z 的披萨（其中 W <= X <= Y <= Z）时，你只会增加 1 个披萨的重量！体重增加规则如下：
 * <p>
 * 在 奇数天（按 1 开始计数）你会增加 Z 的重量。
 * 在 偶数天，你会增加 Y 的重量。
 * 请你设计吃掉 所有 披萨的最优方案，并计算你可以增加的 最大 总重量。
 * <p>
 * 注意：保证 n 是 4 的倍数，并且每个披萨只吃一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： pizzas = [1,2,3,4,5,6,7,8]
 * <p>
 * 输出： 14
 * <p>
 * 解释：
 * <p>
 * 第 1 天，你吃掉下标为 [1, 2, 4, 7] = [2, 3, 5, 8] 的披萨。你增加的重量为 8。
 * 第 2 天，你吃掉下标为 [0, 3, 5, 6] = [1, 4, 6, 7] 的披萨。你增加的重量为 6。
 * 吃掉所有披萨后，你增加的总重量为 8 + 6 = 14。
 * <p>
 * 示例 2：
 * <p>
 * 输入： pizzas = [2,1,1,1,1,1,1,1]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 第 1 天，你吃掉下标为 [4, 5, 6, 0] = [1, 1, 1, 2] 的披萨。你增加的重量为 2。
 * 第 2 天，你吃掉下标为 [1, 2, 3, 7] = [1, 1, 1, 1] 的披萨。你增加的重量为 1。
 * 吃掉所有披萨后，你增加的总重量为 2 + 1 = 3。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 4 <= n == pizzas.length <= 2 * 105
 * 1 <= pizzas[i] <= 105
 * n 是 4 的倍数。
 */
public class Code20 {

    public long maxWeight(int[] pizzas) {
        //排序
        Arrays.sort(pizzas);
        //结果
        long result = 0L;
        //索引
        int index = pizzas.length - 1;
        //增加的重量次数
        int count = pizzas.length / 4;
        //选择最大的数量、选择第二的数量
        int bigCount = count / 2 + count % 2;
        int secondCount = count - bigCount;
        //循环
        while (bigCount-- > 0) {
            //记录、-1
            result += pizzas[index--];
        }
        //循环
        while (secondCount-- > 0) {
            //记录、-2
            result += pizzas[--index];
            index--;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().maxWeight(new int[]{5, 2, 2, 4, 3, 3, 1, 3, 2, 5, 4, 2}));
    }

}
