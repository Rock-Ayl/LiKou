package easy18;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-05-09
 * 2206. 将数组划分成相等数对
 * 给你一个整数数组 nums ，它包含 2 * n 个整数。
 * <p>
 * 你需要将 nums 划分成 n 个数对，满足：
 * <p>
 * 每个元素 只属于一个 数对。
 * 同一数对中的元素 相等 。
 * 如果可以将 nums 划分成 n 个数对，请你返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3,2,2,2]
 * 输出：true
 * 解释：
 * nums 中总共有 6 个元素，所以它们应该被划分成 6 / 2 = 3 个数对。
 * nums 可以划分成 (2, 2) ，(3, 3) 和 (2, 2) ，满足所有要求。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：
 * 无法将 nums 划分成 4 / 2 = 2 个数对且满足所有要求。
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums.length == 2 * n
 * 1 <= n <= 500
 * 1 <= nums[i] <= 500
 */
public class Code18 {

    public boolean divideArray(int[] nums) {
        //如果是偶数
        if (nums.length % 2 != 0) {
            //不是
            return false;
        }
        //缓存
        Set<Integer> set = new HashSet<>();
        //循环
        for (int num : nums) {
            //如果有
            if (set.contains(num)) {
                //删除
                set.remove(num);
            } else {
                //组装ew
                set.add(num);
            }
        }
        //如果有
        if (set.size() > 0) {
            //不是
            return false;
        }
        //默认
        return true;
    }

}
