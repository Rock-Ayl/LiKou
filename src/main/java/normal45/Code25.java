package normal45;

/**
 * @Author ayl
 * @Date 2025-09-01
 * 3101. 交替子数组计数
 * 算术评级: 3
 * 第 391 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1405
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二进制数组nums 。
 * <p>
 * 如果一个子数组中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。
 * <p>
 * 返回数组 nums 中交替子数组的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [0,1,1,1]
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 以下子数组是交替子数组：[0] 、[1] 、[1] 、[1] 以及 [0,1] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,0,1,0]
 * <p>
 * 输出： 10
 * <p>
 * 解释：
 * <p>
 * 数组的每个子数组都是交替子数组。可以统计在内的子数组共有 10 个。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1 。
 */
public class Code25 {

    public long countAlternatingSubarrays(int[] nums) {
        //结果
        long result = 0L;
        //索引
        int index = 0;
        //循环
        while (index < nums.length) {
            //开始
            int start = index;
            //如果是连续的
            while (index + 1 < nums.length && nums[index + 1] != nums[index]) {
                //+1
                index++;
            }
            //本次
            result += count(start, index);
            //下一个
            index++;
        }
        //返回
        return result;
    }

    //计算本次结果
    private long count(int start, int end) {
        //如果相同
        if (start == end) {
            //只有一个
            return 1L;
        }
        //长度
        long length = end - start + 1;
        //返回
        return (1L + length) * (length / 2L) + (length % 2L != 0L ? ((length + 1L) / 2L) : 0L);
    }

    public static void main(String[] args) {
        //System.out.println(new Code25().countAlternatingSubarrays(new int[]{0, 1, 1, 1}));
        System.out.println(new Code25().countAlternatingSubarrays(new int[]{0, 1, 0, 1, 0}));
    }

}
