package easy31;

/**
 * @Author ayl
 * @Date 2023-06-06
 * 2717. 半有序排列
 * 给你一个下标从 0 开始、长度为 n 的整数排列 nums 。
 * <p>
 * 如果排列的第一个数字等于 1 且最后一个数字等于 n ，则称其为 半有序排列 。你可以执行多次下述操作，直到将 nums 变成一个 半有序排列 ：
 * <p>
 * 选择 nums 中相邻的两个元素，然后交换它们。
 * 返回使 nums 变成 半有序排列 所需的最小操作次数。
 * <p>
 * 排列 是一个长度为 n 的整数序列，其中包含从 1 到 n 的每个数字恰好一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,4,3]
 * 输出：2
 * 解释：可以依次执行下述操作得到半有序排列：
 * 1 - 交换下标 0 和下标 1 对应元素。排列变为 [1,2,4,3] 。
 * 2 - 交换下标 2 和下标 3 对应元素。排列变为 [1,2,3,4] 。
 * 可以证明，要让 nums 成为半有序排列，不存在执行操作少于 2 次的方案。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,1,3]
 * 输出：3
 * 解释：
 * 可以依次执行下述操作得到半有序排列：
 * 1 - 交换下标 1 和下标 2 对应元素。排列变为 [2,1,4,3] 。
 * 2 - 交换下标 0 和下标 1 对应元素。排列变为 [1,2,4,3] 。
 * 3 - 交换下标 2 和下标 3 对应元素。排列变为 [1,2,3,4] 。
 * 可以证明，要让 nums 成为半有序排列，不存在执行操作少于 3 次的方案。
 * 示例 3：
 * <p>
 * 输入：nums = [1,3,4,2,5]
 * 输出：0
 * 解释：这个排列已经是一个半有序排列，无需执行任何操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length == n <= 50
 * 1 <= nums[i] <= 50
 * nums 是一个 排列
 */
public class Code15 {

    public int semiOrderedPermutation(int[] nums) {
        //最大目标
        int right = nums.length;
        //目标对应坐标
        int p1 = 1;
        int p2 = 1;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前数字
            int num = nums[i];
            //判断目标坐标
            if (num == 1) {
                //记录
                p1 = i;
            } else if (num == right) {
                //记录
                p2 = i;
            }
        }
        //初始化结果
        int count = 0;
        //如果目标值需要交换
        if (p1 > p2) {
            //计算二者交换次数
            count += p1 - p2;
            //二者坐标进行交换
            p1 = p2;
            p2 = p1 + 1;
        }
        //计算最终结果
        return count + p1 + nums.length - p2 - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().semiOrderedPermutation(new int[]{3, 2, 1}));
    }

}
