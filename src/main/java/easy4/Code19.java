package easy4;

/**
 * Created By Rock-Ayl on 2020-12-24
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class Code19 {

    public static int search(int[] nums, int target) {
        //长度
        int size = nums.length;
        //左
        int left = 0;
        //右
        int right = size - 1;
        //当前位置
        int p = size / 2;
        //循环
        while (left != right) {
            //获取当前值
            int x = nums[p];
            //如果是目标
            if (x == target) {
                //返回
                return p;
            } else if (x > target) {
                //位置缩小
                right = p;
            } else {
                //位置缩小
                left = p;
            }
            //计算出当前位置
            p = left + (right - left) / 2;
            //如果已经到头了
            if (left + 1 == right) {
                //如果左是目标
                if (nums[left] == target) {
                    //返回
                    return left;
                }
                //如果右是目标
                if (nums[right] == target) {
                    //返回
                    return right;
                }
                //结束
                break;
            }
        }
        //如果是目标
        if (nums[p] == target) {
            //返回
            return p;
        }
        //缺省
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 5}, 5));
    }
}
