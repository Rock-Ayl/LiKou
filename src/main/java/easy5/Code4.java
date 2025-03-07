package easy5;

/**
 * Created By Rock-Ayl on 2021-01-03
 * 1668. 最大重复子字符串
 * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 * <p>
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * 示例 2：
 * <p>
 * 输入：sequence = "ababc", word = "ba"
 * 输出：1
 * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 * 示例 3：
 * <p>
 * 输入：sequence = "ababc", word = "ac"
 * 输出：0
 * 解释："ac" 不是 "ababc" 的子字符串。
 */
public class Code4 {

    public static int maxRepeating(String sequence, String word) {
        //最大连击次数
        int max = 0;
        //当前连击次数
        int thisTime = 0;
        //获取单词char[]
        char[] wordCharArr = word.toCharArray();
        //单词读取位置
        int p = 0;
        //上一个位置
        int last = 0;
        //是否存在上一个
        boolean isLast = false;
        //当前单词
        char thisWordChar = wordCharArr[p];
        //整条转化为char[]
        char[] sequenceCharArr = sequence.toCharArray();
        //循环
        for (int i = 0; i < sequenceCharArr.length; i++) {
            //当前字符
            char c = sequenceCharArr[i];
            //如果当前字符满足当前要求单词字符
            if (c == thisWordChar) {
                //记录下来初始位置
                if (last == 0 && thisTime == 0) {
                    //当前位置
                    last = i;
                    //存在last
                    isLast = true;
                }
                //如果已经满足了整个单词的条件
                if (p == wordCharArr.length - 1) {
                    //连击次数叠加
                    thisTime++;
                    //单词位置初始化
                    p = 0;
                }
                //如果还未满足单词的条件
                else {
                    //单词位置+1
                    p++;
                }
            }
            //如果未满足单词条件
            else {
                //清算当前次数
                max = Math.max(max, thisTime);
                //重置当前次数
                thisTime = 0;
                //重置单词读取位置
                p = 0;
                //如果存在上一个位置
                if (isLast) {
                    //回归
                    i = last;
                    //重置
                    last = 0;
                    //重置
                    isLast = false;
                }
            }
            //重置新单词
            thisWordChar = wordCharArr[p];
        }
        //返回
        return Math.max(max, thisTime);
    }

    public static void main(String[] args) {
        System.out.println(maxRepeating("bbaa", "ba"));
    }
}
