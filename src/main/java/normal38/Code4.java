package normal38;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-11-30
 * 测试结果
 * 2202. K 次操作后最大化顶端元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums ，它表示一个 堆 ，其中 nums[0] 是堆顶的元素。
 * <p>
 * 每一次操作中，你可以执行以下操作 之一 ：
 * <p>
 * 如果堆非空，那么 删除 堆顶端的元素。
 * 如果存在 1 个或者多个被删除的元素，你可以从它们中选择任何一个，添加 回堆顶，这个元素成为新的堆顶元素。
 * 同时给你一个整数 k ，它表示你总共需要执行操作的次数。
 * <p>
 * 请你返回 恰好 执行 k 次操作以后，堆顶元素的 最大值 。如果执行完 k 次操作以后，堆一定为空，请你返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,2,4,0,6], k = 4
 * 输出：5
 * 解释：
 * 4 次操作后，堆顶元素为 5 的方法之一为：
 * - 第 1 次操作：删除堆顶元素 5 ，堆变为 [2,2,4,0,6] 。
 * - 第 2 次操作：删除堆顶元素 2 ，堆变为 [2,4,0,6] 。
 * - 第 3 次操作：删除堆顶元素 2 ，堆变为 [4,0,6] 。
 * - 第 4 次操作：将 5 添加回堆顶，堆变为 [5,4,0,6] 。
 * 注意，这不是最后堆顶元素为 5 的唯一方式。但可以证明，4 次操作以后 5 是能得到的最大堆顶元素。
 * 示例 2：
 * <p>
 * 输入：nums = [2], k = 1
 * 输出：-1
 * 解释：
 * 第 1 次操作中，我们唯一的选择是将堆顶元素弹出堆。
 * 由于 1 次操作后无法得到一个非空的堆，所以我们返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i], k <= 109
 */
public class Code4 {

    public int maximumTop(int[] nums, int k) {
        //如果没有
        if (k == 0) {
            //返回
            return nums[0];
        }
        //如果是特殊情况
        if (nums.length == 1) {
            //如果是奇数
            if (k % 2 != 0) {
                //不可能
                return -1;
            }
        }
        //如果是1
        if (k == 1) {
            //直接返回
            return nums[1];
        }
        //如果相同
        if (k == nums.length) {
            //返回最大值即可
            return Arrays.stream(nums).limit(k - 1).max().getAsInt();
        }
        //如果需要一部分
        if (k < nums.length) {
            //返回最大值即可
            return Math.max(Arrays.stream(nums).limit(k - 1).max().getAsInt(), nums[k]);
        }
        //返回最大值即可
        return Arrays.stream(nums).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new Code4().maximumTop(new int[]{0, 1, 2}, 3));
        ;
    }

}
