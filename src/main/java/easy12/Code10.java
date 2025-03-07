package easy12;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2021-10-08
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 非递减顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 */
public class Code10 {

    public int[] twoSum(int[] numbers, int target) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        //循环
        for (int i = 0; i < numbers.length; i++) {
            //记录缓存
            map.put(numbers[i], i);
        }
        //循环
        for (int i = 0; i < numbers.length; i++) {
            //当前
            int first = numbers[i];
            //预期结果
            int will = target - first;
            //如果有结果了
            if (map.containsKey(will)) {
                //返回
                return new int[]{i + 1, map.get(will) + 1};
            }
        }
        //默认
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(new Code10().twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
