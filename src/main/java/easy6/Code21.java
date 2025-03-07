package easy6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-02-19
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1
 */
public class Code21 {

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        //缓存
        List<Integer> list = new ArrayList<>();
        //初始
        list.add(0);
        list.add(1);
        list.add(1);
        //位置
        int p = 3;
        //循环
        while (p <= n) {
            //计算下一级
            list.add(list.get(p - 1) + list.get(p - 2) + list.get(p - 3));
            //+1
            p++;
        }
        //返回
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
