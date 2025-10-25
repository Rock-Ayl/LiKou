package easy41;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-10-25
 * 3718. 缺失的最小倍数
 * 第 472 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1228
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k，请返回从 nums 中缺失的、最小的正整数 k 的倍数。
 * <p>
 * 倍数 指能被 k 整除的任意正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [8,2,3,4,6], k = 2
 * <p>
 * 输出： 10
 * <p>
 * 解释：
 * <p>
 * 当 k = 2 时，其倍数为 2、4、6、8、10、12……，其中在 nums 中缺失的最小倍数是 10。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,4,7,10,15], k = 5
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 当 k = 5 时，其倍数为 5、10、15、20……，其中在 nums 中缺失的最小倍数是 5。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 100
 */
public class Code20 {

    public int missingMultiple(int[] nums, int k) {
        //缓存
        Set<Integer> set = new HashSet<>();
        //循环
        for (int num : nums) {
            //如果是
            if (num % k == 0) {
                //加入缓存
                set.add(num);
            }
        }
        //数字
        int num = k;
        //循环
        while (true) {
            //如果不存在
            if (set.contains(num) == false) {
                //返回
                return num;
            }
            //叠加
            num += k;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code20().missingMultiple(new int[]{8, 2, 3, 4, 6}, 2));
    }

}
