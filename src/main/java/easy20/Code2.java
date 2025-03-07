package easy20;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-06-07
 * 2164. 对奇偶下标分别排序
 * 给你一个下标从 0 开始的整数数组 nums 。根据下述规则重排 nums 中的值：
 * <p>
 * 按 非递增 顺序排列 nums 奇数下标 上的所有值。
 * 举个例子，如果排序前 nums = [4,1,2,3] ，对奇数下标的值排序后变为 [4,3,2,1] 。奇数下标 1 和 3 的值按照非递增顺序重排。
 * 按 非递减 顺序排列 nums 偶数下标 上的所有值。
 * 举个例子，如果排序前 nums = [4,1,2,3] ，对偶数下标的值排序后变为 [2,1,4,3] 。偶数下标 0 和 2 的值按照非递减顺序重排。
 * 返回重排 nums 的值之后形成的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,2,3]
 * 输出：[2,3,4,1]
 * 解释：
 * 首先，按非递增顺序重排奇数下标（1 和 3）的值。
 * 所以，nums 从 [4,1,2,3] 变为 [4,3,2,1] 。
 * 然后，按非递减顺序重排偶数下标（0 和 2）的值。
 * 所以，nums 从 [4,1,2,3] 变为 [2,3,4,1] 。
 * 因此，重排之后形成的数组是 [2,3,4,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,1]
 * 输出：[2,1]
 * 解释：
 * 由于只有一个奇数下标和一个偶数下标，所以不会发生重排。
 * 形成的结果数组是 [2,1] ，和初始数组一样。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code2 {

    public int[] sortEvenOdd(int[] nums) {
        //初始化单双
        List<Integer> single = new ArrayList<>();
        List<Integer> mult = new ArrayList<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果是双
            if (i % 2 == 0) {
                //组装
                mult.add(nums[i]);
            } else {
                single.add(nums[i]);
            }
        }
        //排序
        Collections.sort(single, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Collections.sort(mult);
        //迭代器
        Iterator<Integer> one = single.iterator();
        Iterator<Integer> two = mult.iterator();
        //初始化
        int[] result = new int[nums.length];
        //循环
        for (int i = 0; i < result.length; i++) {
            //如果是双
            if (i % 2 == 0) {
                //组装
                result[i] = two.next();
            } else {
                //组装
                result[i] = one.next();
            }
        }
        //返回
        return result;
    }


    public static void main(String[] args) {
        new Code2().sortEvenOdd(new int[]{4, 1, 2, 3});
    }
}

