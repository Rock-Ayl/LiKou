package easy4;

/**
 * Created By Rock-Ayl on 2020-12-23
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class Code18 {

    public static int missingNumber(int[] nums) {
        //判空
        if (nums.length == 0) {
            //返回
            return 0;
        }
        //和
        int sum = 0;
        //中间值
        int mid = nums.length;
        //循环
        for (int num : nums) {
            //递增
            sum += num;
        }
        //长度
        int size = mid + 1;
        //如果长度是偶数
        if (size % 2 == 0) {
            //计算并返回
            return size / 2 * mid - sum;
        } else {
            //计算并返回
            return size / 2 * mid + mid / 2 - sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }
}
