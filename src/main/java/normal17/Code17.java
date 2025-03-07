package normal17;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2022-12-10
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 */
public class Code17 {

    public int triangleNumber(int[] nums) {
        //排序
        Arrays.sort(nums);
        //对数
        int count = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //第一个
            int a = nums[i];
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //第二个
                int b = nums[j];
                //循环3
                for (int k = j + 1; k < nums.length; k++) {
                    //第三个
                    int c = nums[k];
                    //如果太大了
                    if (a + b <= c) {
                        //直接跳出
                        break;
                    }
                    //+1
                    count++;
                }
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().triangleNumber(new int[]{4, 2, 3, 4}));
    }

}
