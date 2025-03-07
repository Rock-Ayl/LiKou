package easy10;

/**
 * @Author ayl
 * @Date 2021-07-21
 * 807. 保持城市天际线
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
 * <p>
 * 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。
 * <p>
 * 建筑物高度可以增加的最大总和是多少？
 * <p>
 * 例子：
 * 输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * 输出： 35
 * 解释：
 * The grid is:
 * [ [3, 0, 8, 4],
 * [2, 4, 5, 7],
 * [9, 2, 6, 3],
 * [0, 3, 1, 0] ]
 * <p>
 * 从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
 * 从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
 * <p>
 * 在不影响天际线的情况下对建筑物进行增高后，新数组如下：
 * <p>
 * gridNew = [ [8, 4, 8, 7],
 * [7, 4, 7, 7],
 * [9, 4, 8, 7],
 * [3, 3, 3, 3] ]
 * 说明:
 * <p>
 * 1 < grid.length = grid[0].length <= 50。
 * grid[i][j] 的高度范围是： [0, 100]。
 * 一座建筑物占据一个grid[i][j]：换言之，它们是 1 x 1 x grid[i][j] 的长方体。
 */
public class Code12 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        //结果
        int size = 0;
        //竖直
        int[] arr1 = new int[grid[0].length];
        //水平
        int[] arr2 = new int[grid.length];
        //循环
        for (int i = 0; i < arr1.length; i++) {
            //最小
            int max = 0;
            //循环
            for (int[] ints : grid) {
                //如果有更大的
                if (ints[i] > max) {
                    //刷新
                    max = ints[i];
                }
            }
            //记录
            arr1[i] = max;
        }
        //循环2
        for (int i = 0; i < arr2.length; i++) {
            //最小
            int max = 0;
            //循环2-2
            for (int i1 : grid[i]) {
                //如果有更大的
                if (i1 > max) {
                    //刷新
                    max = i1;
                }
            }
            //记录
            arr2[i] = max;
        }
        //循环3
        for (int i = 0; i < grid.length; i++) {
            //循环3-2
            for (int j = 0; j < grid[0].length; j++) {
                //最大值
                int max = Math.min(arr1[j], arr2[i]);
                //如果可以增加
                if (max > grid[i][j]) {
                    //计算
                    size += max - grid[i][j];
                }
            }
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().maxIncreaseKeepingSkyline(new int[][]{
                new int[]{3, 0, 8, 4},
                new int[]{2, 4, 5, 7},
                new int[]{9, 2, 6, 3},
                new int[]{0, 3, 1, 0}
        }));
    }

}
