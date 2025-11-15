package normal47;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-11-15
 * 3282. 到达数组末尾的最大得分
 * 算术评级: 6
 * 第 414 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1772
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 。
 * <p>
 * 你的目标是从下标 0 出发，到达下标 n - 1 处。每次你只能移动到 更大 的下标处。
 * <p>
 * 从下标 i 跳到下标 j 的得分为 (j - i) * nums[i] 。
 * <p>
 * 请你返回你到达最后一个下标处能得到的 最大总得分 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1,5]
 * <p>
 * 输出：7
 * <p>
 * 解释：
 * <p>
 * 一开始跳到下标 1 处，然后跳到最后一个下标处。总得分为 1 * 1 + 2 * 3 = 7 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4,3,1,3,2]
 * <p>
 * 输出：16
 * <p>
 * 解释：
 * <p>
 * 直接跳到最后一个下标处。总得分为 4 * 4 = 16 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class Code26 {

    public long findMaximumScore(List<Integer> nums) {
        //结果
        long result = 0L;
        //索引
        int index = 0;
        //循环
        for (int i = 1; i < nums.size(); i++) {
            //当前数字,如果更大
            if (nums.get(i) > nums.get(index)) {
                //计算本次,叠加
                result += (long) nums.get(index) * (i - index);
                //更换索引
                index = i;
            }
        }
        //如果没有收尾
        if (index != nums.size() - 1) {
            //收尾
            result += (long) nums.get(index) * (nums.size() - 1 - index);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code26().findMaximumScore(Arrays.asList(1, 3, 1, 5)));
        System.out.println(new Code26().findMaximumScore(Arrays.asList(4, 3, 1, 3, 2)));
    }

}
