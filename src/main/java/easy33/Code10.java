package easy33;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-09-17
 * 8039. 使数组成为递增数组的最少右移次数
 * 提示
 * 简单
 * 2
 * 相关企业
 * 给你一个长度为 n 下标从 0 开始的数组 nums ，数组中的元素为 互不相同 的正整数。请你返回让 nums 成为递增数组的 最少右移 次数，如果无法得到递增数组，返回 -1 。
 * <p>
 * 一次 右移 指的是同时对所有下标进行操作，将下标为 i 的元素移动到下标 (i + 1) % n 处。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：2
 * 解释：
 * 第一次右移后，nums = [2,3,4,5,1] 。
 * 第二次右移后，nums = [1,2,3,4,5] 。
 * 现在 nums 是递增数组了，所以答案为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,5]
 * 输出：0
 * 解释：nums 已经是递增数组了，所以答案为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,4]
 * 输出：-1
 * 解释：无法将数组变为递增数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * nums 中的整数互不相同。
 */
public class Code10 {

    public int minimumRightShifts(List<Integer> nums) {
        //上次非递增的索引
        int lastCutIndex = -1;
        //上一个数字
        int last = nums.get(0);
        //循环
        for (int i = 1; i < nums.size(); i++) {
            //当前数字
            int num = nums.get(i);
            //如果不是正常
            if (num <= last) {
                //记录索引
                lastCutIndex = i;
                //跳出
                break;
            }
            //记录数字
            last = num;
        }
        //如果没有
        if (lastCutIndex == -1) {
            //不需要
            return 0;
        }
        //重置为最小值
        last = nums.get(lastCutIndex);
        //循环
        for (int i = lastCutIndex + 1; i < nums.size(); i++) {
            //当前数字
            int num = nums.get(i);
            //如果还有
            if (num <= last) {
                //不行
                return -1;
            }
            //跟换
            last = num;
        }
        //循环2
        for (int i = 0; i < lastCutIndex; i++) {
            //当前数字
            int num = nums.get(i);
            //如果还有
            if (num <= last) {
                //不行
                return -1;
            }
            //跟换
            last = num;
        }
        //返回结果
        return nums.size() - lastCutIndex;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().minimumRightShifts(Arrays.asList(2, 1, 4)));
    }

}
