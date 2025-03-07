package easy33;

/**
 * @Author ayl
 * @Date 2023-08-30
 * 231. 2 的幂
 * 简单
 * 622
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
 * 示例 4：
 * <p>
 * 输入：n = 4
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：n = 5
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能够不使用循环/递归解决此问题吗？
 * <p>
 * 通过次数
 * 303K
 * 提交次数
 * 605.8K
 * 通过率
 */
public class Code6 {

    public boolean isPowerOfTwo(int n) {
        //默认
        if (n == 1) {
            //是
            return true;
        }
        //不是偶数
        if (n % 2 != 0) {
            //不是
            return false;
        }
        //如果太小
        if (n < 0) {
            //不是
            return false;
        }
        //变为正数
        n = Math.abs(n);
        //当前
        int num = 2;
        //循环
        while (num <= n) {
            //如果是目标
            if (num == n) {
                //过
                return true;
            }
            //更换
            num = num * 2;
        }
        //默认
        return false;
    }

}
