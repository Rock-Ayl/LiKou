package normal28;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-01-23
 * 1985. 找出数组中的第 K 大整数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。
 * <p>
 * 返回 nums 中表示第 k 大整数的字符串。
 * <p>
 * 注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1" 是第三大的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = ["3","6","7","10"], k = 4
 * 输出："3"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["3","6","7","10"]
 * 其中第 4 大整数是 "3"
 * 示例 2：
 * <p>
 * 输入：nums = ["2","21","12","1"], k = 3
 * 输出："2"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["1","2","12","21"]
 * 其中第 3 大整数是 "2"
 * 示例 3：
 * <p>
 * 输入：nums = ["0","0"], k = 2
 * 输出："0"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["0","0"]
 * 其中第 2 大整数是 "0"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * 1 <= nums[i].length <= 100
 * nums[i] 仅由数字组成
 * nums[i] 不含任何前导零
 */
public class Code8 {

    public String kthLargestNumber(String[] nums, int k) {
        //优先队列
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //如果长度不同
                if (o1.length() != o2.length()) {
                    //按照长度匹配
                    return o2.length() - o1.length();
                }
                //循环
                for (int i = 0; i < o1.length(); i++) {
                    //如果字符不同
                    if (o1.charAt(i) != o2.charAt(i)) {
                        //按照字符
                        return o2.charAt(i) - o1.charAt(i);
                    }
                }
                //默认
                return 0;
            }
        });
        //加入所有
        queue.addAll(Arrays.stream(nums).collect(Collectors.toList()));
        //循环
        while (k-- > 1) {
            //弹出
            queue.poll();
        }
        //返回目标结果
        return queue.poll();
    }

    public static void main(String[] args) {
        System.out.println(new Code8().kthLargestNumber(new String[]{"2", "21", "12", "1"}, 3));
    }

}
