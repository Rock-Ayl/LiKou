package normal53;

/**
 * 1664. 生成平衡数组的方案数
 * 算术评级: 6
 * 第 216 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1590
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 * <p>
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 * <p>
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 * <p>
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class Code13 {

    public int waysToMakeFair(int[] nums) {

        /**
         * 构建两种 奇偶性前缀和
         */

        //正常奇偶数和数组
        int[] singleSumArr = new int[nums.length];
        int[] doubleSumArr = new int[nums.length];
        //初始化
        doubleSumArr[0] = nums[0];
        //循环
        for (int i = 1; i < nums.length; i++) {
            //判断奇偶
            if (i % 2 == 0) {
                //叠加
                doubleSumArr[i] = doubleSumArr[i - 1] + nums[i];
                singleSumArr[i] = singleSumArr[i - 1];
            } else {
                //叠加
                doubleSumArr[i] = doubleSumArr[i - 1];
                singleSumArr[i] = singleSumArr[i - 1] + nums[i];
            }
        }

        /**
         * 计算
         */

        //结果
        int result = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //删除当前索引数字的二者的前缀和
            int singleSum = 0;
            int doubleSum = 0;
            //前半部分
            singleSum += i > 0 ? singleSumArr[i - 1] : 0;
            doubleSum += i > 0 ? doubleSumArr[i - 1] : 0;
            //后半部分
            singleSum += doubleSumArr[doubleSumArr.length - 1] - doubleSumArr[i];
            doubleSum += singleSumArr[singleSumArr.length - 1] - singleSumArr[i];
            //如果相同
            if (singleSum == doubleSum) {
                //+1
                result++;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().waysToMakeFair(new int[]{2, 1, 6, 4}));
    }

}
