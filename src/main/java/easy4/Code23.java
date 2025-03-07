package easy4;

import java.util.*;

/**
 * Created By Rock-Ayl on 2020-12-28
 * <p>
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * American keyboard
 * <p>
 * 示例：
 * <p>
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 */
public class Code23 {

    public static String[] findWords(String[] words) {
        //上
        Set<Character> top = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        //中
        Set<Character> mid = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        //下
        Set<Character> under = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        //初始化
        List<String> list = new ArrayList<>();
        io:
        //循环
        for (String word : words) {
            //转化为组
            char[] wordChars = word.toLowerCase().toCharArray();
            //当前单词使用set
            Set<Character> thisSet;
            //第一个单词
            Character first = wordChars[0];
            //判断
            if (top.contains(first)) {
                //使用上
                thisSet = top;
            } else if (mid.contains(first)) {
                //使用中
                thisSet = mid;
            } else {
                //使用下
                thisSet = under;
            }
            //循环
            for (int i = 1; i < wordChars.length; i++) {
                //如果不存在
                if (!thisSet.contains(wordChars[i])) {
                    //中断
                    continue io;
                }
            }
            //记录合格的
            list.add(word);
        }
        //转化并返回
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        for (String word : findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})) {
            System.out.println(word);
        }
    }
}
