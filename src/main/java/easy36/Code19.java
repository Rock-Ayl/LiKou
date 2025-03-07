package easy36;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-03-31
 * 3090. 每个字符最多出现两次的最长子字符串
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该
 * 子字符串
 * 的 最大 长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "bcbbbcba"
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 以下子字符串长度为 4，并且每个字符最多出现两次："bcbbbcba"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "aaaa"
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 以下子字符串长度为 2，并且每个字符最多出现两次："aaaa"。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 100
 * s 仅由小写英文字母组成。
 */
public class Code19 {

    public int maximumLengthSubstring(String s) {
        //最大长度
        int maxLength = 0;
        //缓存
        Map<Character, Integer> cacheMap = new HashMap<>();
        //队列
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
        //循环
        for (char letter : s.toCharArray()) {
            //加入
            arrayDeque.addLast(letter);
            cacheMap.put(letter, cacheMap.getOrDefault(letter, 0) + 1);
            //如果太多
            while (cacheMap.get(letter) > 2) {
                //删除最后一个
                Character last = arrayDeque.pollFirst();
                cacheMap.put(last, cacheMap.getOrDefault(last, 0) - 1);
            }
            //刷新最大情况
            maxLength = Math.max(arrayDeque.size(), maxLength);
        }
        //返回
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().maximumLengthSubstring("bcbbbcba"));
    }

}
