package normal53;

import java.util.ArrayList;
import java.util.List;

/**
 * 1567. 乘积为正数的最长子数组长度
 * 算术评级: 5
 * 第 204 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1710
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * <p>
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * <p>
 * 请你返回乘积为正数的最长子数组长度。
 * <p>
 * <p>
 * <p>
 * 示例  1：
 * <p>
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class Code15 {

    public int getMaxLen(int[] nums) {
        //最大长度
        int maxLength = 0;
        //索引
        int index = 0;
        //循环
        while (index < nums.length) {
            //如果是0
            if (nums[index] == 0) {
                //+1
                index++;
                //本轮过
                continue;
            }
            //负数索引列表
            List<Integer> begativeIndexingList = new ArrayList<>();
            //开始索引、结束索引
            int leftIndex = index;
            int rightIndex = index;
            //如果是负数
            if (nums[index] < 0) {
                //添加负数索引
                begativeIndexingList.add(index);
            }
            //如果还有
            while (rightIndex + 1 < nums.length && nums[rightIndex + 1] != 0) {
                //+1,如果是负数
                if (nums[++rightIndex] < 0) {
                    //记录
                    begativeIndexingList.add(rightIndex);
                }
            }
            //如果偶数,说明有偶数个负数,所以是正数
            if (begativeIndexingList.size() % 2 == 0) {
                //直接就符合,刷新本次最大
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            } else {
                //刷新本次最大
                maxLength = Math.max(maxLength, execute(begativeIndexingList, leftIndex, rightIndex));
            }
            //下一个
            index = rightIndex + 1;
        }
        //返回最大
        return maxLength;
    }

    //计算区间最大长度(里面只有正负数)
    public int execute(List<Integer> begativeIndexingList, int leftIndex, int rightIndex) {
        //最大长度
        int maxLength = 0;
        //两种情况
        maxLength = Math.max(maxLength, rightIndex - begativeIndexingList.get(0));
        maxLength = Math.max(maxLength, begativeIndexingList.get(begativeIndexingList.size() - 1) - leftIndex);
        //返回
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().getMaxLen(new int[]{-1, -2, -3, 0, 1}));
    }

}
