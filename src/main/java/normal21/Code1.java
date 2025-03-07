package normal21;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-05-30
 * <p>
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Code1 {

    //结果
    private List<String> result = new ArrayList<>();

    //走下去
    private void next(StringBuilder str, int left, int right, int mid, int n, int target) {
        //如果长度到头了
        if (str.length() == target) {
            //如果是平衡的结果
            if (mid == 0) {
                //记录结果
                result.add(str.toString());
            }
            //过
            return;
        }
        //如果可以左边
        if (left < n) {
            //记录
            str.append("(");
            //走下去
            next(str, left + 1, right, mid + 1, n, target);
            //回溯
            str.deleteCharAt(str.length() - 1);
        }
        //如果可以右边
        if (right < n && mid > 0) {
            //记录
            str.append(")");
            //走下去
            next(str, left, right + 1, mid - 1, n, target);
            //回溯
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        //初始化
        StringBuilder str = new StringBuilder();
        //走下去
        next(str, 0, 0, 0, n, n * 2);
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        new Code1().generateParenthesis(3);
    }

}
