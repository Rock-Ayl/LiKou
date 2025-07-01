package normal44;

/**
 * @Author ayl
 * @Date 2025-07-01
 * 1310. 子数组异或查询
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 * <p>
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 * <p>
 * 并返回一个包含给定查询 queries 所有结果的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 * 示例 2：
 * <p>
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 10^9
 * 1 <= queries.length <= 3 * 10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] < arr.length
 */
public class Code13 {

    public int[] xorQueries(int[] arr, int[][] queries) {

        /**
         * 异或 前缀和
         */

        //缓存
        int[] sumArr = new int[arr.length];
        //第一个
        sumArr[0] = arr[0];
        //循环
        for (int i = 1; i < arr.length; i++) {
            //计算当前
            sumArr[i] = sumArr[i - 1] ^ arr[i];
        }

        /**
         * 计算
         */

        //结果
        int[] result = new int[queries.length];
        //循环
        for (int i = 0; i < queries.length; i++) {
            //本次
            int[] query = queries[i];
            //计算结果
            result[i] = count(sumArr, query[0], query[1]);
        }
        //返回
        return result;
    }

    //计算结果
    private int count(int[] sumArr, int start, int end) {
        //右边
        int right = sumArr[end];
        //如果没左边
        if (start == 0) {
            //直接返回
            return right;
        }
        //返回
        return right ^ sumArr[start - 1];
    }

    public static void main(String[] args) {

        int[] ints = new Code13().xorQueries(new int[]{1, 3, 4, 8}, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{0, 3},
                new int[]{3, 3}
        });
        System.out.println();
    }

}
