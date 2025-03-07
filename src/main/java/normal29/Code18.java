package normal29;

/**
 * @Author ayl
 * @Date 2024-03-08
 * 1914. 循环轮转矩阵
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个大小为 m x n 的整数矩阵 grid​​​ ，其中 m 和 n 都是 偶数 ；另给你一个整数 k 。
 * <p>
 * 矩阵由若干层组成，如下图所示，每种颜色代表一层：
 * <p>
 * <p>
 * <p>
 * 矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 逆时针 方向的相邻元素。轮转示例如下：
 * <p>
 * <p>
 * 返回执行 k 次循环轮转操作后的矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[40,10],[30,20]], k = 1
 * 输出：[[10,20],[40,30]]
 * 解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
 * 输出：[[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
 * 解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 50
 * m 和 n 都是 偶数
 * 1 <= grid[i][j] <= 5000
 * 1 <= k <= 109
 */
public class Code18 {

    //递归不断移动计算坐标,如果找到则填充
    private void moveAndFill(int[][] grid, int[][] target, int sourceX, int sourceY, int x, int y, int k, int level, int firstX, int firstY, int midX, int midY) {
        //根据等级处理
        switch (level) {
            //往下走
            case 1:
                //计算本次可以走的步伐,对比需要走的次数,如果本次可以找到目标
                if (midX - x >= k) {
                    //找到位置,直接覆盖
                    target[x + k][y] = grid[sourceX][sourceY];
                } else {
                    //转方向继续走
                    moveAndFill(grid, target, sourceX, sourceY, midX, y, k - (midX - x), 2, firstX, firstY, midX, midY);
                }
                break;
            //往右走
            case 2:
                //计算本次可以走的步伐,对比需要走的次数,如果本次可以找到目标
                if (midY - y >= k) {
                    //找到位置,直接覆盖
                    target[x][y + k] = grid[sourceX][sourceY];
                } else {
                    //转方向继续走
                    moveAndFill(grid, target, sourceX, sourceY, x, midY, k - (midY - y), 3, firstX, firstY, midX, midY);
                }
                break;
            //往上走
            case 3:
                //计算本次可以走的步伐,对比需要走的次数,如果本次可以找到目标
                if (x - firstX >= k) {
                    //找到位置,直接覆盖
                    target[x - k][y] = grid[sourceX][sourceY];
                } else {
                    //转方向继续走
                    moveAndFill(grid, target, sourceX, sourceY, firstX, y, k - (x - firstX), 4, firstX, firstY, midX, midY);
                }
                break;
            //往左走
            case 4:
                //计算本次可以走的步伐,对比需要走的次数,如果本次可以找到目标
                if (y - firstY >= k) {
                    //找到位置,直接覆盖
                    target[x][y - k] = grid[sourceX][sourceY];
                } else {
                    //转方向继续走
                    moveAndFill(grid, target, sourceX, sourceY, x, firstY, k - (y - firstY), 1, firstX, firstY, midX, midY);
                }
                break;
        }
    }

