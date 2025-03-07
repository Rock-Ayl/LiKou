package normal38;

/**
 * @Author ayl
 * @Date 2024-12-28
 * 930. 和相同的二元子数组
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 */
public class Code23 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        //前缀和
        int[] sumArr = new int[nums.length];
        //前置和缓存
        int[] map = new int[nums.length + 1];
        //数量
        int count = 0;
        //初始化
        sumArr[0] = nums[0];
        //循环
        for (int i = 1; i < nums.length; i++) {
            //叠加
            sumArr[i] = sumArr[i - 1] + nums[i];
        }
        //循环
        for (int i = 0; i < sumArr.length; i++) {
            //当前和
            int num = sumArr[i];
            //目标值
            int target = num - goal;
            //计算并叠加 (前置符合条件的情况 + 当前是否符合条件)
            count += (target >= 0 ? map[target] : 0) + (num == goal ? 1 : 0);
            //当前和存入缓存
            map[num]++;
        }
        //返回
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new Code23().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }

}
