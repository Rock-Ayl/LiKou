package easy37;

/**
 * @Author ayl
 * @Date 2024-07-30
 * 3232. 判断是否可以赢得数字游戏
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 正整数 数组 nums。
 * <p>
 * Alice 和 Bob 正在玩游戏。在游戏中，Alice 可以从 nums 中选择所有个位数 或 所有两位数，剩余的数字归 Bob 所有。如果 Alice 所选数字之和 严格大于 Bob 的数字之和，则 Alice 获胜。
 * <p>
 * 如果 Alice 能赢得这场游戏，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,10]
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * Alice 不管选个位数还是两位数都无法赢得比赛。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5,14]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * Alice 选择个位数可以赢得比赛，所选数字之和为 15。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [5,5,5,25]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * Alice 选择两位数可以赢得比赛，所选数字之和为 25。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 99
 */
public class Code22 {

    public boolean canAliceWin(int[] nums) {
        //缓存
        int small = 0;
        int big = 0;
        //中间数字
        int mid = 10;
        //循环
        for (int num : nums) {
            //判断是个数为还是十位数
            if (num < mid) {
                //叠加
                small += num;
            } else {
                //叠加
                big += num;
            }
        }
        //判断
        return small != big;
    }

    public static void main(String[] args) {

    }

}
