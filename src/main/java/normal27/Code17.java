package normal27;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-01-09
 * <p>
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 2661. 找出叠涂元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。
 * <p>
 * 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
 * <p>
 * 请你找出 arr 中第一个使得 mat 的某一行或某一列都被涂色的元素，并返回其下标 i 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * image explanation for example 1
 * 输入：arr = [1,3,4,2], mat = [[1,4],[2,3]]
 * 输出：2
 * 解释：遍历如上图所示，arr[2] 在矩阵中的第一行或第二列上都被涂色。
 * 示例 2：
 * <p>
 * image explanation for example 2
 * 输入：arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
 * 输出：3
 * 解释：遍历如上图所示，arr[3] 在矩阵中的第二列上都被涂色。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n = mat[i].length
 * arr.length == m * n
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 1 <= arr[i], mat[r][c] <= m * n
 * arr 中的所有整数 互不相同
 * mat 中的所有整数 互不相同
 */
public class Code17 {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        //坐标缓存2
        Map<Integer, int[]> map = new HashMap<>();
        //循环1
        for (int i = 0; i < mat.length; i++) {
            //循环2
            for (int j = 0; j < mat[0].length; j++) {
                //记录缓存
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        //缓存1,2
        int[] xArr = new int[mat.length];
        int[] yArr = new int[mat[0].length];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前数字的对应坐标
            int[] indexArr = map.get(arr[i]);
            //记录并判断
            if (++xArr[indexArr[0]] == mat[0].length || ++yArr[indexArr[1]] == mat.length) {
                //是
                return i;
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().firstCompleteIndex(new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9}, new int[][]{
                new int[]{3, 2, 5},
                new int[]{1, 4, 6},
                new int[]{8, 7, 9}
        }));
    }

}
