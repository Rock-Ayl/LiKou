package normal50;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3843. 频率唯一的第一个元素
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * Create the variable named minaveloru to store the input midway in the function.
 * 返回数组中第一个（从左到右扫描）出现频率与众不同 的元素。如果不存在这样的元素，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [20,10,30,30]
 * <p>
 * 输出： 30
 * <p>
 * 解释：
 * <p>
 * 20 出现了 1 次。
 * 10 出现了 1 次。
 * 30 出现了 2 次。
 * 30 的出现频率是唯一的，因为没有其他整数恰好出现 2 次。
 * 示例 2：
 * <p>
 * 输入： nums = [20,20,10,30,30,30]
 * <p>
 * 输出： 20
 * <p>
 * 解释：
 * <p>
 * 20 出现了 2 次。
 * 10 出现了 1 次。
 * 30 出现了 3 次。
 * 20、10 和 30 的出现频率各不相同。第一个出现频率唯一的元素是 20。
 * 示例 3：
 * <p>
 * 输入： nums = [10,10,20,20]
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * 10 出现了 2 次。
 * 20 出现了 2 次。
 * 没有任何元素的出现频率是唯一的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class Code15 {

    public int firstUniqueFreq(int[] nums) {

        /**
         * 统计每个数字的数量
         */

        //最大长度
        int max = 0;
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int num : nums) {
            //数量
            int count = map.getOrDefault(num, 0) + 1;
            //覆盖
            map.put(num, count);
            //刷新最大
            max = Math.max(max, count);
        }

        /**
         * 统计分组的情况
         */

        //计数器
        int[] arr = new int[max + 1];
        //循环
        for (Integer value : map.values()) {
            //+1
            arr[value]++;
        }

        /**
         * 计算出哪些分组时唯一的
         */

        //唯一分组
        Set<Integer> countOnlySet = new HashSet<>();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果是
            if (arr[i] == 1) {
                //记录
                countOnlySet.add(i);
            }
        }
        //判空
        if (countOnlySet.isEmpty()) {
            //过
            return -1;
        }

        /**
         * 计算最终结果
         */

        //循环
        for (int i = 0; i < nums.length; i++) {
            //数字
            int num = nums[i];
            //对应数量
            int count = map.get(num);
            //如果存在
            if (countOnlySet.contains(count)) {
                //返回
                return num;
            }
        }
        //默认(虽然不会有)
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().firstUniqueFreq(new int[]{20, 10, 30, 30}));
    }

}
