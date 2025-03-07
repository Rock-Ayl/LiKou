package normal40;

/**
 * @Author ayl
 * @Date 2025-02-27
 * 3185. 构成整天的下标对数目 II
 * 中等
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
 * 1 <= hours.length <= 5 * 105
 * 1 <= hours[i] <= 109
 */
public class Code15 {

    public long countCompleteDayPairs(int[] hours) {
        //结果
        long result = 0L;
        //缓存
        int[] arr = new int[24];
        //循环
        for (int i = 0; i < hours.length; i++) {
            //取余
            hours[i] = hours[i] % 24;
            //+1
            arr[hours[i]]++;
        }
        //循环
        for (int i = 0; i < hours.length; i++) {
            //-1,先删除本身
            arr[hours[i]]--;
            //计算出需要的另一半,并叠加本次结果
            result += arr[(24 - hours[i]) % 24];
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().countCompleteDayPairs(new int[]{72, 48, 24, 3}));
    }

}
