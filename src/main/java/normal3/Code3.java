package normal3;

/**
 * Created By Rock-Ayl on 2021-04-25
 * 162. 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * <p>
 * <p>
 * 进阶：你可以实现时间复杂度为 O(logN) 的解决方案吗？
 */
public class Code3 {

    public int findPeakElement(int[] nums) {
        //越界
        if (nums.length < 2) {
            //默认
            return 0;
        }
        //如果左边界大
        if (nums[0] > nums[1]) {
            //默认
            return 0;
        }
        //如果右边界大
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            //默认
            return nums.length - 1;
        }
        //上一个数
        int lastNum = nums[0];
        //默认向上
        boolean isUp = true;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前数
            int num = nums[i];
            //如果应该向上
            if (isUp) {
                //满足
                if (num > lastNum) {
                    //开始寻找向下的了
                    isUp = false;
                }
            } else {
                //如果满足
                if (lastNum > num) {
                    //返回结果
                    return i - 1;
                } else if (lastNum == num) {
                    //回退
                    isUp = true;
                }
            }
            //更新上一个数
            lastNum = num;
        }
        //默认
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().findPeakElement(new int[]{1, 2}));
    }
}
