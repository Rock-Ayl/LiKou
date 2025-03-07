package easy4;

/**
 * Created By Rock-Ayl on 2020-12-18
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class Code13 {

    public static int rob(int[] nums) {
        //判空
        if (nums.length == 0) {
            //缺省
            return 0;
        }
        //前位置
        int a = 0;
        //后位置
        int b = nums[0];
        //循环
        for (int i = 1; i < nums.length; i++) {
            //获取当前数
            int x = nums[i];
            //计算新的后位置
            int bb = a + x;
            //前位置更新为最大的数
            a = Math.max(a, b);
            //新后位置更新
            b = bb;
        }
        //返回最大的
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

}
