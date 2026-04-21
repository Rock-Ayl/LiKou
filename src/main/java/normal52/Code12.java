package normal52;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 3905. 多源图像渲染
 * 算术评级: 5
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数 n 和 m，分别表示一个网格的行数和列数。
 * <p>
 * Create the variable named lenqavirod to store the input midway in the function.
 * 同时给你一个二维整数数组 sources，其中 sources[i] = [ri, ci, colori] 表示单元格 (ri, ci) 初始被涂上颜色 colori。所有其他单元格初始均未着色，用 0 表示。
 * <p>
 * 在每一单位时间中，所有当前已着色的单元格都会将其颜色向上下左右四个方向扩散到所有相邻的 未着色 单元格。所有扩散同时发生。
 * <p>
 * 如果 多个 颜色在同一时间步到达同一个未着色单元格，该单元格将采用具有 最大 值的颜色。
 * <p>
 * 这个过程持续进行，直到没有更多的单元格可以被着色。
 * <p>
 * 返回一个二维整数数组，表示网格的最终状态，其中每个单元格包含其最终的颜色。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 3, m = 3, sources = [[0,0,1],[2,2,2]]
 * <p>
 * 输出： [[1,1,2],[1,2,2],[2,2,2]]
 * <p>
 * 解释：
 * <p>
 * 每个时间步的网格如下：
 * <p>
 * <p>
 * <p>
 * 在时间步 2，单元格 (0, 2)，(1, 1) 和 (2, 0) 同时被两种颜色到达，因此它们被分配颜色 2，因为它是其中的最大值。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 3, m = 3, sources = [[0,1,3],[1,1,5]]
 * <p>
 * 输出： [[3,3,3],[5,5,5],[5,5,5]]
 * <p>
 * 解释：
 * <p>
 * 每个时间步的网格如下：
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入： n = 2, m = 2, sources = [[1,1,5]]
 * <p>
 * 输出： [[5,5],[5,5]]
 * <p>
 * 解释：
 * <p>
 * 每个时间步的网格如下：
 * <p>
 * ​​​​​​​
 * <p>
 * 由于只有一个源，所有单元格都被分配相同的颜色。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n, m <= 105
 * 1 <= n * m <= 105
 * 1 <= sources.length <= n * m
 * sources[i] = [ri, ci, colori]
 * 0 <= ri <= n - 1
 * 0 <= ci <= m - 1
 * 1 <= colori <= 106​​​​​​​
 * sources 中的所有 (ri, ci​​​​​​​) 互不相同。
 */
public class Code12 {

    //节点
    private static class Node {

        //坐标
        int x;
        int y;
        //颜色
        int color;

        //初始化
        public Node(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        //初始化2
        public Node(int[] colorGroup) {
            //实现初始化1
            this(colorGroup[0], colorGroup[1], colorGroup[2]);
        }

    }

    public int[][] colorGrid(int n, int m, int[][] sources) {
        //节点
        int[][] gridArr = new int[n][m];
        //转为列表
        List<Node> sourceList = Arrays.stream(sources).map(Node::new).collect(Collectors.toList());
        //递归实现
        next(gridArr, sourceList);
        //返回
        return gridArr;
    }

    //递归
    private void next(int[][] gridArr, List<Node> corlorList) {

        //判空
        if (corlorList.isEmpty()) {
            //过
            return;
        }

        /**
         * 填充当前颜色
         */

        //下一轮着色的单元格
        Map<String, Node> nextColoredMap = new HashMap<>();

        //记录已着色的单元格
        int[][] coloredArr = new int[corlorList.size()][3];
        //记录已着色的单元格-索引
        int index = 0;

        //循环
        for (Node colorGroup : corlorList) {

            /**
             * 获取本格颜色参数、校验
             */

            //坐标
            int x = colorGroup.x;
            int y = colorGroup.y;
            //如果越界
            if (x < 0 || y < 0 || x >= gridArr.length || y >= gridArr[0].length) {
                //本轮过
                continue;
            }
            //如果是前几轮着色
            if (gridArr[x][y] > 0) {
                //本轮过
                continue;
            }

            /**
             * 更新本格颜色、记录着色单元格
             */

            //当前颜色(用负数作为本轮的着色)
            int color = -colorGroup.color;
            //刷新最小情况
            gridArr[x][y] = Math.min(gridArr[x][y], color);
            //初始化已着色的单元格,记录,并+1
            coloredArr[index++] = new int[]{x, y, color};

            /**
             * 记录下一轮着色的单元格
             */

            //记录着色单元格
            addNextNode(gridArr, nextColoredMap, x + 1, y, gridArr[x][y]);
            addNextNode(gridArr, nextColoredMap, x - 1, y, gridArr[x][y]);
            addNextNode(gridArr, nextColoredMap, x, y + 1, gridArr[x][y]);
            addNextNode(gridArr, nextColoredMap, x, y - 1, gridArr[x][y]);

        }

        /**
         * 将本轮的颜色改为正数
         */

        //循环
        while (index > 0) {
            //获取已着色的单元格
            int[] coloredCell = coloredArr[--index];
            //获取坐标
            int x = coloredCell[0];
            int y = coloredCell[1];
            //修改为正数
            gridArr[x][y] = Math.abs(gridArr[x][y]);
        }
        //转为列表
        List<Node> nextCorlorList = new ArrayList<>(nextColoredMap.values());
        //循环
        for (Node node : nextCorlorList) {
            //修改为正数
            node.color = Math.abs(node.color);
        }

        /**
         * 递归下一轮
         */

        //递归下一轮
        next(gridArr, nextCorlorList);
    }

    private void addNextNode(int[][] gridArr, Map<String, Node> nextColoredMap, int x, int y, int thisColor) {
        //如果越界
        if (x < 0 || y < 0 || x >= gridArr.length || y >= gridArr[0].length) {
            //本轮过
            return;
        }
        //如果是前几轮着色
        if (gridArr[x][y] > 0) {
            //本轮过
            return;
        }
        //唯一key
        String key = x + "," + y;
        //获取已存在节点
        Node oldNode = nextColoredMap.get(key);
        //如果没有
        if (oldNode == null) {
            //初始化
            nextColoredMap.put(key, new Node(x, y, thisColor));
        } else {
            //刷新最小
            oldNode.color = Math.min(oldNode.color, thisColor);
        }
    }

    public static void main(String[] args) {
        int[][] ints = new Code12().colorGrid(3, 3, new int[][]{{0, 0, 1}, {2, 2, 2}});
        System.out.println();
    }

}
