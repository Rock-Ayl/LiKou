package normal48;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-12-15
 * 3011. 判断一个数组是否可以变为有序
 * 尝试过
 * 算术评级: 4
 * 第 122 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1497
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始且全是 正 整数的数组 nums 。
 * <p>
 * 一次 操作 中，如果两个 相邻 元素在二进制下 设置位 的数目 相同 ，那么你可以将这两个元素交换。你可以执行这个操作 任意次 （也可以 0 次）。
 * <p>
 * 如果你可以使数组变为非降序，请你返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,4,2,30,15]
 * 输出：true
 * 解释：我们先观察每个元素的二进制表示。 2 ，4 和 8 分别都只有一个数位为 1 ，分别为 "10" ，"100" 和 "1000" 。15 和 30 分别有 4 个数位为 1 ："1111" 和 "11110" 。
 * 我们可以通过 4 个操作使数组非降序：
 * - 交换 nums[0] 和 nums[1] 。8 和 4 分别只有 1 个数位为 1 。数组变为 [4,8,2,30,15] 。
 * - 交换 nums[1] 和 nums[2] 。8 和 2 分别只有 1 个数位为 1 。数组变为 [4,2,8,30,15] 。
 * - 交换 nums[0] 和 nums[1] 。4 和 2 分别只有 1 个数位为 1 。数组变为 [2,4,8,30,15] 。
 * - 交换 nums[3] 和 nums[4] 。30 和 15 分别有 4 个数位为 1 ，数组变为 [2,4,8,15,30] 。
 * 数组变成有序的，所以我们返回 true 。
 * 注意我们还可以通过其他的操作序列使数组变得有序。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：数组已经是非降序的，所以我们返回 true 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,16,8,4,2]
 * 输出：false
 * 解释：无法通过操作使数组变为非降序。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 28
 */
public class Code24 {

    public boolean canSortArray(int[] nums) {
        //索引
        int index = 0;
        //上一个最大
        int lastMax = 0;
        //循环
        while (index < nums.length) {
            //初始化列表
            List<Integer> numList = new ArrayList<>();
            //当前目标设置位
            int bitCount = Integer.bitCount(nums[index]);
            //记录数字
            numList.add(nums[index]);
            //如果是连续的
            while (index + 1 < nums.length && Integer.bitCount(nums[index + 1]) == bitCount) {
                //+1并记录
                numList.add(nums[++index]);
            }
            //排序
            numList.sort(Integer::compareTo);
            //如果与上一个不匹配
            if (numList.get(0) <= lastMax) {
                //不行
                return false;
            }
            //更新最大
            lastMax = numList.get(numList.size() - 1);
            //下一个
            index++;
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code24().canSortArray(new int[]{8, 4, 2, 30, 15}));
    }

}
