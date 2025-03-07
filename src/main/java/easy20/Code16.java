package easy20;

/**
 * @Author ayl
 * @Date 2022-07-02
 * 1646. 获取生成数组中的最大值
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 7
 * 输出：3
 * 解释：根据规则：
 * nums[0] = 0
 * nums[1] = 1
 * nums[(1 * 2) = 2] = nums[1] = 1
 * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * nums[(2 * 2) = 4] = nums[2] = 1
 * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * nums[(3 * 2) = 6] = nums[3] = 2
 * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
 * 示例 3：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 */
public class Code16 {

    public int getMaximumGenerated(int n) {
        //判空
        if (n < 1) {
            //默认
            return 0;
        } else if (n == 1) {
            //默认
            return 1;
        }
        //初始化结果列表
        int[] arr = new int[n + 1];
        //固定结果
        arr[1] = 1;
        //最大结果
        int max = 1;
        //循环
        for (int i = 2; i <= n; i++) {
            //先除
            int div = i / 2;
            //当前结果
            int num;
            //如果是偶数
            if (i % 2 == 0) {
                //计算
                num = arr[div];
            } else {
                //计算
                num = arr[div] + arr[div + 1];
            }
            //当前结果
            arr[i] = num;
            //记录最大结果
            max = Math.max(max, num);
        }
        //返回最大
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Code16().getMaximumGenerated(4));
    }

}
