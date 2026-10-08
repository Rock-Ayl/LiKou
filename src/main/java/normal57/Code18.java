package normal57;

/**
 * 1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
 * 算术评级: 5
 * 第 24 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1576
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一个 「开心字符串」定义为：
 * <p>
 * 仅包含小写字母 ['a', 'b', 'c'].
 * 对所有在 1 到 s.length - 1 之间的 i ，满足 s[i] != s[i + 1] （字符串的下标从 1 开始）。
 * 比方说，字符串 "abc"，"ac"，"b" 和 "abcbabcbcb" 都是开心字符串，但是 "aa"，"baa" 和 "ababbc" 都不是开心字符串。
 * <p>
 * 给你两个整数 n 和 k ，你需要将长度为 n 的所有开心字符串按字典序排序。
 * <p>
 * 请你返回排序后的第 k 个开心字符串，如果长度为 n 的开心字符串少于 k 个，那么请你返回 空字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, k = 3
 * 输出："c"
 * 解释：列表 ["a", "b", "c"] 包含了所有长度为 1 的开心字符串。按照字典序排序后第三个字符串为 "c" 。
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 4
 * 输出：""
 * 解释：长度为 1 的开心字符串只有 3 个。
 * 示例 3：
 * <p>
 * 输入：n = 3, k = 9
 * 输出："cab"
 * 解释：长度为 3 的开心字符串总共有 12 个 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"] 。第 9 个字符串为 "cab"
 * 示例 4：
 * <p>
 * 输入：n = 2, k = 7
 * 输出：""
 * 示例 5：
 * <p>
 * 输入：n = 10, k = 100
 * 输出："abacbabacb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10
 * 1 <= k <= 100
 *
 *
 *
 */
public class Code18 {

    public String getHappyString(int n, int k) {
        //总可能数
        int maxCount = maxCount(n);
        //如果超了
        if (k > maxCount) {
            //返回
            return "";
        }
        //特殊情况
        if (n == 1) {
            //返回
            return String.valueOf((char) ('a' + k - 1));
        }
        //a开头截至
        int aEnd = maxCount / 3;
        //如果是a
        if (k <= aEnd) {
            //构建结果a开头
            return build(new StringBuilder("a"), n, k, 1, aEnd);
        }
        //b开头截至
        int bEnd = aEnd * 2;
        //如果是b
        if (k <= bEnd) {
            //构建结果b开头
            return build(new StringBuilder("b"), n, k, aEnd + 1, bEnd);
        }
        //构建结果c开头
        return build(new StringBuilder("c"), n, k, bEnd + 1, maxCount);
    }

    //构建字符串并返回
    private String build(StringBuilder str, int n, int k, int start, int end) {
        //如果长度到了
        if (str.length() == n) {
            //返回
            return str.toString();
        }
        //计算本次中间位置
        int mid = (end - start) / 2 + start;
        //判断是左边还是右边
        boolean left = k <= mid;
        //上一个字符
        char lastLetter = str.charAt(str.length() - 1);
        //根据上一个字符处理
        switch (lastLetter) {
            case 'a':
                //如果左边
                if (left) {
                    //添加b
                    str.append('b');
                } else {
                    //添加c
                    str.append('c');
                }
                break;
            case 'b':
                //如果左边
                if (left) {
                    //添加a
                    str.append('a');
                } else {
                    //添加c
                    str.append('c');
                }
                break;
            case 'c':
                //如果左边
                if (left) {
                    //添加a
                    str.append('a');
                } else {
                    //添加b
                    str.append('b');
                }
                break;
            default:
                break;
        }
        //判断左右
        if (left) {
            //返回
            return build(str, n, k, start, mid);
        } else {
            //返回
            return build(str, n, k, mid + 1, end);
        }
    }

    //计算总可能数量
    private int maxCount(int n) {
        //默认n=1
        int count = 3;
        //循环
        while (n-- > 1) {
            //翻倍
            count *= 2;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        //abacbabacb
        String happyString = new Code18().getHappyString(10, 100);
        System.out.println();
    }

}
