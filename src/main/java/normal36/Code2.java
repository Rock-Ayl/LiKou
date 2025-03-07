package normal36;

/**
 * @Author ayl
 * @Date 2024-10-11
 * 974. 和可被 K 整除的子数组
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的非空 子数组 的数目。
 * <p>
 * 子数组 是数组中 连续 的部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,0,-2,-3,1], k = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 k = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 示例 2:
 * <p>
 * 输入: nums = [5], k = 9
 * 输出: 0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * 2 <= k <= 104
 */
public class Code2 {

    public int subarraysDivByK(int[] nums, int k) {
        //前缀和
        int[] arr = new int[nums.length + 1];
        //循环
        for (int i = 1; i < arr.length; i++) {
            //计算求和、取余
            int sum = (arr[i - 1] + nums[i - 1]) % k;
            //记录,如果为负数则修正
            arr[i] = sum >= 0 ? sum : sum + k;
        }
        //缓存
        int[] otherArr = new int[k];
        //结果
        int count = 0;
        //循环1
        for (int i = 1; i < arr.length; i++) {
            //记录前置数据数量
            otherArr[arr[i - 1]]++;
            //叠加本次结果数量
            count += otherArr[arr[i]];
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }

}
