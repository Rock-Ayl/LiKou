package normal44;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-07-05
 * 1061. 按字典序排列最小的等效字符串
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给出长度相同的两个字符串s1 和 s2 ，还有一个字符串 baseStr 。
 * <p>
 * 其中  s1[i] 和 s2[i]  是一组等价字符。
 * <p>
 * 举个例子，如果 s1 = "abc" 且 s2 = "cde"，那么就有 'a' == 'c', 'b' == 'd', 'c' == 'e'。
 * 等价字符遵循任何等价关系的一般规则：
 * <p>
 * 自反性 ：'a' == 'a'
 * 对称性 ：'a' == 'b' 则必定有 'b' == 'a'
 * 传递性 ：'a' == 'b' 且 'b' == 'c' 就表明 'a' == 'c'
 * 例如， s1 = "abc" 和 s2 = "cde" 的等价信息和之前的例子一样，那么 baseStr = "eed" , "acd" 或 "aab"，这三个字符串都是等价的，而 "aab" 是 baseStr 的按字典序最小的等价字符串
 * <p>
 * 利用 s1 和 s2 的等价信息，找出并返回 baseStr 的按字典序排列最小的等价字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "parker", s2 = "morris", baseStr = "parser"
 * 输出："makkek"
 * 解释：根据 A 和 B 中的等价信息，我们可以将这些字符分为 [m,p], [a,o], [k,r,s], [e,i] 共 4 组。每组中的字符都是等价的，并按字典序排列。所以答案是 "makkek"。
 * 示例 2：
 * <p>
 * 输入：s1 = "hello", s2 = "world", baseStr = "hold"
 * 输出："hdld"
 * 解释：根据 A 和 B 中的等价信息，我们可以将这些字符分为 [h,w], [d,e,o], [l,r] 共 3 组。所以只有 S 中的第二个字符 'o' 变成 'd'，最后答案为 "hdld"。
 * 示例 3：
 * <p>
 * 输入：s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
 * 输出："aauaaaaada"
 * 解释：我们可以把 A 和 B 中的等价字符分为 [a,o,e,r,s,c], [l,p], [g,t] 和 [d,m] 共 4 组，因此 S 中除了 'u' 和 'd' 之外的所有字母都转化成了 'a'，最后答案为 "aauaaaaada"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length, baseStr <= 1000
 * s1.length == s2.length
 * 字符串s1, s2, and baseStr 仅由从 'a' 到 'z' 的小写英文字母组成。
 */
public class Code17 {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        /**
         * 初始化 并查集 分组
         */

        //数组
        char[] groupArr = new char[123];
        //循环
        for (char i = 'a'; i <= 'z'; i++) {
            //记录
            groupArr[i] = i;
        }

        /**
         * 构建分组
         */

        //循环
        for (int i = 0; i < s1.length(); i++) {
            //如果不同
            if (s1.charAt(i) != s2.charAt(i)) {
                //并查集递归
                findAndSet(groupArr, s1.charAt(i), s2.charAt(i));
            }
        }

        /**
         * 彻底完善分组
         */

        //循环
        for (char i = 'a'; i <= 'z'; i++) {
            //如果还不够
            if (groupArr[groupArr[i]] != groupArr[i]) {
                //并查集递归
                findAndSet(groupArr, groupArr[i], i);
            }
        }

        /**
         * 为所有分组选出最小
         */

        //缓存
        Map<Character, Character> minMap = new HashMap<>();
        //循环
        for (char i = 'a'; i <= 'z'; i++) {
            //当前分组
            Character group = groupArr[i];
            //如果存在
            if (minMap.containsKey(group)) {
                //如果更小
                if (i < minMap.get(group)) {
                    //覆盖
                    minMap.put(group, i);
                }
            } else {
                //记录
                minMap.put(group, i);
            }
        }

        /**
         * 返回结果
         */

        //初始化结果
        StringBuilder str = new StringBuilder(baseStr.length());
        //循环
        for (int i = 0; i < baseStr.length(); i++) {
            //转移、组装
            str.append(minMap.get(groupArr[baseStr.charAt(i)]));
        }
        //返回
        return str.toString();
    }

    //并查集递归
    private char findAndSet(char[] groupArr, char left, char right) {
        //主节点
        char root;
        //如果是头结点
        if (groupArr[left] == left) {
            //直接使用
            root = left;
        } else {
            //递归
            root = findAndSet(groupArr, groupArr[left], left);
        }
        //如果右边也不是头结点
        if (groupArr[right] != right) {
            //递归
            findAndSet(groupArr, root, groupArr[right]);
        }
        //记录分组信息
        groupArr[right] = root;
        //返回
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().smallestEquivalentString("adbfgjdi", "bccgheej", "abcdefgheij"));
    }

}
