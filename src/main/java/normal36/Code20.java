package normal36;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-11-01
 * 1834. 单线程 CPU
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维数组 tasks ，用于表示 n​​​​​​ 项从 0 到 n - 1 编号的任务。其中 tasks[i] = [enqueueTimei, processingTimei] 意味着第 i​​​​​​​​​​ 项任务将会于 enqueueTimei 时进入任务队列，需要 processingTimei 的时长完成执行。
 * <p>
 * 现有一个单线程 CPU ，同一时间只能执行 最多一项 任务，该 CPU 将会按照下述方式运行：
 * <p>
 * 如果 CPU 空闲，且任务队列中没有需要执行的任务，则 CPU 保持空闲状态。
 * 如果 CPU 空闲，但任务队列中有需要执行的任务，则 CPU 将会选择 执行时间最短 的任务开始执行。如果多个任务具有同样的最短执行时间，则选择下标最小的任务开始执行。
 * 一旦某项任务开始执行，CPU 在 执行完整个任务 前都不会停止。
 * CPU 可以在完成一项任务后，立即开始执行一项新任务。
 * 返回 CPU 处理任务的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = [[1,2],[2,4],[3,2],[4,1]]
 * 输出：[0,2,3,1]
 * 解释：事件按下述流程运行：
 * - time = 1 ，任务 0 进入任务队列，可执行任务项 = {0}
 * - 同样在 time = 1 ，空闲状态的 CPU 开始执行任务 0 ，可执行任务项 = {}
 * - time = 2 ，任务 1 进入任务队列，可执行任务项 = {1}
 * - time = 3 ，任务 2 进入任务队列，可执行任务项 = {1, 2}
 * - 同样在 time = 3 ，CPU 完成任务 0 并开始执行队列中用时最短的任务 2 ，可执行任务项 = {1}
 * - time = 4 ，任务 3 进入任务队列，可执行任务项 = {1, 3}
 * - time = 5 ，CPU 完成任务 2 并开始执行队列中用时最短的任务 3 ，可执行任务项 = {1}
 * - time = 6 ，CPU 完成任务 3 并开始执行任务 1 ，可执行任务项 = {}
 * - time = 10 ，CPU 完成任务 1 并进入空闲状态
 * 示例 2：
 * <p>
 * 输入：tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
 * 输出：[4,3,2,0,1]
 * 解释：事件按下述流程运行：
 * - time = 7 ，所有任务同时进入任务队列，可执行任务项  = {0,1,2,3,4}
 * - 同样在 time = 7 ，空闲状态的 CPU 开始执行任务 4 ，可执行任务项 = {0,1,2,3}
 * - time = 9 ，CPU 完成任务 4 并开始执行任务 3 ，可执行任务项 = {0,1,2}
 * - time = 13 ，CPU 完成任务 3 并开始执行任务 2 ，可执行任务项 = {0,1}
 * - time = 18 ，CPU 完成任务 2 并开始执行任务 0 ，可执行任务项 = {1}
 * - time = 28 ，CPU 完成任务 0 并开始执行任务 1 ，可执行任务项 = {}
 * - time = 40 ，CPU 完成任务 1 并进入空闲状态
 * <p>
 * <p>
 * 提示：
 * <p>
 * tasks.length == n
 * 1 <= n <= 105
 * 1 <= enqueueTimei, processingTimei <= 109
 */
public class Code20 {

    private static class Node {

        //进入时间
        private int enqueueTime;

        //完成时间
        private int processingTime;

        //索引
        private int index;

        //初始化
        public Node(int[] task, int index) {
            this.enqueueTime = task[0];
            this.processingTime = task[1];
            this.index = index;
        }

        //排序规则
        public int compareTo(Node anotherNode) {
            //如果执行时间不同
            if (this.processingTime != anotherNode.processingTime) {
                //按照执行时间
                return this.processingTime - anotherNode.processingTime;
            }
            //默认按照索引
            return this.index - anotherNode.index;
        }

    }

    public int[] getOrder(int[][] tasks) {

        /**
         * step 1.封装为节点,按照进入时间排序
         */

        //初始化节点列表
        List<Node> nodeList = new ArrayList<>();
        //循环
        for (int i = 0; i < tasks.length; i++) {
            //初始化节点、进入数组
            nodeList.add(new Node(tasks[i], i));
        }
        //排序
        nodeList.sort(Comparator.comparingInt(a -> a.enqueueTime));

        /**
         * step 2.递归,逐步加入任务并完成
         */

        //初始化结果数组
        int[] result = new int[nodeList.size()];
        //结果索引
        int resultIndex = 0;
        //时间
        int time = 1;
        //任务索引
        int taskIndex = 0;
        //优先队列
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Node::compareTo);
        //循环
        while (taskIndex < nodeList.size() || priorityQueue.isEmpty() == false) {
            //如果时间达到进入的范围
            if (taskIndex < nodeList.size() && time >= nodeList.get(taskIndex).enqueueTime) {
                //初始化节点、进入队列
                priorityQueue.add(nodeList.get(taskIndex));
                //任务索引+1
                taskIndex++;
                //本轮过
                continue;
            }
            //根据是否存在节点,判断
            if (priorityQueue.isEmpty() == false) {
                //获取优先级最高的任务
                Node task = priorityQueue.poll();
                //完成该任务,计算其时间
                time += task.processingTime;
                //记录结果
                result[resultIndex++] = task.index;
            } else {
                //直接来到最小的执行时间
                time = nodeList.get(taskIndex).enqueueTime;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] order = new Code20().getOrder(new int[][]{
                new int[]{19, 13},
                new int[]{16, 9},
                new int[]{21, 10},
                new int[]{32, 25},
                new int[]{37, 4},
                new int[]{49, 24},
                new int[]{2, 15},
                new int[]{38, 41},
                new int[]{37, 34},
                new int[]{33, 6},
                new int[]{45, 4},
                new int[]{18, 18},
                new int[]{46, 39},
                new int[]{12, 24}
        });
        System.out.println();
    }

}
