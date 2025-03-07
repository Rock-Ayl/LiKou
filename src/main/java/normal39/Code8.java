package normal39;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-01-17
 * 3408. 设计任务管理器
 * 中等
 * 相关标签
 * 相关企业
 * 一个任务管理器系统可以让用户管理他们的任务，每个任务有一个优先级。这个系统需要高效地处理添加、修改、执行和删除任务的操作。
 * <p>
 * 请你设计一个 TaskManager 类：
 * <p>
 * TaskManager(vector<vector<int>>& tasks) 初始化任务管理器，初始化的数组格式为 [userId, taskId, priority] ，表示给 userId 添加一个优先级为 priority 的任务 taskId 。
 * <p>
 * void add(int userId, int taskId, int priority) 表示给用户 userId 添加一个优先级为 priority 的任务 taskId ，输入 保证 taskId 不在系统中。
 * <p>
 * void edit(int taskId, int newPriority) 更新已经存在的任务 taskId 的优先级为 newPriority 。输入 保证 taskId 存在于系统中。
 * <p>
 * void rmv(int taskId) 从系统中删除任务 taskId 。输入 保证 taskId 存在于系统中。
 * <p>
 * int execTop() 执行所有用户的任务中优先级 最高 的任务，如果有多个任务优先级相同且都为 最高 ，执行 taskId 最大的一个任务。执行完任务后，taskId 从系统中 删除 。同时请你返回这个任务所属的用户 userId 。如果不存在任何任务，返回 -1 。
 * <p>
 * 注意 ，一个用户可能被安排多个任务。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
 * [[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]
 * <p>
 * 输出：
 * [null, null, null, 3, null, null, 5]
 * <p>
 * 解释：
 * <p>
 * TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3, 103, 15]]); // 分别给用户 1 ，2 和 3 初始化一个任务。
 * taskManager.add(4, 104, 5); // 给用户 4 添加优先级为 5 的任务 104 。
 * taskManager.edit(102, 8); // 更新任务 102 的优先级为 8 。
 * taskManager.execTop(); // 返回 3 。执行用户 3 的任务 103 。
 * taskManager.rmv(101); // 将系统中的任务 101 删除。
 * taskManager.add(5, 105, 15); // 给用户 5 添加优先级为 15 的任务 105 。
 * taskManager.execTop(); // 返回 5 。执行用户 5 的任务 105 。
 */
public class Code8 {

    //节点
    private static class Node {

        //用户
        private int userId;

        //任务id
        private int taskId;

        //优先级
        private int priority;

        //初始化
        public Node(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        //比较
        public int compareTo(Node another) {
            //如果优先级不同
            if (this.priority != another.priority) {
                //按照优先级
                return another.priority - this.priority;
            }
            //默认按照任务id
            return another.taskId - this.taskId;
        }

    }

    //初始化优先队列
    private PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Node::compareTo);
    //节点map
    private Map<Integer, Node> nodeMap = new HashMap<>();
    //被删除的节点
    private final Node removeNode = new Node(-1, -1, -1);

    public Code8(List<List<Integer>> tasks) {
        //循环
        for (List<Integer> task : tasks) {
            //初始化新增
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        //初始化节点
        Node node = new Node(userId, taskId, priority);
        //记录缓存
        this.nodeMap.put(taskId, node);
        //加入优先队列
        this.priorityQueue.add(node);
    }

    public void edit(int taskId, int newPriority) {
        //获取当前节点
        Node oldNode = this.nodeMap.get(taskId);
        //创建新节点
        Node newNode = new Node(oldNode.userId, taskId, newPriority);
        //覆盖缓存
        this.nodeMap.put(taskId, newNode);
        //加入优先队列
        this.priorityQueue.add(newNode);
    }

    public void rmv(int taskId) {
        //删除缓存就是修改节点
        this.nodeMap.put(taskId, this.removeNode);
    }

    public int execTop() {
        //循环
        while (this.priorityQueue.isEmpty() == false) {
            //拉取一个最大优先级的
            Node pollNode = this.priorityQueue.poll();
            //获取对应的任务id
            int taskId = pollNode.taskId;
            //获取当前最新的数据,默认被删除节点
            Node node = this.nodeMap.get(taskId);
            //如果对象不是一个
            if (node != pollNode) {
                //说明不是最新的，过
                continue;
            }
            //删除任务
            rmv(taskId);
            //返回用户id
            return pollNode.userId;
        }
        //默认
        return -1;
    }

}
