package easy42;

/**
 * 100959. 统计残差前缀
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个仅由小写英文字母组成的字符串 s。
 * <p>
 * 如果字符串 s 的某个 前缀 中 不同字符的数量 等于 len(prefix) % 3，则该前缀被称为残差前缀（residue）。
 * <p>
 * 返回字符串 s 中 残差前缀 的数量。
 * <p>
 * 字符串的 前缀 是一个 非空子字符串，从字符串的开头起始并延伸到任意位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abc"
 * <p>
 * 输出: 2
 * <p>
 * 解释:​​​​​​​
 * <p>
 * 前缀 "a" 有 1 个不同字符，且长度模 3 为 1，因此它是一个残差前缀。
 * 前缀 "ab" 有 2 个不同字符，且长度模 3 为 2，因此它是一个残差前缀。
 * 前缀 "abc" 不满足条件，因此不是残差前缀。
 * 因此，答案是 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入: s = "dd"
 * <p>
 * 输出: 1
 * <p>
 * 解释:​​​​​​​
 * <p>
 * 前缀 "d" 有 1 个不同字符，且长度模 3 为 1，因此它是一个残差前缀。
 * 前缀 "dd" 有 1 个不同字符，但长度模 3 为 2，因此它不是残差前缀。
 * 因此，答案是 1。
 * <p>
 * 示例 3：
 * <p>
 * 输入: s = "bob"
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * <p>
 * 前缀 "b" 有 1 个不同字符，且长度模 3 为 1，因此它是一个残差前缀。
 * 前缀 "bo" 有 2 个不同字符，且长度模 3 为 2，因此它是一个残差前缀。
 * 前缀 "bob" 不满足条件。
 * 因此，答案是 2。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅包含小写英文字母。
 */
public class Code2 {

    public int residuePrefixes(String s) {
        //缓存
        int[] arr = new int[26];
        //数量
        int count = 0;
        //结果
        int result = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //如果第一次
            if (++arr[s.charAt(i) - 'a'] == 1) {
                //+1
                count++;
            }
            //如果满足
            if (count == (i + 1) % 3) {
                //+1结果
                result++;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().residuePrefixes("abc"));
    }

}
