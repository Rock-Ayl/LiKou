package easy30;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-04-24
 * 2652. 倍数求和
 * 给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。
 * <p>
 * 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 解释：在 [1, 7] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7 。数字之和为 21 。
 * 示例 2：
 * <p>
 * 输入：n = 10
 * 输出：40
 * 解释：在 [1, 10] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9、10 。数字之和为 40 。
 * 示例 3：
 * <p>
 * 输入：n = 9
 * 输出：30
 * 解释：在 [1, 9] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9 。数字之和为 30 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 103
 */
public class Code10 {

    //缓存
    private Set<Integer> set = new HashSet<>();

    public int sumOfMultiples(int n) {
        //分别实现
        sum(n, 3);
        sum(n, 5);
        sum(n, 7);
        //求和并返回
        return set.stream().mapToInt(Integer::intValue).sum();
    }

    //1+2+N的和
    private void sum(int n, int num) {
        //如果太小
        if (n < 1) {
            //过
            return;
        }
        //从数字开始
        int p = num;
        //循环
        while (p <= n) {
            //叠加
            set.add(p);
            //下一个
            p = p + num;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code10().sumOfMultiples(15));
    }

}
