package normal17;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-11-09
 * 2442. 反转之后不同整数的数目
 * 给你一个由 正 整数组成的数组 nums 。
 * <p>
 * 你必须取出数组中的每个整数，反转其中每个数位，并将反转后得到的数字添加到数组的末尾。这一操作只针对 nums 中原有的整数执行。
 * <p>
 * 返回结果数组中 不同 整数的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,13,10,12,31]
 * 输出：6
 * 解释：反转每个数字后，结果数组是 [1,13,10,12,31,1,31,1,21,13] 。
 * 反转后得到的数字添加到数组的末尾并按斜体加粗表示。注意对于整数 10 ，反转之后会变成 01 ，即 1 。
 * 数组中不同整数的数目为 6（数字 1、10、12、13、21 和 31）。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2]
 * 输出：1
 * 解释：反转每个数字后，结果数组是 [2,2,2,2,2,2] 。
 * 数组中不同整数的数目为 1（数字 2）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class Code5 {

    public int countDistinctIntegers(int[] nums) {
        //初始化缓存
        Set<Integer> set = new HashSet<>();
        //循环
        for (int num : nums) {
            //先组装本体
            set.add(num);
            //本体的镜面
            int mirror = 0;
            //循环
            while (num > 0) {
                //镜面进位并叠加
                mirror = mirror * 10 + num % 10;
                //更改num
                num = num / 10;
            }
            //组装镜面
            set.add(mirror);
        }
        //返回结果
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new Code5().countDistinctIntegers(new int[]{2, 2, 2}));
    }

}
