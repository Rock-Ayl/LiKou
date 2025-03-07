package easy36;

/**
 * @Author ayl
 * @Date 2024-03-17
 * 100262. 求出加密整数的和
 * 简单
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，数组中的元素都是 正 整数。定义一个加密函数 encrypt ，encrypt(x) 将一个整数 x 中 每一个 数位都用 x 中的 最大 数位替换。比方说 encrypt(523) = 555 且 encrypt(213) = 333 。
 * <p>
 * 请你返回数组中所有元素加密后的 和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * <p>
 * 输出：6
 * <p>
 * 解释：加密后的元素位 [1,2,3] 。加密元素的和为 1 + 2 + 3 == 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [10,21,31]
 * <p>
 * 输出：66
 * <p>
 * 解释：加密后的元素为 [11,22,33] 。加密元素的和为 11 + 22 + 33 == 66 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 1000
 */
public class Code16 {

    //计算单个
    private int count(int num) {
        //几位
        int hit = 0;
        //最大的数字
        int max = 0;
        //循环
        while (num > 0) {
            //最后一位
            int thisNum = num % 10;
            //刷新最大
            max = Math.max(thisNum, max);
            //下一个
            num = num / 10;
            //+1
            hit++;
        }
        //结果
        int result = max;
        //如果还有
        while (hit-- > 1) {
            //叠加
            result = result * 10 + max;
        }
        //返回
        return result;
    }

    public int sumOfEncryptedInt(int[] nums) {
        //结果
        int sum = 0;
        //循环
        for (int num : nums) {
            //计算并叠加
            sum += count(num);
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().sumOfEncryptedInt(new int[]{109}));
    }

}
