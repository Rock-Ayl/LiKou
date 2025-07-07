package normal44;

/**
 * @Author ayl
 * @Date 2025-07-07
 * 947. 移除最多的同行或同列石头
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * <p>
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 * <p>
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 解释：一种移除 5 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
 * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
 * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
 * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
 * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
 * 示例 2：
 * <p>
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 解释：一种移除 3 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
 * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
 * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
 * 示例 3：
 * <p>
 * 输入：stones = [[0,0]]
 * 输出：0
 * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 1000
 * 0 <= xi, yi <= 104
 * 不会有两块石头放在同一个坐标点上
 */
public class Code18 {

    public int removeStones(int[][] stones) {

        /**
         * 初始化并查集
         */

        //并查集
        int[] groupArr = new int[stones.length];
        //循环
        for (int i = 0; i < groupArr.length; i++) {
            //初始化分组
            groupArr[i] = i;
        }

        /**
         * 并查集分组
         */

        //每个轴第一次出现的缓存
        int[] xArr = new int[10001];
        int[] yArr = new int[10001];
        //循环
        for (int i = 0; i < stones.length; i++) {
            //获取本次石头
            int[] stone = stones[i];
            //如果该x轴没有出现过
            if (xArr[stone[0]] == 0) {
                //记录
                xArr[stone[0]] = i + 1;
            } else {
                //并查集分组
                findAndSet(groupArr, xArr[stone[0]] - 1, i);
            }
            //如果该y轴没有出现过
            if (yArr[stone[1]] == 0) {
                //记录
                yArr[stone[1]] = i + 1;
            } else {
                //并查集分组
                findAndSet(groupArr, yArr[stone[1]] - 1, i);
            }
        }

        /**
         * 统计有多少主节点
         */

        //主节点数量
        int rootCount = 0;
        //循环
        for (int i = 0; i < groupArr.length; i++) {
            //如果是主节点
            if (groupArr[i] == i) {
                //+1
                rootCount++;
            }
        }

        //返回结果
        return stones.length - rootCount;
    }

    //并查集
    private int findAndSet(int[] groupArr, int left, int right) {
        //主节点
        int root;
        //左边如果是主节点
        if (groupArr[left] == left) {
            //直接使用
            root = left;
        } else {
            //递归
            root = findAndSet(groupArr, groupArr[left], left);
        }
        //如果右边已经分过组了
        if (groupArr[right] != right) {
            //递归
            findAndSet(groupArr, root, groupArr[right]);
        }
        //记录关系
        groupArr[right] = root;
        //返回
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().removeStones(new int[][]{
                new int[]{0, 0},
                new int[]{0, 2},
                new int[]{1, 1},
                new int[]{2, 0},
                new int[]{2, 2}
        }));
    }

}
