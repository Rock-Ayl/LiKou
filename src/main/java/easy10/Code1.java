package easy10;

import java.util.Stack;

/**
 * @Author 安永亮
 * @Date 2021-07-01
 * @Description 面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class Code1 {

    /**
     * 保证都是一对
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.contains(c)) {
                stack.removeElement(c);
            } else {
                stack.push(c);
            }
        }
        if (stack.size() < 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code1().canPermutePalindrome("aab"));
    }

}
