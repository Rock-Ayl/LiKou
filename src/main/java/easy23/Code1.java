package easy23;

/**
 * @Author ayl
 * @Date 2022-09-15
 * 2293. 极大极小游戏
 * 给你一个下标从 0 开始的整数数组 nums ，其长度是 2 的幂。
 * <p>
 * 对 nums 执行下述算法：
 * <p>
 * 设 n 等于 nums 的长度，如果 n == 1 ，终止 算法过程。否则，创建 一个新的整数数组 newNums ，新数组长度为 n / 2 ，下标从 0 开始。
 * 对于满足 0 <= i < n / 2 的每个 偶数 下标 i ，将 newNums[i] 赋值 为 min(nums[2 * i], nums[2 * i + 1]) 。
 * 对于满足 0 <= i < n / 2 的每个 奇数 下标 i ，将 newNums[i] 赋值 为 max(nums[2 * i], nums[2 * i + 1]) 。
 * 用 newNums 替换 nums 。
 * 从步骤 1 开始 重复 整个过程。
 * 执行算法后，返回 nums 中剩下的那个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [1,3,5,2,4,8,2,2]
 * 输出：1
 * 解释：重复执行算法会得到下述数组。
 * 第一轮：nums = [1,5,4,2]
 * 第二轮：nums = [1,4]
 * 第三轮：nums = [1]
 * 1 是最后剩下的那个数字，返回 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [3]
 * 输出：3
 * 解释：3 就是最后剩下的数字，返回 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1024
 * 1 <= nums[i] <= 109
 * nums.length 是 2 的幂
 */
public class Code1 {

    public int minMaxGame(int[] nums) {
        //下一个数组
        int[] next;
        //循环
        while (nums.length > 1) {
            //初始化
            next = new int[nums.length / 2];
            //下一个数组的指针
            int p = 0;
            //比小比大
            boolean min = true;
            //循环
            for (int i = 0; i < nums.length; i = i + 2) {
                //判断比小比大
                if (min) {
                    //比较并组装
                    next[p++] = Math.min(nums[i], nums[i + 1]);
                } else {
                    //比较并组装
                    next[p++] = Math.max(nums[i], nums[i + 1]);
                }
                //置换
                min = !min;
            }
            //记录下一个
            nums = next;
        }
        //返回
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(new Code1().minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
    }

}
