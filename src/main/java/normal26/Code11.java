package normal26;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-11-28
 * 1765. 地图中的最高点
 * 提示
 * 中等
 * 122
 * 相关企业
 * 给你一个大小为 m x n 的整数矩阵 isWater ，它代表了一个由 陆地 和 水域 单元格组成的地图。
 * <p>
 * 如果 isWater[i][j] == 0 ，格子 (i, j) 是一个 陆地 格子。
 * 如果 isWater[i][j] == 1 ，格子 (i, j) 是一个 水域 格子。
 * 你需要按照如下规则给每个单元格安排高度：
 * <p>
 * 每个格子的高度都必须是非负的。
 * 如果一个格子是 水域 ，那么它的高度必须为 0 。
 * 任意相邻的格子高度差 至多 为 1 。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
 * 找到一种安排高度的方案，使得矩阵中的最高高度值 最大 。
 * <p>
 * 请你返回一个大小为 m x n 的整数矩阵 height ，其中 height[i][j] 是格子 (i, j) 的高度。如果有多种解法，请返回 任意一个 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：isWater = [[0,1],[0,0]]
 * 输出：[[1,0],[2,1]]
 * 解释：上图展示了给各个格子安排的高度。
 * 蓝色格子是水域格，绿色格子是陆地格。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：isWater = [[0,0,1],[1,0,0],[0,0,0]]
 * 输出：[[1,1,0],[0,1,1],[1,2,2]]
 * 解释：所有安排方案中，最高可行高度为 2 。
 * 任意安排方案中，只要最高高度为 2 且符合上述规则的，都为可行方案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == isWater.length
 * n == isWater[i].length
 * 1 <= m, n <= 1000
 * isWater[i][j] 要么是 0 ，要么是 1 。
 * 至少有 1 个水域格子。
 */
public class Code11 {

    public int[][] highestPeak(int[][] isWater) {
        //次数
        int count = 0;
        //目标次数
        int targetCount = isWater.length * isWater[0].length;
        //初始化结果
        int[][] resultArr = new int[isWater.length][isWater[0].length];
        //初始化走过的缓存
        int[][] walkCacheArr = new int[isWater.length][isWater[0].length];
        //缓存
        Set<String> nodeSet = new HashSet<>();
        //循环1
        for (int i = 0; i < isWater.length; i++) {
            //循环2
            for (int j = 0; j < isWater[0].length; j++) {
                //寻找水
                if (isWater[i][j] == 1) {
                    //记录水的位置
                    nodeSet.add(i + "," + j);
                    //记录算是走过了
                    walkCacheArr[i][j] = 1;
                    //记录
                    count++;
                }
            }
        }
        //高度
        int high = 1;
        //如果没有结束
        while (count < targetCount) {
            //下一级
            Set<String> nextNodeSet = new HashSet<>();
            //循环
            for (String key : nodeSet) {
                //获取key
                String[] arr = key.split(",");
                //拆分出坐标
                int x = Integer.valueOf(arr[0]);
                int y = Integer.valueOf(arr[1]);
                //如果未越界
                if (x > 0) {
                    //记录
                    nextNodeSet.add((x - 1) + "," + y);
                }
                //如果未越界
                if (y > 0) {
                    //记录
                    nextNodeSet.add(x + "," + (y - 1));
                }
                //如果未越界
                if (x < isWater.length - 1) {
                    //记录
                    nextNodeSet.add((x + 1) + "," + y);
                }
                //如果未越界
                if (y < isWater[0].length - 1) {
                    //记录
                    nextNodeSet.add(x + "," + (y + 1));
                }
            }
            //过滤掉走过的路径
            nextNodeSet.removeIf(p -> walkCacheArr[Integer.valueOf(p.split(",")[0])][Integer.valueOf(p.split(",")[1])] == 1);
            //循环
            for (String key : nextNodeSet) {
                //获取key
                String[] arr = key.split(",");
                //拆分出坐标
                int x = Integer.valueOf(arr[0]);
                int y = Integer.valueOf(arr[1]);
                //记录高度
                resultArr[x][y] = high;
                //记录算是走过了
                walkCacheArr[x][y] = 1;
                //记录次数
                count++;
            }
            //下一波
            nodeSet = nextNodeSet;
            //高度升级
            high++;
        }
        //返回
        return resultArr;
    }

    public static void main(String[] args) {
        int[][] ints = new Code11().highestPeak(new int[][]{
                new int[]{0, 0, 1},
                new int[]{1, 0, 0},
                new int[]{0, 0, 0,}
        });
        System.out.println();
    }

}
