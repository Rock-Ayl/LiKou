package easy3;

/**
 * Created By Rock-Ayl on 2020-10-30
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10,10], target = 6
 * 输出: 0
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 */
public class Code10 {

    public static int search(int[] nums, int target) {
        //次数
        int size = 0;
        //循环
        for (int num : nums) {
            //判断
            if (num == target) {
                //叠加
                size++;
            }
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
