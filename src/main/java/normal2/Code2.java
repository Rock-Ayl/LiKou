package normal2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-04-03
 * 面试题 16.20. T9键盘
 * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 * 示例 2:
 * <p>
 * 输入: num = "2", words = ["a", "b", "c", "d"]
 * 输出: ["a", "b", "c"]
 * 提示：
 * <p>
 * num.length <= 1000
 * words.length <= 500
 * words[i].length == num.length
 * num中不会出现 0, 1 这两个数字
 */
public class Code2 {

    public static List<String> getValidT9Words(String num, String[] words) {
        //单词对应缓存
        HashMap<Character, Integer> map = new HashMap<>();
        //开始组装按键
        map.put('a', 2);
        map.put('b', 2);
        map.put('c', 2);
        map.put('d', 3);
        map.put('e', 3);
        map.put('f', 3);
        map.put('g', 4);
        map.put('h', 4);
        map.put('i', 4);
        map.put('j', 5);
        map.put('k', 5);
        map.put('l', 5);
        map.put('m', 6);
        map.put('n', 6);
        map.put('o', 6);
        map.put('p', 7);
        map.put('q', 7);
        map.put('r', 7);
        map.put('s', 7);
        map.put('t', 8);
        map.put('u', 8);
        map.put('v', 8);
        map.put('w', 9);
        map.put('x', 9);
        map.put('y', 9);
        map.put('z', 9);
        //初始化结果
        List<String> result = new ArrayList<>();
        //循环
        for (String word : words) {
            //如果长度不一
            if (word.length() != num.length()) {
                //下一个
                continue;
            }
            //单词字符
            StringBuffer wordNum = new StringBuffer();
            //循环
            for (int i = 0; i < word.length(); i++) {
                //当前字符转化为num,并组装
                wordNum.append(map.get(word.charAt(i)));
            }
            //如果是结果
            if (wordNum.toString().equals(num)) {
                //组装
                result.add(word);
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getValidT9Words("8733", new String[]{"tree", "used"}));
    }
}
