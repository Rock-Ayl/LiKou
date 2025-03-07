package easy4;

/**
 * Created By Rock-Ayl on 2020-12-29
 * 747. 至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * <p>
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * <p>
 * 如果是，则返回最大元素的索引，否则返回-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 * <p>
 * 提示:
 * <p>
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 100].
 */
public class Code24 {

    public static int dominantIndex(int[] nums) {
        //第一大
        int first = 0;
        //最大的坐标
        int p = 0;
        //第二大
        int second = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前数
            int num = nums[i];
            //如果刷新最大纪录
            if (num > first) {
                //更新第二大
                second = first;
                //更新最大
                first = num;
                //更新P
                p = i;
            }
            //如果刷新第二大纪录
            else if (num > second) {
                //更新第二大
                second = num;
            }
        }
        //如果满足第二大是最大的二分之一并且第一大的不为0
        if (second * 2 <= first && first != 0) {
            //返回P
            return p;
        }
        //缺省
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
    }
}
