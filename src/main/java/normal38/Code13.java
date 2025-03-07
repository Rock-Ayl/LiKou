package normal38;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-12-09
 * 2195. 向数组中追加 K 个整数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最小 。
 * <p>
 * 返回追加到 nums 中的 k 个整数之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,25,10,25], k = 2
 * 输出：5
 * 解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 2 和 3 。
 * nums 最终元素和为 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70 ，这是所有情况中的最小值。
 * 所以追加到数组中的两个整数之和是 2 + 3 = 5 ，所以返回 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6], k = 6
 * 输出：25
 * 解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 1 、2 、3 、4 、7 和 8 。
 * nums 最终元素和为 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36 ，这是所有情况中的最小值。
 * 所以追加到数组中的两个整数之和是 1 + 2 + 3 + 4 + 7 + 8 = 25 ，所以返回 25 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i], k <= 109
 */
public class Code13 {

    public long minimalKSum(int[] nums, int k) {
        //排序
        Arrays.sort(nums);
        //加入次数
        int count = 0;
        //指针
        int index = 0;
        //加入数字
        int num = 1;
        //和
        long sum = 0L;
        //循环
        while (count < k) {
            //如果有黑名单
            if (index < nums.length) {
                //如果黑名单太小
                if (nums[index] < num) {
                    //+1
                    index++;
                    //本轮过
                    continue;
                }
                //如果命中黑名单
                if (nums[index] == num) {
                    //+1
                    index++;
                    num++;
                    //本轮过
                    continue;
                }
            }
            //叠加本次结果
            sum += num++;
            //清算
            count++;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().minimalKSum(new int[]{1, 4, 25, 10, 25}, 2));
    }

}
