package normal17;

/**
 * @Author ayl
 * @Date 2022-10-23
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * <p>
 * <p>
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class Code1 {

    public int[] productExceptSelf(int[] nums) {
        //全部积
        int all = 1;
        //是否有0,默认没有
        boolean hasZero = false;
        //0的坐标
        int zeroP = -1;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果是0
            if (nums[i] == 0) {
                //如果之前没有
                if (hasZero == false) {
                    //记录
                    hasZero = true;
                    zeroP = i;
                    //过
                    continue;
                }
                //如果之前有
                if (hasZero) {
                    //直接返回结果
                    return new int[nums.length];
                }
            }
            //乘
            all *= nums[i];
        }
        //初始化结果
        int[] result = new int[nums.length];
        //如果有一个0
        if (hasZero) {
            //记录唯一有结果的位置
            result[zeroP] = all;
            //返回
            return result;
        }
        //循环
        for (int i = 0; i < nums.length; i++) {
            //计算结果
            result[i] = all / nums[i];
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().productExceptSelf(new int[]{0, 2, 3, 4}));
    }
}
