package normal38;

/**
 * @Author ayl
 * @Date 2024-12-27
 * 1524. 和为奇数的子数组数目
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
 * <p>
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,3,5]
 * 输出：4
 * 解释：所有的子数组为 [[1],[1,3],[1,3,5],[3],[3,5],[5]] 。
 * 所有子数组的和为 [1,4,9,3,8,5].
 * 奇数和包括 [1,9,3,5] ，所以答案为 4 。
 * 示例 2 ：
 * <p>
 * 输入：arr = [2,4,6]
 * 输出：0
 * 解释：所有子数组为 [[2],[2,4],[2,4,6],[4],[4,6],[6]] 。
 * 所有子数组和为 [2,6,12,4,10,6] 。
 * 所有子数组和都是偶数，所以答案为 0 。
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,3,4,5,6,7]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：arr = [100,100,99,99]
 * 输出：4
 * 示例 5：
 * <p>
 * 输入：arr = [7]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 100
 */
public class Code22 {

    public int numOfSubarrays(int[] arr) {
        //缓存
        int[] sumArr = new int[arr.length];
        //第一个
        sumArr[0] = arr[0] % 2;
        //循环
        for (int i = 1; i < sumArr.length; i++) {
            //计算当前
            sumArr[i] = (sumArr[i - 1] + arr[i]) % 2;
        }
        //前方 0、1 的数量map
        int[] map = new int[2];
        //次数
        int result = 0;
        //循环
        for (int i = 0; i < sumArr.length; i++) {
            //当前数字,不是0就是1
            int num = sumArr[i];
            //求当前数字可以匹配的结果
            int count = (num + (sumArr[i] == 1 ? map[0] : map[1])) % 1000000007;
            //记录结果
            result = (result + count) % 1000000007;
            //记录缓存
            map[num]++;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

}
