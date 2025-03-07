package normal19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-03-28
 * 剑指 Offer II 079. 所有子集
 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
 * nums 中的所有元素 互不相同
 * <p>
 * <p>
 * 注意：本题与主站 78 题相同： https://leetcode-cn.com/problems/subsets/
 */
public class Code19 {

    //初始化结果列表
    private List<List<Integer>> result = new ArrayList<>();

    //走下去
    public void next(int[] nums, LinkedList<Integer> list, int p) {
        //如果越界了
        if (p == nums.length) {
            //过
            return;
        }
        //当前节点
        int num = nums[p];
        //组装当前
        list.addLast(num);
        //记录结果
        result.add(new ArrayList<>(list));
        //循环
        for (int i = p + 1; i < nums.length; i++) {
            //走下去
            next(nums, list, i);
        }
        //回溯
        list.removeLast();
    }

    public List<List<Integer>> subsets(int[] nums) {
        //加入默认
        result.add(new ArrayList<>());
        //初始化列表
        LinkedList<Integer> list = new LinkedList();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //从头走
            next(nums, list, i);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code19().subsets(new int[]{1, 2, 3});
    }

}
