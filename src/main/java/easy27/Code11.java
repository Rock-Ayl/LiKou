package easy27;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-01-30
 * 6337. 统计桌面上的不同数字
 * 给你一个正整数 n ，开始时，它放在桌面上。在 109 天内，每天都要执行下述步骤：
 * <p>
 * 对于出现在桌面上的每个数字 x ，找出符合 1 <= i <= n 且满足 x % i == 1 的所有数字 i 。
 * 然后，将这些数字放在桌面上。
 * 返回在 10^9 天之后，出现在桌面上的 不同 整数的数目。
 * <p>
 * 注意：
 * <p>
 * 一旦数字放在桌面上，则会一直保留直到结束。
 * % 表示取余运算。例如，14 % 3 等于 2 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：4
 * 解释：最开始，5 在桌面上。
 * 第二天，2 和 4 也出现在桌面上，因为 5 % 2 == 1 且 5 % 4 == 1 。
 * 再过一天 3 也出现在桌面上，因为 4 % 3 == 1 。
 * 在十亿天结束时，桌面上的不同数字有 2 、3 、4 、5 。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：
 * 因为 3 % 2 == 1 ，2 也出现在桌面上。
 * 在十亿天结束时，桌面上的不同数字只有两个：2 和 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 */
public class Code11 {

    //最终结果集合
    private Set<Integer> set = new HashSet<>();

    public int distinctIntegers(int n) {
        //指针
        int p = 1;
        //循环
        while (p < n) {
            //如果是
            if (n % p == 1) {
                //记录
                set.add(p);
                //递归
                distinctIntegers(p);
            }
            //下一个
            p++;
        }
        //返回最终结果count+加其本身
        return set.size() + 1;
    }

    public static void main(String[] args) {
        Code11 code11 = new Code11();
        int count = code11.distinctIntegers(5);
        System.out.println();
    }
}
