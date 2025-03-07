package easy7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-03-04
 * 724. 寻找数组的中心索引
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * <p>
 * 数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
 * <p>
 * 注意：中心索引可能出现在数组的两端。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心索引是 3 。
 * 左侧数之和 (1 + 7 + 3 = 11)，
 * 右侧数之和 (5 + 6 = 11) ，二者相等。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 * 示例 3：
 * <p>
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心索引是 0 。
 * 索引 0 左侧不存在元素，视作和为 0 ；
 * 右侧数之和为 1 + (-1) = 0 ，二者相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */
public class Code8 {

    public static int pivotIndex(int[] nums) {
        //左
        int[] aList = new int[nums.length];
        //右
        int[] bList = new int[nums.length];
        //左和
        int aSum = 0;
        //右和
        int bSum = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //叠加
            aSum += nums[i];
            //记录
            aList[i] = aSum;
        }
        //循环
        for (int i = nums.length - 1; i >= 0; i--) {
            //叠加
            bSum += nums[i];
            //记录
            bList[i] = bSum;
        }
        //可能的中心点
        int p = 0;
        //循环
        while (p < nums.length) {
            //如果左边越界,右边越界,不越界的情况,对比两端和
            if (p - 1 < 0) {
                //判断右边是否为0
                if (bList[p + 1] == 0) {
                    //返回
                    return p;
                }
            } else if (p + 1 == nums.length) {
                //判断左边是否为0
                if (aList[p - 1] == 0) {
                    //返回
                    return p;
                }
            } else if (aList[p - 1] == bList[p + 1]) {
                //返回
                return p;
            }
            //递增
            p++;
        }
        //缺省
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{2, 1, -1}));
    }
}
