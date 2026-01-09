package normal49;

import java.util.ArrayList;
import java.util.List;

/**
 * 1262. 可被三整除的最大和
 * 尝试过
 * 算术评级: 6
 * 第 163 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1762
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素 最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 4 * 104
 * 1 <= nums[i] <= 104
 */
public class Code15 {

    public int maxSumDivThree(int[] nums) {
        //余的情况
        List<Integer> oneList = new ArrayList<>();
        List<Integer> twoList = new ArrayList<>();
        //求和
        int sum = 0;
        //循环
        for (int num : nums) {
            //叠加
            sum += num;
            //求余
            int other = num % 3;
            //如果是
            if (other == 1) {
                //记录
                oneList.add(num);
            }
            //如果是
            if (other == 2) {
                //记录
                twoList.add(num);
            }
        }
        //多余的数字
        int willDelete = sum % 3;
        //如果没有
        if (willDelete == 0) {
            //返回
            return sum;
        }
        //排序
        oneList.sort(Integer::compareTo);
        twoList.sort(Integer::compareTo);
        //两种情况 1 or 2
        if (willDelete == 1) {
            //结果
            int one = 0;
            int two = 0;
            //如果有
            if (oneList.size() > 0) {
                //结果
                one = sum - oneList.get(0);
            }
            //如果有
            if (twoList.size() > 1) {
                //结果
                two = sum - twoList.get(0) - twoList.get(1);
            }
            //返回
            return Math.max(one, two);
        } else {
            //结果
            int one = 0;
            int two = 0;
            //如果有
            if (twoList.size() > 0) {
                //结果
                one = sum - twoList.get(0);
            }
            //如果有
            if (oneList.size() > 1) {
                //结果
                two = sum - oneList.get(0) - oneList.get(1);
            }
            //返回
            return Math.max(one, two);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code15().maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
    }

}
