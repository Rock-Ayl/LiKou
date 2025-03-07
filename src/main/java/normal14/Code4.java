package normal14;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-06-12
 * 187. 重复的DNA序列
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * <p>
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * <p>
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 105
 * s[i]=='A'、'C'、'G' or 'T'
 */
public class Code4 {

    public List<String> findRepeatedDnaSequences(String s) {
        //如果太小
        if (s.length() < 11) {
            //返回
            return new ArrayList<>();
        }
        //初始化
        StringBuilder str = new StringBuilder(s.substring(0, 10));
        //缓存
        Map<String, Integer> map = new HashMap<>();
        //默认count
        map.put(str.toString(), 1);
        //循环
        for (int i = 10; i < s.length(); i++) {
            //当前
            char letter = s.charAt(i);
            //进一位
            str.append(letter);
            //退一位
            str.deleteCharAt(0);
            //转化为key
            String key = str.toString();
            //记录
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        //返回
        return map.entrySet()
                .stream()
                .filter(p -> p.getValue() > 1)
                .map(p -> p.getKey())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> list = new Code4().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println();
    }

}
