package difficult2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-04-13
 * 4. 寻找两个正序数组的中位数
 * 尝试过
 * 困难
 * 相关标签
 * 相关企业
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Code9 {

    //加入队列
    private void build(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int num) {
        //如果是第一个
        if (left.isEmpty()) {
            //加入
            left.add(num);
            //过
            return;
        }
        //如果是第二个
        if (right.isEmpty()) {
            //获取
            Integer first = left.poll();
            //对比大小
            Integer big = Math.max(first, num);
            Integer small = Math.min(first, num);
            //加入
            left.add(small);
            right.add(big);
            //过
            return;
        }
        //获取中间的
        Integer mid = left.peek();
        //判断新数字更大更小
        if (mid.compareTo(num) > 0) {
            //加入
            left.add(num);
        } else {
            //加入
            right.add(num);
        }
        //如果左边太多
        if (left.size() > right.size() + 1) {
            //吐出一个
            right.add(left.poll());
        }
        //如果右边太多
        if (right.size() > left.size()) {
            //吐出一个
            left.add(right.poll());
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //双优先队列
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        //循环
        for (int num : nums1) {
            //构建
            build(left, right, num);
        }
        //循环
        for (int num : nums2) {
            //构建
            build(left, right, num);
        }
        //如果是偶数数量
        if (left.size() == right.size()) {
            //求和
            double num = left.poll() + right.poll();
            //返回结果
            return num / 2D;
        } else {
            //直接返回
            return left.poll();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code9().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

}
