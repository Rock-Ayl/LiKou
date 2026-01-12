package normal49;

/**
 * 2466. 统计构造好字符串的方案数
 * 算术评级: 4
 * 第 91 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1694
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：
 * <p>
 * 将 '0' 在字符串末尾添加 zero  次。
 * 将 '1' 在字符串末尾添加 one 次。
 * 以上操作可以执行任意次。
 * <p>
 * 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。
 * <p>
 * 请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：low = 3, high = 3, zero = 1, one = 1
 * 输出：8
 * 解释：
 * 一个可能的好字符串是 "011" 。
 * 可以这样构造得到："" -> "0" -> "01" -> "011" 。
 * 从 "000" 到 "111" 之间所有的二进制字符串都是好字符串。
 * 示例 2：
 * <p>
 * 输入：low = 2, high = 3, zero = 1, one = 2
 * 输出：5
 * 解释：好字符串为 "00" ，"11" ，"000" ，"110" 和 "011" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= low <= high <= 105
 * 1 <= zero, one <= low
 */
public class Code17 {

    public int countGoodStrings(int low, int high, int zero, int one) {
        //情况
        int[] arr = new int[high + 1];
        //第一种情况初始化
        arr[0] = 1;
        //循环
        for (int i = 1; i < arr.length; i++) {
            //两种情况
            int index1 = i - zero;
            int index2 = i - one;
            //如果有
            if (index1 >= 0) {
                //叠加
                arr[i] = (arr[i] + arr[index1]) % 1000000007;
            }
            //如果有
            if (index2 >= 0) {
                //叠加
                arr[i] = (arr[i] + arr[index2]) % 1000000007;
            }
        }
        //结果
        int sum = 0;
        //循环
        for (int i = low; i <= high; i++) {
            //叠加
            sum = (sum + arr[i]) % 1000000007;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        //System.out.println(new Code17().countGoodStrings(2, 3, 1, 2));
        System.out.println(new Code17().countGoodStrings(3, 3, 1, 1));
        //System.out.println(new Code17().countGoodStrings(500, 500, 5, 2));
        //System.out.println(new Code17().countGoodStrings(1, 100000, 1, 1));
    }

}
