package normal5;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2021-07-13
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 */
public class Code4 {

    /**
     * 第一反应：Arrays.sort(nums); 解决问题,但是很明显,考察的不是这个
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        //循环
        for (int i = 0; i < nums.length - 1; i++) {
            //如果是最小的
            if (nums[i] == 0) {
                //下一个
                continue;
            }
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //对比
                if (nums[i] > nums[j]) {
                    //置换
                    int c = nums[i];
                    nums[i] = nums[j];
                    nums[j] = c;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Code4().sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
