package normal5;

/**
 * @Author ayl
 * @Date 2021-07-11
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 */
public class Code2 {

    public void rotate(int[] nums, int k) {
        //不需要移动
        if (nums.length < 2) {
            return;
        }
        //如果越界了
        if (k >= nums.length) {
            //计算真正
            k -= (k / nums.length) * nums.length;
        }
        //缓存
        int[] arr = new int[nums.length - k];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //记录
            arr[i] = nums[i];
        }
        //指针
        int p = 0;
        //循环2
        for (int i = arr.length; i < nums.length; i++) {
            //移动
            nums[p++] = nums[i];
        }
        //指针
        p = 0;
        //循环3
        for (int i = k; i < nums.length; i++) {
            //移动
            nums[i] = arr[p++];
        }
    }

    public static void main(String[] args) {
        new Code2().rotate(new int[]{1, 2}, 3);
    }

}
