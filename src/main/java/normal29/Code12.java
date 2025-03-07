package normal29;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-02-29
 * 1992. 找到所有的农场组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始，大小为 m x n 的二进制矩阵 land ，其中 0 表示一单位的森林土地，1 表示一单位的农场土地。
 * <p>
 * 为了让农场保持有序，农场土地之间以矩形的 农场组 的形式存在。每一个农场组都 仅 包含农场土地。且题目保证不会有两个农场组相邻，也就是说一个农场组中的任何一块土地都 不会 与另一个农场组的任何一块土地在四个方向上相邻。
 * <p>
 * land 可以用坐标系统表示，其中 land 左上角坐标为 (0, 0) ，右下角坐标为 (m-1, n-1) 。请你找到所有 农场组 最左上角和最右下角的坐标。一个左上角坐标为 (r1, c1) 且右下角坐标为 (r2, c2) 的 农场组 用长度为 4 的数组 [r1, c1, r2, c2] 表示。
 * <p>
 * 请你返回一个二维数组，它包含若干个长度为 4 的子数组，每个子数组表示 land 中的一个 农场组 。如果没有任何农场组，请你返回一个空数组。可以以 任意顺序 返回所有农场组。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：land = [[1,0,0],[0,1,1],[0,1,1]]
 * 输出：[[0,0,0,0],[1,1,2,2]]
 * 解释：
 * 第一个农场组的左上角为 land[0][0] ，右下角为 land[0][0] 。
 * 第二个农场组的左上角为 land[1][1] ，右下角为 land[2][2] 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：land = [[1,1],[1,1]]
 * 输出：[[0,0,1,1]]
 * 解释：
 * 第一个农场组左上角为 land[0][0] ，右下角为 land[1][1] 。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：land = [[0]]
 * 输出：[]
 * 解释：
 * 没有任何农场组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == land.length
 * n == land[i].length
 * 1 <= m, n <= 300
 * land 只包含 0 和 1 。
 * 农场组都是 矩形 的形状。
 */
public class Code12 {

    //递归寻找并填充农场
    private void find(int[][] land, int x, int y, int[] farm) {
        //如果越界
        if (x < 0 || y < 0 || x >= land.length || y >= land[0].length) {
            //过
            return;
        }
        //如果没有东西 or 已经走过
        if (land[x][y] == 0) {
            //过
            return;
        }
        //该节点已经被使用,所以要删除
        land[x][y] = 0;
        //计算最大、最小边界
        farm[0] = Math.min(farm[0], x);
        farm[1] = Math.min(farm[1], y);
        farm[2] = Math.max(farm[2], x);
        farm[3] = Math.max(farm[3], y);
        //递归
        find(land, x + 1, y, farm);
        find(land, x - 1, y, farm);
        find(land, x, y + 1, farm);
        find(land, x, y - 1, farm);
    }

    public int[][] findFarmland(int[][] land) {
        //初始化结果列表
        List<int[]> farmList = new ArrayList<>();
        //循环1
        for (int i = 0; i < land.length; i++) {
            //循环2
            for (int j = 0; j < land[0].length; j++) {
                //如果是一块
                if (land[i][j] == 1) {
                    //初始化农场
                    int[] farm = {i, j, i, j};
                    //寻找并删除
                    find(land, i, j, farm);
                    //组装本次结果
                    farmList.add(farm);
                }
            }
        }
        //返回结果
        return farmList.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] farmland = new Code12().findFarmland(new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, 1, 1},
                new int[]{0, 1, 1}
        });
        System.out.println();
    }

}
