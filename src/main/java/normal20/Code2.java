package normal20;

import java.util.Random;

/**
 * @Author ayl
 * @Date 2023-04-22
 * 剑指 Offer II 071. 按权重生成随机数
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 * <p>
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 * <p>
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * inputs = ["Solution","pickIndex"]
 * inputs = [[[1]],[]]
 * 输出：
 * [null,0]
 * 解释：
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
 * 示例 2：
 * <p>
 * 输入：
 * inputs = ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * inputs = [[[1,3]],[],[],[],[],[]]
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
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex 将被调用不超过 10000 次
 */
public class Code2 {

    //权重和
    private int sum;
    //缓存
    private int[] w;

    public Code2(int[] w) {
        //记录缓存
        this.w = w;
        //初始化权重和
        this.sum = 0;
        //循环
        for (int i = 0; i < this.w.length; i++) {
            //叠加和
            this.sum += this.w[i];
        }
    }

    public int pickIndex() {
        //随机一个数字
        int thisSum = new Random().nextInt(sum) + 1;
        //循环
        for (int i = 0; i < this.w.length; i++) {
            //减去当前
            thisSum -= this.w[i];
            //如果是目标
            if (thisSum < 0) {
                //返回
                return i;
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        Code2 code2 = new Code2(new int[]{1, 2, 3, 4, 5});
        code2.pickIndex();
        System.out.println();
    }

}
