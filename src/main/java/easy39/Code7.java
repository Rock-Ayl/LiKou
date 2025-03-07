package easy39;

/**
 * @Author ayl
 * @Date 2024-12-19
 * 3386. 按下时间最长的按钮
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个二维数组 events，表示孩子在键盘上按下一系列按钮触发的按钮事件。
 * <p>
 * 每个 events[i] = [indexi, timei] 表示在时间 timei 时，按下了下标为 indexi 的按钮。
 * <p>
 * 数组按照 time 的递增顺序排序。
 * 按下一个按钮所需的时间是连续两次按钮按下的时间差。按下第一个按钮所需的时间就是其时间戳。
 * 返回按下时间 最长 的按钮的 index。如果有多个按钮的按下时间相同，则返回 index 最小的按钮。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： events = [[1,2],[2,5],[3,9],[1,15]]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 下标为 1 的按钮在时间 2 被按下。
 * 下标为 2 的按钮在时间 5 被按下，因此按下时间为 5 - 2 = 3。
 * 下标为 3 的按钮在时间 9 被按下，因此按下时间为 9 - 5 = 4。
 * 下标为 1 的按钮再次在时间 15 被按下，因此按下时间为 15 - 9 = 6。
 * 最终，下标为 1 的按钮按下时间最长，为 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入： events = [[10,5],[1,7]]
 * <p>
 * 输出： 10
 * <p>
 * 解释：
 * <p>
 * 下标为 10 的按钮在时间 5 被按下。
 * 下标为 1 的按钮在时间 7 被按下，因此按下时间为 7 - 5 = 2。
 * 最终，下标为 10 的按钮按下时间最长，为 5。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= events.length <= 1000
 * events[i] == [indexi, timei]
 * 1 <= indexi, timei <= 105
 * 输入保证数组 events 按照 timei 的递增顺序排序。
 */
public class Code7 {

    public int buttonWithLongestTime(int[][] events) {
        //初始化最大结果
        int max = events[0][1];
        int maxIndex = events[0][0];
        //循环
        for (int i = 1; i < events.length; i++) {
            //当前、上一个
            int[] event = events[i];
            int[] lastEvent = events[i - 1];
            //计算
            int time = event[1] - lastEvent[1];
            //如果更大
            if (time > max) {
                //更新
                maxIndex = event[0];
                max = time;
            }
            //如果相同
            if (time == max) {
                //刷新索引
                maxIndex = Math.min(maxIndex, event[0]);
            }
        }
        //返回结果
        return maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().buttonWithLongestTime(new int[][]{
                new int[]{1, 2},
                new int[]{2, 5},
                new int[]{3, 9},
                new int[]{1, 15}
        }));
        ;
    }

}
