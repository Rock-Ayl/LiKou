package normal45;

/**
 * @Author ayl
 * @Date 2025-08-02
 * 1780. 判断一个数字是否可以表示成三的幂的和
 * 尝试过
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * <p>
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 * 示例 2：
 * <p>
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 30 + 32 + 34
 * 示例 3：
 * <p>
 * 输入：n = 21
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 107
 */
public class Code16 {

    //缓存
    private int[] arr = new int[20];

    public boolean checkPowersOfThree(int n) {
        //如果是特殊情况
        if (n == 1) {
            //返回结果
            return this.arr[0] == 0;
        }
        //如果是结果
        if (n == 0) {
            //是
            return true;
        }
        //幂的次数
        int count = 1;
        int num = 3;
        //如果还可以
        while (num * 3 <= n) {
            //计算
            num = num * 3;
            count++;
        }
        //如果使用过了
        if (++arr[count] > 1) {
            //不可
            return false;
        }
        //递归
        return checkPowersOfThree(n - num);
    }

    public static void main(String[] args) {

        System.out.println(new Code16().checkPowersOfThree(Integer.MAX_VALUE));
    }

}
