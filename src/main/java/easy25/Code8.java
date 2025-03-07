package easy25;

/**
 * @Author ayl
 * @Date 2022-11-28
 * 6245. 找出中枢整数
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 * <p>
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：6
 * 解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 是中枢整数，因为 1 = 1 。
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：-1
 * 解释：可以证明不存在满足题目要求的整数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */
public class Code8 {

    public int pivotInteger(int n) {
        //如果特殊情况
        if (n == 1) {
            //直接返回
            return 1;
        }
        //双端和,用正副判断处理
        int leftSum = 0;
        //双指针-左边
        int p = 1;
        //循环
        while (p < n) {
            //如果左边大
            if (leftSum > 0) {
                //右边进位
                leftSum -= n--;
            } else {
                //否则都算左边进位
                leftSum += p++;
            }
        }
        //如果正好相等,说明是
        if (leftSum == 0) {
            //返回结果
            return p;
        }
        //不行,默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().pivotInteger(8));
    }

}
