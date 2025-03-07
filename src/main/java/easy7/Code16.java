package easy7;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2021-03-12
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5
 * <p>
 * 数组的数取值为 [0, 13] .
 */
public class Code16 {

    public static boolean isStraight(int[] nums) {
        //0的个数
        int zeroSize = 0;
        //排个序
        Arrays.sort(nums);
        //位置
        int p = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前数
            int num = nums[i];
            //如果是0
            if (num == 0) {
                //记录
                zeroSize++;
            } else {
                //记录
                p = i;
                //跳出
                break;
            }
        }
        //差
        int minus = 0;
        //循环次数
        int size = nums.length - p - 1;
        //倒叙循环
        for (int i = nums.length - 1; i > p; i--) {
            //当前值
            int x = nums[i];
            //下一个值
            int y = nums[i - 1];
            //如果有相同
            if (x == y) {
                //铁定不是顺子了
                return false;
            }
            //取差,记录
            minus += x - y;
        }
        //如果说不满足顺子的条件,条件: 差-具体循环次数-大小王次数 还大于0,就不是顺子
        if (minus - size - zeroSize > 0) {
            //不是顺子
            return false;
        } else {
            //是顺子
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{0, 0, 1, 2, 5}));
    }
}
