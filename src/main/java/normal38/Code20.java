package normal38;

/**
 * @Author ayl
 * @Date 2024-12-25
 * 525. 连续数组
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 */
public class Code20 {

    public int findMaxLength(int[] nums) {
        //前缀和
        int[] sumArr = new int[nums.length];
        //初始化第一个
        sumArr[0] = nums[0];
        //循环
        for (int i = 1; i < sumArr.length; i++) {
            //叠加
            sumArr[i] = sumArr[i - 1] + nums[i];
        }
        //区间,固定是偶数长度
        int rangeLength = nums.length / 2 * 2;
        //循环
        while (rangeLength > 0) {
            //开始、结束坐标
            int start = 0;
            int end = rangeLength - 1;
            //循环
            while (end < nums.length) {
                //计算,并进位
                int count = count(sumArr, start++, end++);
                //如果满足,那就是最大结果
                if (count > 0) {
                    //直接返回结果
                    return count;
                }
            }
            //缩小范围
            rangeLength = rangeLength - 2;
        }
        //默认
        return 0;
    }

    //计算
    private int count(int[] sumArr, int start, int end) {
        //计算区间1的数量
        int count = sumArr[end] - (start == 0 ? 0 : sumArr[start - 1]);
        //长度
        int length = end - start + 1;
        //如果不符合条件
        if (count * 2 != length) {
            //没结果
            return -1;
        }
        //返回
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().findMaxLength(new int[]{0, 1, 0, 1, 0, 1, 0, 1}));
    }

}
