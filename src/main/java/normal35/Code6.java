package normal35;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-09-18
 * 621. 任务调度器
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表，用字母 A 到 Z 表示，以及一个冷却时间 n。每个周期或时间间隔允许完成一项任务。任务可以按任何顺序完成，但有一个限制：两个 相同种类 的任务之间必须有长度为 n 的冷却时间。
 * <p>
 * 返回完成所有任务所需要的 最短时间间隔 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * 示例 2：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 0
 * 输出：6
 * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * 诸如此类
 * 示例 3：
 * <p>
 * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tasks.length <= 104
 * tasks[i] 是大写英文字母
 * 0 <= n <= 100
 */
public class Code6 {

    public int leastInterval(char[] tasks, int n) {
        //如果没有间隔
        if (n < 1) {
            //直接返回
            return tasks.length;
        }
        //缓存
        int[] arr = new int[26];
        //循环
        for (Character letter : tasks) {
            //+1
            arr[letter - 'A']++;
        }
        //优先队列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        //循环
        for (int i : arr) {
            //如果有
            if (i > 0) {
                //加入
                priorityQueue.add(i);
            }
        }
        //waitTime
        int waitTime = 0;
        //本次执行的任务
        List<Integer> nodeList = new ArrayList<>();
        //如果还有任务
        while (priorityQueue.isEmpty() == false) {
            //清除
            nodeList.clear();
            //如果有足够的
            if (priorityQueue.size() > n) {
                //指针
                int p = 0;
                //循环
                while (p++ <= n) {
                    //获取节点
                    Integer node = priorityQueue.poll();
                    //如果还有
                    if (--node > 0) {
                        //拉取并记录
                        nodeList.add(node);
                    }
                }
            } else {
                //先默认所有的都是空的
                int thisWaitTime = n + 1;
                //循环
                while (priorityQueue.isEmpty() == false) {
                    //获取节点
                    Integer node = priorityQueue.poll();
                    //如果还有
                    if (--node > 0) {
                        //拉取并记录
                        nodeList.add(node);
                    }
                    //记录
                    thisWaitTime--;
                }
                //如果还有
                if (nodeList.isEmpty() == false) {
                    //才需要等待
                    waitTime += thisWaitTime;
                }
            }
            //加入回队列
            priorityQueue.addAll(nodeList);
        }
        //返回结果
        return tasks.length + waitTime;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'}, 7));
    }

}
