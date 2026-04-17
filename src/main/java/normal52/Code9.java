package normal52;

/**
 * 2904. 最短且字典序最小的美丽子字符串
 * 算术评级: 2
 * 第 367 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1483
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二进制字符串 s 和一个正整数 k 。
 * <p>
 * 如果 s 的某个子字符串中 1 的个数恰好等于 k ，则称这个子字符串是一个 美丽子字符串 。
 * <p>
 * 令 len 等于 最短 美丽子字符串的长度。
 * <p>
 * 返回长度等于 len 且字典序 最小 的美丽子字符串。如果 s 中不含美丽子字符串，则返回一个 空 字符串。
 * <p>
 * 对于相同长度的两个字符串 a 和 b ，如果在 a 和 b 出现不同的第一个位置上，a 中该位置上的字符严格大于 b 中的对应字符，则认为字符串 a 字典序 大于 字符串 b 。
 * <p>
 * 例如，"abcd" 的字典序大于 "abcc" ，因为两个字符串出现不同的第一个位置对应第四个字符，而 d 大于 c 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "100011001", k = 3
 * 输出："11001"
 * 解释：示例中共有 7 个美丽子字符串：
 * 1. 子字符串 "100011001" 。
 * 2. 子字符串 "100011001" 。
 * 3. 子字符串 "100011001" 。
 * 4. 子字符串 "100011001" 。
 * 5. 子字符串 "100011001" 。
 * 6. 子字符串 "100011001" 。
 * 7. 子字符串 "100011001" 。
 * 最短美丽子字符串的长度是 5 。
 * 长度为 5 且字典序最小的美丽子字符串是子字符串 "11001" 。
 * 示例 2：
 * <p>
 * 输入：s = "1011", k = 2
 * 输出："11"
 * 解释：示例中共有 3 个美丽子字符串：
 * 1. 子字符串 "1011" 。
 * 2. 子字符串 "1011" 。
 * 3. 子字符串 "1011" 。
 * 最短美丽子字符串的长度是 2 。
 * 长度为 2 且字典序最小的美丽子字符串是子字符串 "11" 。
 * 示例 3：
 * <p>
 * 输入：s = "000", k = 1
 * 输出：""
 * 解释：示例中不存在美丽子字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * 1 <= k <= s.length
 */
public class Code9 {

    public String shortestBeautifulSubstring(String s, int k) {
        //双指针
        int left = 0;
        int right = 0;
        //1的数量
        int count = s.charAt(left) - '0';
        //最优字符串
        String str = "";
        //循环
        while (left < s.length()) {

            /**
             * 不断右移
             */

            //循环
            while (count < k && right + 1 < s.length()) {
                //右移
                count += s.charAt(++right) - '0';
            }

            /**
             * 记录本次
             */

            //如果满足
            if (count == k) {
                //拆分
                String thisSpace = s.substring(left, right + 1);
                //如果 初始化 or 更小
                if (str.isEmpty() || thisSpace.length() < str.length()) {
                    //直接记录
                    str = thisSpace;
                }
                //如果相同 and 排序更小
                else if (thisSpace.length() == str.length() && thisSpace.compareTo(str) < 0) {
                    //替换
                    str = thisSpace;
                }
            }

            /**
             * 左移一次
             */

            //下一个
            count -= s.charAt(left++) - '0';

        }
        //返回
        return str;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().shortestBeautifulSubstring("100011001", 3));
    }

}