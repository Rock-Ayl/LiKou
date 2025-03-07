package normal38;

/**
 * @Author ayl
 * @Date 2024-12-05
 * 2672. 有相同颜色的相邻元素数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、长度为 n 的数组 nums 。一开始，所有元素都是 未染色 （值为 0 ）的。
 * <p>
 * 给你一个二维整数数组 queries ，其中 queries[i] = [indexi, colori] 。
 * <p>
 * 对于每个操作，你需要将数组 nums 中下标为 indexi 的格子染色为 colori 。
 * <p>
 * 请你返回一个长度与 queries 相等的数组 answer ，其中 answer[i]是前 i 个操作 之后 ，相邻元素颜色相同的数目。
 * <p>
 * 更正式的，answer[i] 是执行完前 i 个操作后，0 <= j < n - 1 的下标 j 中，满足 nums[j] == nums[j + 1] 且 nums[j] != 0 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, queries = [[0,2],[1,2],[3,1],[1,1],[2,1]]
 * 输出：[0,1,1,0,2]
 * 解释：一开始数组 nums = [0,0,0,0] ，0 表示数组中还没染色的元素。
 * - 第 1 个操作后，nums = [2,0,0,0] 。相邻元素颜色相同的数目为 0 。
 * - 第 2 个操作后，nums = [2,2,0,0] 。相邻元素颜色相同的数目为 1 。
 * - 第 3 个操作后，nums = [2,2,0,1] 。相邻元素颜色相同的数目为 1 。
 * - 第 4 个操作后，nums = [2,1,0,1] 。相邻元素颜色相同的数目为 0 。
 * - 第 5 个操作后，nums = [2,1,1,1] 。相邻元素颜色相同的数目为 2 。
 * 示例 2：
 * <p>
 * 输入：n = 1, queries = [[0,100000]]
 * 输出：[0]
 * 解释：一开始数组 nums = [0] ，0 表示数组中还没染色的元素。
 * - 第 1 个操作后，nums = [100000] 。相邻元素颜色相同的数目为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= indexi <= n - 1
 * 1 <=  colori <= 105
 */
public class Code9 {

    public int[] colorTheArray(int n, int[][] queries) {
        //结果
        int[] result = new int[queries.length];
        //颜色缓存
        int[] colorArr = new int[n];
        //相同的数量
        int same = 0;
        //循环
        for (int i = 0; i < queries.length; i++) {
            //被修改的索引
            int index = queries[i][0];
            //如果左边相同,删除一次
            same -= colorArr[index] != 0 && index > 0 && colorArr[index] == colorArr[index - 1] ? 1 : 0;
            //如果右边相同,删除一次
            same -= colorArr[index] != 0 && index + 1 < colorArr.length && colorArr[index] == colorArr[index + 1] ? 1 : 0;
            //更新颜色
            colorArr[index] = queries[i][1];
            //如果左边相同,增加一次
            same += index > 0 && colorArr[index] == colorArr[index - 1] ? 1 : 0;
            //如果右边相同,增加一次
            same += index + 1 < colorArr.length && colorArr[index] == colorArr[index + 1] ? 1 : 0;
            //记录本次结果
            result[i] = same;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code9().colorTheArray(4, new int[][]{
                new int[]{0, 2},
                new int[]{1, 2},
                new int[]{3, 1},
                new int[]{1, 1},
                new int[]{2, 1}
        });
        System.out.println();
    }

}
