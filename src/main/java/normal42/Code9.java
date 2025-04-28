package normal42;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-04-28
 * 2406. 将区间分为最少组数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示 闭 区间 [lefti, righti] 。
 * <p>
 * 你需要将 intervals 划分为一个或者多个区间 组 ，每个区间 只 属于一个组，且同一个组中任意两个区间 不相交 。
 * <p>
 * 请你返回 最少 需要划分成多少个组。
 * <p>
 * 如果两个区间覆盖的范围有重叠（即至少有一个公共数字），那么我们称这两个区间是 相交 的。比方说区间 [1, 5] 和 [5, 8] 相交。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
 * 输出：3
 * 解释：我们可以将区间划分为如下的区间组：
 * - 第 1 组：[1, 5] ，[6, 8] 。
 * - 第 2 组：[2, 3] ，[5, 10] 。
 * - 第 3 组：[1, 10] 。
 * 可以证明无法将区间划分为少于 3 个组。
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,3],[5,6],[8,10],[11,13]]
 * 输出：1
 * 解释：所有区间互不相交，所以我们可以把它们全部放在一个组内。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * 1 <= lefti <= righti <= 106
 */
public class Code9 {

    //节点
    private static class Node {

        //索引
        private int index;

        //数量
        private int count = 0;

        //初始化
        public Node(int index) {
            this.index = index;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("index=%s,count=%s", this.index, this.count);
        }

    }

    public int minGroups(int[][] intervals) {
        //缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环
        for (int[] interval : intervals) {
            //开始、结束
            int start = interval[0];
            int end = interval[1] + 1;
            //初始化
            nodeMap.putIfAbsent(start, new Node(start));
            nodeMap.putIfAbsent(end, new Node(end));
            //加减
            nodeMap.get(start).count++;
            nodeMap.get(end).count--;
        }
        //转化为列表
        List<Node> nodeList = new ArrayList<>(nodeMap.values());
        //排序
        nodeList.sort((a, b) -> a.index - b.index);
        //最大和
        int maxSum = 0;
        //当前和
        int sum = 0;
        //循环
        for (Node node : nodeList) {
            //叠加
            sum += node.count;
            //刷新最大
            maxSum = Math.max(maxSum, sum);
        }
        //返回
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().minGroups(new int[][]{
                new int[]{5, 10},
                new int[]{6, 8},
                new int[]{1, 5},
                new int[]{2, 3},
                new int[]{1, 10}
        }));
    }

}
