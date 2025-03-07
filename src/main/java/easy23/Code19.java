package easy23;

/**
 * @Author ayl
 * @Date 2022-10-05
 * 693. 交替位二进制数
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * 示例 3：
 * <p>
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 */
public class Code19 {

    public boolean hasAlternatingBits(int n) {
        //转化为二进制
        String two = Integer.toBinaryString(n);
        //转化为数组
        char[] arr = two.toCharArray();
        //是否
        char last = arr[0];
        //循环
        for (int i = 1; i < arr.length; i++) {
            //如果是上一个
            if (arr[i] == last) {
                //结束
                return false;
            }
            //记录
            last = arr[i];
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().hasAlternatingBits(5));
    }

}
