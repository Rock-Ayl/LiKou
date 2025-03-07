package normal34;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-08-26
 */
public class Code16 {

    public int[][] divideArray(int[] nums, int k) {
        //排序
        Arrays.sort(nums);
        //初始化结果
        int[][] result = new int[nums.length / 3][3];
        //循环
        for (int i = 0; i < nums.length; i = i + 3) {
            //如果不满足
            if (nums[i + 2] - nums[i] > k) {
                //过
                return new int[][]{};
            }
            //记录
            result[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[][] ints = new Code16().divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2);
        System.out.println();
    }

}
