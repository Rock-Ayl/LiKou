package easy15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-11-30
 * 2089. 找出数组排序后的目标下标
 * 给你一个下标从 0 开始的整数数组 nums 以及一个目标元素 target 。
 * <p>
 * 目标下标 是一个满足 nums[i] == target 的下标 i 。
 * <p>
 * 将 nums 按 非递减 顺序排序后，返回由 nums 中目标下标组成的列表。如果不存在目标下标，返回一个 空 列表。返回的列表必须按 递增 顺序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,5,2,3], target = 2
 * 输出：[1,2]
 * 解释：排序后，nums 变为 [1,2,2,3,5] 。
 * 满足 nums[i] == 2 的下标是 1 和 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,5,2,3], target = 3
 * 输出：[3]
 * 解释：排序后，nums 变为 [1,2,2,3,5] 。
 * 满足 nums[i] == 3 的下标是 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,5,2,3], target = 5
 * 输出：[4]
 * 解释：排序后，nums 变为 [1,2,2,3,5] 。
 * 满足 nums[i] == 5 的下标是 4 。
 * 示例 4：
 * <p>
 * 输入：nums = [1,2,5,2,3], target = 4
 * 输出：[]
 * 解释：nums 中不含值为 4 的元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i], target <= 100
 */
public class Code15 {

    public List<Integer> targetIndices(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        //循环
        for (int left = 0; left < nums.length; left++) {
            //如果是
            if (nums[left] == target) {
                //右边距
                int right = left + 1;
                //循环
                while (right < nums.length) {
                    //如果不是了
                    if (nums[right] != target) {
                        //结束
                        break;
                    }
                    //下一个
                    right++;
                }
                //初始化,计算好长度
                List<Integer> list = new ArrayList<>(right - left);
                //循环
                while (left < right) {
                    //组装
                    list.add(left++);
                }
                //返回
                return list;
            }
        }
        //默认
        return new ArrayList<>(0);
    }

    public static void main(String[] args) {
        for (Integer integer : new Code15().targetIndices(new int[]{1, 2, 5, 2, 3}, 5)) {
            System.out.println(integer);
        }
    }

}
