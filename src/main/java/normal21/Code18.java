package normal21;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-07-12
 * 剑指 Offer II 081. 允许重复选择元素的组合
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 示例 4：
 * <p>
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * 示例 5：
 * <p>
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * <p>
 * <p>
 * 注意：本题与主站 39 题相同： https://leetcode-cn.com/problems/combination-sum/
 */
public class Code18 {

    //结果列表
    private List<List<Integer>> result = new LinkedList<>();

    //递归不断走
    public void next(int[] candidates, int target, int sum, int p, LinkedList<Integer> list) {
        //循环
        for (int i = p; i < candidates.length; i++) {
            //当前数字
            int num = candidates[i];
            //下一个和
            int nextSum = sum + num;
            //如果超过目标了
            if (nextSum > target) {
                //直接跳出即可
                break;
            }
            //加入结果集
            list.add(num);
            //如果是目标了
            if (target == nextSum) {
                //复制,记录结果
                result.add(new LinkedList<>(list));
            } else {
                //递归
                next(candidates, target, nextSum, i, list);
            }
            //回溯
            list.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //先排序
        Arrays.sort(candidates);
        //递归实现
        next(candidates, target, 0, 0, new LinkedList<>());
        //返回结果
        return this.result;
    }

    public static void main(String[] args) {
        new Code18().combinationSum(new int[]{2, 3, 5}, 8);
    }

}