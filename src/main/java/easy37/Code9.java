package easy37;

/**
 * @Author ayl
 * @Date 2024-06-19
 * 3184. 构成整天的下标对数目 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标对 i, j 的数目。
 * <p>
 * 整天 定义为时间持续时间是 24 小时的 整数倍 。
 * <p>
 * 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： hours = [12,12,30,24,24]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 构成整天的下标对分别是 (0, 1) 和 (3, 4)。
 * <p>
 * 示例 2：
 * <p>
 * 输入： hours = [72,48,24,3]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hours.length <= 100
 * 1 <= hours[i] <= 109
 */
public class Code9 {

    public int countCompleteDayPairs(int[] hours) {
        //结果
        int sum = 0;
        //循环1
        for (int i = 0; i < hours.length; i++) {
            //循环2
            for (int j = i + 1; j < hours.length; j++) {
                //如果满足
                if ((hours[i] + hours[j]) % 24 == 0) {
                    //+1
                    ++sum;
                }
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
    }
}
