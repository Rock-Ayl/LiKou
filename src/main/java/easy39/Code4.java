package easy39;

/**
 * @Author ayl
 * @Date 2024-12-14
 * 231. 2 的幂
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 * <p>
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * 示例 3：
 * <p>
 * 输入：n = 3
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能够不使用循环/递归解决此问题吗？
 */
public class Code4 {

    public boolean isPowerOfTwo(int n) {
        //特殊
        if (n == 0) {
            //过
            return false;
        }
        //特殊
        if (n == -1) {
            //过
            return false;
        }
        //通过正负数来判断结果
        return n > 0 ? (n & (n - 1)) == 0 : (n & (n + 1)) == 0;
    }

    //收藏....
    public boolean star(int n) {
        //只有大于0的才是....
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().isPowerOfTwo(-1));
    }

}
