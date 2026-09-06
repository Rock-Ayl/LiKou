package normal56;

import java.util.ArrayList;
import java.util.List;

/**
 * 1409. 查询带键的排列
 * 算术评级: 3
 * 第 184 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1335
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个正整数数组 queries ，其取值范围在 1 到 m 之间。 请你根据以下规则按顺序处理所有 queries[i]（从 i=0 到 i=queries.length-1）：
 * <p>
 * 首先，你有一个排列 P=[1,2,3,...,m]。
 * 对于当前的 i ，找到 queries[i] 在排列 P 中的位置（从 0 开始索引），然后将它移到排列 P 的开头（即下标为 0 处）。注意， queries[i] 的查询结果是 queries[i] 在 P 中移动前的位置。
 * 返回一个数组，包含从给定  queries 中查询到的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = [3,1,2,1], m = 5
 * 输出：[2,1,2,1]
 * 解释：处理 queries 的过程如下：
 * 对于 i=0: queries[i]=3, P=[1,2,3,4,5], 3 在 P 中的位置是 2，然后我们把 3 移动到 P 的开头，得到 P=[3,1,2,4,5] 。
 * 对于 i=1: queries[i]=1, P=[3,1,2,4,5], 1 在 P 中的位置是 1，然后我们把 1 移动到 P 的开头，得到 P=[1,3,2,4,5] 。
 * 对于 i=2: queries[i]=2, P=[1,3,2,4,5], 2 在 P 中的位置是 2，然后我们把 2 移动到 P 的开头，得到 P=[2,1,3,4,5] 。
 * 对于 i=3: queries[i]=1, P=[2,1,3,4,5], 1 在 P 中的位置是 1，然后我们把 1 移动到 P 的开头，得到 P=[1,2,3,4,5] 。
 * 因此，包含结果的数组为 [2,1,2,1] 。
 * 示例 2：
 * <p>
 * 输入：queries = [4,1,2,2], m = 4
 * 输出：[3,1,2,0]
 * 示例 3：
 * <p>
 * 输入：queries = [7,5,5,8,3], m = 8
 * 输出：[6,5,0,7,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m <= 10^3
 * 1 <= queries.length <= m
 * 1 <= queries[i] <= m
 *
 */
public class Code25 {

    public int[] processQueries(int[] queries, int m) {
        //初始化排列
        List<Integer> numList = new ArrayList<>();
        //循环
        for (int i = 1; i <= m; i++) {
            //组装
            numList.add(i);
        }
        //初始化结果
        int[] result = new int[queries.length];
        //循环
        for (int i = 0; i < result.length; i++) {
            //目标值
            int query = queries[i];
            //索引
            int index = 0;
            //如果不是
            while (numList.get(index) != query) {
                //下一个
                index++;
            }
            //记录本次结果
            result[i] = index;
            //移动本次
            numList.remove(index);
            numList.add(0, query);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code25().processQueries(new int[]{3, 1, 2, 1}, 5);
    }

}
