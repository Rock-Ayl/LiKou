package normal53;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2780. 合法分割的最小下标
 * 算术评级: 5
 * 第 354 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1550
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 如果在长度为 m 的整数数组 arr 中 超过一半 的元素值为 x，那么我们称 x 是 支配元素 。
 * <p>
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums ，数据保证它含有一个 支配 元素。
 * <p>
 * 你需要在下标 i 处将 nums 分割成两个数组 nums[0, ..., i] 和 nums[i + 1, ..., n - 1] ，如果一个分割满足以下条件，我们称它是 合法 的：
 * <p>
 * 0 <= i < n - 1
 * nums[0, ..., i] 和 nums[i + 1, ..., n - 1] 的支配元素相同。
 * 这里， nums[i, ..., j] 表示 nums 的一个子数组，它开始于下标 i ，结束于下标 j ，两个端点都包含在子数组内。特别地，如果 j < i ，那么 nums[i, ..., j] 表示一个空数组。
 * <p>
 * 请你返回一个 合法分割 的 最小 下标。如果合法分割不存在，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,2]
 * 输出：2
 * 解释：我们将数组在下标 2 处分割，得到 [1,2,2] 和 [2] 。
 * 数组 [1,2,2] 中，元素 2 是支配元素，因为它在数组中出现了 2 次，且 2 * 2 > 3 。
 * 数组 [2] 中，元素 2 是支配元素，因为它在数组中出现了 1 次，且 1 * 2 > 1 。
 * 两个数组 [1,2,2] 和 [2] 都有与 nums 一样的支配元素，所以这是一个合法分割。
 * 下标 2 是合法分割中的最小下标。
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,3,1,1,1,7,1,2,1]
 * 输出：4
 * 解释：我们将数组在下标 4 处分割，得到 [2,1,3,1,1] 和 [1,7,1,2,1] 。
 * 数组 [2,1,3,1,1] 中，元素 1 是支配元素，因为它在数组中出现了 3 次，且 3 * 2 > 5 。
 * 数组 [1,7,1,2,1] 中，元素 1 是支配元素，因为它在数组中出现了 3 次，且 3 * 2 > 5 。
 * 两个数组 [2,1,3,1,1] 和 [1,7,1,2,1] 都有与 nums 一样的支配元素，所以这是一个合法分割。
 * 下标 4 是所有合法分割中的最小下标。
 * 示例 3：
 * <p>
 * 输入：nums = [3,3,3,3,7,2,2]
 * 输出：-1
 * 解释：没有合法分割。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * nums 有且只有一个支配元素。
 */
public class Code18 {

    public int minimumIndex(List<Integer> nums) {

        /**
         * 寻找最多数量的元素
         */

        //最多数量的元素-key
        Integer maxKey = null;
        //最多数量的元素-数量
        int maxKeyAllCount = 0;
        //计数器
        Map<Integer, Integer> countMap = new HashMap<>();
        //循环
        for (Integer num : nums) {
            //计算新数量
            int count = countMap.getOrDefault(num, 0) + 1;
            //如果更大
            if (count > maxKeyAllCount) {
                //覆盖
                maxKey = num;
                maxKeyAllCount = count;
            }
            //覆盖
            countMap.put(num, count);
        }
        //不大于一半,没办法分割
        if (maxKeyAllCount <= (nums.size() + 1) / 2) {
            //返回-1
            return -1;
        }

        /**
         * 计算
         */

        //左边最大元素数量
        int leftMaxKeyCount = 0;
        //循环
        for (int i = 0; i < nums.size(); i++) {
            //如果当前是
            if (nums.get(i).equals(maxKey)) {
                //+1
                leftMaxKeyCount++;
            }
            //如果 左边是支配地位 and 右边是支配地位
            if (leftMaxKeyCount > (i + 1) / 2 && (maxKeyAllCount - leftMaxKeyCount) > (nums.size() - i - 1) / 2) {
                //返回
                return i;
            }
        }

        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().minimumIndex(Arrays.asList(2, 1, 3, 1, 1, 1, 7, 1, 2, 1)));;
    }

}
