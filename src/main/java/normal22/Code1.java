package normal22;

import java.util.*;

/**
 * @Author ayl
 * @Date 2023-07-13
 * 剑指 Offer II 082. 含有重复元素集合的组合
 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * <p>
 * <p>
 * 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class Code1 {

    //结果列表
    private Set<List<Integer>> result = new HashSet<>();

    //递归实现
    private void next(int[] candidates, int target, LinkedList<Integer> list, int p, int sum) {
        //如果越界
        if (p >= candidates.length) {
            //过
            return;
        }
        //循环
        for (int i = p; i < candidates.length; i++) {
            //当前数字
            int candidate = candidates[i];
            //下一个和
            int nextSum = sum + candidate;
            //如果大于目标了
            if (nextSum > target) {
                //直接结束
                return;
            }
            //记录当前值
            list.addLast(candidate);
            //如果是目标
            if (nextSum == target) {
                //组装结果
                result.add(new LinkedList<>(list));
                //回溯
                list.removeLast();
                //跳出
                return;
            }
            //递归
            next(candidates, target, list, i + 1, nextSum);
            //回溯
            list.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        //递归
        next(candidates, target, new LinkedList<>(), 0, 0);
        //返回结果
        return new ArrayList<>(this.result);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Code1().combinationSum2(new int[]{1, 1, 2, 5, 6, 7}, 8);
        System.out.println();
    }

}
