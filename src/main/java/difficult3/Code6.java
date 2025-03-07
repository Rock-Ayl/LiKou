package difficult3;

import javafx.util.Pair;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-01-05
 * LCR 183. 望远镜中最高的海拔
 * 困难
 * 相关标签
 * 相关企业
 * 科技馆内有一台虚拟观景望远镜，它可以用来观测特定纬度地区的地形情况。该纬度的海拔数据记于数组 heights ，其中 heights[i] 表示对应位置的海拔高度。请找出并返回望远镜视野范围 limit 内，可以观测到的最高海拔值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：heights = [14,2,27,-5,28,13,39], limit = 3
 * 输出：[27,27,28,28,39]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [14 2 27] -5 28 13 39          27
 * 14 [2 27 -5] 28 13 39          27
 * 14 2 [27 -5 28] 13 39          28
 * 14 2 27 [-5 28 13] 39          28
 * 14 2 27 -5 [28 13 39]          39
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设输入总是有效的，在输入数组不为空的情况下：
 * <p>
 * 1 <= limit <= heights.length
 * -10000 <= heights[i] <= 10000
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Code6 {

    //节点
    private class Node {

        //数字
        private int num;

        //索引
        private int index;

        //初始化
        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }

    }

    public int[] maxAltitude(int[] heights, int limit) {
        //如果没有
        if (heights.length < 1) {
            //过
            return new int[]{};
        }
        //优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.num - a.num);
        //初始化结果
        int[] result = new int[heights.length - limit + 1];
        //索引
        int index = 0;
        //如果不满
        while (queue.size() < limit) {
            //加入
            queue.add(new Node(heights[index], index++));
        }
        //初始化第一个
        result[0] = queue.peek().num;
        //循环
        for (int i = 1; i < result.length; i++) {
            //加入
            queue.add(new Node(heights[index], index++));
            //如果队列的最大值过期了
            while (i - queue.peek().index >= 1) {
                //惰性删除之
                queue.poll();
            }
            //记录当前结果
            result[i] = queue.peek().num;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code6().maxAltitude(new int[]{7, 2, 4}, 2);
        System.out.println();
    }

}
