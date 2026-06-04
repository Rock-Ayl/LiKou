package easy43;

/**
 * 3940. 限制有序数组中的元素出现次数
 * 算术评级: 2
 * 第 503 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1202
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 按升序排序 的整数数组 nums 和一个整数 k。
 * <p>
 * 返回一个数组，使得每个 不同 元素最多出现 k 次，同时保持 nums 中元素的相对顺序不变。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,1,1,2,2,3], k = 2
 * <p>
 * 输出： [1,1,2,2,3]
 * <p>
 * 解释：
 * <p>
 * 每个元素最多可以出现 2 次。
 * <p>
 * 元素 1 出现了 3 次，因此只保留其中 2 次。
 * 元素 2 出现了 2 次，因此全部保留。
 * 元素 3 出现了 1 次，因此保留。
 * 因此，结果数组为 [1, 1, 2, 2, 3]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,3], k = 1
 * <p>
 * 输出： [1,2,3]
 * <p>
 * 解释：
 * <p>
 * 所有元素都互不相同，且已经最多只出现一次，因此数组保持不变。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * nums 按非递减顺序排序。
 * 1 <= k <= nums.length
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能使用原地算法，并仅使用 O(1) 额外空间解决该问题吗？
 * 注意：用于返回结果或调整结果大小所占用的空间不计入上述空间复杂度，因为有些语言不支持原地调整数组大小。
 */
public class Code14 {

    /**
     * 2026-6-5 日 不得不提前做
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] limitOccurrences(int[] nums, int k) {
        //双指针
        int left = 1;
        int right = 1;
        //总数
        int allCount = 1;
        //当前数字
        int num = nums[0];
        //次数
        int numCount = 1;
        //循环
        while (right < nums.length) {
            //如果数字相同 and 还可以继续递增
            if (nums[right] == num && numCount < k) {
                //+1
                numCount++;
                //记录,二者+1
                nums[left++] = nums[right++];
                //+1总数
                allCount++;
                //本轮过
                continue;
            }
            //如果数字相同
            if (nums[right] == num) {
                //+1
                right++;
            } else {
                //下一个数字
                numCount = 1;
                num = nums[right];
                //记录,二者+1
                nums[left++] = nums[right++];
                //+1总数
                allCount++;
            }
        }
        //初始化数组
        int[] result = new int[allCount];
        //写入
        System.arraycopy(nums, 0, result, 0, allCount);
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code14().limitOccurrences(new int[]{1, 1, 1, 2, 2, 3}, 1);
    }

}
