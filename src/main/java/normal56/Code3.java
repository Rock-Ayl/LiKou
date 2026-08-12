package normal56;

/**
 * 2443. 反转之后的数字和
 * 算术评级: 2
 * 第 315 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1376
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 非负 整数 num 。如果存在某个 非负 整数 k 满足 k + reverse(k) = num  ，则返回 true ；否则，返回 false 。
 * <p>
 * reverse(k) 表示 k 反转每个数位后得到的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 443
 * 输出：true
 * 解释：172 + 271 = 443 ，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：num = 63
 * 输出：false
 * 解释：63 不能表示为非负整数及其反转后数字之和，返回 false 。
 * 示例 3：
 * <p>
 * 输入：num = 181
 * 输出：true
 * 解释：140 + 041 = 181 ，所以返回 true 。注意，反转后的数字可能包含前导零。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num <= 105
 *
 */
public class Code3 {

    public boolean sumOfNumberAndReverse(int num) {
        //特殊
        if (num == 0) {
            //过
            return true;
        }
        //中间
        int left = num / 2;
        //循环
        while (left < num) {
            //另一个数字
            int right = num - left;
            //如果是
            if (reverse(left, right)) {
                //返回
                return true;
            }
            //+1
            left++;
        }
        //默认
        return false;
    }

    //如果是翻转
    private boolean reverse(int left, int right) {
        //反转后数字
        int reversed = 0;
        //如果还有
        while (left != 0) {
            //叠加
            reversed = reversed * 10 + left % 10;
            //下一个
            left = left / 10;
        }
        //判断
        return reversed == right;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().sumOfNumberAndReverse(181));
    }

}
