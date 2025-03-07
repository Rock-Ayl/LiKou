package normal30;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-03-29
 * 840. 矩阵中的幻方
 * 中等
 * 相关标签
 * 相关企业
 * 3 x 3 的幻方是一个填充有 从 1 到 9  的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * <p>
 * 给定一个由整数组成的row x col 的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * <p>
 * 而这一个不是：
 * <p>
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 示例 2:
 * <p>
 * 输入: grid = [[8]]
 * 输出: 0
 * <p>
 * <p>
 * 提示:
 * <p>
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 10
 * 0 <= grid[i][j] <= 15
 */
public class Code8 {

    private void print(int[][] row) {
        for (int[] ints : row) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int numMagicSquaresInside(int[][] grid) {
        //初始化行缓存
        int[][] one = new int[grid.length][grid[0].length];
        //初始化列缓存
        int[][] two = new int[grid.length][grid[0].length];
        //初始化右下对角线缓存
        int[][] three = new int[grid.length][grid[0].length];
        //初始化左上对角线缓存
        int[][] four = new int[grid.length][grid[0].length];
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length - 2; j++) {
                //计算本位置行的和
                one[i][j] = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
            }
        }
        //循环1
        for (int i = 0; i < grid.length - 2; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //计算本位置行的和
                two[i][j] = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
            }
        }
        //循环1
        for (int i = 0; i < grid.length - 2; i++) {
            //循环2
            for (int j = 0; j < grid[0].length - 2; j++) {
                //计算本位置行的和
                three[i][j] = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
            }
        }
        //循环1
        for (int i = 0; i < grid.length - 2; i++) {
            //循环2
            for (int j = 0; j < grid[0].length - 2; j++) {
                //计算本位置行的和
                four[i][j] = grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2];
            }
        }
        //结果数量
        int count = 0;
        //循环1
        for (int i = 0; i < grid.length - 2; i++) {
            //循环2
            for (int j = 0; j < grid[0].length - 2; j++) {
                //如果行不同
                if (one[i][j] != one[i + 1][j] || one[i][j] != one[i + 2][j]) {
                    //本轮过
                    continue;
                }
                //如果列不同
                if (two[i][j] != two[i][j + 1] || two[i][j] != two[i][j + 2]) {
                    //本轮过
                    continue;
                }
                //如果行、列不同
                if (one[i][j] != two[i][j]) {
                    //本轮过
                    continue;
                }
                //如果行、右下对角线不同
                if (one[i][j] != three[i][j]) {
                    //本轮过
                    continue;
                }
                //如果行、左上对角线不同
                if (one[i][j] != four[i][j]) {
                    //本轮过
                    continue;
                }
                //如果数字不对
                if (grid[i][j] < 1 || grid[i][j] > 9 ||
                        grid[i][j + 1] < 1 || grid[i][j + 1] > 9 ||
                        grid[i][j + 2] < 1 || grid[i][j + 2] > 9 ||
                        grid[i + 1][j] < 1 || grid[i + 1][j] > 9 ||
                        grid[i + 1][j + 1] < 1 || grid[i + 1][j + 1] > 9 ||
                        grid[i + 1][j + 2] < 1 || grid[i + 1][j + 2] > 9 ||
                        grid[i + 2][j] < 1 || grid[i + 2][j] > 9 ||
                        grid[i + 2][j + 1] < 1 || grid[i + 2][j + 1] > 9 ||
                        grid[i + 2][j + 2] < 1 || grid[i + 2][j + 2] > 9) {
                    //本轮过
                    continue;
                }
                //去重集合
                Set<Integer> set = new HashSet<>();
                //加入
                set.add(grid[i][j]);
                set.add(grid[i][j + 1]);
                set.add(grid[i][j + 2]);
                set.add(grid[i + 1][j]);
                set.add(grid[i + 1][j + 1]);
                set.add(grid[i + 1][j + 2]);
                set.add(grid[i + 2][j]);
                set.add(grid[i + 2][j + 1]);
                set.add(grid[i + 2][j + 2]);
                //如果有重复
                if (set.size() < 9) {
                    //本轮过
                    continue;
                }
                //记录数量
                count++;
            }
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().numMagicSquaresInside(new int[][]{
                new int[]{3, 2, 9, 2, 7},
                new int[]{6, 1, 8, 4, 2},
                new int[]{7, 5, 3, 2, 7},
                new int[]{2, 9, 4, 9, 6},
                new int[]{4, 3, 8, 2, 5}
        }));
    }

}
