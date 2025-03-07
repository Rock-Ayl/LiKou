package normal22;

import java.util.*;

/**
 * @Author ayl
 * @Date 2023-07-26
 * 2785. 将字符串中的元音字母排序
 * 给你一个下标从 0 开始的字符串 s ，将 s 中的元素重新 排列 得到新的字符串 t ，它满足：
 * <p>
 * 所有辅音字母都在原来的位置上。更正式的，如果满足 0 <= i < s.length 的下标 i 处的 s[i] 是个辅音字母，那么 t[i] = s[i] 。
 * 元音字母都必须以他们的 ASCII 值按 非递减 顺序排列。更正式的，对于满足 0 <= i < j < s.length 的下标 i 和 j  ，如果 s[i] 和 s[j] 都是元音字母，那么 t[i] 的 ASCII 值不能大于 t[j] 的 ASCII 值。
 * 请你返回结果字母串。
 * <p>
 * 元音字母为 'a' ，'e' ，'i' ，'o' 和 'u' ，它们可能是小写字母也可能是大写字母，辅音字母是除了这 5 个字母以外的所有字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "lEetcOde"
 * 输出："lEOtcede"
 * 解释：'E' ，'O' 和 'e' 是 s 中的元音字母，'l' ，'t' ，'c' 和 'd' 是所有的辅音。将元音字母按照 ASCII 值排序，辅音字母留在原地。
 * 示例 2：
 * <p>
 * 输入：s = "lYmpH"
 * 输出："lYmpH"
 * 解释：s 中没有元音字母（s 中都为辅音字母），所以我们返回 "lYmpH" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含英语字母表中的 大写 和 小写 字母。
 */
public class Code11 {

    public String sortVowels(String s) {
        //元音缓存,按照排序载入
        LinkedHashSet<Character> cacheSet = new LinkedHashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        //存在的元音数量
        Map<Character, Integer> countMap = new HashMap<>();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前
            Character space = s.charAt(i);
            //如果不是元音
            if (cacheSet.contains(space) == false) {
                //本轮过
                continue;
            }
            //记录该元音数量
            countMap.put(space, countMap.getOrDefault(space, 0) + 1);
        }
        //元音顺位迭代器
        Iterator<Character> cacheSetIterator = cacheSet.iterator();
        //当前节点
        Character node = cacheSetIterator.next();
        //初始化结果
        StringBuilder str = new StringBuilder();
        //循环2
        for (int i = 0; i < s.length(); i++) {
            //当前
            Character space = s.charAt(i);
            //如果不是元音
            if (cacheSet.contains(space) == false) {
                //组装
                str.append(space);
                //本轮过
                continue;
            }
            //获取顺位优先最高的
            int count = countMap.getOrDefault(node, 0);
            //循环
            while (count == 0) {
                //下一个
                node = cacheSetIterator.next();
                //获取下一个
                count = countMap.getOrDefault(node, 0);
            }
            //组装本次
            str.append(node);
            //删除数量
            countMap.put(node, count - 1);
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code11().sortVowels("lEetcOde"));
    }

}
