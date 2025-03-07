package easy30;

/**
 * @Author ayl
 * @Date 2023-04-18
 * 2639. 查询网格图中每一列的宽度
 * 给你一个下标从 0 开始的 m x n 整数矩阵 grid 。矩阵中某一列的宽度是这一列数字的最大 字符串长度 。
 * <p>
 * 比方说，如果 grid = [[-10], [3], [12]] ，那么唯一一列的宽度是 3 ，因为 -10 的字符串长度为 3 。
 * 请你返回一个大小为 n 的整数数组 ans ，其中 ans[i] 是第 i 列的宽度。
 * <p>
 * 一个有 len 个数位的整数 x ，如果是非负数，那么 字符串长度 为 len ，否则为 len + 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1],[22],[333]]
 * 输出：[3]
 * 解释：第 0 列中，333 字符串长度为 3 。
 * 示例 2：
 * <p>
 * 输入：grid = [[-15,1,3],[15,7,12],[5,6,-2]]
 * 输出：[3,1,2]
 * 解释：
 * 第 0 列中，只有 -15 字符串长度为 3 。
 * 第 1 列中，所有整数的字符串长度都是 1 。
 * 第 2 列中，12 和 -2 的字符串长度都为 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -109 <= grid[r][c] <= 109
 */
public class Code5 {

    public int[] findColumnWidth(int[][] grid) {
        //初始化结果
        int[] arr = new int[grid[0].length];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //最大长度
            int maxLength = 0;
            //循环2
            for (int[] ints : grid) {
                //当前数字
                int num = ints[i];
                //如果是0
                if (num == 0) {
                    //更新最大
                    maxLength = Math.max(maxLength, 1);
                    //本轮过
                    continue;
                }
                //当前长度
                int thisLength = 0;
                //如果是负数
                if (num < 0) {
                    //+1
                    thisLength++;
                    //转为正数
                    num = Math.abs(num);
                }
                //如果有
                while (num > 0) {
                    //+1
                    thisLength++;
                    //下一级
                    num = num / 10;
                }
                //更新最大
                maxLength = Math.max(maxLength, thisLength);
            }
            //记录结果
            arr[i] = maxLength;
        }
        //返回
        return arr;
    }

    public static void main(String[] args) {
        new Code5().findColumnWidth(new int[][]{
                new int[]{-15, 1, 3},
                new int[]{15, 7, 12},
                new int[]{5, 6, -2},
        });
    }
}
