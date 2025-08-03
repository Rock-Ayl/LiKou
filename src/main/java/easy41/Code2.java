package easy41;

/**
 * @Author ayl
 * @Date 2025-08-03
 * 3637. 三段式数组 I
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums。
 * <p>
 * 如果存在索引 0 < p < q < n − 1，使得数组满足以下条件，则称其为 三段式数组（trionic）：
 * <p>
 * nums[0...p] 严格 递增，
 * nums[p...q] 严格 递减，
 * nums[q...n − 1] 严格 递增。
 * 如果 nums 是三段式数组，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,4,2,6]
 * <p>
 * 输出: true
 * <p>
 * 解释:
 * <p>
 * 选择 p = 2, q = 4：
 * <p>
 * nums[0...2] = [1, 3, 5] 严格递增 (1 < 3 < 5)。
 * nums[2...4] = [5, 4, 2] 严格递减 (5 > 4 > 2)。
 * nums[4...5] = [2, 6] 严格递增 (2 < 6)。
 * 示例 2:
 * <p>
 * 输入: nums = [2,1,3]
 * <p>
 * 输出: false
 * <p>
 * 解释:
 * <p>
 * 无法选出能使数组满足三段式要求的 p 和 q 。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 3 <= n <= 100
 * -1000 <= nums[i] <= 1000
 */
public class Code2 {

    public boolean isTrionic(int[] nums) {
        //判断
        return first(nums, 0);
    }

    //增
    private boolean first(int[] num, int start) {
        //循环
        while (start + 1 < num.length && num[start + 1] > num[start]) {
            //+1
            start++;
        }
        //如果是最后一个
        if (start == num.length - 1) {
            //不是
            return false;
        }
        //如果没动
        if (start == 0) {
            //不是
            return false;
        }
        //如果相同
        if (num[start] == num[start + 1]) {
            //不是
            return false;
        }
        //下一个
        return second(num, start + 1);
    }

    //减
    private boolean second(int[] num, int start) {
        //循环
        while (start + 1 < num.length && num[start + 1] < num[start]) {
            //+1
            start++;
        }
        //如果是最后一个
        if (start == num.length - 1) {
            //不是
            return false;
        }
        //如果相同
        if (num[start] == num[start + 1]) {
            //不是
            return false;
        }
        //下一个
        return third(num, start + 1);
    }

    //增
    private boolean third(int[] num, int start) {
        //循环
        while (start + 1 < num.length && num[start + 1] > num[start]) {
            //+1
            start++;
        }
        //如果相同
        if (num[start] == num[start - 1]) {
            //不是
            return false;
        }
        //默认
        return start == num.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().isTrionic(new int[]{1, 6, 6, 3, 7}));
    }

}
