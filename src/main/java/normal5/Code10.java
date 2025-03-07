package normal5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-07-26
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Code10 {

    int maxSize;
    //目标
    int target;
    //结果
    List<List<Integer>> result = new ArrayList<>();

    public void dfs(List<Integer> list, List<Integer> nums, int sum) {
        //如果满了
        if (nums.size() == maxSize) {
            //如果正好是目标
            if (sum == target) {
                //复制
                List<Integer> newList = new ArrayList<>(nums);
                //排个序
                Collections.sort(newList);
                //如果不存在
                if (!result.contains(newList)) {
                    //记录结果
                    result.add(newList);
                }
            }
            //否则终止
            return;
        }
        //循环
        for (int i = 0; i < list.size(); i++) {
            //当前
            int num = list.get(i);
            //如果超了
            if (num + sum > target) {
                //结束
                return;
            }
            //组装
            nums.add(num);
            //删除
            list.remove(i);
            //dfs
            dfs(list, nums, num + sum);
            //回溯
            nums.remove(nums.size() - 1);
            list.add(i, num);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        //记录目标,最大组
        this.target = n;
        this.maxSize = k;
        //最大的数
        int max = Math.min(9, this.target);
        //初始化stack
        List<Integer> list = new ArrayList<>(max);
        //指针
        int i = 0;
        //循环
        while (i < max) {
            //组装
            list.add(++i);
        }
        //下一步
        dfs(list, new ArrayList<>(k), 0);
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (List<Integer> list : new Code10().combinationSum3(3, 7)) {
            System.out.print("[");
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

}
