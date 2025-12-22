package difficult4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-12-22
 * 2102. 序列顺序查询
 * 算术评级: 7
 * 第 67 场双周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2159
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一个观光景点由它的名字 name 和景点评分 score 组成，其中 name 是所有观光景点中 唯一 的字符串，score 是一个整数。景点按照最好到最坏排序。景点评分 越高 ，这个景点越好。如果有两个景点的评分一样，那么 字典序较小 的景点更好。
 * <p>
 * 你需要搭建一个系统，查询景点的排名。初始时系统里没有任何景点。这个系统支持：
 * <p>
 * 添加 景点，每次添加 一个 景点。
 * 查询 已经添加景点中第 i 好 的景点，其中 i 是系统目前位置查询的次数（包括当前这一次）。
 * 比方说，如果系统正在进行第 4 次查询，那么需要返回所有已经添加景点中第 4 好的。
 * 注意，测试数据保证 任意查询时刻 ，查询次数都 不超过 系统中景点的数目。
 * <p>
 * 请你实现 SORTracker 类：
 * <p>
 * SORTracker() 初始化系统。
 * void add(string name, int score) 向系统中添加一个名为 name 评分为 score 的景点。
 * string get() 查询第 i 好的景点，其中 i 是目前系统查询的次数（包括当前这次查询）。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["SORTracker", "add", "add", "get", "add", "get", "add", "get", "add", "get", "add", "get", "get"]
 * [[], ["bradford", 2], ["branford", 3], [], ["alps", 2], [], ["orland", 2], [], ["orlando", 3], [], ["alpine", 2], [], []]
 * 输出：
 * [null, null, null, "branford", null, "alps", null, "bradford", null, "bradford", null, "bradford", "orland"]
 * <p>
 * 解释：
 * SORTracker tracker = new SORTracker(); // 初始化系统
 * tracker.add("bradford", 2); // 添加 name="bradford" 且 score=2 的景点。
 * tracker.add("branford", 3); // 添加 name="branford" 且 score=3 的景点。
 * tracker.get();              // 从好到坏的景点为：branford ，bradford 。
 * // 注意到 branford 比 bradford 好，因为它的 评分更高 (3 > 2) 。
 * // 这是第 1 次调用 get() ，所以返回最好的景点："branford" 。
 * tracker.add("alps", 2);     // 添加 name="alps" 且 score=2 的景点。
 * tracker.get();              // 从好到坏的景点为：branford, alps, bradford 。
 * // 注意 alps 比 bradford 好，虽然它们评分相同，都为 2 。
 * // 这是因为 "alps" 字典序 比 "bradford" 小。
 * // 返回第 2 好的地点 "alps" ，因为当前为第 2 次调用 get() 。
 * tracker.add("orland", 2);   // 添加 name="orland" 且 score=2 的景点。
 * tracker.get();              // 从好到坏的景点为：branford, alps, bradford, orland 。
 * // 返回 "bradford" ，因为当前为第 3 次调用 get() 。
 * tracker.add("orlando", 3);  // 添加 name="orlando" 且 score=3 的景点。
 * tracker.get();              // 从好到坏的景点为：branford, orlando, alps, bradford, orland 。
 * // 返回 "bradford".
 * tracker.add("alpine", 2);   // 添加 name="alpine" 且 score=2 的景点。
 * tracker.get();              // 从好到坏的景点为：branford, orlando, alpine, alps, bradford, orland 。
 * // 返回 "bradford" 。
 * tracker.get();              // 从好到坏的景点为：branford, orlando, alpine, alps, bradford, orland 。
 * // 返回 "orland" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * name 只包含小写英文字母，且每个景点名字互不相同。
 * 1 <= name.length <= 10
 * 1 <= score <= 105
 * 任意时刻，调用 get 的次数都不超过调用 add 的次数。
 * 总共 调用 add 和 get 不超过 4 * 104
 */
public class Code17 {

    public Code17() {

    }

    private static class Node {

        //名称
        private String name;

        //分数
        private Integer score;

        //初始化
        public Node(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        //排序方法
        public int compareTo(Node another) {
            //按照分数对比
            int scoreRank = this.score.compareTo(another.score);
            //如果分数不同
            if (scoreRank != 0) {
                //按照分数排序
                return scoreRank;
            }
            //默认按照字典序
            return another.name.compareTo(this.name);
        }

        //调试
        @Override
        public String toString() {
            return String.format("name=%s,score=%s", this.name, this.score);
        }

    }

    //预期查询次数
    private int getCount = 1;

    //双队列挤压
    private PriorityQueue<Node> leftQueue = new PriorityQueue<>((a, b) -> a.compareTo(b));
    private PriorityQueue<Node> rightQueue = new PriorityQueue<>((a, b) -> b.compareTo(a));

    public void add(String name, int score) {
        //初始化节点
        Node node = new Node(name, score);
        //加入右边节点
        this.rightQueue.add(node);
    }

    public String get() {

        /**
         * 平衡队列
         */

        //如果不够数量
        while (this.leftQueue.size() != this.getCount) {
            //平衡数量
            this.leftQueue.add(this.rightQueue.poll());
        }
        //如果左边的比右边的小
        while (this.leftQueue.isEmpty() == false && this.rightQueue.isEmpty() == false && this.leftQueue.peek().compareTo(this.rightQueue.peek()) < 0) {
            //拉取节点
            Node one = this.leftQueue.poll();
            Node two = this.rightQueue.poll();
            //交换
            this.leftQueue.add(two);
            this.rightQueue.add(one);
        }

        /**
         * 返回结果
         */

        //获取目标名称
        String name = Optional.ofNullable(this.leftQueue)
                .map(PriorityQueue::peek)
                .map(p -> p.name)
                .orElse(null);
        //+1
        this.getCount++;
        //返回
        return name;
    }

    public static void main(String[] args) {

        //初始化
        Code17 code17 = new Code17();

        //操作
        String[] ops = {
                "SORTracker", "add", "add", "get", "add", "get", "add", "get", "add", "get", "add", "get", "get"
        };

        //参数（每一项对应 ops 的同位置操作）
        Object[][] params = {
                {}, {"bradford", 2}, {"branford", 3}, {}, {"alps", 2}, {}, {"orland", 2}, {},
                {"orlando", 3}, {}, {"alpine", 2}, {}, {}
        };

        //收集输出：构造器也输出 null（和 LeetCode 常见输出格式一致）
        List<String> outputs = new ArrayList<>();

        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            switch (op) {
                case "SORTracker":
                    // 已经 new 过了，这里仅为了对齐输出格式
                    outputs.add(null);
                    break;
                case "add":
                    String name = (String) params[i][0];
                    int score = (int) params[i][1];
                    code17.add(name, score);
                    outputs.add(null);
                    break;
                case "get":
                    outputs.add(code17.get());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown op: " + op);
            }
        }

        System.out.println(outputs);

    }

    //打印队列
    private void print(PriorityQueue<Node> queue) {
        //如果还有
        while (queue.isEmpty() == false) {
            //输出
            System.out.println(queue.poll());
        }
    }

}
