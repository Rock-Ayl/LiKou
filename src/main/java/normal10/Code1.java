package normal10;

/**
 * @Author ayl
 * @Date 2022-01-12
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class Code1 {

    public int rob(int[] nums) {
        //前几个
        if (nums.length == 1) {
            //返回
            return nums[0];
        }
        if (nums.length == 2) {
            //返回
            return Math.max(nums[0], nums[1]);
        }
        //每个位置最高打劫多少
        int[] arr = new int[nums.length];
        //第一个
        arr[0] = nums[0];
        //第二个
        arr[1] = Math.max(nums[0], nums[1]);
        //循环
        for (int i = 2; i < nums.length - 1; i++) {
            //计算最大
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + nums[i]);
        }
        //没有最后一个
        int max1 = arr[arr.length - 2];
        //每个位置最高打劫多少
        int[] arr2 = new int[nums.length];
        //第一个
        arr2[1] = nums[1];
        //第二个
        arr2[2] = Math.max(nums[1], nums[2]);
        //循环
        for (int i = 3; i < nums.length; i++) {
            //计算最大
            arr2[i] = Math.max(arr2[i - 1], arr2[i - 2] + nums[i]);
        }
        //没有第一个
        int max2 = arr2[arr.length - 1];
        //二者对比
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        System.out.println(new Code1().rob(new int[]{1, 2, 3}));
    }

}
