package normal32;

/**
 * @Author ayl
 * @Date 2024-06-15
 * LCP 56. 信物传送
 * 中等
 * 相关标签
 * 相关企业
 * 欢迎各位勇者来到力扣城，本次试炼主题为「信物传送」。
 * <p>
 * 本次试炼场地设有若干传送带，matrix[i][j] 表示第 i 行 j 列的传送带运作方向，"^","v","<",">" 这四种符号分别表示 上、下、左、右 四个方向。信物会随传送带的方向移动。勇者每一次施法操作，可临时变更一处传送带的方向，在物品经过后传送带恢复原方向。lcp (2).gif
 * <p>
 * 通关信物初始位于坐标 start处，勇者需要将其移动到坐标 end 处，请返回勇者施法操作的最少次数。
 * <p>
 * 注意：
 * <p>
 * start 和 end 的格式均为 [i,j]
 * 示例 1:
 * <p>
 * 输入：matrix = [">>v","v^<","<><"], start = [0,1], end = [2,0]
 * <p>
 * 输出：1
 * <p>
 * 解释： 如上图所示 当信物移动到 [1,1] 时，勇者施法一次将 [1,1] 的传送方向 ^ 从变更为 < 从而信物移动到 [1,0]，后续到达 end 位置 因此勇者最少需要施法操作 1 次
 * <p>
 * 示例 2:
 * <p>
 * 输入：matrix = [">>v",">>v","^<<"], start = [0,0], end = [1,1]
 * <p>
 * 输出：0
 * <p>
 * 解释：勇者无需施法，信物将自动传送至 end 位置
 * <p>
 * 示例 3:
 * <p>
 * 输入：matrix = [">^^>","<^v>","^v^<"], start = [0,0], end = [1,3]
 * <p>
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * matrix 中仅包含 '^'、'v'、'<'、'>'
 * 0 < matrix.length <= 100
 * 0 < matrix[i].length <= 100
 * 0 <= start[0],end[0] < matrix.length
 * 0 <= start[1],end[1] < matrix[i].length
 */
public class Code20 {

    //根据字符,判断移动坐标
    private int[] getDir(char letter) {
        //根据字符判断
        switch (letter) {
            //上
            case '^':
                //返回
                return new int[]{-1, 0};
            //下
            case 'v':
                //返回
                return new int[]{1, 0};
            //左
            case '<':
                //返回
                return new int[]{0, -1};
            //右
            case '>':
            default:
                //返回
                return new int[]{0, 1};
        }
    }

    //尝试发现改目标,有没有指定数字
    private boolean findNum(int[][] arr, int x, int y, int num) {
        //如果越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //过
            return false;
        }
        //验证
        return arr[x][y] == num;
    }

    //尝试发现改目标上下左右,有没有指定数字
    private boolean findNear(int[][] arr, int x, int y, int num) {
        return findNum(arr, x + 1, y, num) ||
                findNum(arr, x - 1, y, num) ||
                findNum(arr, x, y + 1, num) ||
                findNum(arr, x, y - 1, num);
    }

    //移动并填充
    private void moveAndSet(String[] matrix, int[][] arr, int x, int y, int cost) {
        //如果越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //过
            return;
        }
        //如果当前走过了
        if (arr[x][y] != 0) {
            //过
            return;
        }
        //当前是
        arr[x][y] = cost;
        //获取下一步的方向
        int[] dir = getDir(matrix[x].charAt(y));
        //尝试继续走
        moveAndSet(matrix, arr, x + dir[0], y + dir[1], cost);
    }

    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        //初始化矩阵
        int[][] arr = new int[matrix.length][matrix[0].length()];
        //默认花费1
        int cost = 1;
        //移动并填充第一步
        moveAndSet(matrix, arr, start[0], start[1], cost);
        //无限循环
        while (true) {
            //下一个花费
            int nextCost = cost + 1;
            //循环1
            for (int i = 0; i < matrix.length; i++) {
                //循环2
                for (int j = 0; j < matrix[0].length(); j++) {
                    //如果该坐标附近没有当前花费
                    if (findNear(arr, i, j, cost) == false) {
                        //本轮过
                        continue;
                    }
                    //填充
                    moveAndSet(matrix, arr, i, j, nextCost);
                }
            }
            //如果终点有结果了
            if (arr[end[0]][end[1]] != 0) {
                //返回结果
                return arr[end[0]][end[1]] - 1;
            }
            //下一步
            cost = nextCost;
        }
    }

    public static void main(String[] args) {
        int i = new Code20().conveyorBelt(new String[]{">>v", "v^<", "<><"}, new int[]{0, 1}, new int[]{2, 0});
        System.out.println(i);
    }

    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
        System.out.println("###########");
    }

}
