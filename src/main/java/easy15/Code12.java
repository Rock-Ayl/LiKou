package easy15;

/**
 * @Author ayl
 * @Date 2021-11-27
 * 2057. 值相等的最小索引
 * 给你一个下标从 0 开始的整数数组 nums ，返回 nums 中满足 i mod 10 == nums[i] 的最小下标 i ；如果不存在这样的下标，返回 -1 。
 * <p>
 * x mod y 表示 x 除以 y 的 余数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2]
 * 输出：0
 * 解释：
 * i=0: 0 mod 10 = 0 == nums[0].
 * i=1: 1 mod 10 = 1 == nums[1].
 * i=2: 2 mod 10 = 2 == nums[2].
 * 所有下标都满足 i mod 10 == nums[i] ，所以返回最小下标 0
 * 示例 2：
 * <p>
 * 输入：nums = [4,3,2,1]
 * 输出：2
 * 解释：
 * i=0: 0 mod 10 = 0 != nums[0].
 * i=1: 1 mod 10 = 1 != nums[1].
 * i=2: 2 mod 10 = 2 == nums[2].
 * i=3: 3 mod 10 = 3 != nums[3].
 * 2 唯一一个满足 i mod 10 == nums[i] 的下标
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,5,6,7,8,9,0]
 * 输出：-1
 * 解释：不存在满足 i mod 10 == nums[i] 的下标
 * 示例 4：
 * <p>
 * 输入：nums = [2,1,3,5,2]
 * 输出：1
 * 解释：1 是唯一一个满足 i mod 10 == nums[i] 的下标
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 9
 */
public class Code12 {

    public int smallestEqual(int[] nums) {
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果是
            if (i % 10 == nums[i]) {
                //返回
                return i;
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().smallestEqual(new int[]{2, 1, 3, 5, 2}));
    }

}
