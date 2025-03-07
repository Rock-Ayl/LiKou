package normal3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-04-29
 * 442. 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * <p>
 * 找到所有出现两次的元素。
 * <p>
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * <p>
 * 示例：
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [2,3]
 * 通过次数34,678提交次数50,332
 */
public class Code7 {

    /**
     * 收藏的算法
     *
     * @param nums
     * @return
     */
    public List<Integer> star(int[] nums) {
        List<Integer> res = new ArrayList<>();
        //循环
        for (int i = 0; i < nums.length; ++i) {
            //当前数字
            int num = nums[i];
            //索引
            int index = Math.abs(num) - 1;
            //如果是负数
            if (nums[index] < 0){
                //
                res.add(Math.abs(index + 1));
            }
            //
            nums[index] = -nums[index];
        }
        return res;
    }

    /**
     * 自己的，用桶
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        //返回
        List<Integer> result = new ArrayList<>();
        //桶
        int[] arr = new int[nums.length + 1];
        //循环
        for (int num : nums) {
            //叠加
            arr[num] = arr[num] + 1;
            //如果重复了
            if (arr[num] == 2) {
                //记录
                result.add(num);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (Integer duplicate : new Code7().star(new int[]{4, 3, 2, 7, 8, 2, 3, 1})) {
            System.out.println(duplicate);
        }
    }
}
