package normal49;

/**
 * 2522. 将字符串分割成值不超过 K 的子字符串
 * 算术评级: 5
 * 第 326 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1605
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个字符串 s ，它每一位都是 1 到 9 之间的数字组成，同时给你一个整数 k 。
 * <p>
 * 如果一个字符串 s 的分割满足以下条件，我们称它是一个 好 分割：
 * <p>
 * s 中每个数位 恰好 属于一个子字符串。
 * 每个子字符串的值都小于等于 k 。
 * 请你返回 s 所有的 好 分割中，子字符串的 最少 数目。如果不存在 s 的 好 分割，返回 -1 。
 * <p>
 * 注意：
 * <p>
 * 一个字符串的 值 是这个字符串对应的整数。比方说，"123" 的值为 123 ，"1" 的值是 1 。
 * 子字符串 是字符串中一段连续的字符序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "165462", k = 60
 * 输出：4
 * 解释：我们将字符串分割成子字符串 "16" ，"54" ，"6" 和 "2" 。每个子字符串的值都小于等于 k = 60 。
 * 不存在小于 4 个子字符串的好分割。
 * 示例 2：
 * <p>
 * 输入：s = "238182", k = 5
 * 输出：-1
 * 解释：这个字符串不存在好分割。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 是 '1' 到 '9' 之间的数字。
 * 1 <= k <= 109
 */
public class Code16 {

    public int minimumPartition(String s, int k) {
        //数字
        long num = 0;
        //连击
        int hit = 0;
        //索引
        int index = 0;
        //循环
        while (index < s.length()) {
            //如果叠加本次数字有结果
            long nextNum = num * 10 + (s.charAt(index) - '0');
            //如果 非零 and 未越界 and 目标值
            if (nextNum <= k) {
                //记录
                num = nextNum;
                //下一个
                index++;
            } else {
                //如果数字太大
                if (num == 0) {
                    //特殊情况
                    return -1;
                }
                //+1
                hit++;
                //重置
                num = 0;
            }
        }
        //返回
        return hit + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().minimumPartition("238182",
                5));
    }

}