    //根据传入的节点,计算出对应节点并填充
    private void countAndFill(int[][] grid, int[][] target, int x, int y, int k) {
        //本坐标在由外向内数第几圈
        int cirCle = Math.min(Math.min(x, y), Math.min(grid.length - x - 1, grid[0].length - y - 1));
        //本圈总count
        int oneCircleCount = ((grid.length - (cirCle * 2)) * 2) + ((grid[0].length - (cirCle * 2)) * 2) - 4;
        if (grid[x][y] == 911) {
            System.out.println();
        }
        //本圈的转了一圈等于没转
        k = k % oneCircleCount;
        //如果不需要转
        if (k == 0) {
            //就是原点,直接覆盖
            target[x][y] = grid[x][y];
            //结束
            return;
        }
        //本圈右下角坐标(中点)
        int cirCleMidX = cirCle + (grid.length - (cirCle * 2)) - 1;
        int cirCleMidY = cirCle + (grid[0].length - (cirCle * 2)) - 1;
        //当前节点阶段等级
        int level;
        //如果是等级1的情况
        if (y == cirCle && x < cirCleMidX) {
            //阶段1
            level = 1;
        } else if (x == cirCleMidX && y < cirCleMidY) {
            //阶段2
            level = 2;
        } else if (y == cirCleMidY && x > cirCle) {
            //阶段3
            level = 3;
        } else {
            //阶段4
            level = 4;
        }
        //开始不断递归移动,找到节点后则填充
        moveAndFill(grid, target, x, y, x, y, k, level, cirCle, cirCle, cirCleMidX, cirCleMidY);
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        //最外面一圈一轮的数量
        int oneCircleCount = grid.length * 2 + grid[0].length * 2 - 4;
        //如果最外圈不需要转圈,说明整体都不需要转圈
        if (k % oneCircleCount == 0) {
            //返回
            return grid;
        }
        //初始化结果
        int[][] result = new int[grid.length][grid[0].length];
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //计算并填充
                countAndFill(grid, result, i, j, k);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[][] result = new Code18().rotateGrid(new int[][]{
                new int[]{2190, 43, 3543, 1196, 875, 4722, 4841, 4224, 475, 42, 4349, 4166, 814, 3318, 4764, 2731, 1022, 4213, 150, 4391, 582, 2454, 447, 3157},
                new int[]{2736, 4404, 3175, 3807, 1534, 3725, 2417, 3360, 1749, 3092, 165, 34, 911, 3827, 333, 2026, 4002, 115, 4389, 3548, 1566, 3985, 1383, 591},
                new int[]{1343, 309, 2997, 2659, 3121, 762, 309, 4475, 3139, 3126, 3678, 1947, 4207, 2151, 4008, 2811, 3337, 2367, 2050, 425, 2462, 1103, 4475, 1447},
                new int[]{57, 296, 3206, 3633, 876, 2715, 3943, 871, 4430, 3789, 2488, 3156, 1313, 3758, 993, 2642, 2356, 1373, 2548, 571, 1538, 2368, 3509, 850},
                new int[]{2951, 3293, 2349, 3811, 4280, 2703, 1519, 3670, 4116, 2361, 1852, 3331, 2183, 4571, 4088, 3246, 4331, 3907, 4112, 2215, 4115, 4659, 4178, 320},
                new int[]{2608, 3119, 4589, 1551, 1451, 4069, 1250, 1237, 4535, 2239, 4468, 1731, 1106, 4388, 2649, 1397, 1349, 3177, 3239, 1907, 529, 402, 126, 2722},
                new int[]{3443, 866, 3791, 4617, 2328, 4647, 1094, 3169, 2298, 4930, 3686, 2633, 790, 3756, 1898, 2264, 4792, 3918, 4080, 37, 779, 596, 536, 4376},
                new int[]{2235, 1944, 1903, 316, 2162, 1123, 2621, 750, 4183, 2306, 3104, 1810, 1198, 3107, 1447, 3305, 2649, 3206, 4562, 4115, 2520, 2387, 691, 1269},
                new int[]{3425, 2830, 374, 327, 2894, 306, 4503, 3540, 3260, 1873, 2634, 3938, 957, 3228, 4012, 421, 470, 619, 4919, 1948, 3865, 124, 2701, 736},
                new int[]{4538, 2195, 4995, 4802, 3747, 2207, 1660, 2975, 3344, 4191, 4515, 2024, 3439, 3346, 1977, 915, 66, 3838, 1931, 4046, 3764, 1190, 4511, 2151},
                new int[]{1781, 4700, 1414, 3255, 668, 645, 1728, 790, 430, 3985, 4145, 4023, 4229, 738, 3527, 1210, 658, 3291, 563, 4801, 3961, 3967, 376, 4841},
                new int[]{955, 926, 1494, 3899, 2146, 1787, 282, 623, 3343, 3851, 1811, 3011, 4776, 1063, 508, 775, 2113, 3261, 8, 4534, 403, 1257, 4367, 2529},
                new int[]{943, 2465, 3674, 1751, 349, 2910, 787, 2797, 2483, 742, 3138, 118, 3599, 1428, 968, 2228, 3388, 2764, 4475, 2893, 2248, 3610, 2526, 1468},
                new int[]{1326, 1142, 1317, 3972, 3205, 989, 1046, 3336, 4035, 1956, 433, 4345, 447, 3372, 232, 3784, 1203, 1586, 4557, 1237, 2759, 2402, 2753, 1630}
        }, 717433611);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
        System.out.println();
    }
}
