package easy37;

/**
 * @Author ayl
 * @Date 2024-06-20
 * 3105. 最长的严格递增或递减子数组
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums 。
 * <p>
 * 返回数组 nums 中
 * 严格递增
 * 或
 * 严格递减
 * 的最长非空子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,3,3,2]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * nums 中严格递增的子数组有[1]、[2]、[3]、[3]、[4] 以及 [1,4] 。
 * <p>
 * nums 中严格递减的子数组有[1]、[2]、[3]、[3]、[4]、[3,2] 以及 [4,3] 。
 * <p>
 * 因此，返回 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,3,3,3]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums 中严格递增的子数组有 [3]、[3]、[3] 以及 [3] 。
 * <p>
 * nums 中严格递减的子数组有 [3]、[3]、[3] 以及 [3] 。
 * <p>
 * 因此，返回 1 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * nums 中严格递增的子数组有 [3]、[2] 以及 [1] 。
 * <p>
 * nums 中严格递减的子数组有 [3]、[2]、[1]、[3,2]、[2,1] 以及 [3,2,1] 。
 * <p>
 * 因此，返回 3 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 */
public class Code10 {

    public int longestMonotonicSubarray(int[] nums) {
        //升序
        int upHit = 1;
        int upMaxHit = upHit;
        int upLastNum = nums[0];
        //降序
        int downHit = 1;
        int downMaxHit = downHit;
        int downLastNum = nums[0];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前字符
            int num = nums[i];
            //判断升序逻辑
            if (num > upLastNum) {
                //成功
                upLastNum = num;
                upMaxHit = Math.max(upMaxHit, ++upHit);
            } else {
                //失败重置
                upHit = 1;
                upLastNum = num;
            }
            //判断降序逻辑
            if (num < downLastNum) {
                //成功
                downLastNum = num;
                downMaxHit = Math.max(downMaxHit, ++downHit);
            } else {
                //失败重置
                downHit = 1;
                downLastNum = num;
            }
        }
        //返回最大情况
        return Math.max(upMaxHit, downMaxHit);
    }

    public static void main(String[] args) {
        System.out.println(new Code10().longestMonotonicSubarray(new int[]{1, 4, 3, 3, 2}));
        ;
    }

}
