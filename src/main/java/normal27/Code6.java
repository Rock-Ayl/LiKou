package normal27;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-12-19
 * 面试题 10.11. 峰与谷
 * 提示
 * 中等
 * 59
 * 相关企业
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 * <p>
 * 示例:
 * <p>
 * 输入: [5, 3, 1, 2, 3]
 * 输出: [5, 1, 3, 2, 3]
 * 提示：
 * <p>
 * nums.length <= 10000
 */
public class Code6 {

    public void wiggleSort(int[] nums) {
        //先正规排序
        Arrays.sort(nums);
        //缓存
        int[] cacheArr = nums.clone();
        //缓存坐标
        int p = cacheArr.length - 1;
        //循环1
        for (int i = 0; i < nums.length; i = i + 2) {
            //覆盖
            nums[i] = cacheArr[p--];
        }
        //循环2
        for (int i = 1; i < nums.length; i = i + 2) {
            //覆盖
            nums[i] = cacheArr[p--];
        }
    }

    public static void main(String[] args) {
        new Code6().wiggleSort(new int[]{5, 2, 1, 4, 3});
    }

}
