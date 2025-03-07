package normal36;

/**
 * @Author ayl
 * @Date 2024-10-12
 * 2216. 美化数组的最少删除数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums ，如果满足下述条件，则认为数组 nums 是一个 美丽数组 ：
 * <p>
 * nums.length 为偶数
 * 对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立
 * 注意，空数组同样认为是美丽数组。
 * <p>
 * 你可以从 nums 中删除任意数量的元素。当你删除一个元素时，被删除元素右侧的所有元素将会向左移动一个单位以填补空缺，而左侧的元素将会保持 不变 。
 * <p>
 * 返回使 nums 变为美丽数组所需删除的 最少 元素数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,3,5]
 * 输出：1
 * 解释：可以删除 nums[0] 或 nums[1] ，这样得到的 nums = [1,2,3,5] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至少需要删除 1 个元素。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,2,3,3]
 * 输出：2
 * 解释：可以删除 nums[0] 和 nums[5] ，这样得到的 nums = [1,2,2,3] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至少需要删除 2 个元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class Code3 {

    public int minDeletion(int[] nums) {
        //删除次数
        int count = 0;
        //循环
        for (int i = 0; i < nums.length - 1; i++) {
            //如果是指定下标 and 不满条件
            if ((i - count) % 2 == 0 && nums[i] == nums[i + 1]) {
                //删除+1
                count++;
            }
        }
        //返回,如果删除完是奇数,则额外删除一个
        return count + ((nums.length - count) % 2 == 0 ? 0 : 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code3().minDeletion(new int[]{1, 1, 2, 2, 3, 3}));
    }

}
