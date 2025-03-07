package easy5;

/**
 * Created By Rock-Ayl on 2021-01-05
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Code6 {

    public static int searchInsert(int[] nums, int target) {
        //如果长度为1
        if (nums.length == 1) {
            //获取数
            int num = nums[0];
            //如果相同
            if (num >= target) {
                //返回0
                return 0;
            } else {
                return 1;
            }
        }
        //左右两边
        int left = 0, right = nums.length - 1;
        //当前位置
        int p = right / 2;
        //循环
        while (left < right) {
            //获取当前位置
            int x = nums[p];
            //如果直接等于
            if (x == target) {
                //返回
                return p;
            } else if (x > target) {
                //缩小右边距
                right = p;
            } else {
                //缩小左边距
                left = p;
            }
            //计算p
            p = left + ((right - left) / 2);
            //如果已经到中间了
            if (left + 1 == right) {
                //获取左右
                int a = nums[left], b = nums[right];
                //如果是左
                if (a == target) {
                    //返回左
                    return left;
                }
                //如果是右或者是两者中间
                if (b == target || (a < target && b > target)) {
                    //返回右
                    return right;
                }
                //如果是右边
                if (right == nums.length - 1) {
                    //返回边距+1
                    return right + 1;
                }
                //如果是左边
                if (left == 0) {
                    //返回0
                    return 0;
                }
            }
        }
        //返回
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
