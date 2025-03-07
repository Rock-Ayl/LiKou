package normal19;

import java.util.*;

/**
 * @Author ayl
 * @Date 2023-03-17
 * 398. 随机数索引
 * 给你一个可能含有 重复元素 的整数数组 nums ，请你随机输出给定的目标数字 target 的索引。你可以假设给定的数字一定存在于数组中。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution(int[] nums) 用数组 nums 初始化对象。
 * int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i 。如果存在多个有效的索引，则每个索引的返回概率应当相等。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Solution", "pick", "pick", "pick"]
 * [[[1, 2, 3, 3, 3]], [3], [1], [3]]
 * 输出
 * [null, 4, 0, 2]
 * <p>
 * 解释
 * Solution solution = new Solution([1, 2, 3, 3, 3]);
 * solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
 * solution.pick(1); // 返回 0 。因为只有 nums[0] 等于 1 。
 * solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * target 是 nums 中的一个整数
 * 最多调用 pick 函数 104 次
 */
public class Code10 {

    //缓存
    private Map<Integer, List<Integer>> map;
    //随机数
    private Random random;

    public Code10(int[] nums) {
        //初始化
        this.map = new HashMap<>();
        this.random = new Random();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //获取魂村
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            //记录
            list.add(i);
            //记录回去
            map.put(nums[i], list);
        }
    }

    //随机拿
    public int pick(int target) {
        //获取本次的坐标
        List<Integer> list = map.get(target);
        //随机拿
        return list.get(this.random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        Code10 code10 = new Code10(new int[]{1, 2, 3, 3, 3});
        System.out.println(code10.pick(3));
        System.out.println(code10.pick(1));
        System.out.println(code10.pick(3));

    }

}
