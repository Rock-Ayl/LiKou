package normal18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-12-24
 * 378. 有序矩阵中第 K 小的元素
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * <p>
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 示例 2：
 * <p>
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 <= k <= n2
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题?
 * 你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。
 */
public class Code4 {

    public int kthSmallest(int[][] matrix, int k) {
        //缓存
        List<Integer> list = new ArrayList<>();
        //循环
        for (int[] ints : matrix) {
            //循环
            for (int anInt : ints) {
                //记录
                list.add(anInt);
            }
        }
        //排序
        Collections.sort(list);
        //返回结果
        return list.get(k - 1);
    }
}
