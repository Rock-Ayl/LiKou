package easy27;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-02-01
 * 1399. 统计最大组的数目
 * 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 * <p>
 * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：4
 * 解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
 * [1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：总共有 2 个大小为 1 的组 [1]，[2]。
 * 示例 3：
 * <p>
 * 输入：n = 15
 * 输出：6
 * 示例 4：
 * <p>
 * 输入：n = 24
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^4
 */
public class Code13 {

    public int countLargestGroup(int n) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //指针
        int p = 1;
        //最多组数
        int maxGroupCount = 0;
        //最多组数count
        int maxGroupCountCount = 0;
        //循环
        while (p <= n) {
            //当前数字
            int num = p++;
            //当前和
            int sum = 0;
            //循环
            while (num > 0) {
                //叠加
                sum += num % 10;
                //下一个
                num = num / 10;
            }
            //计算出新的组数
            int count = map.getOrDefault(sum, 0) + 1;
            //如果刷新了
            if (count > maxGroupCount) {
                //更新
                maxGroupCount = count;
                maxGroupCountCount = 1;
            } else if (count == maxGroupCount) {
                //叠加
                maxGroupCountCount++;
            }
            //记录
            map.put(sum, count);
        }
        //返回结果
        return maxGroupCountCount;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().countLargestGroup(24));
    }
}
