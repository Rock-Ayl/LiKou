package normal2;

/**
 * Created By Rock-Ayl on 2021-04-20
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class Code17 {

    public int[] searchRange(int[] nums, int target) {
        //左右边距
        int x = 0, y = nums.length - 1;
        //循环
        while (x <= y) {
            //计算中间坐标
            int z = (y - x) / 2 + x;
            //取值
            int num = nums[z];
            //如果比目标大
            if (num > target) {
                //更换
                y = z - 1;
            } else if (num < target) {
                //更换
                x = z + 1;
            } else {
                //他的左右
                int left = z, right = z;
                //循环
                while (left > 0) {
                    //递减
                    left--;
                    //如果不是目标值了
                    if (nums[left] != target) {
                        //回去
                        left++;
                        //结束
                        break;
                    }
                }
                //循环
                while (right < nums.length - 1) {
                    //递增
                    right++;
                    //如果不是目标值了
                    if (nums[right] != target) {
                        //回去
                        right--;
                        //结束
                        break;
                    }
                }
                //结果
                return new int[]{left, right};
            }
        }
        //默认结果
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        for (int i : new Code17().searchRange(new int[]{1, 4}, 4)) {
            System.out.println(i);
        }
    }
}
