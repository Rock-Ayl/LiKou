package normal4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-05-18
 * 1578. 避免重复字母的最小删除成本
 * 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 * <p>
 * 返回使字符串任意相邻两个字母不相同的最小删除成本。
 * <p>
 * 请注意，删除一个字符后，删除其他字符的成本不会改变。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abaac", cost = [1,2,3,4,5]
 * 输出：3
 * 解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
 * 示例 2：
 * <p>
 * 输入：s = "abc", cost = [1,2,3]
 * 输出：0
 * 解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
 * 示例 3：
 * <p>
 * 输入：s = "aabaa", cost = [1,2,3,4,1]
 * 输出：2
 * 解释：删除第一个和最后一个字母，得到字符串 ("aba") 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * s.length == cost.length
 * 1 <= s.length, cost.length <= 10^5
 * 1 <= cost[i] <= 10^4
 * s 中只含有小写英文字母
 * 通过次数9,793提交次数16,986
 */
public class Code4 {

    public int minCost(String s, int[] cost) {
        //最小花费
        int result = 0;
        //开始,结束
        int first = 0, end = 0;
        //循环
        for (int i = 1; i < s.length(); i++) {
            //当前字符
            char space = s.charAt(i);
            //上一个字符
            char last = s.charAt(i - 1);
            //如果一致
            if (last == space) {
                //刷新结束
                end = i;
            } else {
                //如果要删除
                if (end - first > 0) {
                    //和
                    int sum = 0;
                    //最大的花费
                    int max = 0;
                    //循环
                    for (int j = first; j <= end; j++) {
                        //组装
                        sum += cost[j];
                        //如果有更大的花费
                        if (cost[j] > max) {
                            //更新
                            max = cost[j];
                        }
                    }
                    //计算最小花费
                    result += (sum - max);
                }
                //更新开始结束
                first = i;
                end = i;
            }
        }
        //如果要删除
        if (end - first > 0) {
            //和
            int sum = 0;
            //最大的花费
            int max = 0;
            //循环
            for (int j = first; j <= end; j++) {
                //组装
                sum += cost[j];
                //如果有更大的花费
                if (cost[j] > max) {
                    //更新
                    max = cost[j];
                }
            }
            //计算最小花费
            result += (sum - max);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
    }
}
