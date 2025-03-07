package easy27;

/**
 * @Author ayl
 * @Date 2023-02-07
 * 598. 范围求和 II
 * 给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
 * <p>
 * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: m = 3, n = 3，ops = [[2,2],[3,3]]
 * 输出: 4
 * 解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * 示例 2:
 * <p>
 * 输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: m = 3, n = 3, ops = []
 * 输出: 9
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= m, n <= 4 * 104
 * 0 <= ops.length <= 104
 * ops[i].length == 2
 * 1 <= ai <= m
 * 1 <= bi <= n
 */
public class Code18 {

    //思路:只需要取每次都++的情况即可,也就是判断边界
    public int maxCount(int m, int n, int[][] ops) {
        //如果太小
        if (ops.length < 1) {
            //过
            return m * n;
        }
        int minX = ops[0][0];
        int minY = ops[0][1];
        //循环
        for (int i = 1; i < ops.length; i++) {
            //刷新最小值
            minX = Math.min(minX, ops[i][0]);
            minY = Math.min(minY, ops[i][1]);
        }
        //计算结果
        return minX * minY;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().maxCount(3, 3, new int[][]{
                new int[]{2, 2},
                new int[]{3, 3}
        }));
    }

}
