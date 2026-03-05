package normal51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2101. 引爆最多的炸弹
 * 算术评级: 5
 * 第 67 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1880
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
 * <p>
 * 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。
 * <p>
 * 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
 * <p>
 * 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：bombs = [[2,1,3],[6,1,4]]
 * 输出：2
 * 解释：
 * 上图展示了 2 个炸弹的位置和爆炸范围。
 * 如果我们引爆左边的炸弹，右边的炸弹不会被影响。
 * 但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
 * 所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：bombs = [[1,1,5],[10,10,5]]
 * 输出：1
 * 解释：
 * 引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
 * 输出：5
 * 解释：
 * 最佳引爆炸弹为炸弹 0 ，因为：
 * - 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
 * - 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
 * - 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
 * 所以总共有 5 个炸弹被引爆。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= bombs.length <= 100
 * bombs[i].length == 3
 * 1 <= xi, yi, ri <= 105
 */
public class Code3 {

    private static class Node {

        //索引
        private int index;

        //坐标
        private int x;

        //坐标
        private int y;

        //爆炸范围
        private int scope;

        //该节点能影响的其他节点
        private List<Node> bombList = new ArrayList<>();

        //初始化
        public Node(int index, int x, int y, int scope) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.scope = scope;
        }

        //方便调试
        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", x=" + x +
                    ", y=" + y +
                    ", scope=" + scope +
                    ", bombList=" + bombList.size() +
                    '}';
        }

    }

    public int maximumDetonation(int[][] bombs) {

        /***
         * 构建节点
         */

        //初始化节点数组
        Node[] nodeArr = new Node[bombs.length];
        //循环
        for (int i = 0; i < bombs.length; i++) {
            //构建
            nodeArr[i] = new Node(i, bombs[i][0], bombs[i][1], bombs[i][2]);
        }

        /**
         * 计算每个节点能影响到其他的哪些节点
         */

        //循环
        for (Node father : nodeArr) {
            //循环2
            for (Node child : nodeArr) {
                //如果是同一个
                if (father == child) {
                    //本轮过
                    continue;
                }
                //如果父亲能影响到儿子
                if (isInScope(father, child)) {
                    //关联
                    father.bombList.add(child);
                }
            }
        }

        /**
         * 递归出每个节点最大影响的路径
         */

        //最大结果
        int maxBombTotalCount = 0;
        //循环
        for (Node node : nodeArr) {
            //递归,并更新最大值
            maxBombTotalCount = Math.max(maxBombTotalCount, next(node, new int[nodeArr.length]));
        }
        //返回
        return maxBombTotalCount;
    }

    //深度递归,计算每个节点影响返回
    private int next(Node node, int[] waledSet) {
        //如果走过了
        if (waledSet[node.index] == 1) {
            //过
            return 0;
        }
        //记录走过了
        waledSet[node.index] = 1;
        //当前也算
        int bombTotalCount = 1;
        //循环
        for (Node child : node.bombList) {
            //递归,并叠加
            bombTotalCount += next(child, waledSet);
        }
        //返回
        return bombTotalCount;
    }

    //判断父亲是否能引爆儿子
    private boolean isInScope(Node father, Node child) {
        //计算距离
        long xd = father.x - child.x;
        long yd = father.y - child.y;
        long zd = father.scope;
        //判断是否在范围内 x方 + y方 = z方
        return xd * xd + yd * yd <= zd * zd;
    }

    public static void main(String[] args) {
        //System.out.println(new Code3().maximumDetonation(new int[][]{{2, 1, 3}, {6, 1, 4}}));
        //[[1,1,100000],[100000,100000,1]]
        System.out.println(new Code3().maximumDetonation(new int[][]{{1, 1, 100000}, {100000, 100000, 1}}));
    }

}
