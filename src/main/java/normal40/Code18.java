package normal40;

/**
 * @Author ayl
 * @Date 2025-03-02
 * 3467. 将数组按照奇偶性转化
 * 简单
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。请你按照以下顺序 依次 执行操作，转换 nums：
 * <p>
 * 将每个偶数替换为 0。
 * 将每个奇数替换为 1。
 * 按 非递减 顺序排序修改后的数组。
 * 执行完这些操作后，返回结果数组。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：nums = [4,3,2,1]
 * <p>
 * 输出：[0,0,1,1]
 * <p>
 * 解释：
 * <p>
 * 将偶数（4 和 2）替换为 0，将奇数（3 和 1）替换为 1。现在，nums = [0, 1, 0, 1]。
 * 按非递减顺序排序 nums，得到 nums = [0, 0, 1, 1]。
 * 示例 2:
 * <p>
 * 输入：nums = [1,5,1,4,2]
 * <p>
 * 输出：[0,0,1,1,1]
 * <p>
 * 解释：
 * <p>
 * 将偶数（4 和 2）替换为 0，将奇数（1, 5 和 1）替换为 1。现在，nums = [1, 1, 1, 0, 0]。
 * 按非递减顺序排序 nums，得到 nums = [0, 0, 1, 1, 1]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 */
public class Code18 {

    public int[] transformArray(int[] nums) {
        //缓存
        int[] result = new int[nums.length];
        //双指针
        int left = 0;
        int right = nums.length - 1;
        //循环
        for (int num : nums) {
            //如果是偶数
            if (num % 2 == 0) {
                //+1
                result[left++] = 0;
            } else {
                //-1
                result[right--] = 1;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().transformArray(new int[]{1, 5, 1, 4, 2}));
    }

}
