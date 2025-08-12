package difficult3;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-08-12
 * 1269. 停在原地的方案数
 * 算术评级: 6
 * 第 164 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1854
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * <p>
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * <p>
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * <p>
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * 示例  2：
 * <p>
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * 示例 3：
 * <p>
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= steps <= 500
 * 1 <= arrLen <= 106
 */
public class Code14 {

    public int numWays(int steps, int arrLen) {
        //动态规划
        int[] arr = new int[arrLen];
        int[] nextArr = new int[arrLen];
        //开始位置
        arr[0] = 1;
        //指针
        int index = 1;
        //循环
        while (index++ <= steps) {
            //填充
            Arrays.fill(nextArr, 0);
            //循环2
            for (int j = 0; j < arr.length; j++) {
                //当前数量
                int count = arr[j];
                //如果没有
                if (count < 1) {
                    //本轮过
                    continue;
                }
                //如果可以左移动
                if (j > 0) {
                    //叠加
                    nextArr[j - 1] = (nextArr[j - 1] + count) % 1000000007;
                }
                //叠加中间
                nextArr[j] = (nextArr[j] + count) % 1000000007;
                //如果可以右移动
                if (j + 1 < nextArr.length) {
                    //叠加
                    nextArr[j + 1] = (nextArr[j + 1] + count) % 1000000007;
                }
            }
            //替换
            arr = nextArr.clone();
        }
        //返回
        return arr[0];
    }

    public static void main(String[] args) {
        System.out.println(new Code14().numWays(27, 7));
    }

}
