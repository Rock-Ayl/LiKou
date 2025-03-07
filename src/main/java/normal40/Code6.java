package normal40;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-02-15
 * LCR 119. 最长连续序列
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 128 题相同： https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class Code6 {

    public int longestConsecutive(int[] nums) {
        //判空
        if (nums.length == 0) {
            //返回
            return 0;
        }
        //排个序
        Arrays.sort(nums);
        //最短长度
        int max = 0;
        //初始化
        int last = nums[0];
        //长度
        int size = 1;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前
            int num = nums[i];
            //如果是+1
            if (last + 1 == num) {
                //更改
                size++;
            } else if (last == num) {
                //过
            } else {
                //如果刷新了记录
                if (size > max) {
                    //刷新
                    max = size;
                }
                //重置
                size = 1;
            }
            //记录
            last = num;
        }
        //返回结果
        return Math.max(max, size);
    }

}
