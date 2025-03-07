package easy29;

/**
 * @Author ayl
 * @Date 2023-03-20
 * 6319. 奇偶位数
 * 给你一个 正 整数 n 。
 * <p>
 * 用 even 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的偶数下标的个数。
 * <p>
 * 用 odd 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的奇数下标的个数。
 * <p>
 * 返回整数数组 answer ，其中 answer = [even, odd] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 17
 * 输出：[2,0]
 * 解释：17 的二进制形式是 10001 。
 * 下标 0 和 下标 4 对应的值为 1 。
 * 共有 2 个偶数下标，0 个奇数下标。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：[0,1]
 * 解释：2 的二进制形式是 10 。
 * 下标 1 对应的值为 1 。
 * 共有 0 个偶数下标，1 个奇数下标。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */
public class Code6 {

    public int[] evenOddBit(int n) {
        //结果
        int even = 0;
        int odd = 0;
        //指针
        int p = 0;
        //如果还有数字
        while (n > 0) {
            //本次值(二进制中最后一位)
            int num = n % 2;
            //如果本次指针指向的是1
            if (num == 1) {
                //如果是偶数
                if (p % 2 == 0) {
                    //记录
                    even++;
                } else {
                    //记录
                    odd++;
                }
            }
            //移动指针
            p++;
            //值减去最后一位
            n = (n - num) / 2;
        }
        //返回
        return new int[]{even, odd};
    }

    public static void main(String[] args) {
        int[] arr = new Code6().evenOddBit(17);
        System.out.println();
    }

}
