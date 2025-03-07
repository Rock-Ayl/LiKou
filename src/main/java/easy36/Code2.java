package easy36;

/**
 * @Author ayl
 * @Date 2024-02-09
 * 3028. 边界上的蚂蚁
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 边界上有一只蚂蚁，它有时向 左 走，有时向 右 走。
 * <p>
 * 给你一个 非零 整数数组 nums 。蚂蚁会按顺序读取 nums 中的元素，从第一个元素开始直到结束。每一步，蚂蚁会根据当前元素的值移动：
 * <p>
 * 如果 nums[i] < 0 ，向 左 移动 -nums[i]单位。
 * 如果 nums[i] > 0 ，向 右 移动 nums[i]单位。
 * 返回蚂蚁 返回 到边界上的次数。
 * <p>
 * 注意：
 * <p>
 * 边界两侧有无限的空间。
 * 只有在蚂蚁移动了 |nums[i]| 单位后才检查它是否位于边界上。换句话说，如果蚂蚁只是在移动过程中穿过了边界，则不会计算在内。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,-5]
 * 输出：1
 * 解释：第 1 步后，蚂蚁距边界右侧 2 单位远。
 * 第 2 步后，蚂蚁距边界右侧 5 单位远。
 * 第 3 步后，蚂蚁位于边界上。
 * 所以答案是 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,-3,-4]
 * 输出：0
 * 解释：第 1 步后，蚂蚁距边界右侧 3 单位远。
 * 第 2 步后，蚂蚁距边界右侧 5 单位远。
 * 第 3 步后，蚂蚁距边界右侧 2 单位远。
 * 第 4 步后，蚂蚁距边界左侧 2 单位远。
 * 蚂蚁从未返回到边界上，所以答案是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * -10 <= nums[i] <= 10
 * nums[i] != 0
 */
public class Code2 {

    public int returnToBoundaryCount(int[] nums) {
        //次数
        int count = 0;
        //和
        int sum = 0;
        //循环
        for (int num : nums) {
            //叠加
            sum += num;
            //记录
            count += sum == 0 ? 1 : 0;
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().returnToBoundaryCount(new int[]{2, 3, -5}));
    }

}
