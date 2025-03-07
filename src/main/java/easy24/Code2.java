package easy24;

/**
 * @Author ayl
 * @Date 2022-10-15
 * 461. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= x, y <= 231 - 1
 */
public class Code2 {

    public int hammingDistance(int x, int y) {
        //记录
        int count = 0;
        //大小二进制数
        String small;
        String big;
        //如果左边大
        if (x > y) {
            //转化为
            small = Integer.toBinaryString(y);
            big = Integer.toBinaryString(x);
        } else {
            //转化为
            small = Integer.toBinaryString(x);
            big = Integer.toBinaryString(y);
        }
        //指针
        int smallP = 0;
        int bigP = 0;
        //长度
        int smallL = small.length();
        int bigL = big.length();
        //要单独执行的次数
        int min = bigL - smallL;
        //如果不相同
        while (min-- > 0) {
            //如果不同
            if (big.charAt(bigP++) == '1') {
                //记录结果
                count++;
            }
        }
        //如果有结果
        while (bigP < bigL) {
            //如果不同
            if (small.charAt(smallP++) != big.charAt(bigP++)) {
                //记录结果
                count++;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().hammingDistance(1, 4));
    }

}
