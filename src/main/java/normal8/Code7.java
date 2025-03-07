package normal8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-09-20
 * 491. 递增子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 */
public class Code7 {

    //组
    int[] arr;
    //结果
    Set<List<Integer>> result = new HashSet<>();

    /**
     * 下一级
     *
     * @param p
     * @param list
     */
    public void set(int p, List<Integer> list) {
        //如果越界了
        if (p >= arr.length) {
            //过
            return;
        }
        //上一个
        int last = list.get(list.size() - 1);
        //循环
        for (int i = p; i < arr.length; i++) {
            //当前
            int num = arr[i];
            //如果是递增
            if (num >= last) {
                //增加
                list.add(num);
                //记录结果
                result.add(new ArrayList<>(list));
                //下一个
                set(i + 1, list);
                //回溯
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        //全局
        this.arr = nums;
        //组装
        List<Integer> list = new ArrayList<>(nums.length);
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前
            int num = arr[i];
            //组装
            list.add(num);
            //下一级
            set(i + 1, list);
            //回溯
            list.remove(list.size() - 1);
        }
        //返回
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        for (List<Integer> subsequence : new Code7().findSubsequences(new int[]{4, 6, 7, 7})) {
            for (Integer integer : subsequence) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

}
