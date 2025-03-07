package easy27;

/**
 * @Author ayl
 * @Date 2023-01-29
 * 2220. 转换数字的最少位翻转次数
 * 一次 位翻转 定义为将数字 x 二进制中的一个位进行 翻转 操作，即将 0 变成 1 ，或者将 1 变成 0 。
 * <p>
 * 比方说，x = 7 ，二进制表示为 111 ，我们可以选择任意一个位（包含没有显示的前导 0 ）并进行翻转。比方说我们可以翻转最右边一位得到 110 ，或者翻转右边起第二位得到 101 ，或者翻转右边起第五位（这一位是前导 0 ）得到 10111 等等。
 * 给你两个整数 start 和 goal ，请你返回将 start 转变成 goal 的 最少位翻转 次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：start = 10, goal = 7
 * 输出：3
 * 解释：10 和 7 的二进制表示分别为 1010 和 0111 。我们可以通过 3 步将 10 转变成 7 ：
 * - 翻转右边起第一位得到：1010 -> 1011 。
 * - 翻转右边起第三位：1011 -> 1111 。
 * - 翻转右边起第四位：1111 -> 0111 。
 * 我们无法在 3 步内将 10 转变成 7 。所以我们返回 3 。
 * 示例 2：
 * <p>
 * 输入：start = 3, goal = 4
 * 输出：3
 * 解释：3 和 4 的二进制表示分别为 011 和 100 。我们可以通过 3 步将 3 转变成 4 ：
 * - 翻转右边起第一位：011 -> 010 。
 * - 翻转右边起第二位：010 -> 000 。
 * - 翻转右边起第三位：000 -> 100 。
 * 我们无法在 3 步内将 3 变成 4 。所以我们返回 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= start, goal <= 109
 */
public class Code10 {

    public int minBitFlips(int start, int goal) {
        //结果
        int count = 0;
        //转化为二进制数组
        char[] bigStrArr = Integer.toBinaryString(Math.max(start, goal)).toCharArray();
        char[] smallStrArr = Integer.toBinaryString(Math.min(start, goal)).toCharArray();
        //二者倒叙指针
        int bigP = bigStrArr.length - 1;
        int smallP = smallStrArr.length - 1;
        //先二者对比
        while (smallP >= 0) {
            //如果需要修改
            if (smallStrArr[smallP--] != bigStrArr[bigP--]) {
                //记录
                count++;
            }
        }
        //再清算大的
        while (bigP >= 0) {
            //如果需要修改
            if (bigStrArr[bigP--] == '1') {
                //记录
                count++;
            }
        }
        //返回结果
        return count;
    }

    //异或 ,然后统计出所有1的数量 异或就是相同的位0 不同的位为1
    public int start(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }

    public static void main(String[] args) {
        System.out.println(new Code10().minBitFlips(3, 4));
    }

}
