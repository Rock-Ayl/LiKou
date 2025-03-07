package easy13;

/**
 * @Author ayl
 * @Date 2021-10-25
 * 1266. 访问所有点的最小时间
 * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi] 。请你计算访问所有这些点需要的 最小时间（以秒为单位）。
 * <p>
 * 你需要按照下面的规则在平面上移动：
 * <p>
 * 每一秒内，你可以：
 * 沿水平方向移动一个单位长度，或者
 * 沿竖直方向移动一个单位长度，或者
 * 跨过对角线移动 sqrt(2) 个单位长度（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 * 在访问某个点时，可以经过该点后面出现的点，但经过的那些点不算作有效访问。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[1,1],[3,4],[-1,0]]
 * 输出：7
 * 解释：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * 从 [1,1] 到 [3,4] 需要 3 秒
 * 从 [3,4] 到 [-1,0] 需要 4 秒
 * 一共需要 7 秒
 * 示例 2：
 * <p>
 * 输入：points = [[3,2],[-2,2]]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * points.length == n
 * 1 <= n <= 100
 * points[i].length == 2
 * -1000 <= points[i][0], points[i][1] <= 1000
 */
public class Code12 {

    public int minTimeToVisitAllPoints(int[][] points) {
        //和
        int sum = 0;
        //循环
        for (int i = 1; i < points.length; i++) {
            //两点坐标
            int x1 = points[i][0];
            int x2 = points[i - 1][0];
            int y1 = points[i][1];
            int y2 = points[i - 1][1];
            //计算x、y轴的最远距离,二者在比较,最大的距离为时间,叠加
            sum += Math.max(Math.max(Math.abs(x2 - x1), Math.abs(x1 - x2)), Math.max(Math.abs(y2 - y1), Math.abs(y1 - y2)));
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().minTimeToVisitAllPoints(new int[][]{
                new int[]{1, 1},
                new int[]{3, 4},
                new int[]{-1, 0}
        }));
    }
}
