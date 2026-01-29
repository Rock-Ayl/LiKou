package normal50;

/**
 * 1775. 通过最少操作次数使数组的和相等
 * 算术评级: 6
 * 第 230 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1850
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
 * <p>
 * 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
 * <p>
 * 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * 输出：-1
 * 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
 * 示例 3：
 * <p>
 * 输入：nums1 = [6,6], nums2 = [1]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
 * - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
 * - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[i] <= 6
 */
public class Code1 {

    public int minOperations(int[] nums1, int[] nums2) {

        /**
         * 构建统计
         */

        //计数器
        int[] oneArr = new int[7];
        int[] twoArr = new int[7];

        //和
        int sum1 = 0;
        int sum2 = 0;

        //循环
        for (int num : nums1) {
            //+1
            oneArr[num]++;
            //叠加
            sum1 += num;
        }
        //循环
        for (int num : nums2) {
            //+1
            twoArr[num]++;
            //叠加
            sum2 += num;
        }

        /**
         * 计算
         */

        //如果相同
        if (sum1 == sum2) {
            //结束
            return 0;
        }
        //判断大小
        if (sum1 > sum2) {
            //实现
            return count(oneArr, sum1, twoArr, sum2);
        } else {
            //实现
            return count(twoArr, sum2, oneArr, sum1);
        }
    }

    //计算结果
    private int count(int[] bigArr, int bigSum, int[] smallArr, int smallSum) {
        //结果
        int result = 0;
        //二者索引
        int bigIndex = 6;
        int smallIndex = 1;
        //如果还不相同
        while (bigSum != smallSum) {
            //如果没有值
            if (bigIndex > 0 && bigArr[bigIndex] == 0) {
                //--
                bigIndex--;
                //本轮过
                continue;
            }
            //如果没有值
            if (smallIndex < smallArr.length && smallArr[smallIndex] == 0) {
                //+1
                smallIndex++;
                //本轮过
                continue;
            }
            //二者一次靠近的值
            int bigRemove = bigIndex - 1;
            int smallAdd = 6 - smallIndex;
            //我们最多需要
            int other = bigSum - smallSum;
            //如果没有
            if (bigRemove <= 0 && smallAdd <= 0) {
                //无法满足
                return -1;
            }
            //如果大的更多
            if (bigRemove > smallAdd) {
                //计算当前最大可以靠近的值
                int max = bigRemove * bigArr[bigIndex];
                //如果完全消耗
                if (max <= other) {
                    //叠加本次消耗数
                    result += bigArr[bigIndex];
                    //消耗
                    bigSum -= max;
                    bigArr[bigIndex--] = 0;
                } else {
                    //计算本次消耗数
                    int count = (other / bigRemove) + (other % bigRemove == 0 ? 0 : 1);
                    //叠加本次消耗数
                    result += count;
                    //消耗
                    bigSum -= other;
                    bigArr[bigIndex] -= count;
                }
            } else {
                //计算当前最大可以靠近的值
                int max = smallAdd * smallArr[smallIndex];
                //如果完全消耗
                if (max <= other) {
                    //叠加本次消耗数
                    result += smallArr[smallIndex];
                    //消耗
                    smallSum += max;
                    smallArr[smallIndex++] = 0;
                } else {
                    //计算本次消耗数
                    int count = (other / smallAdd) + (other % smallAdd == 0 ? 0 : 1);
                    //叠加本次消耗数
                    result += count;
                    //消耗
                    smallSum += other;
                    smallArr[smallIndex] -= count;
                }
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(new Code1().minOperations(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6}));

        System.out.println(new Code1().minOperations(new int[]{5, 6, 4, 3, 1, 2}, new int[]{6, 3, 3, 1, 4, 5, 3, 4, 1, 3, 4}));

    }

}
