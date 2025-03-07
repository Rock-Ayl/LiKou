package easy29;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-03-11
 * 1018. 可被 5 整除的二进制前缀
 * 给定一个二进制数组 nums ( 索引从0开始 )。
 * <p>
 * 我们将xi 定义为其二进制表示形式为子数组 nums[0..i] (从最高有效位到最低有效位)。
 * <p>
 * 例如，如果 nums =[1,0,1] ，那么 x0 = 1, x1 = 2, 和 x2 = 5。
 * 返回布尔值列表 answer，只有当 xi 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为 true 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：[false,false,false]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 仅为 0 或 1
 */
public class Code2 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        //结果
        List<Boolean> result = new ArrayList<>(nums.length);
        //数字
        int num = 0;
        //循环其余的
        for (int i = 0; i < nums.length; i++) {
            //进位并加当前(最后余数减位数,保证无论多少次,结果不变,但不会溢出)
            num = (num * 2 + nums[i]) % 10;
            //计算本次结果
            result.add(num == 0 || num == 5);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().prefixesDivBy5(new int[]{0, 1, 1}));
    }

}
