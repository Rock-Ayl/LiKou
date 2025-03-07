package normal5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-07-30
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * <p>
 * 输入：nums = [1], target = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class Code15 {

    int size = 0;
    int[] nums;
    int target;

    public void dfs(int sum, int p) {
        //如果是结尾
        if (p == nums.length) {
            if (sum == target) {
                size++;
            }
            return;
        }
        //获取数字,+1
        int num = nums[p++];
        dfs(sum + num, p);
        dfs(sum - num, p);
    }

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        dfs(0, 0);
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
