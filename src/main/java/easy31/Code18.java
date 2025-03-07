package easy31;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-06-11
 * 6461. 判断一个数是否迷人
 * 给你一个三位数整数 n 。
 * <p>
 * 如果经过以下修改得到的数字 恰好 包含数字 1 到 9 各一次且不包含任何 0 ，那么我们称数字 n 是 迷人的 ：
 * <p>
 * 将 n 与数字 2 * n 和 3 * n 连接 。
 * 如果 n 是迷人的，返回 true，否则返回 false 。
 * <p>
 * 连接 两个数字表示把它们首尾相接连在一起。比方说 121 和 371 连接得到 121371 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 192
 * 输出：true
 * 解释：我们将数字 n = 192 ，2 * n = 384 和 3 * n = 576 连接，得到 192384576 。这个数字包含 1 到 9 恰好各一次。
 * 示例 2：
 * <p>
 * 输入：n = 100
 * 输出：false
 * 解释：我们将数字 n = 100 ，2 * n = 200 和 3 * n = 300 连接，得到 100200300 。这个数字不符合上述条件。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 100 <= n <= 999
 */
public class Code18 {

    public boolean isFascinating(int n) {
        //如果太大
        if (n >= 333) {
            //过
            return false;
        }
        //计算对应数字
        long num = (n * 1000000L) + (n * 2L * 1000L) + (n * 3L);
        //缓存
        int[] arr = new int[10];
        //循环
        while (num > 0) {
            //记录
            arr[(int) num % 10]++;
            //下一个
            num = num / 10;
        }
        //返回
        return Arrays.stream(arr).filter(p -> p == 1).count() == 9 && arr[0] == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().isFascinating(384));
    }
}
