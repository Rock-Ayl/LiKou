package easy35;

/**
 * @Author ayl
 * @Date 2023-11-29
 * 2946. 循环移位后的矩阵相似检查
 * 提示
 * 简单
 * 3
 * 相关企业
 * 给你一个下标从 0 开始且大小为 m x n 的整数矩阵 mat 和一个整数 k 。请你将矩阵中的 奇数 行循环 右 移 k 次，偶数 行循环 左 移 k 次。
 * <p>
 * 如果初始矩阵和最终矩阵完全相同，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2
 * 输出：true
 * 解释：
 * <p>
 * <p>
 * 初始矩阵如图一所示。
 * 图二表示对奇数行右移一次且对偶数行左移一次后的矩阵状态。
 * 图三是经过两次循环移位后的最终矩阵状态，与初始矩阵相同。
 * 因此，返回 true 。
 * 示例 2：
 * <p>
 * 输入：mat = [[2,2],[2,2]], k = 3
 * 输出：true
 * 解释：由于矩阵中的所有值都相等，即使进行循环移位，矩阵仍然保持不变。因此，返回 true 。
 * 示例 3：
 * <p>
 * 输入：mat = [[1,2]], k = 1
 * 输出：false
 * 解释：循环移位一次后，mat = [[2,1]]，与初始矩阵不相等。因此，返回 false 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= mat.length <= 25
 * 1 <= mat[i].length <= 25
 * 1 <= mat[i][j] <= 25
 * 1 <= k <= 50
 */
public class Code7 {

    public boolean areSimilar(int[][] mat, int k) {
        //删除一圈的
        k = k % mat[0].length;
        //如果正好一圈
        if (k == 0) {
            //肯定行
            return true;
        }
        //循环
        for (int[] arr : mat) {
            //循环2
            for (int i = 0; i < arr.length; i++) {
                //计算索引
                int index = i + k;
                //如果越界了
                if (index >= arr.length) {
                    //减去
                    index = index - arr.length;
                }
                //如果不同
                if (arr[index] != arr[i]) {
                    //不行
                    return false;
                }
            }
        }
        //默认可行
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().areSimilar(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 5, 5, 5},
                new int[]{6, 3, 6, 3}
        }, 14));
    }
}
