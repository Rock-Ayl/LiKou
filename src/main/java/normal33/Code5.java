package normal33;

/**
 * @Author ayl
 * @Date 2024-07-06
 * 1529. 最少的后缀翻转次数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 、下标从 0 开始的二进制字符串 target 。你自己有另一个长度为 n 的二进制字符串 s ，最初每一位上都是 0 。你想要让 s 和 target 相等。
 * <p>
 * 在一步操作，你可以选择下标 i（0 <= i < n）并翻转在 闭区间 [i, n - 1] 内的所有位。翻转意味着 '0' 变为 '1' ，而 '1' 变为 '0' 。
 * <p>
 * 返回使 s 与 target 相等需要的最少翻转次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = "10111"
 * 输出：3
 * 解释：最初，s = "00000" 。
 * 选择下标 i = 2: "00000" -> "00111"
 * 选择下标 i = 0: "00111" -> "11000"
 * 选择下标 i = 1: "11000" -> "10111"
 * 要达成目标，需要至少 3 次翻转。
 * 示例 2：
 * <p>
 * 输入：target = "101"
 * 输出：3
 * 解释：最初，s = "000" 。
 * 选择下标 i = 0: "000" -> "111"
 * 选择下标 i = 1: "111" -> "100"
 * 选择下标 i = 2: "100" -> "101"
 * 要达成目标，需要至少 3 次翻转。
 * 示例 3：
 * <p>
 * 输入：target = "00000"
 * 输出：0
 * 解释：由于 s 已经等于目标，所以不需要任何操作
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == target.length
 * 1 <= n <= 105
 * target[i] 为 '0' 或 '1'
 */
public class Code5 {

    public int minFlips(String target) {
        //操作次数
        int count = 0;
        //循环
        for (int i = 0; i < target.length(); i++) {
            //如果 翻转操作次数 与 当前目标值 相同
            if (count % 2 == (target.charAt(i) - '0')) {
                //本轮过
                continue;
            }
            //+1
            ++count;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().minFlips("10111"));
    }

}
