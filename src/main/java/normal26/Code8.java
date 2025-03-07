package normal26;

/**
 * @Author ayl
 * @Date 2023-11-23
 * 1824. 最少侧跳次数
 * 提示
 * 中等
 * 121
 * 相关企业
 * 给你一个长度为 n 的 3 跑道道路 ，它总共包含 n + 1 个 点 ，编号为 0 到 n 。一只青蛙从 0 号点第二条跑道 出发 ，它想要跳到点 n 处。然而道路上可能有一些障碍。
 * <p>
 * 给你一个长度为 n + 1 的数组 obstacles ，其中 obstacles[i] （取值范围从 0 到 3）表示在点 i 处的 obstacles[i] 跑道上有一个障碍。如果 obstacles[i] == 0 ，那么点 i 处没有障碍。任何一个点的三条跑道中 最多有一个 障碍。
 * <p>
 * 比方说，如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。
 * 这只青蛙从点 i 跳到点 i + 1 且跑道不变的前提是点 i + 1 的同一跑道上没有障碍。为了躲避障碍，这只青蛙也可以在 同一个 点处 侧跳 到 另外一条 跑道（这两条跑道可以不相邻），但前提是跳过去的跑道该点处没有障碍。
 * <p>
 * 比方说，这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1 。
 * 这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数 。
 * <p>
 * 注意：点 0 处和点 n 处的任一跑道都不会有障碍。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：obstacles = [0,1,2,3,0]
 * 输出：2
 * 解释：最优方案如上图箭头所示。总共有 2 次侧跳（红色箭头）。
 * 注意，这只青蛙只有当侧跳时才可以跳过障碍（如上图点 2 处所示）。
 * 示例 2：
 * <p>
 * <p>
 * 输入：obstacles = [0,1,1,3,3,0]
 * 输出：0
 * 解释：跑道 2 没有任何障碍，所以不需要任何侧跳。
 * 示例 3：
 * <p>
 * <p>
 * 输入：obstacles = [0,2,1,0,3,0]
 * 输出：2
 * 解释：最优方案如上图所示。总共有 2 次侧跳。
 * <p>
 * <p>
 * 提示：
 * <p>
 * obstacles.length == n + 1
 * 1 <= n <= 5 * 105
 * 0 <= obstacles[i] <= 3
 * obstacles[0] == obstacles[n] == 0
 */
public class Code8 {

    public int minSideJumps(int[] obstacles) {
        //初始化缓存
        int[][] arr = new int[4][obstacles.length];
        //默认第一层
        for (int i = 1; i < arr.length; i++) {
            //如果不是阻碍
            if (obstacles[0] != i) {
                //默认
                arr[i][0] = i == 2 ? 1 : 2;
            }
        }
        //从第二层开始
        for (int j = 1; j < obstacles.length; j++) {
            //循环
            for (int i = 1; i < arr.length; i++) {
                //如果不是阻碍
                if (obstacles[j] != i) {
                    //默认
                    arr[i][j] = arr[i][j - 1];
                }
            }
            //循环
            for (int i = 1; i < arr.length; i++) {
                //如果后面阻碍
                if (obstacles[j - 1] == i) {
                    //根据位置处理
                    switch (i) {
                        case 1:
                            //其他两个
                            arr[i][j] = Math.min(arr[i + 1][j] == 0 ? Integer.MAX_VALUE : arr[i + 1][j], arr[i + 2][j] == 0 ? Integer.MAX_VALUE : arr[i + 2][j]) + 1;
                            break;
                        case 2:
                            //其他两个
                            arr[i][j] = Math.min(arr[i + 1][j] == 0 ? Integer.MAX_VALUE : arr[i + 1][j], arr[i - 1][j] == 0 ? Integer.MAX_VALUE : arr[i - 1][j]) + 1;
                            break;
                        case 3:
                            //其他两个
                            arr[i][j] = Math.min(arr[i - 1][j] == 0 ? Integer.MAX_VALUE : arr[i - 1][j], arr[i - 2][j] == 0 ? Integer.MAX_VALUE : arr[i - 2][j]) + 1;
                            break;
                    }

                }
            }
        }
        //获取最终结果的三个值
        int a = arr[1][arr[0].length - 1];
        int b = arr[2][arr[0].length - 1];
        int c = arr[3][arr[0].length - 1];
        //删除0
        a = a == 0 ? Integer.MAX_VALUE : a;
        b = b == 0 ? Integer.MAX_VALUE : b;
        c = c == 0 ? Integer.MAX_VALUE : c;
        //返回
        return Math.min(Math.min(a, b), c) - 1;
    }

    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
        System.out.println("#############");
    }

    public static void main(String[] args) {
        System.out.println(new Code8().minSideJumps(new int[]{0, 1, 2, 3, 0}));
        ;
    }

}
