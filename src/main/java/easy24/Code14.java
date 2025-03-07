package easy24;

/**
 * @Author ayl
 * @Date 2022-11-07
 * 2460. 对数组执行操作
 * 给你一个下标从 0 开始的数组 nums ，数组大小为 n ，且由 非负 整数组成。
 * <p>
 * 你需要对数组执行 n - 1 步操作，其中第 i 步操作（从 0 开始计数）要求对 nums 中第 i 个元素执行下述指令：
 * <p>
 * 如果 nums[i] == nums[i + 1] ，则 nums[i] 的值变成原来的 2 倍，nums[i + 1] 的值变成 0 。否则，跳过这步操作。
 * 在执行完 全部 操作后，将所有 0 移动 到数组的 末尾 。
 * <p>
 * 例如，数组 [1,0,2,0,0,1] 将所有 0 移动到末尾后变为 [1,2,1,0,0,0] 。
 * 返回结果数组。
 * <p>
 * 注意 操作应当 依次有序 执行，而不是一次性全部执行。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,1,1,0]
 * 输出：[1,4,2,0,0,0]
 * 解释：执行以下操作：
 * - i = 0: nums[0] 和 nums[1] 不相等，跳过这步操作。
 * - i = 1: nums[1] 和 nums[2] 相等，nums[1] 的值变成原来的 2 倍，nums[2] 的值变成 0 。数组变成 [1,4,0,1,1,0] 。
 * - i = 2: nums[2] 和 nums[3] 不相等，所以跳过这步操作。
 * - i = 3: nums[3] 和 nums[4] 相等，nums[3] 的值变成原来的 2 倍，nums[4] 的值变成 0 。数组变成 [1,4,0,2,0,0] 。
 * - i = 4: nums[4] 和 nums[5] 相等，nums[4] 的值变成原来的 2 倍，nums[5] 的值变成 0 。数组变成 [1,4,0,2,0,0] 。
 * 执行完所有操作后，将 0 全部移动到数组末尾，得到结果数组 [1,4,2,0,0,0] 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * 解释：无法执行任何操作，只需要将 0 移动到末尾。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2000
 * 0 <= nums[i] <= 1000
 */
public class Code14 {

    public int[] applyOperations(int[] nums) {
        //非0数字指针
        int p = 0;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前和上一个
            int num = nums[i];
            int last = nums[i - 1];
            //如果不相等
            if (num != last) {
                //如果大于0
                if (last > 0) {
                    //记录
                    nums[p++] = last;
                }
                //如果是最后一个,并且当前也不是0
                if (i + 1 == nums.length && num != 0) {
                    //最后一位补上
                    nums[p++] = num;
                }
                //跳过本次
                continue;
            }
            //该字段为0
            nums[i] = 0;
            //上一个翻倍
            int lastTwo = last * 2;
            //如果不是0
            if (lastTwo > 0) {
                //记录
                nums[p++] = lastTwo;
            }
        }
        //循环
        while (p < nums.length) {
            //设置为0
            nums[p++] = 0;
        }
        //返回
        return nums;
    }

    public static void main(String[] args) {
        new Code14().applyOperations(new int[]{0, 1});
    }

}
