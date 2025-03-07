package normal28;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-01-20
 * 973. 最接近原点的 K 个点
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
 * <p>
 * 这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。
 * <p>
 * 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[1,3],[-2,2]], k = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 * <p>
 * 输入：points = [[3,3],[5,-1],[-2,4]], k = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= points.length <= 104
 * -104 < xi, yi < 104
 */
public class Code6 {

    private class Node {

        //点
        private int[] point;
        //距离
        private int length;

        //初始化
        public Node(int[] point) {
            this.point = point;
            //计算距离
            this.length = point[0] * point[0] + point[1] * point[1];
        }

    }

    public int[][] kClosest(int[][] points, int k) {
        //优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.length));
        //循环
        for (int[] point : points) {
            //初始化节点并加入
            queue.add(new Node(point));
        }
        //初始化结果
        int[][] result = new int[k][];
        //循环
        for (int i = 0; i < result.length; i++) {
            //获取结果并记录
            result[i] = queue.poll().point;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[][] ints = new Code6().kClosest(new int[][]{
                new int[]{1, 3},
                new int[]{2, 2}
        }, 1);
    }

}
