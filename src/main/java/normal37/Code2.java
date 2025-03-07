package normal37;

import java.util.*;

/**
 * @Author ayl
 * @Date 2024-11-05
 * 1942. 最小未被占据椅子的编号
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有 n 个朋友在举办一个派对，这些朋友从 0 到 n - 1 编号。派对里有 无数 张椅子，编号为 0 到 infinity 。当一个朋友到达派对时，他会占据 编号最小 且未被占据的椅子。
 * <p>
 * 比方说，当一个朋友到达时，如果椅子 0 ，1 和 5 被占据了，那么他会占据 2 号椅子。
 * 当一个朋友离开派对时，他的椅子会立刻变成未占据状态。如果同一时刻有另一个朋友到达，可以立即占据这张椅子。
 * <p>
 * 给你一个下标从 0 开始的二维整数数组 times ，其中 times[i] = [arrivali, leavingi] 表示第 i 个朋友到达和离开的时刻，同时给你一个整数 targetFriend 。所有到达时间 互不相同 。
 * <p>
 * 请你返回编号为 targetFriend 的朋友占据的 椅子编号 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：times = [[1,4],[2,3],[4,6]], targetFriend = 1
 * 输出：1
 * 解释：
 * - 朋友 0 时刻 1 到达，占据椅子 0 。
 * - 朋友 1 时刻 2 到达，占据椅子 1 。
 * - 朋友 1 时刻 3 离开，椅子 1 变成未占据。
 * - 朋友 0 时刻 4 离开，椅子 0 变成未占据。
 * - 朋友 2 时刻 4 到达，占据椅子 0 。
 * 朋友 1 占据椅子 1 ，所以返回 1 。
 * 示例 2：
 * <p>
 * 输入：times = [[3,10],[1,5],[2,6]], targetFriend = 0
 * 输出：2
 * 解释：
 * - 朋友 1 时刻 1 到达，占据椅子 0 。
 * - 朋友 2 时刻 2 到达，占据椅子 1 。
 * - 朋友 0 时刻 3 到达，占据椅子 2 。
 * - 朋友 1 时刻 5 离开，椅子 0 变成未占据。
 * - 朋友 2 时刻 6 离开，椅子 1 变成未占据。
 * - 朋友 0 时刻 10 离开，椅子 2 变成未占据。
 * 朋友 0 占据椅子 2 ，所以返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == times.length
 * 2 <= n <= 104
 * times[i].length == 2
 * 1 <= arrivali < leavingi <= 105
 * 0 <= targetFriend <= n - 1
 * 每个 arrivali 时刻 互不相同 。
 */
public class Code2 {

    //节点对象
    private static class Node {

        //朋友编号
        private int friend;

        //操作类型：1=到达、2=离开
        private int type;

        //操作时间
        private int time;

        //锁定的位置,默认-1
        private int lock = -1;

        //初始化节点
        public Node(int friend, int type, int time) {
            this.friend = friend;
            this.type = type;
            this.time = time;
        }

        //排序
        public int compareTo(Node another) {
            //如果时间不同
            if (this.time != another.time) {
                //按照时间
                return this.time - another.time;
            }
            //默认 按照类型
            return another.type - this.type;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("friend=%s,type=%s,time=%s,lock=%s", friend, type, time, lock);
        }

    }

    public int smallestChair(int[][] times, int targetFriend) {
        //初始化节点列表
        List<Node> nodeList = new ArrayList<>();
        //循环
        for (int i = 0; i < times.length; i++) {
            //初始化节点并组装
            nodeList.add(new Node(i, 1, times[i][0]));
            nodeList.add(new Node(i, 2, times[i][1]));
        }
        //排序
        nodeList.sort(Node::compareTo);
        //锁定座位的节点map
        Map<Integer, Node> lockMap = new HashMap<>();
        //座位的优先队列
        PriorityQueue<Integer> sitSet = new PriorityQueue<>(Integer::compareTo);
        //循环
        for (Node node : nodeList) {
            //判断是到达还是立刻
            if (node.type == 1) {
                //判断有没有返还的座位
                if (sitSet.isEmpty() == false) {
                    //锁定最高优先级返还的队列
                    node.lock = sitSet.poll();
                } else {
                    //锁定新的座位
                    node.lock = lockMap.size();
                }
                //如果是目标
                if (node.friend == targetFriend) {
                    //返回结果
                    return node.lock;
                }
                //记录节点
                lockMap.put(node.friend, node);
            } else {
                //释放座位到优先队列
                sitSet.add(lockMap.get(node.friend).lock);
                //删除对应锁定
                lockMap.remove(node.friend);
            }
        }
        //默认结果
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().smallestChair(new int[][]{
                new int[]{3, 10},
                new int[]{1, 5},
                new int[]{2, 6}
        }, 0));
    }

}
