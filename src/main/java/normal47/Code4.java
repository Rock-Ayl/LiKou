package normal47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-10-18
 * 面试题 08.02. 迷路的机器人
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释：
 * 输入中标粗的位置即为输出表示的路径，即
 * 0 行 0 列（左上角） -> 0 行 1 列 -> 0 行 2 列 -> 1 行 2 列 -> 2 行 2 列（右下角）
 * 说明：r 和 c 的值均不超过 100。
 */
public class Code4 {

    private static class Node {

        //上一个节点x
        private int lastX;

        //上一个节点y
        private int lastY;

        //初始化1
        public Node() {

        }

        //初始化2
        public Node(int lastX, int lastY) {
            this.lastX = lastX;
            this.lastY = lastY;
        }

        //调试
        @Override
        public String toString() {
            return String.format("lastX=%s,lastY=%s", this.lastX, this.lastY);
        }

    }

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        //如果最后一个节点有障碍
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            //过
            return new ArrayList<>();
        }
        //如果开始是障碍
        if (obstacleGrid[0][0] == 1) {
            //过
            return new ArrayList<>();
        }
        //动态规划
        Node[][] arr = new Node[obstacleGrid.length][obstacleGrid[0].length];
        //初始化开始节点
        arr[0][0] = new Node(-1, -1);
        //循环
        for (int i = 1; i < arr[0].length; i++) {
            //如果是阻碍
            if (obstacleGrid[0][i] == 1) {
                //跳出
                break;
            }
            //初始化
            arr[0][i] = new Node(0, i - 1);
        }
        //循环
        for (int i = 1; i < arr.length; i++) {
            //如果是阻碍
            if (obstacleGrid[i][0] == 1) {
                //跳出
                break;
            }
            //初始化
            arr[i][0] = new Node(i - 1, 0);
        }
        //循环1
        for (int i = 1; i < arr.length; i++) {
            //循环2
            for (int j = 1; j < arr[0].length; j++) {
                //如果是阻碍
                if (obstacleGrid[i][j] == 1) {
                    //本轮过
                    continue;
                }
                //如果上面有
                if (arr[i - 1][j] != null) {
                    //初始化
                    arr[i][j] = new Node(i - 1, j);
                    //本轮过
                    continue;
                }
                //如果左边有
                if (arr[i][j - 1] != null) {
                    //初始化
                    arr[i][j] = new Node(i, j - 1);
                    //本轮过
                    continue;
                }
            }
        }
        //初始化
        List<List<Integer>> result = new ArrayList<>();
        //最后一个节点
        int x = arr.length - 1;
        int y = arr[0].length - 1;
        //如果最后节点没有结果
        if (arr[x][y] == null) {
            //过
            return new ArrayList<>();
        }
        //如果不是开始节点
        while ((x == 0 && y == 0) == false) {
            //加入结果
            result.add(Arrays.asList(x, y));
            //获取节点
            Node node = arr[x][y];
            //下一个
            x = node.lastX;
            y = node.lastY;
        }
        //开始节点
        result.add(Arrays.asList(x, y));
        //翻转结果
        Collections.reverse(result);
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Code4().pathWithObstacles(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        });
        System.out.println();
    }

}
