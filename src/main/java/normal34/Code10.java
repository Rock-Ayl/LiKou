package normal34;

import java.util.ArrayDeque;

/**
 * @Author ayl
 * @Date 2024-08-18
 * 2772. 使数组中的所有元素都等于零
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个正整数 k 。
 * <p>
 * 你可以对数组执行下述操作 任意次 ：
 * <p>
 * 从数组中选出长度为 k 的 任一 子数组，并将子数组中每个元素都 减去 1 。
 * 如果你可以使数组中的所有元素都等于 0 ，返回  true ；否则，返回 false 。
 * <p>
 * 子数组 是数组中的一个非空连续元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,1,1,0], k = 3
 * 输出：true
 * 解释：可以执行下述操作：
 * - 选出子数组 [2,2,3] ，执行操作后，数组变为 nums = [1,1,2,1,1,0] 。
 * - 选出子数组 [2,1,1] ，执行操作后，数组变为 nums = [1,1,1,0,0,0] 。
 * - 选出子数组 [1,1,1] ，执行操作后，数组变为 nums = [0,0,0,0,0,0] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,1,1], k = 2
 * 输出：false
 * 解释：无法使数组中的所有元素等于 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 105
 * 0 <= nums[i] <= 106
 */
public class Code10 {

    public boolean checkArray(int[] nums, int k) {
        //双端队列
        ArrayDeque<Integer> list = new ArrayDeque<>();
        //当前需要减少的操作数
        int delete = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前数字
            int num = nums[i];
            //如果需要剔除最前面的
            if (list.size() == k) {
                //删除第一个并叠加回来
                delete -= list.pollFirst();
            }
            //如果到这里,已经删除的超额了
            if (delete > num) {
                //不行
                return false;
            }
            //如果是最后几个k以内的情况,无法操作,需要直接判断是否满足
            if (i + k > nums.length && num != delete) {
                //不行
                return false;
            }
            //计算出要删除的值,可以为0
            int willDelete = num - delete;
            //叠加
            delete += willDelete;
            //加入队列
            list.addLast(willDelete);
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().checkArray(new int[]{2, 2, 3, 1, 1, 0}, 3));
    }

}
