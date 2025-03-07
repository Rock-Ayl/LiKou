package normal5;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-07-27
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
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
 */
public class Code11 {

    //结果集
    List<List<Integer>> result = new ArrayList<>();

    public void dfs(List<Integer> list, List<Integer> value, int p) {
        //记录
        result.add(new ArrayList<>(value));
        //到头了
        if (list.size() == 0) {
            //终止
            return;
        }
        //循环
        for (int i = p; i < list.size(); i++) {
            //当前
            int num = list.get(i);
            //下一步前
            list.remove(i);
            value.add(num);
            //下一步
            dfs(list, value, i);
            //回溯
            list.add(i, num);
            value.remove(value.size() - 1);
        }
    }

    /**
     * dfs+剪枝
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        //stack
        List<Integer> list = new ArrayList<>(nums.length);
        //循环
        for (int num : nums) {
            //组装
            list.add(num);
        }
        //dfs
        dfs(list, new ArrayList<>(), 0);
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().subsets(new int[]{1, 2, 3}));
    }
}
