package normal39;

/**
 * @Author ayl
 * @Date 2025-02-06
 * 1871. 跳跃游戏 VII
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足如下条件时，你可以从下标 i 移动到下标 j 处：
 * <p>
 * i + minJump <= j <= min(i + maxJump, s.length - 1) 且
 * s[j] == '0'.
 * 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "011010", minJump = 2, maxJump = 3
 * 输出：true
 * 解释：
 * 第一步，从下标 0 移动到下标 3 。
 * 第二步，从下标 3 移动到下标 5 。
 * 示例 2：
 * <p>
 * 输入：s = "01101110", minJump = 2, maxJump = 3
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 105
 * s[i] 要么是 '0' ，要么是 '1'
 * s[0] == '0'
 * 1 <= minJump <= maxJump < s.length
 */
public class Code26 {

    public boolean canReach(String s, int minJump, int maxJump) {

        /**
         * 特殊情况
         */

        //如果最后一个是1
        if (s.charAt(s.length() - 1) == '1') {
            //不可能
            return false;
        }

        /**
         * 前缀和递推落脚点
         */

        //对应位置是否曾经跳到过,默认未到达过
        int[] jumpedArr = new int[s.length()];
        //第一个节点是一定到
        jumpedArr[0] = 1;
        //循环
        for (int i = 1; i < s.length(); i++) {
            //落脚点数量,默认是前一个节点数量
            int jumped = jumpedArr[i - 1];
            //前置区间右边
            int end = i - minJump;
            //如果当前位置是0 and 有前置区间
            if (s.charAt(i) == '0' && end >= 0) {
                //前置区间左边
                int start = i - maxJump;
                //叠加新的落脚点
                jumped += (jumpedArr[end] - (start > 0 ? jumpedArr[start - 1] : 0) > 0) ? 1 : 0;
            }
            //记录缓存
            jumpedArr[i] = jumped;
        }

        //返回最终结果
        return jumpedArr[jumpedArr.length - 1] > jumpedArr[jumpedArr.length - 2];
    }

    public static void main(String[] args) {
        System.out.println(new Code26().canReach("01111010111101110110111011110", 2, 2));
    }

}
