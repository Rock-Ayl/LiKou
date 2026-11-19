package normal59;

/**
 * 2222. 选择建筑的方案数
 * 算术评级: 5
 * 第 75 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1657
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二进制字符串 s ，它表示一条街沿途的建筑类型，其中：
 * <p>
 * s[i] = '0' 表示第 i 栋建筑是一栋办公楼，
 * s[i] = '1' 表示第 i 栋建筑是一间餐厅。
 * 作为市政厅的官员，你需要随机 选择 3 栋建筑。然而，为了确保多样性，选出来的 3 栋建筑 相邻 的两栋不能是同一类型。
 * <p>
 * 比方说，给你 s = "001101" ，我们不能选择第 1 ，3 和 5 栋建筑，因为得到的子序列是 "011" ，有相邻两栋建筑是同一类型，所以 不合 题意。
 * 请你返回可以选择 3 栋建筑的 有效方案数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "001101"
 * 输出：6
 * 解释：
 * 以下下标集合是合法的：
 * - [0,2,4] ，从 "001101" 得到 "010"
 * - [0,3,4] ，从 "001101" 得到 "010"
 * - [1,2,4] ，从 "001101" 得到 "010"
 * - [1,3,4] ，从 "001101" 得到 "010"
 * - [2,4,5] ，从 "001101" 得到 "101"
 * - [3,4,5] ，从 "001101" 得到 "101"
 * 没有别的合法选择，所以总共有 6 种方法。
 * 示例 2：
 * <p>
 * 输入：s = "11100"
 * 输出：0
 * 解释：没有任何符合题意的选择。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 105
 * s[i] 要么是 '0' ，要么是 '1' 。
 *
 */
public class Code4 {

    public long numberOfWays(String s) {
        //两种情况
        return execute(s, new char[]{'0', '1', '0'}) + execute(s, new char[]{'1', '0', '1'});
    }

    //一次实现
    private long execute(String s, char[] targetArr) {
        //前缀和
        long[][] arr = new long[3][s.length()];
        //第一个是0的情况
        for (int i = 0; i < s.length(); i++) {
            //叠加
            arr[0][i] = (i > 0 ? arr[0][i - 1] : 0) + (s.charAt(i) == targetArr[0] ? 1L : 0L);
        }
        //第二个是1的情况
        for (int i = 1; i < s.length(); i++) {
            //叠加
            arr[1][i] = arr[1][i - 1] + (s.charAt(i) == targetArr[1] ? arr[0][i - 1] : 0L);
        }
        //第三个是0的情况
        for (int i = 2; i < s.length(); i++) {
            //叠加
            arr[2][i] = arr[2][i - 1] + (s.charAt(i) == targetArr[0] ? arr[1][i - 1] : 0L);
        }
        //返回
        return arr[2][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code4().numberOfWays("001101"));
    }

}
