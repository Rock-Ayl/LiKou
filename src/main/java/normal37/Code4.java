package normal37;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-11-07
 * 1882. 使用服务器处理任务
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个 下标从 0 开始 的整数数组 servers 和 tasks ，长度分别为 n​​​​​​ 和 m​​​​​​ 。servers[i] 是第 i​​​​​​​​​​ 台服务器的 权重 ，而 tasks[j] 是处理第 j​​​​​​ 项任务 所需要的时间（单位：秒）。
 * <p>
 * 你正在运行一个仿真系统，在处理完所有任务后，该系统将会关闭。每台服务器只能同时处理一项任务。第 0 项任务在第 0 秒可以开始处理，相应地，第 j 项任务在第 j 秒可以开始处理。处理第 j 项任务时，你需要为它分配一台 权重最小 的空闲服务器。如果存在多台相同权重的空闲服务器，请选择 下标最小 的服务器。如果一台空闲服务器在第 t 秒分配到第 j 项任务，那么在 t + tasks[j] 时它将恢复空闲状态。
 * <p>
 * 如果没有空闲服务器，则必须等待，直到出现一台空闲服务器，并 尽可能早 地处理剩余任务。 如果有多项任务等待分配，则按照 下标递增 的顺序完成分配。
 * <p>
 * 如果同一时刻存在多台空闲服务器，可以同时将多项任务分别分配给它们。
 * <p>
 * 构建长度为 m 的答案数组 ans ，其中 ans[j] 是第 j 项任务分配的服务器的下标。
 * <p>
 * 返回答案数组 ans​​​​ 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：servers = [3,3,2], tasks = [1,2,3,2,1,2]
 * 输出：[2,2,0,2,1,2]
 * 解释：事件按时间顺序如下：
 * - 0 秒时，第 0 项任务加入到任务队列，使用第 2 台服务器处理到 1 秒。
 * - 1 秒时，第 2 台服务器空闲，第 1 项任务加入到任务队列，使用第 2 台服务器处理到 3 秒。
 * - 2 秒时，第 2 项任务加入到任务队列，使用第 0 台服务器处理到 5 秒。
 * - 3 秒时，第 2 台服务器空闲，第 3 项任务加入到任务队列，使用第 2 台服务器处理到 5 秒。
 * - 4 秒时，第 4 项任务加入到任务队列，使用第 1 台服务器处理到 5 秒。
 * - 5 秒时，所有服务器都空闲，第 5 项任务加入到任务队列，使用第 2 台服务器处理到 7 秒。
 * 示例 2：
 * <p>
 * 输入：servers = [5,1,4,3,2], tasks = [2,1,2,4,5,2,1]
 * 输出：[1,4,1,4,1,3,2]
 * 解释：事件按时间顺序如下：
 * - 0 秒时，第 0 项任务加入到任务队列，使用第 1 台服务器处理到 2 秒。
 * - 1 秒时，第 1 项任务加入到任务队列，使用第 4 台服务器处理到 2 秒。
 * - 2 秒时，第 1 台和第 4 台服务器空闲，第 2 项任务加入到任务队列，使用第 1 台服务器处理到 4 秒。
 * - 3 秒时，第 3 项任务加入到任务队列，使用第 4 台服务器处理到 7 秒。
 * - 4 秒时，第 1 台服务器空闲，第 4 项任务加入到任务队列，使用第 1 台服务器处理到 9 秒。
 * - 5 秒时，第 5 项任务加入到任务队列，使用第 3 台服务器处理到 7 秒。
 * - 6 秒时，第 6 项任务加入到任务队列，使用第 2 台服务器处理到 7 秒。
 * <p>
 * <p>
 * 提示：
 * <p>
 * servers.length == n
 * tasks.length == m
 * 1 <= n, m <= 2 * 105
 * 1 <= servers[i], tasks[j] <= 2 * 105
 */
public class Code4 {

    //服务器
    private static class Server {

        //服务器索引
        private int index;

        //权重
        private int weight;

        //完成时间,默认-1
        private int finishTime = -1;

        //初始化
        public Server(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        //比较权重
        public int compareToWeight(Server another) {
            //如果权重不同
            if (this.weight != another.weight) {
                //权重正序
                return this.weight - another.weight;
            }
            //默认索引正序
            return this.index - another.index;
        }

        //比较完成时间
        public int compareToFinishTime(Server another) {
            //完成时间正序
            return this.finishTime - another.finishTime;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("index=%s,weight=%s,finishTime=%s", index, weight, finishTime);
        }

    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        //闲值服务器优先队列
        PriorityQueue<Server> serverQueue = new PriorityQueue<>(Server::compareToWeight);
        //循环
        for (int i = 0; i < servers.length; i++) {
            //初始化节点并组装
            serverQueue.add(new Server(i, servers[i]));
        }
        //任务进行中服务器优先队列
        PriorityQueue<Server> doingQueue = new PriorityQueue<>(Server::compareToFinishTime);
        //初始化结果
        int[] result = new int[tasks.length];
        //当前真实的时间
        int time = 0;
        //任务索引/任务可以被执行的时间
        int taskIndex = 0;
        //循环
        while (taskIndex < tasks.length) {
            //如果有完成的服务器
            while (doingQueue.isEmpty() == false && doingQueue.peek().finishTime == time) {
                //拉取服务器,加入到闲值的列表
                serverQueue.add(doingQueue.poll());
            }
            //如果此时,还没有闲值服务器
            if (serverQueue.isEmpty()) {
                //直接快进到最近的完成时间
                time = doingQueue.peek().finishTime;
                //本轮过
                continue;
            }
            //获取优先级最高的服务器
            Server server = serverQueue.poll();
            //计算其完成时间
            server.finishTime = time + tasks[taskIndex];
            //记录本次结果
            result[taskIndex] = server.index;
            //服务器加入到进行中队列
            doingQueue.add(server);
            //如果时间和任务启动时间是同步
            if (time == taskIndex) {
                //时间+1
                time++;
            }
            //下一个任务
            taskIndex++;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code4().assignTasks(new int[]{3, 3, 2}, new int[]{1, 2, 3, 2, 1, 2});
        System.out.println();
    }

}
