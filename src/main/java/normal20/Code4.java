package normal20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-04-26
 * 剑指 Offer II 080. 含有 k 个元素的组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: [[1]]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * <p>
 * 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/
 */
public class Code4 {

    //结果
    private List<List<Integer>> result = new ArrayList<>();
    //缓存
    private int n;
    private int k;

    private void next(LinkedList<Integer> list, int p) {
        //如果到头了
        if (list.size() == k) {
            //记录结果
            result.add(new ArrayList<>(list));
            //过
            return;
        }
        //循环
        for (int i = p; i <= n; i++) {
            //记录
            list.addLast(i);
            //走下去
            next(list, i + 1);
            //回溯
            list.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        //记录缓存
        this.n = n;
        this.k = k;
        //回溯递归实现
        next(new LinkedList<>(), 1);
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code4().combine(4, 2);
    }

}
