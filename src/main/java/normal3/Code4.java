package normal3;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2021-04-26
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：nums = [1,1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：1
 */
public class Code4 {

    public int findDuplicate(int[] nums) {
        //排序
        Arrays.sort(nums);
        //循环
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            int y = nums[i - 1];
            if (x == y) {
                return x;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().findDuplicate(new int[]{1, 1}));
    }
}
