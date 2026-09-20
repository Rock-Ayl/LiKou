package normal57;

/**
 * 1653. 使字符串平衡的最少删除次数
 * 算术评级: 5
 * 第 39 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1794
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
 * <p>
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 * <p>
 * 请你返回使 s 平衡 的 最少 删除次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 * <p>
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 要么是 'a' 要么是 'b'​ 。​
 *
 */
public class Code8 {

    public int minimumDeletions(String s) {
        //特殊
        if (s.length() < 2) {
            //过
            return 0;
        }
        //b前缀后
        int[] leftArr = new int[s.length()];
        //初始化第一个
        leftArr[0] = s.charAt(0) == 'b' ? 1 : 0;
        //循环
        for (int i = 1; i < s.length(); i++) {
            //叠加
            leftArr[i] = leftArr[i - 1] + (s.charAt(i) == 'b' ? 1 : 0);
        }
        //如果全是b or 没有b
        if (leftArr[s.length() - 1] == s.length() || leftArr[s.length() - 1] == 0) {
            //过
            return 0;
        }
        //a后缀后
        int[] rightArr = new int[s.length()];
        //初始化第一个
        rightArr[s.length() - 1] = s.charAt(s.length() - 1) == 'a' ? 1 : 0;
        //循环
        for (int i = s.length() - 2; i >= 0; i--) {
            //叠加
            rightArr[i] = rightArr[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }
        //最小情况
        int min = Math.min(leftArr[leftArr.length - 1], rightArr[0]);
        //循环
        for (int i = 0; i < s.length() - 1; i++) {
            //取最小值
            int a = leftArr[i];
            int b = rightArr[i + 1];
            //和
            int sum = a + b;
            //刷新最小
            min = Math.min(sum, min);
        }
        //返回
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().star("aababbab"));
    }

    //动态规划
    public int star(String s) {
        //结果
        int result = 0;
        //b数量
        int count = 0;
        //循环
        for (char c : s.toCharArray()) {
            //如果是b
            if (c == 'b') {
                //+1
                count++;
            } else {
                //刷新最小结果
                result = Math.min(result + 1, count);
            }
        }
        //返回
        return result;
    }


}
