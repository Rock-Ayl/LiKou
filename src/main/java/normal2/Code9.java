package normal2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-04-10
 * 994. 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 * <p>
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 */
public class Code9 {

    //总时间
    int minutes = 0;
    //橘子网格
    int[][] oranges;

    //不断腐烂
    public void rot() {
        //初始化本次要腐烂的新鲜橘子橘子
        List<List<Integer>> list = new ArrayList<>();
        //循环
        for (int i = 0; i < oranges.length; i++) {
            //循环
            for (int j = 0; j < oranges[0].length; j++) {
                //当前橘子
                int orange = oranges[i][j];
                //如果是腐烂的橘子
                if (orange == 2) {
                    //如果未越界
                    if (i > 0) {
                        //获取空间
                        int a = oranges[i - 1][j];
                        //如果是新鲜橘子
                        if (a == 1) {
                            //初始化
                            List<Integer> newOrangeList = new ArrayList<>();
                            //记录
                            newOrangeList.add(i - 1);
                            //记录
                            newOrangeList.add(j);
                            //记录
                            list.add(newOrangeList);
                        }
                    }
                    //如果未越界
                    if (i < oranges.length - 1) {
                        //获取空间
                        int b = oranges[i + 1][j];
                        //如果是新鲜橘子
                        if (b == 1) {
                            //初始化
                            List<Integer> newOrangeList = new ArrayList<>();
                            //记录
                            newOrangeList.add(i + 1);
                            //记录
                            newOrangeList.add(j);
                            //记录
                            list.add(newOrangeList);
                        }
                    }
                    //如果未越界
                    if (j > 0) {
                        //获取空间
                        int c = oranges[i][j - 1];
                        //如果是新鲜橘子
                        if (c == 1) {
                            //初始化
                            List<Integer> newOrangeList = new ArrayList<>();
                            //记录
                            newOrangeList.add(i);
                            //记录
                            newOrangeList.add(j - 1);
                            //记录
                            list.add(newOrangeList);
                        }
                    }
                    //如果未越界
                    if (j < oranges[0].length - 1) {
                        //获取空间
                        int d = oranges[i][j + 1];
                        //如果是新鲜橘子
                        if (d == 1) {
                            //初始化
                            List<Integer> newOrangeList = new ArrayList<>();
                            //记录
                            newOrangeList.add(i);
                            //记录
                            newOrangeList.add(j + 1);
                            //记录
                            list.add(newOrangeList);
                        }
                    }
                }
            }
        }
        //如果有新鲜的橘子要被腐化了
        if (list.size() > 0) {
            //循环
            for (List<Integer> xy : list) {
                //腐烂橘子
                oranges[xy.get(0)][xy.get(1)] = 2;
            }
            //时间+1
            minutes++;
            //结束后下一轮
            rot();
        }
    }

    public int orangesRotting(int[][] grid) {
        //给与
        oranges = grid;
        //不断腐烂
        rot();
        //循环
        for (int i = 0; i < oranges.length; i++) {
            //循环
            for (int j = 0; j < oranges[0].length; j++) {
                //如果还有新鲜的橘子
                if (oranges[i][j] == 1) {
                    //直接返回
                    return -1;
                }
            }
        }
        //返回时间
        return minutes;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().orangesRotting(new int[][]{new int[]{0, 1}}));
    }

}
