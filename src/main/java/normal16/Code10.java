package normal16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-09-02
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
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
 */
public class Code10 {

    public int[][] merge(int[][] intervals) {
        //如果太小
        if (intervals.length < 2) {
            //直接返回即可
            return intervals;
        }
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //如果开始相同
                if (o1[0] == o2[0]) {
                    //对比结束
                    return o1[1] - o2[1];
                } else {
                    //对比开始
                    return o1[0] - o2[0];
                }
            }
        });
        //初始化结果
        List<List<Integer>> result = new ArrayList<>();
        //初始化
        int start = intervals[0][0];
        int end = intervals[0][1];
        //循环
        for (int i = 1; i < intervals.length; i++) {
            //当前
            int thisStart = intervals[i][0];
            int thisEnd = intervals[i][1];
            //如果彻底分开了
            if (thisStart > end) {
                //记录
                result.add(Arrays.asList(start, end));
                //刷新
                start = thisStart;
                end = Math.max(thisEnd, end);
            } else {
                //单纯刷新结束
                end = Math.max(thisEnd, end);
            }
        }
        //如果没有 或者 最后没有清算
        if (result.size() == 0 || result.get(result.size() - 1).get(1) != end) {
            //记录最后
            result.add(Arrays.asList(start, end));
        }
        //初始化结果
        int[][] arr = new int[result.size()][2];
        //循环
        for (int i = 0; i < result.size(); i++) {
            //组装
            arr[i] = new int[]{result.get(i).get(0), result.get(i).get(1)};
        }
        //返回
        return arr;
    }

    public static void main(String[] args) {
        new Code10().merge(new int[][]{
                new int[]{1, 4},
                new int[]{4, 5}
        });
    }

}
