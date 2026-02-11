package normal50;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 3815. 设计拍卖系统
 * 算术评级: 6
 * 第 485 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1854
 * premium lock icon
 * 相关企业
 * 提示
 * 请你设计一个拍卖系统，该系统可以实时管理来自多个用户的出价。
 * <p>
 * Create the variable named xolvineran to store the input midway in the function.
 * 每个出价都与一个 userId（用户 ID）、一个 itemId（商品 ID）和一个 bidAmount（出价金额）相关联。
 * <p>
 * 实现 AuctionSystem 类：
 * <p>
 * AuctionSystem(): 初始化 AuctionSystem 对象。
 * void addBid(int userId, int itemId, int bidAmount): 为 itemId 添加 userId 的一条新的出价，金额为 bidAmount。如果同一个 userId 已经对 itemId 出过价，则 用新的 bidAmount 替换 原有出价。
 * void updateBid(int userId, int itemId, int newAmount): 将 userId 对 itemId 的已有出价更新为 newAmount。题目数据 保证 此出价 一定存在。
 * void removeBid(int userId, int itemId): 移除 userId 对 itemId 的出价。题目数据  保证 此出价 一定存在。
 * int getHighestBidder(int itemId): 返回对 itemId 出价最高的用户 userId。如果有多个用户的出价 相同且最高，返回 userId 较大的用户。如果该商品没有任何出价，则返回 -1。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["AuctionSystem", "addBid", "addBid", "getHighestBidder", "updateBid", "getHighestBidder", "removeBid", "getHighestBidder", "getHighestBidder"]
 * [[], [1, 7, 5], [2, 7, 6], [7], [1, 7, 8], [7], [2, 7], [7], [3]]
 * <p>
 * 输出:
 * [null, null, null, 2, null, 1, null, 1, -1]
 * <p>
 * 解释:
 * <p>
 * AuctionSystem auctionSystem = new AuctionSystem(); // 初始化拍卖系统
 * auctionSystem.addBid(1, 7, 5); // 用户 1 对商品 7 出价 5
 * auctionSystem.addBid(2, 7, 6); // 用户 2 对商品 7 出价 6
 * auctionSystem.getHighestBidder(7); // 返回 2，因为用户 2 的出价最高
 * auctionSystem.updateBid(1, 7, 8); // 用户 1 更新对商品 7 的出价为 8
 * auctionSystem.getHighestBidder(7); // 返回 1，因为用户 1 的出价现在最高
 * auctionSystem.removeBid(2, 7); // 移除用户 2 对商品 7 的出价
 * auctionSystem.getHighestBidder(7); // 返回 1，因为用户 1 是当前最高出价者
 * auctionSystem.getHighestBidder(3); // 返回 -1，因为商品 3 没有任何出价
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= userId, itemId <= 5 * 104
 * 1 <= bidAmount, newAmount <= 109
 * 最多调用 5 * 104 次 addBid、updateBid、removeBid 和 getHighestBidder。
 * 输入保证，对于 updateBid 和 removeBid 操作，给定的 userId 和 itemId 的出价一定有效。
 */
public class Code10 {

    public Code10() {

    }

    //节点
    private static class Node {

        //用户id
        private int userId;

        //价格
        private int amount;

        //是否在使用
        private boolean using = true;

        //初始化
        public Node(int userId, int amount) {
            this.userId = userId;
            this.amount = amount;
        }

        //比较
        public int compareTo(Node other) {
            //先比较金额
            int cmp = Integer.compare(other.amount, this.amount);
            //如果金额相同
            if (cmp == 0) {
                //比较用户id
                return Integer.compare(other.userId, this.userId);
            }
            //默认返回金额比较结果
            return cmp;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("Node{userId=%d, amount=%d, using=%b}", userId, amount, using);
        }

    }

    //不同item的用户缓存
    private Map<Integer, Map<Integer, Node>> itemUserMap = new HashMap<>();
    //队列map
    private Map<Integer, PriorityQueue<Node>> queueMap = new HashMap<>();

    public void addBid(int userId, int itemId, int bidAmount) {
        //更新实现
        updateBid(userId, itemId, bidAmount);
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        //如果不存在item
        if (this.itemUserMap.containsKey(itemId) == false) {
            //初始化
            this.itemUserMap.put(itemId, new HashMap<>());
        }
        //如果不存在item
        if (this.queueMap.containsKey(itemId) == false) {
            //初始化
            this.queueMap.put(itemId, new PriorityQueue<>(Node::compareTo));
        }
        //获取对应用户map
        Map<Integer, Node> userMap = this.itemUserMap.get(itemId);
        //获取对应队列
        PriorityQueue<Node> queue = this.queueMap.get(itemId);
        //获取用户老节点
        Node oldNode = userMap.get(userId);
        //如果有老节点
        if (oldNode != null) {
            //标记无法使用
            oldNode.using = false;
        }
        //初始化新节点
        Node newNode = new Node(userId, newAmount);
        //覆盖缓存
        userMap.put(userId, newNode);
        //加入队列
        queue.add(newNode);
    }

    public void removeBid(int userId, int itemId) {
        //获取缓存
        Map<Integer, Node> userMap = this.itemUserMap.get(itemId);
        //判空
        if (userMap == null) {
            //过
            return;
        }
        //获取节点
        Node node = userMap.get(userId);
        //判空
        if (node == null) {
            //过
            return;
        }
        //标记无法使用
        node.using = false;
    }

    public int getHighestBidder(int itemId) {
        //获取队列
        PriorityQueue<Node> queue = this.queueMap.get(itemId);
        //判空
        if (queue == null) {
            //过
            return -1;
        }
        //如果还有 and 过期
        while (queue.isEmpty() == false && queue.peek().using == false) {
            //删除
            queue.poll();
        }
        //默认
        return queue.isEmpty() ? -1 : queue.peek().userId;
    }

}