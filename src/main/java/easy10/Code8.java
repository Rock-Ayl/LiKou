package easy10;

/**
 * @Author ayl
 * @Date 2021-07-17
 * 1800. 最大升序子数组和
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * <p>
 * 子数组是数组中的一个连续数字序列。
 * <p>
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,20,30,5,10,50]
 * 输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,20,30,40,50]
 * 输出：150
 * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 * 示例 3：
 * <p>
 * 输入：nums = [12,17,15,13,10,11,12]
 * 输出：33
 * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 * 示例 4：
 * <p>
 * 输入：nums = [100,10,1]
 * 输出：100
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code8 {

    public int maxAscendingSum(int[] nums) {
        //最大
        int max = nums[0];
        //当前
        int lastSize = nums[0];
        //上个值
        int last = nums[0];
        //循环
        for (int i = 1; i < nums.length; i++) {
            //下个值
            int next = nums[i];
            //如果升序
            if (next > last) {
                //更新
                lastSize += next;
            } else {
                //更新当前值
                lastSize = next;
            }
            //如果破纪录了
            if (lastSize > max) {
                //刷新
                max = lastSize;
            }
            //更新上一个值
            last = next;
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
    }
}
