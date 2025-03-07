package normal23;

/**
 * @Author ayl
 * @Date 2023-08-14
 * LCR 070. 有序数组中的单一元素
 * 中等
 * 74
 * 相关企业
 * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 * <p>
 * <p>
 * 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 540 题相同：https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 */
public class Code4 {

    private int singleNonDuplicate(int[] nums, int left, int right) {
        //如果左右只差1了
        if (left + 1 == right) {
            //如果是目标结果
            if (nums[left] != nums[left - 1] && nums[left] != nums[left + 1]) {
                //返回
                return nums[left];
            } else {
                return nums[right];
            }
        }
        //计算二分
        int mid = ((right - left) / 2) + left;
        //如果是目标结果
        if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
            //返回结果
            return nums[mid];
        }
        //如果是左边相同
        if (nums[mid - 1] == nums[mid]) {
            int other = mid - left;
            //如果在左边
            if (other % 2 == 0) {
                //继续
                return singleNonDuplicate(nums, left, mid);
            } else {
                //继续
                return singleNonDuplicate(nums, mid + 1, right);
            }
        }
        //如果是右边相同
        if (nums[mid + 1] == nums[mid]) {
            int other = right - mid;
            //如果在左边
            if (other % 2 == 0) {
                //继续
                return singleNonDuplicate(nums, mid, right);
            } else {
                //继续
                return singleNonDuplicate(nums, left, mid - 1);
            }
        }
        //默认
        return 0;
    }

    public int singleNonDuplicate(int[] nums) {
        //如果只有一个
        if (nums.length == 1) {
            //默认
            return nums[0];
        }
        //如果是边界
        if (nums[0] != nums[1]) {
            //返回
            return nums[0];
        }
        //如果是边界
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            //返回
            return nums[nums.length - 1];
        }
        //二分查找
        return singleNonDuplicate(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code4().singleNonDuplicate(new int[]{1, 1, 2, 2, 4, 5, 5, 9, 9, 10, 10}));
    }

}
