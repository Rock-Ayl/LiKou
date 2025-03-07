package normal2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-04-16
 * 1162. 地图分析
 * 你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
 * <p>
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * 如果网格上只有陆地或者海洋，请返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
 */
public class Code14 {

    //总时间
    int minutes = 0;
    //总网格
    int[][] oranges;

    //不断腐烂
    public void rot() {
        //初始化本次要海洋画陆地
        List<List<Integer>> list = new ArrayList<>();
        //循环
        for (int i = 0; i < oranges.length; i++) {
            //循环
            for (int j = 0; j < oranges[0].length; j++) {
                //当前空间
                int space = oranges[i][j];
                //如果是陆地
                if (space == 1) {
                    //如果未越界
                    if (i > 0) {
                        //获取空间
                        int a = oranges[i - 1][j];
                        //如果是海洋
                        if (a == 0) {
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
                        //如果是海洋
                        if (b == 0) {
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
                        //如果是海洋
                        if (c == 0) {
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
                        //如果是海洋
                        if (d == 0) {
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
        //如果有海洋变陆地
        if (list.size() > 0) {
            //循环
            for (List<Integer> xy : list) {
                //变
                oranges[xy.get(0)][xy.get(1)] = 1;
            }
            //时间+1
            minutes++;
            //结束后下一轮
            rot();
        }
    }

    public int maxDistance(int[][] grid) {
        //给与
        oranges = grid;
        //陆地,海洋
        boolean isLand = false, isSea = false;
        //循环
        for (int i = 0; i < oranges.length; i++) {
            //循环2
            for (int j = 0; j < oranges[0].length; j++) {
                //当前空间
                int space = oranges[i][j];
                //如果是陆地
                if (space == 1) {
                    //存在
                    isLand = true;
                } else {
                    //存在
                    isSea = true;
                }
            }
        }
        //如果不存在任意
        if (isLand == false || isSea == false) {
            //默认
            return -1;
        }
        //递归
        rot();
        //递归
        return minutes;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().maxDistance(new int[][]{new int[]{1, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}));
    }
}
