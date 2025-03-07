package normal16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-08-31
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * <p>
 * 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/
 */
public class Code9 {

    //初始化结果
    private List<List<Integer>> result = new ArrayList<>();

    public void next(List<Integer> numList, List<Integer> list) {
        //如果结束了
        if (numList.isEmpty()) {
            //记录结果
            result.add(new ArrayList<>(list));
            return;
        }
        //循环
        for (int i = 0; i < numList.size(); i++) {
            //当前
            Integer num = numList.get(i);
            //组装
            list.add(num);
            //删除
            numList.remove(i);
            //下一组
            next(numList, list);
            //回溯
            list.remove(list.size() - 1);
            numList.add(i, num);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        //转化为集合
        List<Integer> numList = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        //走下去
        next(numList, new ArrayList<>(nums.length));
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        new Code9().permute(new int[]{1, 2, 3});
    }

}
