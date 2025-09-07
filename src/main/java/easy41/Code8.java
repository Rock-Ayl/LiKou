package easy41;

/**
 * @Author ayl
 * @Date 2025-09-07
 * 3668. 重排完成顺序
 * 算术评级: 2
 * 第 465 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1255
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 order 和一个整数数组 friends。
 * <p>
 * order 包含从 1 到 n 的每个整数，且 恰好出现一次 ，表示比赛中参赛者按照 完成顺序 的 ID。
 * friends 包含你朋友们的 ID，按照 严格递增 的顺序排列。friends 中的每个 ID 都保证出现在 order 数组中。
 * 请返回一个数组，包含你朋友们的 ID，按照他们的 完成顺序 排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：order = [3,1,2,5,4], friends = [1,3,4]
 * <p>
 * 输出：[3,1,4]
 * <p>
 * 解释：
 * <p>
 * 完成顺序是 [3, 1, 2, 5, 4]。因此，你朋友的完成顺序是 [3, 1, 4]。
 * <p>
 * 示例 2：
 * <p>
 * 输入：order = [1,4,5,3,2], friends = [2,5]
 * <p>
 * 输出：[5,2]
 * <p>
 * 解释：
 * <p>
 * 完成顺序是 [1, 4, 5, 3, 2]。因此，你朋友的完成顺序是 [5, 2]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == order.length <= 100
 * order 包含从 1 到 n 的每个整数，且恰好出现一次
 * 1 <= friends.length <= min(8, n)
 * 1 <= friends[i] <= n
 * friends 是严格递增的
 */
public class Code8 {

    public int[] recoverOrder(int[] order, int[] friends) {
        //是否存在缓存
        int[] arr = new int[order.length + 1];
        //循环
        for (int friend : friends) {
            //+1
            arr[friend]++;
        }
        //结果
        int[] result = new int[friends.length];
        //索引
        int index = 0;
        //循环
        for (int i = 0; i < order.length; i++) {
            //如果存在
            if (arr[order[i]] > 0) {
                //使用,并+1
                result[index++] = order[i];
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        new Code8().recoverOrder(new int[]{3, 1, 2, 5, 4}, new int[]{1, 3, 4});
    }

}
