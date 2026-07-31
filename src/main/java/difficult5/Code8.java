package difficult5;

/**
 * 899. 有序队列
 * 算术评级: 7
 * 第 100 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2097
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 * <p>
 * 返回 在应用上述步骤的任意数量的移动后，字典序最小的字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cba", k = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * 示例 2：
 * <p>
 * 输入：s = "baaca", k = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= s.length <= 1000
 * s 只由小写字母组成。
 */
public class Code8 {

    public String orderlyQueue(String s, int k) {
        //判断 one or two
        return k == 1 ? one(s) : two(s);
    }

    //实现1
    private String one(String word) {
        //最小字符串,默认是自己
        String minStr = word;
        //允许交换次数
        int count = word.length() - 1;
        //不断交换
        StringBuilder changeStr = new StringBuilder(word);
        //循环
        while (count-- > 0) {
            //获取首字母
            char first = changeStr.charAt(0);
            //删除开始
            changeStr.deleteCharAt(0);
            //添加到末尾
            changeStr.append(first);
            //如果更小
            if (isMin(minStr, changeStr)) {
                //覆盖
                minStr = changeStr.toString();
            }
        }
        //返回
        return minStr;
    }

    //判断是否更小
    private boolean isMin(String word, StringBuilder str) {
        //先这么写
        return word.compareTo(str.toString()) > 0;
    }

    //实现2 直接返回最小顺序
    private String two(String word) {
        //数组
        int[] arr = new int[26];
        //循环
        for (int i = 0; i < word.length(); i++) {
            //记录
            arr[word.charAt(i) - 'a']++;
        }
        //字符串
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < 26; i++) {
            //当前字符
            char c = (char) (i + 'a');
            //如果还有
            while (arr[i]-- > 0) {
                //组装
                str.append(c);
            }
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {

    }

}
