package normal22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-07-18
 * 剑指 Offer II 084. 含有重复元素集合的全排列
 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * <p>
 * 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/
 */
public class Code4 {

    //初始化结果
    private List<List<Integer>> result = new ArrayList<>();

    //递归
    private void next(List<Integer> stack, LinkedList<Integer> list) {
        //如果是结果
        if (stack.isEmpty()) {
            //记录本次结果
            result.add(new LinkedList<>(list));
            //过
            return;
        }
        //上一个数字
        Integer lastNum = null;
        //循环
        for (int i = 0; i < stack.size(); i++) {
            //当前数字
            Integer num = stack.get(i);
            //如果当前数组是上一个数字(去重)
            if (num.equals(lastNum)) {
                //本轮过
                continue;
            }
            //执行置换
            list.addLast(num);
            stack.remove(i);
            //递归
            next(stack, list);
            //回溯
            stack.add(i, num);
            list.removeLast();
            //记录上一个数字
            lastNum = num;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        //初始化列表
        List<Integer> stack = Arrays.stream(nums)
                //装箱
                .boxed()
                //排序
                .sorted()
                //转为列表
                .collect(Collectors.toList());
        //递归寻找
        next(stack, new LinkedList<>());
        //返回结果
        return this.result;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().permuteUnique(new int[]{1, 1, 2}));
    }

}
