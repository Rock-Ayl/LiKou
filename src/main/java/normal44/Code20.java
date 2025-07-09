package normal44;

/**
 * @Author ayl
 * @Date 2025-07-09
 * 2182. 构造限制重复的字符串
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
 * <p>
 * 返回 字典序最大的 repeatLimitedString 。
 * <p>
 * 如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，则认为字符串 a 比字符串 b 字典序更大 。如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cczazcc", repeatLimit = 3
 * 输出："zzcccac"
 * 解释：使用 s 中的所有字符来构造 repeatLimitedString "zzcccac"。
 * 字母 'a' 连续出现至多 1 次。
 * 字母 'c' 连续出现至多 3 次。
 * 字母 'z' 连续出现至多 2 次。
 * 因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
 * 该字符串是字典序最大的 repeatLimitedString ，所以返回 "zzcccac" 。
 * 注意，尽管 "zzcccca" 字典序更大，但字母 'c' 连续出现超过 3 次，所以它不是一个有效的 repeatLimitedString 。
 * 示例 2：
 * <p>
 * 输入：s = "aababab", repeatLimit = 2
 * 输出："bbabaa"
 * 解释：
 * 使用 s 中的一些字符来构造 repeatLimitedString "bbabaa"。
 * 字母 'a' 连续出现至多 2 次。
 * 字母 'b' 连续出现至多 2 次。
 * 因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
 * 该字符串是字典序最大的 repeatLimitedString ，所以返回 "bbabaa" 。
 * 注意，尽管 "bbabaaa" 字典序更大，但字母 'a' 连续出现超过 2 次，所以它不是一个有效的 repeatLimitedString 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= repeatLimit <= s.length <= 105
 * s 由小写英文字母组成
 */
public class Code20 {

    public String repeatLimitedString(String s, int repeatLimit) {

        /**
         * 统计
         */

        //字符数量
        int[] arr = new int[26];
        //循环
        for (int i = 0; i < s.length(); i++) {
            //+1
            arr[s.charAt(i) - 'a']++;
        }

        /**
         * 初始化索引
         */

        //最后一个
        int first = arr.length - 1;
        //如果不够
        while (arr[first] == 0) {
            //-1
            first--;
        }

        /**
         * 不断计算结果
         */

        //初始化结果
        StringBuilder result = new StringBuilder();
        //跳出标记
        out:
        //循环
        while (first >= 0) {
            //如果不够
            while (first >= 0 && arr[first] == 0) {
                //-1
                first--;
            }
            //如果没有了
            if (first < 0) {
                //跳出
                break out;
            }
            //如果足够多
            while (arr[first] >= repeatLimit) {
                //字符对应
                char letter = (char) (first + 'a');
                //计算长度
                int length = (result.length() > 0 && result.charAt(result.length() - 1) == letter ? repeatLimit - 1 : repeatLimit);
                //循环
                for (int i = 0; i < length; i++) {
                    //组装
                    result.append(letter);
                }
                //扣减
                arr[first] -= length;
                //下一个
                int next = first - 1;
                //如果不够
                while (next >= 0 && arr[next] == 0) {
                    //-1
                    next--;
                }
                //如果没有了
                if (next < 0) {
                    //跳出
                    break out;
                }
                //-1
                arr[next]--;
                //组装
                result.append((char) (next + 'a'));
            }
            //如果不够多了
            if (arr[first] > 0) {
                //循环
                for (int i = 0; i < arr[first]; i++) {
                    //组装
                    result.append((char) (first + 'a'));
                }
                //扣减
                arr[first] = 0;
                //下一个
                first--;
            }
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code20().repeatLimitedString("aababab", 2));
    }

}
