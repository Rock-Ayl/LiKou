package normal3;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-05-12
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class Code19 {

    //全局
    int[] candidates;
    int target;
    //结果
    List<List<Integer>> result = new ArrayList<>();
    //已存在的缓存
    Set<List<Integer>> set = new HashSet<>();

    public void add(int num, List<Integer> list) {
        //循环
        for (Integer integer : candidates) {
            //当前和
            int thisNum = integer + num;
            //如果越界了
            if (thisNum > target) {
                //结束
                return;
            }
            //组装
            list.add(integer);
            //如果是目标了
            if (thisNum == target) {
                //新对象
                List<Integer> newList = new ArrayList<>(list);
                //排个序
                Collections.sort(newList);
                //记录
                set.add(newList);
                //回溯
                list.remove(list.size() - 1);
                //结束
                return;
            } else {
                //下一步
                add(thisNum, list);
                //回溯
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //全局
        this.candidates = candidates;
        this.target = target;
        //排个序
        Arrays.sort(this.candidates);
        //不断组装
        add(0, new ArrayList<>());
        //如果有结果
        if (set.size() > 0) {
            //循环
            for (List<Integer> list : set) {
                //组装
                result.add(list);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (List<Integer> list : new Code19().combinationSum(new int[]{2, 3, 5}, 8)) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

}
