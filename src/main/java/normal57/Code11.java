package normal57;

/**
 * 1390. 四因数
 * 算术评级: 5
 * 第 181 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1478
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。如果数组中不存在满足题意的整数，则返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 * 示例 2:
 * <p>
 * 输入: nums = [21,21]
 * 输出: 64
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,4,5]
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * 1 <= nums[i] <= 105
 */
public class Code11 {

    public int sumFourDivisors(int[] nums) {
        //和
        int sum = 0;
        //循环
        for (int num : nums) {
            //叠加本次
            sum += sum(num);
        }
        //返回
        return sum;
    }

    //最大因数数量(不包含1和num)
    private static final int MAX = 4 - 2;

    //计算本次和
    private int sum(int num) {
        //因数数量
        int count = 0;
        //本次和
        int sum = num + 1;
        //循环
        for (int i = 2; i < num; i++) {
            //如果i是num的因数
            if (num % i == 0) {
                //因数数量++
                count++;
                //叠加本次
                sum += i;
                //如果超了
                if (count > MAX) {
                    //直接返回0
                    return 0;
                }
            }
        }
        //返回结果
        return count == MAX ? sum : 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().sumFourDivisors(new int[]{21, 4, 7}));
    }

}
