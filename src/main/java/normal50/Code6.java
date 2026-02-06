package normal50;

/**
 * 2844. 生成特殊数字的最少操作
 * 算术评级: 4
 * 第 361 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1588
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
 * <p>
 * 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
 * <p>
 * 返回最少需要多少次操作可以使 num 变成特殊数字。
 * <p>
 * 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "2245047"
 * 输出：2
 * 解释：删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
 * 可以证明要使数字变成特殊数字，最少需要删除 2 位数字。
 * 示例 2：
 * <p>
 * 输入：num = "2908305"
 * 输出：3
 * 解释：删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
 * 可以证明要使数字变成特殊数字，最少需要删除 3 位数字。
 * 示例 3：
 * <p>
 * 输入：num = "10"
 * 输出：1
 * 解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
 * 可以证明要使数字变成特殊数字，最少需要删除 1 位数字。
 * <p>
 * <p>
 * 提示
 * <p>
 * 1 <= num.length <= 100
 * num 仅由数字 '0' 到 '9' 组成
 * num 不含任何前导零
 */
public class Code6 {

    public int minimumOperations(String num) {
        //目标后缀
        String[] arr = new String[]{"00", "25", "50", "75"};
        //最小结果
        int min = Integer.MAX_VALUE;
        //循环
        for (String target : arr) {
            //计算、刷新本次最小结果
            min = Math.min(min, count(num, target));
        }
        //返回结果
        return min == Integer.MAX_VALUE ? zero(num) : min;
    }

    //计算本次目标值的结果
    private int count(String num, String target) {
        //目标数字1
        String one = target.substring(1, 2);
        //寻找数字1第一次出现
        int oneIndex = num.lastIndexOf(one);
        //如果没有
        if (oneIndex == -1) {
            //默认
            return Integer.MAX_VALUE;
        }
        //目标数字2
        String two = target.substring(0, 1);
        //寻找数字2第一次出现
        int twoIndex = num.lastIndexOf(two, oneIndex - 1);
        //如果没有
        if (twoIndex == -1) {
            //默认
            return Integer.MAX_VALUE;
        }
        //本次结果
        int result = num.length() - twoIndex - 2;
        //返回
        return result;
    }

    //特殊情况0
    private int zero(String num) {
        //计算是否有0,判断
        return num.lastIndexOf("0") == -1 ? num.length() : num.length() - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().minimumOperations("011111"));
    }

}
