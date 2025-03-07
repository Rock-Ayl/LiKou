package easy32;

/**
 * @Author ayl
 * @Date 2023-08-04
 * CR 006. 两数之和 II - 输入有序数组
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 * <p>
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[0,2]
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 非递减顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 * <p>
 * <p>
 * 注意：本题与主站 167 题相似（下标起点不同）：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 */
public class Code18 {

    public int[] twoSum(int[] numbers, int target) {
        //双指针
        int p1 = 0;
        int p2 = 1;
        //如果还可以移动
        while (p1 < numbers.length - 1) {
            //如果更大
            while (numbers[p1] + numbers[p2] > target) {
                //回滚
                --p2;
            }
            //如果更小
            while (numbers[p1] + numbers[p2] < target && p2 < numbers.length - 1) {
                //进步
                ++p2;
            }
            //如果是目标
            if (numbers[p1] + numbers[p2] == target) {
                //返回
                return new int[]{p1, p2};
            }
            //左边进位
            p1++;
        }
        //返回
        return new int[]{p1, p2};
    }

    public static void main(String[] args) {
        int[] ints = new Code18().twoSum(new int[]{1, 2, 4, 6, 10}, 8);
        System.out.println();
    }


}
