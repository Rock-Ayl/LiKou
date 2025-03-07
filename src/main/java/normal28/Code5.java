package normal28;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ayl
 * @Date 2024-01-19
 * LCR 074. 合并区间
 * 中等
 * 相关标签
 * 相关企业
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * <p>
 * 注意：本题与主站 56 题相同： https://leetcode-cn.com/problems/merge-intervals/
 */
public class Code5 {

    public int[][] merge(int[][] intervals) {
        //按照左边排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //慢指针
        int index = 0;
        //循环,快指针
        for (int i = 1; i < intervals.length; i++) {
            //当前
            int[] interval = intervals[i];
            //获取上一个
            int[] last = intervals[index];
            //判断是需要合并
            if (last[1] < interval[0]) {
                //不合并,直接加入
                intervals[++index] = interval;
            } else {
                //合并
                last[1] = Math.max(interval[1], last[1]);
            }
        }
        //复制个新的结果并返回
        return Arrays.copyOf(intervals, index + 1);
    }

    public static void main(String[] args) {
        int[][] arr = new Code5().merge(new int[][]{
                new int[]{2, 3},
                new int[]{4, 5},
                new int[]{1, 10},
                new int[]{6, 7}

        });
        System.out.println();
    }

}
