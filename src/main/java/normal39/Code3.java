package normal39;

/**
 * @Author ayl
 * @Date 2025-01-08
 * 1248. 统计「优美子数组」
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中 「优美子数组」 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 * <p>
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
public class Code3 {

    public int numberOfSubarrays(int[] nums, int k) {
        //缓存
        int[] arr = new int[nums.length];
        //初始化第一个
        arr[0] = nums[0] % 2 == 1 ? 1 : 0;
        //循环
        for (int i = 1; i < arr.length; i++) {
            //计算
            arr[i] = arr[i - 1] + (nums[i] % 2 == 1 ? 1 : 0);
        }
        //次数
        int count = 0;
        //缓存
        int[] map = new int[nums.length + 1];
        //默认出发点
        map[0] = 1;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //目标
            int need = arr[i] - k;
            //如果不够
            if (need >= 0) {
                //叠加本次可能
                count += map[need];
            }
            //计算缓存
            map[arr[i]]++;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }

}
