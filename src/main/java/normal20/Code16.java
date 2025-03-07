package normal20;

import java.util.LinkedList;

/**
 * @Author ayl
 * @Date 2023-05-20
 * 967. 连续差相同的数字
 * 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
 * <p>
 * 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 * 示例 2：
 * <p>
 * 输入：n = 2, k = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * 示例 3：
 * <p>
 * 输入：n = 2, k = 0
 * 输出：[11,22,33,44,55,66,77,88,99]
 * 示例 4：
 * <p>
 * 输入：n = 2, k = 2
 * 输出：[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 9
 * 0 <= k <= 9
 */
public class Code16 {

    //结果列表
    private LinkedList<Integer> list = new LinkedList<>();

    //走下去
    public void next(int n, int k, int num, int length) {
        //如果是目标长度
        if (length == n) {
            //记录结果
            list.add(num);
            //结束
            return;
        }
        //最后一位
        int last = num % 10;
        //如果是0,则只处理一次
        if (k == 0) {
            //继续走下去
            next(n, k, num * 10 + last, length + 1);
            //结束
            return;
        }
        //如果可以+
        if (last + k <= 9) {
            //继续走下去
            next(n, k, num * 10 + last + k, length + 1);
        }
        //如果可以减
        if (last - k >= 0) {
            //继续走下去
            next(n, k, num * 10 + last - k, length + 1);
        }
    }

    public int[] numsSameConsecDiff(int n, int k) {
        //从1开始
        for (int i = 1; i <= 9; i++) {
            //循环
            next(n, k, i, 1);
        }
        //返回
        return this.list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = new Code16().numsSameConsecDiff(3, 7);
        System.out.println();
    }

}
