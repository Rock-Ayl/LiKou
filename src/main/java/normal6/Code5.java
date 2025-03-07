package normal6;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-08-12
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
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
 */
public class Code5 {

    //全局
    int[] candidates;
    int target;
    //结果集
    List<List<Integer>> result = new ArrayList<>();
    //去重
    Set<List<Integer>> set = new HashSet<>();

    public void dfs(int p, int sum, List<Integer> list) {
        //循环
        for (int i = p; i < candidates.length; i++) {
            //当前
            int num = candidates[i];
            //当前和
            int thisSum = sum + num;
            //记录
            list.add(num);
            //如果存在
            if (set.contains(list)) {
                //回溯
                list.remove(list.size() - 1);
                //结束本次
                continue;
            }
            //记录
            set.add(new ArrayList<>(list));
            //如果是结果
            if (thisSum == target) {
                //记录
                result.add(new ArrayList<>(list));
                //回溯
                list.remove(list.size() - 1);
                //结束本次
                break;
            } else if (thisSum > target) {
                //回溯
                list.remove(list.size() - 1);
                //结束
                break;
            } else {
                //不断计算
                dfs(i + 1, thisSum, list);
                //回溯
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //全局
        this.candidates = candidates;
        this.target = target;
        //排序
        Arrays.sort(this.candidates);
        //不断计算
        dfs(0, 0, new ArrayList<>());
        //返回
        return this.result;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

}
