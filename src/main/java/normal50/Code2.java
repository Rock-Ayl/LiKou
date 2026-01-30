package normal50;

import java.util.Arrays;

/**
 * 2563. 统计公平数对的数目
 * 算术评级: 5
 * 第 332 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1721
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。
 * <p>
 * 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：
 * <p>
 * 0 <= i < j < n，且
 * lower <= nums[i] + nums[j] <= upper
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,7,4,4,5], lower = 3, upper = 6
 * 输出：6
 * 解释：共计 6 个公平数对：(0,3)、(0,4)、(0,5)、(1,3)、(1,4) 和 (1,5) 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,7,9,2,5], lower = 11, upper = 11
 * 输出：1
 * 解释：只有单个公平数对：(2,3) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums.length == n
 * -109 <= nums[i] <= 109
 * -109 <= lower <= upper <= 109
 */
public class Code2 {

    public long countFairPairs(int[] nums, int lower, int upper) {
        //排序
        Arrays.sort(nums);
        //结果ø
        long result = 0L;
        //循环
        for (int i = 0; i < nums.length - 1; i++) {
            //当前左边的数字
            int num = nums[i];
            //最大最小值
            int min = lower - num;
            int max = upper - num;
            //获取左右索引
            int left = findMinIndex(nums, min, i + 1, nums.length - 1);
            //如果没有
            if (left == -1) {
                //本轮过
                continue;
            }
            int right = findMaxIndex(nums, max, i + 1, nums.length - 1);
            //如果没有
            if (right == -1) {
                //本轮过
                continue;
            }
            //叠加本次结果
            result += (right - left + 1);
        }
        //返回结果
        return result;
    }

    //二分查找索引
    private int findMinIndex(int[] nums, int min, int left, int right) {
        //如果是边界
        if (nums[left] >= min) {
            //返回
            return left;
        }
        //如果边界都不行
        if (nums[right] < min) {
            //返回
            return -1;
        }
        //实现
        return findMinIndexExecute(nums, min, left, right);
    }

    //二分查找实现
    private int findMinIndexExecute(int[] nums, int min, int left, int right) {
        //计算中间节点
        int mid = (left + right) / 2;
        //如果是目标
        if (nums[mid] >= min && nums[mid - 1] < min) {
            //返回
            return mid;
        }
        //如果到头了
        if (left + 1 == right) {
            //如果左边是
            if (nums[left] >= min) {
                //返回
                return left;
            } else {
                //返回
                return right;
            }
        }
        //如果当前更大
        if (nums[mid] >= min) {
            //返回
            return findMinIndexExecute(nums, min, left, mid);
        } else {
            //返回
            return findMinIndexExecute(nums, min, mid, right);
        }
    }

    //二分查找索引
    private int findMaxIndex(int[] nums, int max, int left, int right) {
        //如果是边界
        if (nums[right] <= max) {
            //返回
            return right;
        }
        //如果边界都不行
        if (nums[left] > max) {
            //返回
            return -1;
        }
        //实现
        return findMaxIndexExecute(nums, max, left, right);
    }

    //二分查找索引
    private int findMaxIndexExecute(int[] nums, int max, int left, int right) {
        //计算中间节点
        int mid = (left + right) / 2;
        //如果是目标
        if (nums[mid] <= max && nums[mid + 1] > max) {
            //返回
            return mid;
        }
        //如果到头了
        if (left + 1 == right) {
            //如果左边是
            if (nums[right] <= max) {
                //返回
                return right;
            } else {
                //返回
                return left;
            }
        }
        //判断反向
        if (nums[mid] <= max) {
            //返回
            return findMaxIndexExecute(nums, max, mid, right);
        } else {
            //返回
            return findMaxIndexExecute(nums, max, left, mid);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code2().countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
        System.out.println(new Code2().countFairPairs(new int[]{-2, -6, 4, 0, -1000000000, -1000000000, -1000000000, -1000000000}, -15, 15));
    }

}
