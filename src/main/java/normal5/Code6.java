package normal5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-07-15
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
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
 */
public class Code6 {

    //结果集去重
    Set<List<Integer>> set = new HashSet<>();
    //结果集
    List<List<Integer>> result = new ArrayList<>();

    public void dfs(List<Integer> list, List<Integer> value) {
        //如果存在了
        if (set.contains(value)) {
            //过
            return;
        }
        //如果是某个结果
        if (list.size() == 0) {
            //记录
            result.add(new ArrayList<>(value));
        }
        //表示该集合之前走过了
        set.add(value);
        //循环
        for (int i = 0; i < list.size(); i++) {
            //当前num
            int num = list.get(i);
            //组装
            value.add(num);
            //删除
            list.remove(i);
            //下一步
            dfs(list, value);
            //回溯
            list.add(i, num);
            value.remove(value.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        //dfs集合
        List<Integer> list = new ArrayList<>(nums.length);
        //循环
        for (int num : nums) {
            //组装
            list.add(num);
        }
        //dfs
        dfs(list, new ArrayList<>(nums.length));
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (List<Integer> list : new Code6().permuteUnique(new int[]{1, 1, 2})) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

}
