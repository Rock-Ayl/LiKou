package easy16;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-12-08
 * 594. 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * <p>
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 */
public class Code6 {

    public int findLHS(int[] nums) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //列表
        Set<Integer> set = new HashSet<>();
        //循环
        for (int num : nums) {
            //记录
            map.put(num, map.getOrDefault(num, 0) + 1);
            //记录
            set.add(num);
        }
        //转为set
        List<Integer> list = new ArrayList<>(set);
        //排序
        Collections.sort(list);
        //最大可能
        int max = 0;
        //循环
        for (int i = 1; i < list.size(); i++) {
            //左右
            int left = list.get(i - 1), right = list.get(i);
            //如果符合
            if (right - left == 1) {
                //结果
                int sum = map.get(left) + map.get(right);
                //如果满足
                if (sum > max) {
                    //更新
                    max = sum;
                }
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }
}
