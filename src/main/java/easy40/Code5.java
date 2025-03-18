package easy40;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-03-18
 * 3483. 不同三位偶数的数目
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个数字数组 digits，你需要从中选择三个数字组成一个三位偶数，你的任务是求出 不同 三位偶数的数量。
 * <p>
 * 注意：每个数字在三位偶数中都只能使用 一次 ，并且 不能 有前导零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： digits = [1,2,3,4]
 * <p>
 * 输出： 12
 * <p>
 * 解释： 可以形成的 12 个不同的三位偶数是 124，132，134，142，214，234，312，314，324，342，412 和 432。注意，不能形成 222，因为数字 2 只有一个。
 * <p>
 * 示例 2：
 * <p>
 * 输入： digits = [0,2,2]
 * <p>
 * 输出： 2
 * <p>
 * 解释： 可以形成的三位偶数是 202 和 220。注意，数字 2 可以使用两次，因为数组中有两个 2 。
 * <p>
 * 示例 3：
 * <p>
 * 输入： digits = [6,6,6]
 * <p>
 * 输出： 1
 * <p>
 * 解释： 只能形成 666。
 * <p>
 * 示例 4：
 * <p>
 * 输入： digits = [1,3,5]
 * <p>
 * 输出： 0
 * <p>
 * 解释： 无法形成三位偶数。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= digits.length <= 10
 * 0 <= digits[i] <= 9
 */
public class Code5 {

    public int totalNumbers(int[] digits) {
        //缓存
        Set<Integer> set = new HashSet<>();
        //循环1
        for (int i = 0; i < digits.length; i++) {
            //获取数字1
            int num1 = digits[i];
            //如果数字是奇数
            if (num1 % 2 != 0) {
                //本轮过
                continue;
            }
            //循环2
            for (int j = 0; j < digits.length; j++) {
                //如果相同
                if (i == j) {
                    //本轮过
                    continue;
                }
                //获取数字2
                int num2 = digits[j];
                //循环3
                for (int k = 0; k < digits.length; k++) {
                    //如果相同
                    if (i == k || j == k) {
                        //本轮过
                        continue;
                    }
                    //获取数字3
                    int num3 = digits[k];
                    //如果是0
                    if (num3 == 0) {
                        //本轮过
                        continue;
                    }
                    //求和
                    int sum = num3 * 100 + num2 * 10 + num1;
                    //组装
                    set.add(sum);
                }
            }
        }
        //返回
        return set.size();
    }

    public static void main(String[] args) {

    }

}
