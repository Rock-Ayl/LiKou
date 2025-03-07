package normal17;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-11-19
 * 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 */
public class Code9 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        //初始化结果列表
        List<int[]> list = new ArrayList<>();
        //是否组装过mix
        boolean setMix = false;
        //循环
        for (int[] interval : intervals) {
            //如果太小,说明还没找到相交内容
            if (interval[1] < newInterval[0]) {
                //直接组装
                list.add(interval);
                //本轮过
                continue;
            }
            //如果太大,说明相交内容已经结束了
            if (interval[0] > newInterval[1]) {
                //如果没组装
                if (setMix == false) {
                    //组装mix
                    list.add(newInterval);
                    //记录已组装
                    setMix = true;
                }
                //直接组装
                list.add(interval);
                //本轮过
                continue;
            }
            //最后,相交,更换最小最大作用域
            newInterval[0] = Math.min(interval[0], newInterval[0]);
            newInterval[1] = Math.max(interval[1], newInterval[1]);
        }
        //如果没有组装过
        if (setMix == false) {
            //组装
            list.add(newInterval);
        }
        //返回结果
        return list.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        new Code9().insert(new int[][]{
                new int[]{1, 5}
        }, new int[]{6, 8});
    }

}
