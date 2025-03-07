package normal4;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created By Rock-Ayl on 2021-05-21
 * 1079. 活字印刷
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 * <p>
 * 输入："AAABBC"
 * 输出：188
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 */
public class Code7 {

    //结果
    Set<String> set = new HashSet<>();

    public void set(Stack<Character> stack, StringBuilder str) {
        //记录结果
        set.add(str.toString());
        //如果完事了
        if (stack.size() == 0) {
            //结束
            return;
        }
        //循环
        for (int i = 0; i < stack.size(); i++) {
            //当前
            char thisChar = stack.get(i);
            //删除
            stack.remove(i);
            //组装
            str.append(thisChar);
            //下一级
            set(stack, str);
            //回溯
            stack.add(i, thisChar);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public int numTilePossibilities(String tiles) {
        //栈
        Stack<Character> stack = new Stack<>();
        //循环
        for (char c : tiles.toCharArray()) {
            //组装
            stack.add(c);
        }
        //不断组装
        set(stack, new StringBuilder());
        //返回结果
        return set.size() - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().numTilePossibilities("AAABBC"));
    }

}
