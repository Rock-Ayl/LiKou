package normal48;

/**
 * @Author ayl
 * @Date 2025-12-04
 * 1432. 改变一个整数能得到的最大差值
 * 算术评级: 5
 * 第 25 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1427
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 num 。你可以对它进行以下步骤共计 两次：
 * <p>
 * 选择一个数字 x (0 <= x <= 9).
 * 选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
 * 将 num 中所有出现 x 的数位都用 y 替换。
 * 令两次对 num 的操作得到的结果分别为 a 和 b 。
 * <p>
 * 请你返回 a 和 b 的 最大差值 。
 * <p>
 * 注意，a 和 b 必须不能 含有前导 0，并且 不为 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 555
 * 输出：888
 * 解释：第一次选择 x = 5 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 5 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 999 和 b = 111 ，最大差值为 888
 * 示例 2：
 * <p>
 * 输入：num = 9
 * 输出：8
 * 解释：第一次选择 x = 9 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 9 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 9 和 b = 1 ，最大差值为 8
 * 示例 3：
 * <p>
 * 输入：num = 123456
 * 输出：820000
 * 示例 4：
 * <p>
 * 输入：num = 10000
 * 输出：80000
 * 示例 5：
 * <p>
 * 输入：num = 9288
 * 输出：8700
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 10^8
 */
public class Code15 {

    public int maxDiff(int num) {
        //最大最小
        int a = max(num);
        int b = min(num);
        //实现
        return a - b;
    }

    //最小
    private int min(int num) {
        //最小结果
        int min = num;
        //循环
        for (int i = 0; i < 10; i++) {
            //替换
            min = Math.min(min, minExecute(num, (char) (i + '0')));
        }
        //返回
        return min;
    }

    //最大
    private int minExecute(int num, char target) {
        //字符串
        StringBuilder str = new StringBuilder(String.valueOf(num));
        //覆盖
        char cover = (str.charAt(0) == target ? '1' : '0');
        //循环
        for (int i = 0; i < str.length(); i++) {
            //如果相同
            if (str.charAt(i) == target) {
                //覆盖
                str.setCharAt(i, cover);
            }
        }
        //返回
        return Integer.valueOf(str.toString());
    }

    //最大
    private int max(int num) {
        //最大结果
        int max = 0;
        //循环
        for (int i = 0; i < 10; i++) {
            //替换
            max = Math.max(max, maxExecute(num, (char) (i + '0')));
        }
        //返回
        return max;
    }

    //最大
    private int maxExecute(int num, char target) {
        //字符串
        StringBuilder str = new StringBuilder(String.valueOf(num));
        //循环
        for (int i = 0; i < str.length(); i++) {
            //如果相同
            if (str.charAt(i) == target) {
                //覆盖
                str.setCharAt(i, '9');
            }
        }
        //返回
        return Integer.valueOf(str.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Code15().maxDiff(555));
    }

}
