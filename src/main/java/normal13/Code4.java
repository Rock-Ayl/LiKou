package normal13;

/**
 * @Author ayl
 * @Date 2022-03-14
 * 2149. 按符号重排数组
 * 给你一个下标从 0 开始的整数数组 nums ，数组长度为 偶数 ，由数目相等的正整数和负整数组成。
 * <p>
 * 你需要 重排 nums 中的元素，使修改后的数组满足下述条件：
 * <p>
 * 任意 连续 的两个整数 符号相反
 * 对于符号相同的所有整数，保留 它们在 nums 中的 顺序 。
 * 重排后数组以正整数开头。
 * 重排元素满足上述条件后，返回修改后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,-2,-5,2,-4]
 * 输出：[3,-2,1,-5,2,-4]
 * 解释：
 * nums 中的正整数是 [3,1,2] ，负整数是 [-2,-5,-4] 。
 * 重排的唯一可行方案是 [3,-2,1,-5,2,-4]，能满足所有条件。
 * 像 [1,-2,2,-5,3,-4]、[3,1,2,-2,-5,-4]、[-2,3,-5,1,-4,2] 这样的其他方案是不正确的，因为不满足一个或者多个条件。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,1]
 * 输出：[1,-1]
 * 解释：
 * 1 是 nums 中唯一一个正整数，-1 是 nums 中唯一一个负整数。
 * 所以 nums 重排为 [1,-1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2 * 105
 * nums.length 是 偶数
 * 1 <= |nums[i]| <= 105
 * nums 由 相等 数量的正整数和负整数组成
 */
public class Code4 {

    public int[] rearrangeArray(int[] nums) {
        //缓存
        int[] singles = new int[nums.length / 2];
        int[] parts = new int[nums.length / 2];
        //指针
        int a = 0, b = 0;
        //循环
        for (int num : nums) {
            //如果是正数
            if (num > -1) {
                //记录
                parts[b++] = num;
            } else {
                //记录
                singles[a++] = num;
            }
        }
        //默认从负开始走
        boolean plus = false;
        //指针
        int aa = 0, bb = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果是正
            if (plus) {
                //赋予
                nums[i] = singles[aa++];
            } else {
                //赋予
                nums[i] = parts[bb++];
            }
            //翻转
            plus = !plus;
        }
        //返回
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().rearrangeArray(new int[]{3, 1, -2, -5, 2, -4}));
    }

}
