package easy25;

/**
 * @Author ayl
 * @Date 2022-11-22
 * 2475. 数组中不等三元组的数目
 * 给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
 * <p>
 * 0 <= i < j < k < nums.length
 * nums[i]、nums[j] 和 nums[k] 两两不同 。
 * 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
 * 返回满足上述条件三元组的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,4,2,4,3]
 * 输出：3
 * 解释：下面列出的三元组均满足题目条件：
 * - (0, 2, 4) 因为 4 != 2 != 3
 * - (1, 2, 4) 因为 4 != 2 != 3
 * - (2, 3, 4) 因为 2 != 4 != 3
 * 共计 3 个三元组，返回 3 。
 * 注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：不存在满足条件的三元组，所以返回 0 。
 */
public class Code3 {

    public int unequalTriplets(int[] nums) {
        //数量
        int count = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //第一个
            int a = nums[i];
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //第二个
                int b = nums[j];
                //如果相同
                if (a == b) {
                    //本轮过
                    continue;
                }
                //循环3
                for (int k = j + 1; k < nums.length; k++) {
                    //第三个
                    int c = nums[k];
                    //如果相同
                    if (b == c || a == c) {
                        //本轮过
                        continue;
                    }
                    //+1
                    count++;
                }
            }
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().unequalTriplets(new int[]{4, 4, 2, 4, 3}));
    }

}
