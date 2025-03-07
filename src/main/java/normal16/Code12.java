package normal16;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-09-06
 * 318. 最大单词长度乘积
 * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出：16
 * 解释：这两个单词为 "abcw", "xtfn"。
 * 示例 2：
 * <p>
 * 输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出：4
 * 解释：这两个单词为 "ab", "cd"。
 * 示例 3：
 * <p>
 * 输入：words = ["a","aa","aaa","aaaa"]
 * 输出：0
 * 解释：不存在这样的两个单词。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 */
public class Code12 {

    public int maxProduct(String[] words) {
        //缓存
        Map<String, List<Character>> map = new HashMap<>(words.length);
        //最大结果
        int max = 0;
        //循环1
        for (int i = 0; i < words.length; i++) {
            //当前左
            String left = words[i];
            //循环2
            for (int j = i + 1; j < words.length; j++) {
                //当前右
                String right = words[j];
                //当前可能的结果
                int thisNum = left.length() * right.length();
                //如果当前比最大值还大 同时 对比是否可以乘
                if (thisNum > max && can(map, left, right)) {
                    //刷新最大结果
                    max = thisNum;
                }

            }
        }
        //返回
        return max;
    }

    //判断是否没有共同char
    private boolean can(Map<String, List<Character>> map, String leftKey, String rightKey) {
        //左右
        List<Character> left;
        List<Character> right;
        //如果有
        if (map.containsKey(leftKey)) {
            //直接用
            left = map.get(leftKey);
        } else {
            //初始化
            left = initWord(leftKey);
            //记录
            map.put(leftKey, left);
        }
        //如果有
        if (map.containsKey(rightKey)) {
            //直接用
            right = map.get(rightKey);
        } else {
            //初始化
            right = initWord(rightKey);
            //记录
            map.put(rightKey, right);
        }
        //双指针
        int leftP = 0, rightP = 0;
        //一直走到二者有头
        while (true) {
            //获取左右
            char x = left.get(leftP);
            char y = right.get(rightP);
            //如果相等了
            if (x > y) {
                //进位,判断
                if (++rightP == right.size()) {
                    //直接返回可以
                    return true;
                }
            } else if (x < y) {
                //进位,判断
                if (++leftP == left.size()) {
                    //直接返回可以
                    return true;
                }
            } else {
                //直接失败
                return false;
            }
        }
    }

    //初始化记录单词列表
    private List<Character> initWord(String word) {
        //set集合
        Set<Character> set = new HashSet<>();
        //循环
        for (char c : word.toCharArray()) {
            //记录
            set.add(c);
        }
        //排序,转化为list,并返回
        return set.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new Code12().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }

}
