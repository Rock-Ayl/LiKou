package normal26;

/**
 * @Author ayl
 * @Date 2023-11-16
 * LCR 089. 打家劫舍
 * 中等
 * 51
 * 相关企业
 * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * <p>
 * 注意：本题与主站 198 题相同： https://leetcode-cn.com/problems/house-robber/
 */
public class Code2 {


    public int rob(int[] nums) {
        //如果只有一个
        if (nums.length == 1) {
            //默认
            return nums[0];
        }
        //如果有俩
        if (nums.length == 2) {
            //取最大的
            return Math.max(nums[0], nums[1]);
        }
        //初始化结果
        int[] arr = new int[nums.length];
        //第一个直接拿
        arr[0] = nums[0];
        //第二个取最大的那个
        arr[1] = Math.max(nums[0], nums[1]);
        //从这里开始拿
        for (int i = 2; i < nums.length; i++) {
            //取最大的
            arr[i] = Math.max(arr[i - 2] + nums[i], arr[i - 1]);
        }
        //返回
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code2().rob(new int[]{2, 7, 9, 3, 1}));
    }

}
