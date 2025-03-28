package easy12;

/**
 * @Author ayl
 * @Date 2021-10-03
 * 1991. 找到数组的中间位置
 * 给你一个下标从 0 开始的整数数组 nums ，请你找到 最左边 的中间位置 middleIndex （也就是所有可能中间位置下标最小的一个）。
 * <p>
 * 中间位置 middleIndex 是满足 nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1] 的数组下标。
 * <p>
 * 如果 middleIndex == 0 ，左边部分的和定义为 0 。类似的，如果 middleIndex == nums.length - 1 ，右边部分的和定义为 0 。
 * <p>
 * 请你返回满足上述条件 最左边 的 middleIndex ，如果不存在这样的中间位置，请你返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,-1,8,4]
 * 输出：3
 * 解释：
 * 下标 3 之前的数字和为：2 + 3 + -1 = 4
 * 下标 3 之后的数字和为：4 = 4
 * 示例 2：
 * <p>
 * 输入：nums = [1,-1,4]
 * 输出：2
 * 解释：
 * 下标 2 之前的数字和为：1 + -1 = 0
 * 下标 2 之后的数字和为：0
 * 示例 3：
 * <p>
 * 输入：nums = [2,5]
 * 输出：-1
 * 解释：
 * 不存在符合要求的 middleIndex 。
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * 解释：
 * 下标 0 之前的数字和为：0
 * 下标 0 之后的数字和为：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * -1000 <= nums[i] <= 1000
 */
public class Code5 {

    public int findMiddleIndex(int[] nums) {
        //左右
        int left = 0, right = 0;
        //结果坐标
        int p = 0;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //叠加
            right += nums[i];
        }
        //如果一开始就是结果
        if (left == right) {
            //直接返回
            return p;
        }
        //边界
        int size = nums.length - 1;
        //循环
        while (p < size) {
            //左边+
            left += nums[p++];
            //右边减
            right -= nums[p];
            //如果是结果
            if (left == right) {
                //返回坐标
                return p;
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().findMiddleIndex(new int[]{2, 3, -1, 8, 4}));
    }

}
