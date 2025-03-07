package normal38;

/**
 * @Author ayl
 * @Date 2024-11-29
 * LCR 116. 省份数量
 * 中等
 * 相关标签
 * 相关企业
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 * <p>
 * <p>
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * <p>
 * <p>
 * 注意：本题与主站 547 题相同： https://leetcode-cn.com/problems/number-of-provinces/
 */
public class Code3 {

    public int findCircleNum(int[][] isConnected) {
        //城市数量
        int city = isConnected.length;
        //初始化城市并查集数组
        int[] cityGroupArr = new int[city];
        //循环
        for (int i = 0; i < cityGroupArr.length; i++) {
            //默认城市分组
            cityGroupArr[i] = i;
        }
        //循环1
        for (int i = 0; i < city; i++) {
            //循环2
            for (int j = 0; j < city; j++) {
                //如果没连接 or 如果是一个城市
                if (isConnected[i][j] == 0 || i == j) {
                    //本轮过
                    continue;
                }
                //关联
                union(cityGroupArr, i, j);
            }
        }
        //目标结果
        int count = 0;
        //循环
        for (int i = 0; i < cityGroupArr.length; i++) {
            //如果是顶层
            if (cityGroupArr[i] == i) {
                //+1
                count++;
            }
        }
        //返回结果
        return count;
    }

    //关联
    private void union(int[] cityGroupArr, int left, int right) {
        //关联顶级的2个顶点
        cityGroupArr[findAndUpdate(cityGroupArr, right)] = findAndUpdate(cityGroupArr, left);
    }

    //寻找顶层,并不断更新顶层
    private int findAndUpdate(int[] cityGroupArr, int city) {
        //如果相同
        if (cityGroupArr[city] != city) {
            //递归父级,更新
            cityGroupArr[city] = findAndUpdate(cityGroupArr, cityGroupArr[city]);
        }
        //返回
        return cityGroupArr[city];
    }

    public static void main(String[] args) {
        int[][] ints = {
                new int[]{1, 1, 1, 0, 1, 1, 1, 0, 0, 0},
                new int[]{1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                new int[]{1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                new int[]{1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                new int[]{1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                new int[]{0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                new int[]{0, 0, 0, 1, 0, 0, 1, 0, 1, 1},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1}
        };
        System.out.println(new Code3().findCircleNum(ints));
    }

}
