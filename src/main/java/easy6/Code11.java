package easy6;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-02-08
 * 1748. 唯一元素的和
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * <p>
 * 请你返回 nums 中唯一元素的 和 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 * 示例 3 ：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 */
public class Code11 {

    public static int sumOfUnique(int[] nums) {
        //只出现一次的
        Set<Integer> set1 = new HashSet<>();
        //出现多次的
        Set<Integer> set2 = new HashSet<>();
        //循环
        for (int num : nums) {
            //如果没有存在多次
            if (!set2.contains(num)) {
                //如果存在了一次
                if (set1.contains(num)) {
                    //计算
                    set1.remove(num);
                    set2.add(num);
                } else {
                    //计算
                    set1.add(num);
                }
            }
        }
        //计算并返回
        return set1.stream().mapToInt(p -> p).sum();
    }

    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1, 2, 3, 2}));
    }
}
