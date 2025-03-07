package normal32;

/**
 * @Author ayl
 * @Date 2024-06-07
 * LCS 03. 主题空间
 * 中等
 * 相关标签
 * 相关企业
 * 「以扣会友」线下活动所在场地由若干主题空间与走廊组成，场地的地图记作由一维字符串型数组 grid，字符串中仅包含 "0"～"5" 这 6 个字符。地图上每一个字符代表面积为 1 的区域，其中 "0" 表示走廊，其他字符表示主题空间。相同且连续（连续指上、下、左、右四个方向连接）的字符组成同一个主题空间。
 * <p>
 * 假如整个 grid 区域的外侧均为走廊。请问，不与走廊直接相邻的主题空间的最大面积是多少？如果不存在这样的空间请返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入：grid = ["110","231","221"]
 * <p>
 * 输出：1
 * <p>
 * 解释：4 个主题空间中，只有 1 个不与走廊相邻，面积为 1。image.png
 * <p>
 * 示例 2:
 * <p>
 * 输入：grid = ["11111100000","21243101111","21224101221","11111101111"]
 * <p>
 * 输出：3
 * <p>
 * 解释：8 个主题空间中，有 5 个不与走廊相邻，面积分别为 3、1、1、1、2，最大面积为 3。image.png
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 500
 * 1 <= grid[i].length <= 500
 * grid[i][j] 仅可能是 "0"～"5"
 */
public class Code15 {

    //计算连通目标值的和
    private int countAndSet(int[][] arr, int x, int y, int target) {
        //如果越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //过
            return 0;
        }
        //如果不是目标
        if (arr[x][y] != target) {
            //过
            return 0;
        }
        //已经计算过了,改为-1
        arr[x][y] = -1;
        //递归和
        int sum = 1;
        //递归四个方向
        sum += countAndSet(arr, x + 1, y, target);
        sum += countAndSet(arr, x - 1, y, target);
        sum += countAndSet(arr, x, y + 1, target);
        sum += countAndSet(arr, x, y - 1, target);
        //返回
        return sum;
    }

    //判断指定区域是否存在目标值
    private boolean findNearNumberDir(int[][] arr, int x, int y, int target) {
        //如果越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //过
            return false;
        }
        //判断是否为目标值
        return arr[x][y] == target;
    }

    //判断指定区域,周边是否存在目标值
    private boolean findNearNumber(int[][] arr, int x, int y, int target) {
        //直接判断四个方向
        return findNearNumberDir(arr, x + 1, y, target) ||
                findNearNumberDir(arr, x - 1, y, target) ||
                findNearNumberDir(arr, x, y + 1, target) ||
                findNearNumberDir(arr, x, y - 1, target);
    }

    //将 连续的目标值 设置为置顶值
    private void setNearNumber(int[][] arr, int x, int y, int target, int number) {
        //如果越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //过
            return;
        }
        //如果不是目标值
        if (arr[x][y] != target) {
            //过
            return;
        }
        //设置为指定值
        arr[x][y] = number;
        //递归周边
        setNearNumber(arr, x + 1, y, target, number);
        setNearNumber(arr, x - 1, y, target, number);
        setNearNumber(arr, x, y + 1, target, number);
        setNearNumber(arr, x, y - 1, target, number);
    }

    public int largestArea(String[] grid) {
        //矩阵
        int[][] arr = new int[grid.length + 2][grid[0].length() + 2];
        //循环1
        for (int i = 1; i < arr.length - 1; i++) {
            //循环2
            for (int j = 1; j < arr[0].length - 1; j++) {
                //写入矩阵
                arr[i][j] = grid[i - 1].charAt(j - 1) - '0';
            }
        }
        //循环1
        for (int i = 0; i < arr.length; i++) {
            //循环2
            for (int j = 0; j < arr[0].length; j++) {
                //如果不是正常的区域
                if (arr[i][j] == 0 || arr[i][j] == -1) {
                    //本轮过
                    continue;
                }
                //如果周边不存在走廊
                if (findNearNumber(arr, i, j, 0) == false) {
                    //本轮过
                    continue;
                }
                //递归将当前节点、以及节点连通的区域,改为-1
                setNearNumber(arr, i, j, arr[i][j], -1);
            }
        }
        //最大面积
        int maxResult = 0;
        //循环1
        for (int i = 0; i < arr.length; i++) {
            //循环2
            for (int j = 0; j < arr[0].length; j++) {
                //如果不是正常的区域
                if (arr[i][j] == 0 || arr[i][j] == -1) {
                    //本轮过
                    continue;
                }
                //计算面积、并刷新最大情况
                maxResult = Math.max(maxResult, countAndSet(arr, i, j, arr[i][j]));
            }
        }
        //返回
        return maxResult;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().largestArea(new String[]{"11111100000", "21243101111", "21224101221", "11111101111"}));
    }

    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
        System.out.println("################");
    }

}
