package normal23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-08-29
 * 22. 括号生成
 * 中等
 * 3.4K
 * 相关企业
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
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
 */
public class Code13 {

    //结果集合
    private Set<String> result;

    /**
     * 递归实现
     *
     * @param str        当前拼接的字符串
     * @param n          单边 ( or ) 的最大数量
     * @param addCount   剩余可加入()的数量,到0时彻底结束递归
     * @param leftCount  (的总数,不可超过n
     * @param rightCount )的总数,补课超过n
     */
    private void next(StringBuilder str, int n, int addCount, int leftCount, int rightCount) {
        //如果结束了
        if (addCount == 0) {
            //记录结果
            this.result.add(str.toString());
            //过
            return;
        }
        //如果可以继续插入(
        if (leftCount < n) {
            //加入
            str.append('(');
            //继续递归
            next(str, n, addCount - 1, leftCount + 1, rightCount);
            //回溯
            str.deleteCharAt(str.length() - 1);
        }
        //如果可以继续插入)
        if (leftCount > rightCount) {
            //加入
            str.append(')');
            //继续递归
            next(str, n, addCount - 1, leftCount, rightCount + 1);
            //回溯
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        //初始化结果
        this.result = new HashSet<>();
        //递归
        next(new StringBuilder(), n, n * 2, 0, 0);
        //返回结果
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(new Code13().generateParenthesis(3));
    }

}
