package easy43;

/**
 * 3917. 统计下标的相反奇偶性得分
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums。
 * <p>
 * 下标 i 的 分数 定义为满足以下条件的下标 j 的数量：
 * <p>
 * i < j < n，并且
 * nums[i] 和 nums[j] 的奇偶性不同（一个为偶数，另一个为奇数）。
 * 返回一个长度为 n 的整数数组 answer，其中 answer[i] 表示下标 i 的分数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3,4]
 * <p>
 * 输出： [2,1,1,0]
 * <p>
 * 解释：
 * <p>
 * nums[0] = 1，为奇数。因此，下标 j = 1 和 j = 3 满足条件，所以下标 0 的分数为 2。
 * nums[1] = 2，为偶数。因此，下标 j = 2 满足条件，所以下标 1 的分数为 1。
 * nums[2] = 3，为奇数。因此，下标 j = 3 满足条件，所以下标 2 的分数为 1。
 * nums[3] = 4，为偶数。因此，没有下标满足条件，所以下标 3 的分数为 0。
 * 因此，answer = [2, 1, 1, 0]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1]
 * <p>
 * 输出： [0]
 * <p>
 * 解释：
 * <p>
 * nums 中只有一个元素。因此，下标 0 的分数为 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code6 {

    public int[] countOppositeParity(int[] nums) {

        /**
         * 统计奇偶性
         */

        //奇偶数组
        int[] singleArr = new int[nums.length];
        int[] doubleArr = new int[nums.length];
        //初始化最后一个
        singleArr[singleArr.length - 1] = nums[singleArr.length - 1] % 2 == 1 ? 1 : 0;
        doubleArr[singleArr.length - 1] = nums[singleArr.length - 1] % 2 == 0 ? 1 : 0;
        //从后往前遍历，统计奇偶性
        for (int i = singleArr.length - 2; i >= 0; i--) {
            //叠加
            singleArr[i] = nums[i] % 2 == 1 ? singleArr[i + 1] + 1 : singleArr[i + 1];
            doubleArr[i] = nums[i] % 2 == 0 ? doubleArr[i + 1] + 1 : doubleArr[i + 1];
        }

        /**
         * 计算结果
         */

        //初始化
        int[] result = new int[nums.length];
        //循环
        for (int i = 0; i < result.length; i++) {
            //如果是奇数
            if (nums[i] % 2 == 1) {
                //使用偶数
                result[i] = doubleArr[i];
            } else {
                //使用奇数
                result[i] = singleArr[i];
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code6().countOppositeParity(new int[]{1, 2, 3, 4});
        System.out.println();
    }

}