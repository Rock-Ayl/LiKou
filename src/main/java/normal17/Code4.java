package normal17;

/**
 * @Author ayl
 * @Date 2022-11-06
 * 1658. 将 x 减到 0 的最小操作数
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 */
public class Code4 {

    public int minOperations(int[] nums, int x) {

        /**
         * 先判空
         */

        //如果太小
        if (nums.length < 1) {
            //默认
            return -1;
        }

        /**
         * 先从左边数到头,找到左边最多减到娜
         */

        //左边最后一个值坐标
        int left = -1;
        //当前和
        int sum = 0;
        //如果小于目标
        while (sum < x) {
            //如果越界了
            if (++left == nums.length) {
                //不可能有
                return -1;
            }
            //当前值
            int leftNum = nums[left];
            //计算出新的和
            int nextSum = sum + leftNum;
            //如果大于目标
            if (nextSum > x) {
                //回滚回滚坐标
                left--;
                //跳出
                break;
            }
            //记录这个和
            sum = nextSum;
        }

        /**
         * 初始化结果
         */

        //初始化最小的结果
        int minCount;
        //如果本次正好是目标
        if (sum == x) {
            //记录这个可能的结果
            minCount = left + 1;
        } else {
            //给个默认值
            minCount = Integer.MAX_VALUE;
        }

        /**
         * 不断削减左边,叠加右边,滑动窗口
         */

        //右边坐标
        int right = nums.length;
        //跳出标记
        out:
        //如果左边还没结束,循环
        while (left >= 0) {
            //如果小于目标
            while (sum <= x) {
                //如果到头了
                if (--right < 0) {
                    //彻底跳出
                    break out;
                }
                //叠加
                sum += nums[right];
            }
            //后退一位
            sum -= nums[right++];
            //如果是目标
            if (sum == x) {
                //计算出本次目标值
                int count = (left + 1) + (nums.length - right);
                //尝试刷新
                minCount = Math.min(minCount, count);
            }
            //左边移动
            sum -= nums[left--];
        }
        //如果左右都没有
        if (left == -1 && right == nums.length) {
            //如果左右1这种特殊情况
            if (nums[nums.length - 1] == x || nums[0] == x) {
                //否则
                return 1;
            }
            //如果小于目标
            while (sum < x) {
                //如果到头了
                if (--right < 0) {
                    //彻底跳出
                    break;
                }
                //叠加
                sum += nums[right];
            }
            //如果是
            if (sum == x) {
                //返回结果
                return nums.length - right;
            }
            //否则
            return minCount < Integer.MAX_VALUE ? minCount : -1;
        }
        //如果单独右边是特殊情况
        if (sum + nums[--right] == x) {
            //返回结果
            return Math.min(minCount, nums.length - right);
        } else {
            //返回结果
            return minCount < Integer.MAX_VALUE ? minCount : -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code4().minOperations(new int[]{1, 1, 3, 2, 5}, 5));
    }

}
