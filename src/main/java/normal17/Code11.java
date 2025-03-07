package normal17;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-11-26
 * 2352. 相等行列对
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * <p>
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 105
 */
public class Code11 {

    public int equalPairs(int[][] grid) {
        //行缓存
        Map<String, Integer> rowMap = new HashMap<>();
        //循环
        for (int[] ints : grid) {
            //初始化
            StringBuilder str = new StringBuilder();
            //循环2
            for (int anInt : ints) {
                //组装
                str.append(anInt);
                str.append(',');
            }
            //key
            String key = str.toString();
            //叠加
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }
        //结果
        int result = 0;
        //循环
        for (int i = 0; i < grid[0].length; i++) {
            //初始化
            StringBuilder str = new StringBuilder();
            //循环2
            for (int j = 0; j < grid.length; j++) {
                //组装
                str.append(grid[j][i]);
                str.append(',');
            }
            //根据行计算结果并叠加
            result += rowMap.getOrDefault(str.toString(), 0);
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().equalPairs(new int[][]{
                new int[]{3, 1, 2, 2},
                new int[]{1, 4, 4, 5},
                new int[]{2, 4, 2, 2},
                new int[]{2, 4, 2, 2}
        }));
    }

}
