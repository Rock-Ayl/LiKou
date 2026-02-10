package normal50;

/**
 * 1319. 连通网络的操作次数
 * 算术评级: 6
 * 第 171 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1633
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 * <p>
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 * <p>
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 * 示例 4：
 * <p>
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] < n
 * connections[i][0] != connections[i][1]
 * 没有重复的连接。
 * 两台计算机不会通过多条线缆连接。
 */
public class Code9 {

    public int makeConnected(int n, int[][] connections) {
        //如果线不够
        if (n - 1 > connections.length) {
            //过
            return -1;
        }
        //并查集
        int[] arr = new int[n];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //默认分组
            arr[i] = i;
        }
        //循环
        for (int[] connection : connections) {
            //并查集递归
            findAndSet(arr, connection[0], connection[1]);
        }
        //分组数
        int count = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果是头
            if (arr[i] == i) {
                //+1
                count++;
            }
        }
        //返回
        return count - 1;
    }

    //并查集
    private int findAndSet(int[] arr, int a, int b) {
        //主节点
        int root;
        //如果是自己
        if (arr[a] == a) {
            //使用之
            root = a;
        } else {
            //递归主节点
            root = findAndSet(arr, arr[a], a);
        }
        //如果右边也不是
        if (arr[b] != b) {
            //递归之
            findAndSet(arr, root, arr[b]);
        }
        //记录之
        arr[b] = root;
        //返回主节点
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().makeConnected(6, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3},
                new int[]{1, 2},
                new int[]{1, 3}
        }));
    }

}
