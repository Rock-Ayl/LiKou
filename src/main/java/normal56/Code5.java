package normal56;

/**
 * 2310. 个位数字为 K 的整数之和
 * 算术评级: 5
 * 第 298 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1559
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数 num 和 k ，考虑具有以下属性的正整数多重集：
 * <p>
 * 每个整数个位数字都是 k 。
 * 所有整数之和是 num 。
 * 返回该多重集的最小大小，如果不存在这样的多重集，返回 -1 。
 * <p>
 * 注意：
 * <p>
 * 多重集与集合类似，但多重集可以包含多个同一整数，空多重集的和为 0 。
 * 个位数字 是数字最右边的数位。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 58, k = 9
 * 输出：2
 * 解释：
 * 多重集 [9,49] 满足题目条件，和为 58 且每个整数的个位数字是 9 。
 * 另一个满足条件的多重集是 [19,39] 。
 * 可以证明 2 是满足题目条件的多重集的最小长度。
 * 示例 2：
 * <p>
 * 输入：num = 37, k = 2
 * 输出：-1
 * 解释：个位数字为 2 的整数无法相加得到 37 。
 * 示例 3：
 * <p>
 * 输入：num = 0, k = 7
 * 输出：0
 * 解释：空多重集的和为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num <= 3000
 * 0 <= k <= 9
 *
 */
public class Code5 {

    public int minimumNumbers(int num, int k) {
        //特殊
        if (num == 0) {
            //过
            return 0;
        }
        //特殊
        if (k == 0) {
            //判断
            return num % 10 == 0 ? 1 : -1;
        }
        //结果
        int count = 1;
        //目标
        int hit = k;
        //如果还可以继续
        while (num >= hit) {
            //如果满足
            if ((num - hit) % 10 == 0) {
                //返回
                return count;
            }
            //下一个
            count++;
            hit += k;
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().minimumNumbers(37, 2));
    }

}
