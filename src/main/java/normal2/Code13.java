package normal2;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-04-15
 * 524. 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 * 示例 2:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * 输出:
 * "a"
 */
public class Code13 {

    public String findLongestWord(String s, List<String> dictionary) {
        //排个序
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //对比长度
                int min = o2.length() - o1.length();
                //同长度
                if (min == 0) {
                    //字典顺序正序
                    return o1.compareTo(o2);
                }
                //倒叙
                return min;
            }
        });
        //缓存
        Stack<Character> stack = new Stack<>();
        //循环
        for (int i = s.length() - 1; i >= 0; i--) {
            //记录
            stack.add(s.charAt(i));
        }
        next:
        //循环
        for (String word : dictionary) {
            //如果长度越界
            if (word.length() > s.length()) {
                //终止
                continue next;
            }
            //如果长度相同
            if (word.length() == s.length()) {
                //如果完全一致
                if (word.equals(s)) {
                    //返回
                    return word;
                }
            }
            //新缓存
            Stack<Character> newStack = new Stack<>();
            //加载所有
            newStack.addAll(stack);
            //上一次的长度
            int lastP = stack.size() - 1;
            nextTwo:
            //循环
            for (int i = 0; i < word.length(); i++) {
                //获取字符
                char x = word.charAt(i);
                //循环
                while (lastP >= 0) {
                    //如果是这个字符
                    if (newStack.get(lastP) == x) {
                        //如果是最后一个了
                        if (i == word.length() - 1) {
                            //返回结果
                            return word;
                        }
                        //递减
                        lastP--;
                        //下一个
                        continue nextTwo;
                    } else {
                        //递减
                        lastP--;
                    }
                }
            }
        }
        //默认
        return "";
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(new Code13().findLongestWord("abpcplea", list));
    }
}
