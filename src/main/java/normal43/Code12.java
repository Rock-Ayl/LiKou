package normal43;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-05-29
 * 152. 乘积最大子数组
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何子数组的乘积都 保证 是一个 32-位 整数
 */
public class Code12 {

    public int maxProduct(int[] nums) {

        //初始化最大值
        int max = nums[0];

        /**
         * 分层
         */

        //列表
        List<List<Integer>> list = new ArrayList<>();
        //初始化
        list.add(new ArrayList<>());
        //循环
        for (int num : nums) {

            //刷新最大
            max = Math.max(max, num);

            //获取最后一个列表
            List<Integer> lastList = list.get(list.size() - 1);
            //如果是0
            if (num == 0) {
                //如果上一个有节点
                if (lastList.size() > 0) {
                    //新创建
                    list.add(new ArrayList<>());
                }
                //本轮过
                continue;
            }
            //如果 不存在前置 or 数字小于0 or 前面是负数
            if (lastList.isEmpty() || num < 0 || lastList.get(lastList.size() - 1) < 0) {
                //直接加入
                lastList.add(num);
            } else {
                //叠加和
                lastList.set(lastList.size() - 1, lastList.get(lastList.size() - 1) * num);
            }

        }

        /**
         * 计算最大值
         */

        //循环每层
        for (List<Integer> partList : list) {
            //计算最大值
            max = Math.max(max, countMax(partList, 0, partList.size() - 1));
        }

        //返回
        return max;
    }

    //计算同一层级,区间,最大值
    private int countMax(List<Integer> partList, int start, int end) {
        //如果越界
        if (start > end) {
            //返回
            return Integer.MIN_VALUE;
        }
        //如果开始等于结束
        if (start == end) {
            //直接返回
            return partList.get(start);
        }
        //负数的数量
        int count = 0;
        //乘积
        int sum = 1;
        //负数的开始、结束位置
        int first = -1;
        int last = -1;
        //循环
        for (int i = start; i <= end; i++) {
            //获取数字
            int num = partList.get(i);
            //乘积
            sum = sum * num;
            //如果是负数
            if (num < 0) {
                //如果没有记录过开始
                if (first == -1) {
                    //记录
                    first = i;
                }
                //覆盖结束
                last = i;
                //统计
                count++;
            }
        }
        //如果有偶数个负数
        if (count % 2 == 0) {
            //直接返回结果
            return sum;
        }
        //同时判断左右
        return Math.max(countMax(partList, start, last - 1), countMax(partList, first + 1, end));
    }

    public static void main(String[] args) {
        System.out.println(new Code12().maxProduct(new int[]{-2, 3, 1, 3}));
    }

}
