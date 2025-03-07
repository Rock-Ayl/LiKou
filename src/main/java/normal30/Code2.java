package normal30;

/**
 * @Author ayl
 * @Date 2024-03-22
 * 457. 环形数组是否存在循环
 * 中等
 * 相关标签
 * 相关企业
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 * <p>
 * 如果 nums[i] 是正数，向前（下标递增方向）移动 |nums[i]| 步
 * 如果 nums[i] 是负数，向后（下标递减方向）移动 |nums[i]| 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 * <p>
 * 数组中的 循环 由长度为 k 的下标序列 seq 标识：
 * <p>
 * 遵循上述移动规则将导致一组重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,2]
 * 输出：false
 * 解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 * 示例 3:
 * <p>
 * 输入：nums = [-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
 * 所有 nums[seq[j]] 应当不是全正就是全负。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 * <p>
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(n) 且额外空间复杂度为 O(1) 的算法吗？
 */
public class Code2 {

    private boolean next(int[] nums, int p) {
        //已经走过的填充物
        int space = p + 10000;
        //判断是正数还是负数
        boolean dir = nums[0] > 0;
        //连击数
        int hit = 0;
        //循环
        while (true) {
            //如果是本次的循环
            if (nums[p] == space) {
                //返回结果
                return hit > 0;
            }
            //如果是别人走过的循环(无论正负,大于5000统一视为别人走过的)
            if (nums[p] > 5000) {
                //不行
                return false;
            }
            //如果是单个节点无线套娃
            if (nums[p] % nums.length == 0) {
                //不行
                return false;
            }
            //如果方向不同
            if (nums[p] > 0 != dir) {
                //过
                return false;
            }
            //叠加出下一步的位置
            int nextP = p + (nums[p] % nums.length);
            //已经走过了
            nums[p] = space;
            //如果越界1
            if (nextP >= nums.length) {
                //修正
                nextP -= nums.length;
            }
            //如果越界2
            if (nextP < 0) {
                //计算
                nextP += nums.length;
            }
            //下一个
            p = nextP;
            hit++;
        }
    }

    public boolean circularArrayLoop(int[] nums) {
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果可以
            if (next(nums, i)) {
                //可以
                return true;
            }
        }
        //默认
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
    }

}
