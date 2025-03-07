package difficult2;

/**
 * @Author ayl
 * @Date 2023-02-11
 * 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 */
public class Code1 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        //边界
        int right = nums.length - 1;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //循环2,保证配对范围,前面跟后面,后面不跟前面了(配对过了)
            for (int j = i + 1; j <= Math.min(right, i + indexDiff); j++) {
                //如果是目标
                if (Math.abs(nums[i] - nums[j]) <= valueDiff) {
                    //是
                    return true;
                }
            }
        }
        //默认不可以
        return false;
    }

    public static void main(String[] args) {

        System.out.println(new Code1().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

}
