package normal17;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-11-13
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class Code8 {

    //结果
    private Set<List<Integer>> result = new HashSet<>();

    //数组
    private int[] arr;

    //走下去
    public void next(int p, List<Integer> list) {
        //当前
        int num = arr[p];
        //组装
        list.add(num);
        //如果不存在
        if (result.contains(list) == false) {
            //记录结果
            result.add(new ArrayList<>(list));
        } else {
            //存在则结束
            return;
        }
        //循环
        for (int i = p + 1; i < arr.length; i++) {
            //继续走下去
            next(i, list);
        }
        //统一回溯
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先排序
        Arrays.sort(nums);
        //记录
        this.arr = nums;
        //默认结果
        result.add(new ArrayList<>());
        //循环
        for (int i = 0; i < arr.length; i++) {
            //走下去
            next(i, new ArrayList<>());
        }
        //返回结果
        return result.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new Code8().subsetsWithDup(new int[]{1, 2, 2}));
    }

}
