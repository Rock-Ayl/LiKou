package normal35;

/**
 * @Author ayl
 * @Date 2024-09-12
 * 1144. 递减元素使数组呈锯齿状
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * <p>
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * <p>
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 示例 2：
 * <p>
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 */
public class Code2 {

    //计算,0大于1
    private int count1(int[] nums) {
        //操作次数
        int result = 0;
        //循环
        for (int i = 1; i < nums.length; i = i + 2) {
            //左边一定有,如果看左边,当前值最大可以为
            int target = nums[i - 1] - 1;
            //如果有右边
            if (i + 1 < nums.length) {
                //对比右边
                target = Math.min(target, nums[i + 1] - 1);
            }
            //如果已经足够小了
            if (nums[i] <= target) {
                //本轮过
                continue;
            }
            //记录
            result += nums[i] - target;
            //更新
            nums[i] = target;
        }
        //返回
        return result;
    }

    //计算,0小于1
    private int count2(int[] nums) {
        //操作次数
        int result = 0;
        //首字符最小情况
        if (nums[0] >= nums[1]) {
            //记录
            result = nums[0] - (nums[1] - 1);
            //更新
            nums[0] = (nums[1] - 1);
        }
        //循环
        for (int i = 2; i < nums.length; i = i + 2) {
            //左边一定有,如果看左边,当前值最大可以为
            int target = nums[i - 1] - 1;
            //如果有右边
            if (i + 1 < nums.length) {
                //对比右边
                target = Math.min(target, nums[i + 1] - 1);
            }
            //如果已经足够小了
            if (nums[i] <= target) {
                //本轮过
                continue;
            }
            //记录
            result += nums[i] - target;
            //更新
            nums[i] = target;
        }
        //返回
        return result;
    }

    public int movesToMakeZigzag(int[] nums) {
        //如果太小
        if (nums.length < 2) {
            //过
            return 0;
        }
        //两次尝试,获取最小值
        return Math.min(count1(nums.clone()), count2(nums));
    }

    public static void main(String[] args) {
        System.out.println(new Code2().movesToMakeZigzag(new int[]{10, 4, 4, 10, 10, 6, 2, 3}));
    }
}
