package easy44;

import java.util.Arrays;

/**
 * 4056. 统计相交区间对 I
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个包含 n 个元素的二维整数数组 intervals，其中 intervals[i] = [starti, endi] 表示从 starti 到 endi 的 闭区间 。
 * <p>
 * 返回满足 0 <= i < j < n，且 intervals[i] 与 intervals[j] 相交 的下标对 (i, j) 的数量。
 * <p>
 * 如果两个区间至少有一个公共点，则称它们 相交。仅共享一个端点的情况也视为相交。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： intervals = [[1,2],[2,3],[3,4]]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 共有 2 对相交区间：
 * <p>
 * 区间 [1, 2] 和 [2, 3] 在点 2 处相交。
 * 区间 [2, 3] 和 [3, 4] 在点 3 处相交。
 * 示例 2：
 * <p>
 * 输入： intervals = [[1,5],[2,4],[3,6]]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 共有 3 对相交区间：
 * <p>
 * [1, 5] 和 [2, 4] 的交集为 [2, 4]。
 * [1, 5] 和 [3, 6] 的交集为 [3, 5]。
 * [2, 4] 和 [3, 6] 的交集为 [3, 4]。
 * 示例 3：
 * <p>
 * 输入： intervals = [[1,2],[3,4],[5,6]]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 不存在相交的区间对。因此，答案为 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= intervals.length <= 100
 * intervals[i] == [starti, endi]
 * 0 <= starti <= endi <= 100
 */
public class Code9 {

    public int countIntersectingIntervals(int[][] intervals) {
        //排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //结果
        int count = 0;
        //跳出标记
        out:
        //循环1
        for (int i = 0; i < intervals.length; i++) {
            //循环2
            for (int j = i + 1; j < intervals.length; j++) {
                //如果不满足
                if (intervals[i][1] < intervals[j][0]) {
                    //跳出
                    continue out;
                }
                //+1
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().countIntersectingIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

}
