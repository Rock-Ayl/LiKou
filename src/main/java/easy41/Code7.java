package easy41;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-08-31
 * 3663. 出现频率最低的数字
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n，找出在其十进制表示中出现频率 最低 的数字。如果多个数字的出现频率相同，则选择 最小 的那个数字。
 * <p>
 * 以整数形式返回所选的数字。
 * <p>
 * 数字 x 的出现频率是指它在 n 的十进制表示中的出现次数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入： n = 1553322
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 在 n 中，出现频率最低的数字是 1，它只出现了一次。所有其他数字都出现了两次。
 * <p>
 * 示例 2:
 * <p>
 * 输入： n = 723344511
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 在 n 中，出现频率最低的数字是 7、2 和 5，它们都只出现了一次。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 231 - 1
 */
public class Code7 {

    public int getLeastFrequentDigit(int n) {
        //缓存
        int[] arr = new int[10];
        //循环
        while (n > 9) {
            //+1
            ++arr[n % 10];
            //下一个
            n = n / 10;
        }
        //+1
        ++arr[n];
        //最小可能
        int min = Arrays.stream(arr).filter(p -> p != 0).min().getAsInt();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果是最小
            if (arr[i] == min) {
                //返回
                return i;
            }
        }
        //返回
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().getLeastFrequentDigit(11));
    }

}
