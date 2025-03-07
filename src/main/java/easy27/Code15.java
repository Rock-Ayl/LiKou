package easy27;

/**
 * @Author ayl
 * @Date 2023-02-04
 * 1869. 哪种连续子字符串更长
 * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
 * <p>
 * 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
 * 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1101"
 * 输出：true
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："1101"
 * 由 0 组成的最长连续子字符串的长度是 1："1101"
 * 由 1 组成的子字符串更长，故返回 true 。
 * 示例 2：
 * <p>
 * 输入：s = "111000"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 3："111000"
 * 由 0 组成的最长连续子字符串的长度是 3："111000"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 * 示例 3：
 * <p>
 * 输入：s = "110100010"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："110100010"
 * 由 0 组成的最长连续子字符串的长度是 3："110100010"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s[i] 不是 '0' 就是 '1'
 */
public class Code15 {

    public boolean checkZeroOnes(String s) {
        //返回
        int oneMax = 0;
        int zeroMax = 0;
        //记录
        int oneHit = 0;
        int zeroHit = 0;
        //数组
        char[] arr = s.toCharArray();
        //初始化第一个
        char last = arr[0];
        //初始化第一个计数
        if (last == '0') {
            //记录
            zeroHit++;
        } else {
            //记录
            oneHit++;
        }
        //循环
        for (int i = 1; i < arr.length; i++) {
            //单签
            char space = arr[i];
            //如果上一个相同
            if (last == space) {
                //判断
                if (space == '0') {
                    //记录
                    zeroHit++;
                } else {
                    //记录
                    oneHit++;
                }
                //本轮过
                continue;
            }
            //更新上一个
            last = space;
            //如果是0
            if (space == '0') {
                //更新最大
                oneMax = Math.max(oneHit, oneMax);
                //重置
                oneHit = 0;
                //记录第一个
                zeroHit = 1;
            } else {
                //更新最大
                zeroMax = Math.max(zeroHit, zeroMax);
                //重置
                zeroHit = 0;
                //记录第一个
                oneHit = 1;
            }
        }
        //判断结果
        return Math.max(oneMax, oneHit) > Math.max(zeroMax, zeroHit);
    }

    public static void main(String[] args) {
        System.out.println(new Code15().checkZeroOnes("111000"));
    }

}
