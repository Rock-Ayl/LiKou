package normal40;

/**
 * @Author ayl
 * @Date 2025-02-13
 * 900. RLE 迭代器
 * 中等
 * 相关标签
 * 相关企业
 * 我们可以使用游程编码(即 RLE )来编码一个整数序列。在偶数长度 encoding ( 从 0 开始 )的游程编码数组中，对于所有偶数 i ，encoding[i] 告诉我们非负整数 encoding[i + 1] 在序列中重复的次数。
 * <p>
 * 例如，序列 arr = [8,8,8,5,5] 可以被编码为 encoding =[3,8,2,5] 。encoding =[3,8,0,9,2,5] 和 encoding =[2,8,1,8,2,5] 也是 arr 有效的 RLE 。
 * 给定一个游程长度的编码数组，设计一个迭代器来遍历它。
 * <p>
 * 实现 RLEIterator 类:
 * <p>
 * RLEIterator(int[] encoded) 用编码后的数组初始化对象。
 * int next(int n) 以这种方式耗尽后 n 个元素并返回最后一个耗尽的元素。如果没有剩余的元素要耗尽，则返回 -1 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["RLEIterator","next","next","next","next"]
 * [[[3,8,0,9,2,5]],[2],[1],[1],[2]]
 * 输出：
 * [null,8,8,5,-1]
 * 解释：
 * RLEIterator rLEIterator = new RLEIterator([3, 8, 0, 9, 2, 5]); // 这映射到序列 [8,8,8,5,5]。
 * rLEIterator.next(2); // 耗去序列的 2 个项，返回 8。现在剩下的序列是 [8, 5, 5]。
 * rLEIterator.next(1); // 耗去序列的 1 个项，返回 8。现在剩下的序列是 [5, 5]。
 * rLEIterator.next(1); // 耗去序列的 1 个项，返回 5。现在剩下的序列是 [5]。
 * rLEIterator.next(2); // 耗去序列的 2 个项，返回 -1。 这是由于第一个被耗去的项是 5，
 * 但第二个项并不存在。由于最后一个要耗去的项不存在，我们返回 -1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= encoding.length <= 1000
 * encoding.length 为偶
 * 0 <= encoding[i] <= 109
 * 1 <= n <= 109
 * 每个测试用例调用next 不高于 1000 次
 */
public class Code4 {

    public Code4(int[] encoding) {
        this.encoding = encoding;
        this.index = 0;
    }

    //缓存
    private int[] encoding;
    //索引
    private int index;

    public int next(int n) {
        //循环
        while (this.index < this.encoding.length && n > 0) {
            //如果不够扣
            if (this.encoding[this.index] < n) {
                //完全扣减
                n -= this.encoding[this.index];
                //进位
                this.index += 2;
                //本轮过
                continue;
            }
            //如果正好
            else if (this.encoding[this.index] == n) {
                //进位
                this.index += 2;
                //返回结果
                return this.encoding[this.index - 1];
            }
            //如果太够扣了
            else {
                //扣减
                this.encoding[this.index] -= n;
                //返回结果
                return this.encoding[this.index + 1];
            }
        }
        //默认
        return -1;
    }

}
