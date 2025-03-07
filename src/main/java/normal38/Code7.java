package normal38;

/**
 * @Author ayl
 * @Date 2024-12-03
 * 3355. 零数组变换 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri]。
 * <p>
 * 对于每个查询 queries[i]：
 * <p>
 * 在 nums 的下标范围 [li, ri] 内选择一个下标
 * 子集
 * 。
 * 将选中的每个下标对应的元素值减 1。
 * 零数组 是指所有元素都等于 0 的数组。
 * <p>
 * 如果在按顺序处理所有查询后，可以将 nums 转换为 零数组 ，则返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,0,1], queries = [[0,2]]
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 对于 i = 0：
 * 选择下标子集 [0, 2] 并将这些下标处的值减 1。
 * 数组将变为 [0, 0, 0]，这是一个零数组。
 * 示例 2：
 * <p>
 * 输入： nums = [4,3,2,1], queries = [[1,3],[0,2]]
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 对于 i = 0：
 * 选择下标子集 [1, 2, 3] 并将这些下标处的值减 1。
 * 数组将变为 [4, 2, 1, 0]。
 * 对于 i = 1：
 * 选择下标子集 [0, 1, 2] 并将这些下标处的值减 1。
 * 数组将变为 [3, 1, 0, 0]，这不是一个零数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= li <= ri < nums.length
 */
public class Code7 {

    public boolean isZeroArray(int[] nums, int[][] queries) {
        //缓存数组
        int[] arr = new int[nums.length + 1];
        //循环
        for (int[] query : queries) {
            //计算
            arr[query[0]]++;
            arr[query[1] + 1]--;
        }
        //默认数字
        int other = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //先增加当前的
            other += arr[i];
            //如果不够
            if (other < nums[i]) {
                //不可以
                return false;
            }
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().isZeroArray(new int[]{4, 3, 2, 1}, new int[][]{
                new int[]{1, 3},
                new int[]{0, 2}
        }));
    }

}
