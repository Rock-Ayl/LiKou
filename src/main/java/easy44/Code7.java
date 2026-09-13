package easy44;

/**
 * 4048. 统计等间距出现整数数目 I
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 nums。
 * <p>
 * 如果一个整数 x 满足以下条件，则被称为 特别 的：
 * <p>
 * x 在 nums 中 恰好出现三次。
 * x 的 所有 三次出现，在 nums 中都是 等间隔 的。换句话说，如果 x 的所有出现位置的下标为 i1 < i2 < i3，那么 i2 - i1 = i3 - i2。
 * 返回 nums 中 不同 特别整数的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,8,1,5,1,5,8,5]
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * <p>
 * 1 是特别的，因为它恰好出现三次，且出现的等间隔下标为 0、2 和 4。
 * 5 是特别的，因为它恰好出现三次，且出现的等间隔下标为 3、5 和 7。
 * 8 不是特别的，因为它只出现了两次。
 * 因此，答案是 2。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [8,8,8,8]
 * <p>
 * 输出: 0
 * <p>
 * 解释:
 * <p>
 * 8 不是特别的，因为它出现的次数不是恰好三次。因此，答案是 0。
 * <p>
 * 示例 3:
 * <p>
 * 输入: nums = [8,6,6,8,8]
 * <p>
 * 输出: 0
 * <p>
 * 解释:
 * <p>
 * 8 出现的下标为 0、3 和 4，这些下标不是等间隔的。6 只出现了两次。因此，没有整数是特别的。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 3 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code7 {

    public int countSpecialIntegers(int[] nums) {

        /**
         * 构建 计数器、索引
         */

        //计数器
        int[] countArr = new int[101];
        //索引
        int[][] indexArr = new int[101][3];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果还有记录的必要
            if (countArr[nums[i]] < 3) {
                //记录索引
                indexArr[nums[i]][countArr[nums[i]]] = i;
            }
            //计数器+1
            countArr[nums[i]]++;
        }

        /**
         * 寻找结果
         */

        //结果
        int count = 0;
        //循环
        for (int i = 0; i < countArr.length; i++) {
            //如果不是目标
            if (countArr[i] != 3) {
                //本轮过
                continue;
            }
            //如果等间距
            if (indexArr[i][0] - indexArr[i][1] == indexArr[i][1] - indexArr[i][2]) {
                //结果+1
                count++;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().countSpecialIntegers(new int[]{1, 8, 1, 5, 1, 5, 8, 5}));
    }

}
