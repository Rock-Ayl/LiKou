package normal23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-08-30
 * LCR 085. 括号生成
 * 中等
 * 76
 * 相关企业
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * <p>
 * <p>
 * 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Code14 {

    //结果
    private Set<String> result;

    private void next(StringBuilder str, int n, int hadCount, int leftCount, int rightCount) {
        //如果没有了
        if (hadCount == 0) {
            //记录结果
            result.add(str.toString());
            //过
            return;
        }
        //如果可以加(
        if (leftCount < n) {
            //加入
            str.append('(');
            //递归
            next(str, n, hadCount - 1, leftCount + 1, rightCount);
            //回溯
            str.deleteCharAt(str.length() - 1);
        }
        //如果可以加)
        if (leftCount > rightCount) {
            //加入
            str.append(')');
            //递归
            next(str, n, hadCount - 1, leftCount, rightCount + 1);
            //回溯
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        //初始化
        this.result = new HashSet<>();
        //递归
        next(new StringBuilder(), n, n * 2, 0, 0);
        //返回结果
        return new ArrayList<>(this.result);
    }

    public static void main(String[] args) {
        System.out.println(new Code14().generateParenthesis(8).toString());
    }

}
