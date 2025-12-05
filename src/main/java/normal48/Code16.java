package normal48;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-12-05
 * 1414. 和为 K 的最少斐波那契数字数目
 * 算术评级: 6
 * 第 24 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1466
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 * <p>
 * 斐波那契数字定义为：
 * <p>
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 数据保证对于给定的 k ，一定能找到可行解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 7
 * 输出：2
 * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
 * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
 * 示例 2：
 * <p>
 * 输入：k = 10
 * 输出：2
 * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
 * 示例 3：
 * <p>
 * 输入：k = 19
 * 输出：3
 * 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 10^9
 */
public class Code16 {

    public int findMinFibonacciNumbers(int k) {
        //列表
        List<Integer> list = new ArrayList<>();
        //数组
        list.add(1);
        list.add(1);
        //当前数字
        int num = list.get(list.size() - 1) + list.get(list.size() - 2);
        //循环
        while (num <= k) {
            //加入
            list.add(num);
            //下一个
            num = list.get(list.size() - 1) + list.get(list.size() - 2);
        }
        //次数
        int count = 0;
        //索引
        int index = list.size() - 1;
        //循环
        while (index >= 0 && k > 0) {
            //当前
            int number = list.get(index);
            //如果满足满足
            if (number <= k) {
                //有几个
                int hit = k / number;
                //清算
                count += hit;
                k = k - hit * number;
            }
            //下一个
            index--;
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        int minFibonacciNumbers = new Code16().findMinFibonacciNumbers(1000000000);
        System.out.println();
    }
}
