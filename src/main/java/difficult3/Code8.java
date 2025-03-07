package difficult3;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-01-11
 * 2402. 会议室 III
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n ，共有编号从 0 到 n - 1 的 n 个会议室。
 * <p>
 * 给你一个二维整数数组 meetings ，其中 meetings[i] = [starti, endi] 表示一场会议将会在 半闭 时间区间 [starti, endi) 举办。所有 starti 的值 互不相同 。
 * <p>
 * 会议将会按以下方式分配给会议室：
 * <p>
 * 每场会议都会在未占用且编号 最小 的会议室举办。
 * 如果没有可用的会议室，会议将会延期，直到存在空闲的会议室。延期会议的持续时间和原会议持续时间 相同 。
 * 当会议室处于未占用状态时，将会优先提供给原 开始 时间更早的会议。
 * 返回举办最多次会议的房间 编号 。如果存在多个房间满足此条件，则返回编号 最小 的房间。
 * <p>
 * 半闭区间 [a, b) 是 a 和 b 之间的区间，包括 a 但 不包括 b 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
 * 输出：0
 * 解释：
 * - 在时间 0 ，两个会议室都未占用，第一场会议在会议室 0 举办。
 * - 在时间 1 ，只有会议室 1 未占用，第二场会议在会议室 1 举办。
 * - 在时间 2 ，两个会议室都被占用，第三场会议延期举办。
 * - 在时间 3 ，两个会议室都被占用，第四场会议延期举办。
 * - 在时间 5 ，会议室 1 的会议结束。第三场会议在会议室 1 举办，时间周期为 [5,10) 。
 * - 在时间 10 ，两个会议室的会议都结束。第四场会议在会议室 0 举办，时间周期为 [10,11) 。
 * 会议室 0 和会议室 1 都举办了 2 场会议，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
 * 输出：1
 * 解释：
 * - 在时间 1 ，所有三个会议室都未占用，第一场会议在会议室 0 举办。
 * - 在时间 2 ，会议室 1 和 2 未占用，第二场会议在会议室 1 举办。
 * - 在时间 3 ，只有会议室 2 未占用，第三场会议在会议室 2 举办。
 * - 在时间 4 ，所有三个会议室都被占用，第四场会议延期举办。
 * - 在时间 5 ，会议室 2 的会议结束。第四场会议在会议室 2 举办，时间周期为 [5,10) 。
 * - 在时间 6 ，所有三个会议室都被占用，第五场会议延期举办。
 * - 在时间 10 ，会议室 1 和 2 的会议结束。第五场会议在会议室 1 举办，时间周期为 [10,12) 。
 * 会议室 1 和会议室 2 都举办了 2 场会议，所以返回 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 1 <= meetings.length <= 105
 * meetings[i].length == 2
 * 0 <= starti < endi <= 5 * 105
 * starti 的所有值 互不相同
 */
public class Code8 {

    /**
     * 会议节点
     */
    private static class Meet {

        //开始时间
        private int start;

        //进行时间
        private int running;

        //初始化
        public Meet(int start, int running) {
            this.start = start;
            this.running = running;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("start=%s,running=%s", this.start, this.running);
        }

    }

    /**
     * 使用中的会议节点
     */
    private static class UseMeet {

        //会议室编号
        private int number;

        //结束时间
        private long endTime;

        //初始化
        public UseMeet(int number, long endTime) {
            this.number = number;
            this.endTime = endTime;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("number=%s,endTime=%s", this.number, this.endTime);
        }

    }

    public int mostBooked(int n, int[][] meetings) {

        /**
         * 1. 构建会议节点
         */

        //初始化节点列表
        LinkedList<Meet> meetList = new LinkedList<>();
        //循环
        for (int[] meeting : meetings) {
            //初始化、并组装
            meetList.add(new Meet(meeting[0], meeting[1] - meeting[0]));
        }
        //排序
        meetList.sort(Comparator.comparingInt(a -> a.start));

        /**
         * 2. 构建会议室
         */

        //未被使用的会议室队列
        PriorityQueue<Integer> noUsingMeetingQueue = new PriorityQueue<>();
        //循环
        for (int i = 0; i < n; i++) {
            //初始化
            noUsingMeetingQueue.add(i);
        }

        /**
         * 3. 开始计算
         */

        //使用中的会议室队列
        PriorityQueue<UseMeet> useMeetPriorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a.endTime));

        //最多次被使用的数量
        int maxCount = 0;
        //最多词被使用的会议室编号、
        int maxNumber = Integer.MAX_VALUE;

        //当前时间
        long time = 0L;

        //初始化会议室使用的次数
        int[] useMeetArr = new int[n];

        //如果还没有清算完所有会议
        while (meetList.isEmpty() == false) {

            /**
             * 拉取会议、同步时间
             */

            //偷窥最近的一个会议
            Meet meet = meetList.peekFirst();
            //如果时间太早
            if (time < meet.start) {
                //默认来到这个时间
                time = meet.start;
            }

            /**
             * 如果有使用完毕的会议室、回滚
             */

            //如果有使用完毕的会议室
            while (useMeetPriorityQueue.isEmpty() == false && useMeetPriorityQueue.peek().endTime <= time) {
                //放回到未使用队列
                noUsingMeetingQueue.add(useMeetPriorityQueue.poll().number);
            }
            //如果还是没有可以使用的会议室
            if (noUsingMeetingQueue.isEmpty()) {
                //时间来到最近的会议结束时间
                time = useMeetPriorityQueue.peek().endTime;
                //本轮过
                continue;
            }

            /**
             * 结算会议室
             */

            //拉取一个优先级最高的会议室
            int number = noUsingMeetingQueue.poll();
            //计算出真实的结束时间
            long realEntTime = Math.max(time, meet.start) + meet.running;
            //进入使用中队列
            useMeetPriorityQueue.add(new UseMeet(number, realEntTime));
            //删除该会议
            meetList.pollFirst();

            /**
             * 刷新最大结果
             */

            //如果刷新为最大
            if (++useMeetArr[number] > maxCount) {
                //更新为最大结果
                maxCount = useMeetArr[number];
                maxNumber = number;
            }
            //如果可能优先级更高
            else if (useMeetArr[number] == maxCount) {
                //刷新最小会议室
                maxNumber = Math.min(maxNumber, number);
            }

        }

        //返回最终结果
        return maxNumber;
    }

    public static void main(String[] args) {


        System.out.println(new Code8().mostBooked(3, new int[][]{
                new int[]{1, 20},
                new int[]{2, 10},
                new int[]{3, 5},
                new int[]{4, 9},
                new int[]{6, 8}
        }));
    }

}
