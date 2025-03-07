package easy6;

/**
 * Created By Rock-Ayl on 2021-02-05
 * 1437. 是否所有 1 都至少相隔 k 个元素
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,0,0,1,0,0,1], k = 2
 * 输出：true
 * 解释：每个 1 都至少相隔 2 个元素。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [1,0,0,1,0,1], k = 2
 * 输出：false
 * 解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1,1], k = 0
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：nums = [0,1,0,1], k = 1
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= k <= nums.length
 * nums[i] 的值为 0 或 1
 */
public class Code9 {

    public static boolean kLengthApart(int[] nums, int k) {
        //如果小于1
        if (k < 1) {
            //直接过
            return true;
        }
        //上一个1的位置
        int lastOneP = -1;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前字符
            int thisOne = nums[i];
            //如果这个等于1
            if (thisOne == 1) {
                //如果第一个1
                if (lastOneP == -1) {
                    //记录即可
                    lastOneP = i;
                } else {
                    //如果不符合距离
                    if (!(i - lastOneP - k - 1 >= 0)) {
                        //直接返回
                        return false;
                    } else {
                        //记录
                        lastOneP = i;
                    }
                }
            }
        }
        //可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
    }
}
