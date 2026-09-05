package normal56;

/**
 * 2384. 最大回文数字
 * 算术评级: 5
 * 第 307 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1636
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个仅由数字（0 - 9）组成的字符串 num 。
 * <p>
 * 请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。
 * <p>
 * 注意：
 * <p>
 * 你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。
 * 数字可以重新排序。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "444947137"
 * 输出："7449447"
 * 解释：
 * 从 "444947137" 中选用数字 "4449477"，可以形成回文整数 "7449447" 。
 * 可以证明 "7449447" 是能够形成的最大回文整数。
 * 示例 2：
 * <p>
 * 输入：num = "00009"
 * 输出："9"
 * 解释：
 * 可以证明 "9" 能够形成的最大回文整数。
 * 注意返回的整数不应含前导零。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num.length <= 105
 * num 由数字（0 - 9）组成
 */
public class Code24 {

    public String largestPalindromic(String num) {
        //数字
        int[] arr = new int[10];
        //循环
        for (int i = 0; i < num.length(); i++) {
            //+1
            arr[num.charAt(i) - '0']++;
        }
        //初始化字符
        StringBuilder leftStr = new StringBuilder();
        //开始索引
        int index = arr.length - 1;
        //循环
        while (index >= 0) {
            //如果有足够的
            if (arr[index] > 1) {
                //组装
                arr[index] -= 2;
                leftStr.append(index);
            } else {
                //下一个
                index--;
            }
        }
        //寻找中间的数字
        int mid = -1;
        //循环
        for (int i = arr.length - 1; i >= 0; i--) {
            //如果有
            if (arr[i] != 0) {
                //返回
                mid = i;
                //跳出
                break;
            }
        }
        //如果是特殊情况,左边数字=0
        if (leftStr.length() == 0 || leftStr.charAt(0) == '0') {
            //特殊情况
            if (mid == -1) {
                //返回
                return Integer.valueOf(0).toString();
            } else {
                //返回
                return Integer.valueOf(mid).toString();
            }
        }
        //三部分
        String a = leftStr.toString();
        String b = mid == -1 ? "" : Integer.valueOf(mid).toString();
        String c = leftStr.reverse().toString();
        //返回
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println(new Code24().largestPalindromic("0000000000000"));
    }

}
