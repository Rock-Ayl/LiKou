package normal20;

/**
 * @Author ayl
 * @Date 2023-04-23
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 */
public class Code3 {

    public int sumNums(int n) {
        //下一个值
        int nextSum = 0;
        //判断是否递归
        boolean asda = n == 0 || (nextSum += sumNums(n - 1)) > 0;
        //返回
        return n + nextSum;
    }

}
