package normal30;

/**
 * @Author ayl
 * @Date 2024-04-12
 * 33. 搜索旋转排序数组
 * 中等
 * 相关标签
 * 相关企业
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 */
public class Code16 {

    //寻找
    private int next(int[] nums, int target, int left, int mid, int right) {
        //如果是目标结果
        if (nums[mid] == target) {
            //返回
            return mid;
        }
        //如果到头了
        if (left + 1 >= right) {
            //如果是
            if (nums[left] == target) {
                //返回
                return left;
            }
            //如果是
            if (nums[right] == target) {
                //返回
                return right;
            }
            //默认
            return -1;
        }
        //判断方向
        if (nums[mid] > target) {
            //递归
            return next(nums, target, left, (mid - left) / 2 + left, mid);
        } else {
            //递归
            return next(nums, target, mid, (right - mid) / 2 + mid, right);
        }
    }

    //寻找旋转节点
    private int findCircleIndex(int[] nums, int left, int mid, int right) {
        //如果越级
        if (mid == nums.length - 1) {
            //最后一个就是
            return nums.length - 1;
        }
        //如果找到目标了
        if (nums[mid] > nums[mid + 1]) {
            //返回
            return mid + 1;
        }
        //如果找到目标了
        if (nums[mid - 1] > nums[mid]) {
            //返回
            return mid;
        }
        //如果左边大于中间
        if (nums[left] > nums[mid]) {
            //继续
            return findCircleIndex(nums, left, (mid - left) / 2 + left, mid);
        }
        //如果右边小于中间
        if (nums[right] < nums[mid]) {
            //继续
            return findCircleIndex(nums, mid, (right - mid) / 2 + mid, right);
        }
        return 0;
    }

    public int search(int[] nums, int target) {
        //如果只有一个
        if (nums.length == 1) {
            //返回
            return nums[0] == target ? 0 : -1;
        }
        //如果是边界
        if (nums[0] == target) {
            //返回
            return 0;
        }
        //如果是边界
        if (nums[nums.length - 1] == target) {
            //返回
            return nums.length - 1;
        }
        //如果是边界中间
        if (nums[nums.length - 1] < target && target < nums[0]) {
            //过
            return -1;
        }
        //如果没有旋转
        if (nums[0] < nums[nums.length - 1]) {
            //直接寻找
            return next(nums, target, 0, nums.length / 2, nums.length - 1);
        }
        //寻找旋转点
        int circleIndex = findCircleIndex(nums, 0, nums.length / 2, nums.length - 1);
        //如果在左边
        if (nums[0] < target) {
            //使用左边
            return next(nums, target, 0, circleIndex / 2, circleIndex);
        }
        //如果在右边
        if (nums[nums.length - 1] > target) {
            //使用右边
            return next(nums, target, circleIndex, (nums.length - 1 - circleIndex) / 2 + circleIndex, nums.length - 1);
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().search(new int[]{3, 1}, 0));
    }

}
