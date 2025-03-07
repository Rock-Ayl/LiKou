package easy7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-03-03
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 * <p>
 * 输入：nums = [0]
 * 输出：["0"]
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 */
public class Code7 {

    public static List<String> summaryRanges(int[] nums) {
        //判空
        if (nums.length == 0) {
            //返回
            return new ArrayList<>();
        }
        //初始化
        List<String> result = new ArrayList<>();
        //当前
        StringBuffer thisSpace = new StringBuffer();
        //左边开头
        int first = 0;
        //当前左边
        int a = 0;
        //循环
        for (int num : nums) {
            //如果是左边
            if (thisSpace.length() == 0) {
                //直接组装
                thisSpace.append(num);
                //开头
                first = num;
                //当前
                a = num;
            } else {
                //如果是连续的
                if (a + 1 == num) {
                    //更新
                    a = num;
                } else {
                    //如果是单个
                    if (first != a) {
                        //记录右边
                        thisSpace.append("->" + a);
                    }
                    //记录
                    result.add(thisSpace.toString());
                    //初始化
                    thisSpace = new StringBuffer();
                    //更新当前
                    thisSpace.append(num);
                    //首个
                    first = num;
                    //记录
                    a = num;
                }
            }
        }
        //如果是单个
        if (first != a) {
            //记录右边
            thisSpace.append("->" + a);
        }
        //记录
        result.add(thisSpace.toString());
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (String summaryRange : summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9})) {
            System.out.println(summaryRange);
        }
    }
}
