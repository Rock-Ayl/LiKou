package easy19;

/**
 * @Author ayl
 * @Date 2022-05-18
 * 2239. 找到最接近 0 的数字
 * 给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-2,1,4,8]
 * 输出：1
 * 解释：
 * -4 到 0 的距离为 |-4| = 4 。
 * -2 到 0 的距离为 |-2| = 2 。
 * 1 到 0 的距离为 |1| = 1 。
 * 4 到 0 的距离为 |4| = 4 。
 * 8 到 0 的距离为 |8| = 8 。
 * 所以，数组中距离 0 最近的数字为 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,-1,1]
 * 输出：1
 * 解释：1 和 -1 都是距离 0 最近的数字，所以返回较大值 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * -105 <= nums[i] <= 105
 */
public class Code2 {

    public int findClosestNumber(int[] nums) {
        //最小差
        int min = Math.abs(nums[0] - 0);
        //目标
        int target = nums[0];
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前数
            int thisNum = nums[i];
            //当前差
            int thisMin = Math.abs(thisNum - 0);
            //如果要刷新
            if (thisMin < min) {
                //刷新
                target = thisNum;
                min = thisMin;
            } else if (thisMin == min) {
                //用最大的
                target = Math.max(target, thisNum);
                min = thisMin;
            }
        }
        //返回
        return target;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
    }

}
