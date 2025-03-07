package normal30;

/**
 * @Author ayl
 * @Date 2024-04-01
 * 2400. 恰好移动 k 步到达某一位置的方法数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个 正 整数 startPos 和 endPos 。最初，你站在 无限 数轴上位置 startPos 处。在一步移动中，你可以向左或者向右移动一个位置。
 * <p>
 * 给你一个正整数 k ，返回从 startPos 出发、恰好 移动 k 步并到达 endPos 的 不同 方法数目。由于答案可能会很大，返回对 109 + 7 取余 的结果。
 * <p>
 * 如果所执行移动的顺序不完全相同，则认为两种方法不同。
 * <p>
 * 注意：数轴包含负整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：startPos = 1, endPos = 2, k = 3
 * 输出：3
 * 解释：存在 3 种从 1 到 2 且恰好移动 3 步的方法：
 * - 1 -> 2 -> 3 -> 2.
 * - 1 -> 2 -> 1 -> 2.
 * - 1 -> 0 -> 1 -> 2.
 * 可以证明不存在其他方法，所以返回 3 。
 * 示例 2：
 * <p>
 * 输入：startPos = 2, endPos = 5, k = 10
 * 输出：0
 * 解释：不存在从 2 到 5 且恰好移动 10 步的方法。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= startPos, endPos, k <= 1000
 */
public class Code9 {

    //获取
    private int get(int[] arr, int p) {
        //如果越界
        if (p < 0 || p >= arr.length) {
            //过
            return 0;
        }
        //返回
        return arr[p];
    }

    //计算本次移动
    private void count(int[] arr, int[] lastArr) {
        //循环
        for (int i = 0; i < arr.length; i++) {
            //叠加
            arr[i] += (get(lastArr, i - 1) + get(lastArr, i + 1)) % 1000000007L;
        }
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        //如果不够步数
        if (startPos + k < endPos) {
            //过
            return 0;
        }
        //所有情况统计
        int[][] arr = new int[k + 1][k * 2 + 1];
        //开始节点算1个
        arr[0][k] = 1;
        //循环
        for (int i = 1; i < arr.length; i++) {
            //计算本次移动
            count(arr[i], arr[i - 1]);
        }
        //返回
        return arr[arr.length - 1][k + (endPos - startPos)];
    }

    public static void main(String[] args) {
        System.out.println(new Code9().numberOfWays(1, 10, 3));
    }

}
