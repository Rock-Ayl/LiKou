package normal23;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-09-02
 * 525. 连续数组
 * 中等
 * 674
 * 相关企业
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 */
public class Code17 {

    public int findMaxLength(int[] nums) {
        //连续
        List<Integer> list = new ArrayList<>();
        //第一个
        int lastNum = nums[0];
        //连击
        int hit = 1;
        //最大情况
        int max = 0;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //如果相同 and 不是最后一个
            if (nums[i] == lastNum) {
                //记录
                hit++;
            } else {
                //如果是0
                if (lastNum == 0) {
                    //如果上一个是正数
                    if (list.size() > 0 && list.get(list.size() - 1) > 0) {
                        //刷新最大
                        max = Math.max(max, Math.min(list.get(list.size() - 1), hit));
                    }
                    //记录
                    list.add(-hit);
                } else {
                    //如果上一个是负数
                    if (list.size() > 0 && list.get(list.size() - 1) < 0) {
                        //刷新最大
                        max = Math.max(max, Math.min(list.get(list.size() - 1), hit));
                    }
                    //记录
                    list.add(hit);
                }
                //更新
                lastNum = nums[i];
                hit = 1;
            }
        }
        //如果是0
        if (lastNum == 0) {
            //如果上一个是正数
            if (list.size() > 0 && list.get(list.size() - 1) > 0) {
                //刷新最大
                max = Math.max(max, Math.min(list.get(list.size() - 1), hit));
            }
            //记录
            list.add(-hit);
        } else {
            //如果上一个是负数
            if (list.size() > 0 && list.get(list.size() - 1) < 0) {
                //刷新最大
                max = Math.max(max, Math.min(Math.abs(list.get(list.size() - 1)), hit));
            }
            //记录
            list.add(hit);
        }
        //返回
        return max * 2;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().findMaxLength(new int[]{0, 1}));
    }

}
