package normal21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-06-19
 * 面试题 08.04. 幂集
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Code6 {

    //结果
    private List<List<Integer>> result = new ArrayList<>();

    //走下去
    public void next(int[] nums, int p, LinkedList<Integer> list) {
        //如果越界
        if (p == nums.length) {
            //过
            return;
        }
        //循环
        for (int i = p; i < nums.length; i++) {
            //组装当前
            list.addLast(nums[i]);
            //记录结果
            result.add(new LinkedList<>(list));
            //下一个
            next(nums, i + 1, list);
            //回溯
            list.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        //默认的
        result.add(new ArrayList<>());
        //走下去
        next(nums, 0, new LinkedList<>());
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        new Code6().subsets(new int[]{1, 2, 3});
    }

}
