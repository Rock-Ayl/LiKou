package normal19;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ayl
 * @Date 2023-03-27
 * 528. 按权重随机选择
 * 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
 * <p>
 * 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
 * <p>
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * 输出：
 * [null,0]
 * 解释：
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
 * 示例 2：
 * <p>
 * 输入：
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * 输出：
 * [null,1,1,1,1,0]
 * 解释：
 * Solution solution = new Solution([1, 3]);
 * solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
 * <p>
 * 由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
 * [null,1,1,1,1,0]
 * [null,1,1,1,1,1]
 * [null,1,1,1,0,0]
 * [null,1,1,1,0,1]
 * [null,1,0,1,0,0]
 * ......
 * 诸若此类。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= w.length <= 104
 * 1 <= w[i] <= 105
 * pickIndex 将被调用不超过 104 次
 */
public class Code18 {

    //缓存
    private int[] w;
    //所有权重
    private int weight;

    public Code18(int[] w) {
        this.w = w;
        //记录权重和
        this.weight = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        //随机一个当前权重
        int thisWeight = new Random().nextInt(this.weight);
        //循环
        for (int i = 0; i < this.w.length; i++) {
            //减去当前权重
            thisWeight -= this.w[i];
            //如果权重是负数,说明就是目标
            if (thisWeight < 0) {
                //返回命中目标
                return i;
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        Code18 code18 = new Code18(new int[]{1, 3});
        for (int i = 0; i < 100; i++) {
            System.out.println(code18.pickIndex());
        }
    }

}
