package difficult4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-08-23
 * 827. 最大人工岛
 * 算术评级: 7
 * 第 82 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1934
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 * <p>
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * <p>
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: grid = [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 * <p>
 * 输入: grid = [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 * <p>
 * 输入: grid = [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] 为 0 或 1
 */
public class Code2 {

    public int largestIsland(int[][] grid) {

        /**
         * 为现有岛屿分组,统计每个岛屿的节点数量
         */

        //节点分组数量
        List<Integer> nodeCountList = new ArrayList<>();
        //默认填充一个占位
        nodeCountList.add(0);

        //为岛屿分组
        int[][] groupArr = new int[grid.length][grid[0].length];
        //分组,从1开始
        int group = 1;

        //循环
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果是 海水 or 已经被使用了
                if (grid[i][j] != 1) {
                    //本轮过
                    continue;
                }
                //递归填充本次分组,计算节点数量
                int nodeCount = nextGroup(groupArr, grid, i, j, group++);
                //记录
                nodeCountList.add(nodeCount);
            }
        }

        /**
         * 计算
         */

        //print(groupArr);
        //print(grid);

        //最大连通岛屿数量,默认是单个岛屿最大
        int maxCount = nodeCountList.stream().mapToInt(Integer::intValue).max().getAsInt();
        //循环
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果不是可以填充的海
                if (grid[i][j] != 0) {
                    //本轮过
                    continue;
                }
                //计算出如果填充该节点,可以获得的人工岛
                int count = setAndCount(groupArr, grid, nodeCountList, i, j);
                //刷新最大结果
                maxCount = Math.max(maxCount, count);
            }
        }
        //返回
        return maxCount;
    }

    //计算出如果填充该节点,可以获得的人工岛
    private int setAndCount(int[][] groupArr, int[][] grid, List<Integer> nodeCountList, int x, int y) {
        //分组集合
        Set<Integer> groupSet = new HashSet<>(4);
        //获取可以连通的分组
        groupSet.add(get(groupArr, x + 1, y));
        groupSet.add(get(groupArr, x - 1, y));
        groupSet.add(get(groupArr, x, y + 1));
        groupSet.add(get(groupArr, x, y - 1));
        //和,默认填充指定坐标
        int sum = 1;
        //循环
        for (Integer group : groupSet) {
            //叠加
            sum += nodeCountList.get(group);
        }
        //返回
        return sum;
    }

    //获取数组内容
    private int get(int[][] arr, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //过
            return 0;
        }
        //返回
        return arr[x][y];
    }

    //递归填充本次分组
    private int nextGroup(int[][] groupArr, int[][] grid, int x, int y, int group) {
        //如果越界
        if (x < 0 || y < 0 || x >= groupArr.length || y >= groupArr[0].length) {
            //过
            return 0;
        }
        //如果是 海水 or 已经被使用过
        if (grid[x][y] != 1) {
            //过
            return 0;
        }
        //如果已经被分组过
        if (groupArr[x][y] != 0) {
            //过
            return 0;
        }
        //初始化和
        int sum = 1;
        //修改当前为对应分组
        groupArr[x][y] = group;
        //递归上下左右
        sum += nextGroup(groupArr, grid, x + 1, y, group);
        sum += nextGroup(groupArr, grid, x - 1, y, group);
        sum += nextGroup(groupArr, grid, x, y + 1, group);
        sum += nextGroup(groupArr, grid, x, y - 1, group);
        //返回节点数量
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().largestIsland(new int[][]{
                new int[]{0, 1, 0},
                new int[]{1, 0, 1},
                new int[]{0, 1, 0}
        }));
    }

    private static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

}