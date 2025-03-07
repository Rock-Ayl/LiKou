package easy2;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2020-09-25
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Code7 {

    /**
     * 最优解,原理:异或两次直接归0
     *
     * @param nums
     * @return
     */
    public static int best(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }

    public static int singleNumber(int[] nums) {
        //排序
        Arrays.sort(nums);
        //返回值
        int num = 0;
        //是记录
        boolean isCheck = false;
        //循环
        for (int i : nums) {
            //如果已经记录了
            if (isCheck) {
                //如果不同
                if (num != i) {
                    //返回那个不一样的
                    return num;
                } else {
                    //未记录
                    isCheck = false;
                }
            } else {
                //记录
                num = i;
                //已记录
                isCheck = true;
            }
        }
        //缺省
        return num;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(best(new int[]{4, 1, 2, 1, 2}));
    }

}
