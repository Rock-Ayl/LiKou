package normal13;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ayl
 * @Date 2022-03-29
 * 1288. 删除被覆盖区间
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * <p>
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * <p>
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 * <p>
 * <p>
 * 提示：​​​​​​
 * <p>
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * 对于所有的 i != j：intervals[i] != intervals[j]
 */
public class Code15 {

    public int removeCoveredIntervals(int[][] intervals) {
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //按照先开始后结束的节点进行排序
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        //被删除的个数
        int count = 0;
        //当前最大的节点
        int maxEnd = 0;
        //循环
        for (int i = 0; i < intervals.length; i++) {
            //本节点结束节点
            int end = intervals[i][1];
            //如果更大
            if (end > maxEnd) {
                //使用现在的节点
                maxEnd = end;
            } else {
                //删除
                count++;
            }
        }
        //返回结果
        return intervals.length - count;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().removeCoveredIntervals(new int[][]{
                new int[]{1, 4},
                new int[]{3, 6},
                new int[]{2, 8},
                new int[]{2, 7},
                new int[]{2, 5}
        }));
        ;
    }

}
