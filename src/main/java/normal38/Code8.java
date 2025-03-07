package normal38;

/**
 * @Author ayl
 * @Date 2024-12-04
 * 3153. 所有数对中数位差之和
 * 中等
 * 你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 * <p>
 * 两个整数的 数位差 指的是两个整数 相同 位置上不同数字的数目。
 * <p>
 * 请你返回 nums 中 所有 整数对里，数位差之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [13,23,12]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * 计算过程如下：
 * - 13 和 23 的数位差为 1 。
 * - 13 和 12 的数位差为 1 。
 * - 23 和 12 的数位差为 2 。
 * 所以所有整数数对的数位差之和为 1 + 1 + 2 = 4 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [10,10,10,10]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * 数组中所有整数都相同，所以所有整数数对的数位不同之和为 0 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] < 109
 * nums 中的整数都有相同的数位长度。
 */
public class Code8 {

    public long sumDigitDifferences(int[] nums) {
        //计算本次数字的数位
        int length = countLength(nums[0]);
        //初始化所有数位的统计数组
        int[][] countArr = new int[length][10];
        //循环所有数字
        for (int num : nums) {
            //索引
            int index = countArr.length - 1;
            //循环
            while (num > 9) {
                //记录本次
                countArr[index--][num % 10]++;
                //下一个
                num = num / 10;
            }
            //最后一位
            countArr[index][num % 10]++;
        }
        //目标结果
        long result = 0L;
        //循环
        for (int i = 0; i < nums.length - 1; i++) {
            //当前数字
            int num = nums[i];
            //索引
            int index = countArr.length - 1;
            //循环
            while (num > 9) {
                //先删除本数字的数位,获取剩余相同数位
                int other = --countArr[index--][num % 10];
                //计算本次不同数位
                result += nums.length - i - other - 1;
                //下一个
                num = num / 10;
            }
            //最后一位
            int other = --countArr[index][num % 10];
            //计算本次不同数位
            result += nums.length - i - other - 1;
        }
        //返回
        return result;
    }

    //计算本次数字的数位
    private int countLength(int num) {
        //循环,默认1
        int result = 1;
        //循环
        while (num > 9) {
            //除以10
            num = num / 10;
            //+1
            result++;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().sumDigitDifferences(new int[]{13, 23, 12}));
    }

}
