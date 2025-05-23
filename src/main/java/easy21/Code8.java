package easy21;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-07-19
 * 1337. 矩阵中战斗力最弱的 K 行
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * <p>
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * <p>
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * <p>
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * 示例 2：
 * <p>
 * 输入：mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 */
public class Code8 {

    public int[] kWeakestRows(int[][] mat, int k) {
        //初始化结果列表
        int[] arr = new int[mat.length];
        //循环
        for (int i = 0; i < mat.length; i++) {
            //当前和,并记录
            arr[i] = Arrays.stream(mat[i]).sum();
        }
        //指针
        int p = 0;
        //初始化
        int[] link = new int[mat.length];
        //循环
        while (p < link.length) {
            //记录
            link[p] = p;
            //进位
            p++;
        }
        //排序
        List<Integer> list = Arrays.stream(link).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return arr[o1] - arr[o2];
            }
        }).collect(Collectors.toList());
        //初始化结果
        int[] result = new int[k];
        //循环
        for (int i = 0; i < result.length; i++) {
            //结果
            result[i] = list.get(i);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code8().kWeakestRows(new int[][]{
                new int[]{1, 1, 0, 0, 0},
                new int[]{1, 1, 1, 1, 0},
                new int[]{1, 0, 0, 0, 0},
                new int[]{1, 1, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1}
        }, 3);
    }

}
