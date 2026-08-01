package easy43;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 263. 丑数
 * 尝试过
 * 算术评级: 1
 * 同步题目状态
 * <p>
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 丑数 就是只包含质因数 2、3 和 5 的 正 整数。
 * <p>
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数。
 * 示例 3：
 * <p>
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 *
 */
public class Code25 {

    //丑数的质因数
    private static final Set<Integer> SET = new HashSet<>(Arrays.asList(2, 3, 5));

    public boolean isUgly(int n) {
        //如果不够大
        if (n < 1) {
            //不是
            return false;
        }
        //如果是1
        if (n == 1) {
            //是
            return true;
        }
        //如果存在
        if (SET.contains(n)) {
            //是
            return true;
        }
        //可以整除的数量
        int count = 0;
        //循环
        for (int num : SET) {
            //如果可以整除
            if (n % num == 0) {
                //计算出来
                int next = n / num;
                //如果其不是
                if (isUgly(next) == false) {
                    //不是
                    return false;
                }
                //+1
                count++;
            }
        }
        //至少要有一次
        return count > 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code25().isUgly(6));
    }

}