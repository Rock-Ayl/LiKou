package normal42;

/**
 * @Author ayl
 * @Date 2025-05-07
 * 3537. 填充特殊网格
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个非负整数 N，表示一个 2N x 2N 的网格。你需要用从 0 到 22N - 1 的整数填充网格，使其成为一个 特殊 网格。一个网格当且仅当满足以下 所有 条件时，才能称之为 特殊 网格：
 * <p>
 * 右上角象限中的所有数字都小于右下角象限中的所有数字。
 * 右下角象限中的所有数字都小于左下角象限中的所有数字。
 * 左下角象限中的所有数字都小于左上角象限中的所有数字。
 * 每个象限也都是一个特殊网格。
 * 返回一个 2N x 2N 的特殊网格。
 * <p>
 * 注意：任何 1x1 的网格都是特殊网格。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： N = 0
 * <p>
 * 输出： [[0]]
 * <p>
 * 解释：
 * <p>
 * 唯一可以放置的数字是 0，并且网格中只有一个位置。
 * <p>
 * 示例 2：
 * <p>
 * 输入： N = 1
 * <p>
 * 输出： [[3,0],[2,1]]
 * <p>
 * 解释：
 * <p>
 * 每个象限的数字如下：
 * <p>
 * 右上角：0
 * 右下角：1
 * 左下角：2
 * 左上角：3
 * 由于 0 < 1 < 2 < 3，该网格满足给定的约束条件。
 * <p>
 * 示例 3：
 * <p>
 * 输入： N = 2
 * <p>
 * 输出： [[15,12,3,0],[14,13,2,1],[11,8,7,4],[10,9,6,5]]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 每个象限的数字如下：
 * <p>
 * 右上角：3, 0, 2, 1
 * 右下角：7, 4, 6, 5
 * 左下角：11, 8, 10, 9
 * 左上角：15, 12, 14, 13
 * max(3, 0, 2, 1) < min(7, 4, 6, 5)
 * max(7, 4, 6, 5) < min(11, 8, 10, 9)
 * max(11, 8, 10, 9) < min(15, 12, 14, 13)
 * 这满足前三个要求。此外，每个象限也是一个特殊网格。因此，这是一个特殊网格。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= N <= 10
 */
public class Code18 {

    public int[][] specialGrid(int n) {

        //特殊情况
        if (n == 0) {
            //返回
            return new int[][]{new int[]{0}};
        }

        /**
         * 计算矩阵大小
         */

        //变长
        int length = 2;
        //索引
        int xIndex = 1;
        //循环
        while (xIndex++ < n) {
            //次方
            length = length * 2;
        }

        /**
         * 开始填充
         */

        //数字数量
        int count = length * length;
        //矩阵
        int[][] arr = new int[length][length];
        //递归实现
        countAndSet(arr, 0, count - 1, 0, 0, length - 1, length - 1);
        //返回
        return arr;
    }

    //递归不断填充
    private void countAndSet(int[][] arr,
                             int startNum, int endNum,
                             int startX, int startY,
                             int endX, int endY) {

        //计算当前范围内数字数量
        int numberCount = endNum - startNum + 1;

        /**
         * 如果最小范围,填充
         */

        //如果是最小范围
        if (numberCount == 4) {
            //写入
            arr[startX][endY] = startNum++;
            arr[endX][endY] = startNum++;
            arr[endX][startY] = startNum++;
            arr[startX][startY] = startNum;
            //结束
            return;
        }

        /**
         * 如果不是最小范围,递归缩小范围
         */

        //计算中间节点
        int midX = (endX - startX) / 2 + startX;
        int midY = (endY - startY) / 2 + startY;
        //计算下一部分数字数量
        int nextPartNumberCount = numberCount / 4;
        int midNumberCount = (endNum - startNum) / 2 + startNum;

        //左上
        countAndSet(arr,
                endNum - nextPartNumberCount + 1, endNum,
                startX, startY,
                midX, midY);
        //右下
        countAndSet(arr,
                midNumberCount - nextPartNumberCount + 1, midNumberCount,
                midX + 1, midY + 1,
                endX, endY);
        //右上
        countAndSet(arr,
                startNum, startNum + nextPartNumberCount - 1,
                startX, midY + 1,
                midX, endY);
        //左下
        countAndSet(arr,
                midNumberCount + 1, midNumberCount + nextPartNumberCount,
                midX + 1, startY,
                endX, midY);

    }

    public static void main(String[] args) {
        int[][] ints = new Code18().specialGrid(2);
        print(ints);
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
