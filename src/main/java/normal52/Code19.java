package normal52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1630. 等差子数组
 * 算术评级: 4
 * 第 212 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1422
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 等差数列 。更正式地，数列 s 是等差数列，只需要满足：对于每个有效的 i ， s[i+1] - s[i] == s[1] - s[0] 都成立。
 * <p>
 * 例如，下面这些都是 等差数列 ：
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 下面的数列 不是等差数列 ：
 * <p>
 * 1, 1, 2, 5, 7
 * 给你一个由 n 个整数组成的数组 nums，和两个由 m 个整数组成的数组 l 和 r，后两个数组表示 m 组范围查询，其中第 i 个查询对应范围 [l[i], r[i]] 。所有数组的下标都是 从 0 开始 的。
 * <p>
 * 返回 boolean 元素构成的答案列表 answer 。如果子数组 nums[l[i]], nums[l[i]+1], ... , nums[r[i]] 可以 重新排列 形成 等差数列 ，answer[i] 的值就是 true；否则answer[i] 的值就是 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
 * 输出：[true,false,true]
 * 解释：
 * 第 0 个查询，对应子数组 [4,6,5] 。可以重新排列为等差数列 [6,5,4] 。
 * 第 1 个查询，对应子数组 [4,6,5,9] 。无法重新排列形成等差数列。
 * 第 2 个查询，对应子数组 [5,9,3,7] 。可以重新排列为等差数列 [3,5,7,9] 。
 * 示例 2：
 * <p>
 * 输入：nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
 * 输出：[false,true,false,false,true,true]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * m == l.length
 * m == r.length
 * 2 <= n <= 500
 * 1 <= m <= 500
 * 0 <= l[i] < r[i] < n
 * -105 <= nums[i] <= 105
 */
public class Code19 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        //长度
        int length = l.length;
        //初始化结果
        List<Boolean> resultList = new ArrayList<>(length);
        //跳出标记
        out:
        //循环
        for (int i = 0; i < length; i++) {
            //获取开始结束
            int start = l[i];
            int end = r[i];
            //获取对应子数组、并排序
            int[] childArr = Arrays.stream(nums, start, end + 1).sorted().toArray();
            //获取柴智
            int diff = childArr[1] - childArr[0];
            //循环
            for (int j = 2; j < childArr.length; j++) {
                //判断是否等差
                if (childArr[j] - childArr[j - 1] != diff) {
                    //不是
                    resultList.add(false);
                    //本轮过
                    continue out;
                }
            }
            //是
            resultList.add(true);
        }
        //返回结果
        return resultList;
    }

    public static void main(String[] args) {
        List<Boolean> booleans = new Code19().checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5});
        System.out.println();
    }

}
