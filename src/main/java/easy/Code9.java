package easy;

/**
 * Created By Rock-Ayl on 2020-08-15
 * 1512. 好数对的数目
 * 给你一个整数数组 nums
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * <p>
 * 返回好数对的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code9 {

    public static int numIdenticalPairs(int[] nums) {
        //初始化
        int num = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //循环
            for (int j = 0; j < nums.length; j++) {
                //如果
                if (nums[i] == nums[j] && i < j) {
                    //累加
                    num++;
                }
            }
        }
        //返回
        return num;
    }

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
    }
}
