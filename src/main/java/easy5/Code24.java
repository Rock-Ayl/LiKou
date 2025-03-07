package easy5;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-01-24
 * 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 * 示例 1：
 * <p>
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * <p>
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * <p>
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * 提示：
 * <p>
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S 中不包含 \ or "
 */
public class Code24 {

    /**
     * 推荐，用栈解决
     *
     * @param S
     * @return
     */
    public static String star(String S) {
        //用栈
        Stack<Character> letters = new Stack();
        for (char c : S.toCharArray())
            //如果是字符
            if (Character.isLetter(c))
                //记录
                letters.push(c);
        StringBuilder ans = new StringBuilder();
        for (char c : S.toCharArray()) {
            //如果当前位置是字符
            if (Character.isLetter(c))
                //移除栈底并返回
                ans.append(letters.pop());
            else
                //使用当前
                ans.append(c);
        }
        //返回
        return ans.toString();
    }

    public static String reverseOnlyLetters(String S) {
        //排序缓存
        LinkedHashMap<Integer, Boolean> sort = new LinkedHashMap<>();
        //字符列表
        List<Character> letterList = new ArrayList<>();
        //其他符号列表
        List<Character> anotherList = new ArrayList<>();
        //循环
        for (int i = 0; i < S.toCharArray().length; i++) {
            //当前字符
            char letter = S.charAt(i);
            //如果是大小写字符
            if ((letter >= 97 && letter <= 122) || letter >= 65 && letter <= 90) {
                //记录当前位置是字符
                sort.put(i, true);
                //记录字符
                letterList.add(letter);
            } else {
                //记录当前位置是其他符号
                sort.put(i, false);
                //记录其他符号
                anotherList.add(letter);
            }
        }
        //翻转
        Collections.reverse(letterList);
        //初始化返回句子
        StringBuffer sentence = new StringBuffer();
        //字符位置
        int lp = 0;
        //符号位置
        int ap = 0;
        //循环
        for (Map.Entry<Integer, Boolean> entry : sort.entrySet()) {
            //如果当前位置是字符
            if (entry.getValue()) {
                //从字符中抽取
                sentence.append(letterList.get(lp++));
            } else {
                //从符号中抽取
                sentence.append(anotherList.get(ap++));
            }
        }
        //返回
        return sentence.toString();
    }

    public static void main(String[] args) {
        System.out.println(star("Test1ng-Leet=code-Q!"));
    }
}
