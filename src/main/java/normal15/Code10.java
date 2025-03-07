package normal15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-08-01
 * 1267. 统计参与通信的服务器
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * <p>
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * <p>
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 */
public class Code10 {

    public int countServers(int[][] grid) {
        //初始化可以的数量
        int result = 0;
        //行,列
        Map<Integer, Set<Integer>> link = new HashMap<>(grid.length);
        Map<Integer, Set<Integer>> row = new HashMap<>(grid[0].length);
        //指针
        int linkP = 0, rowP = 0;
        //循环
        while (linkP < grid.length) {
            //初始化
            link.put(linkP++, new HashSet<>());
        }
        //循环
        while (rowP < grid[0].length) {
            //初始化
            row.put(rowP++, new HashSet<>());
        }
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果啥也没有
                if (grid[i][j] == 0) {
                    //过
                    continue;
                }
                //记录行列关系
                link.get(i).add(j);
                row.get(j).add(i);
            }
        }
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果啥也没有
                if (grid[i][j] == 0) {
                    //过
                    continue;
                }
                //如果任一一个可以通讯
                if (link.get(i).size() > 1 || row.get(j).size() > 1) {
                    //记录
                    result++;
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().countServers(new int[][]{
                new int[]{1, 1, 0, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 0, 1},
        }));
    }


}
