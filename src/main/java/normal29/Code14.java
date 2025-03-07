package normal29;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-03-04
 * 436. 寻找右区间
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * <p>
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。注意 i 可能等于 j 。
 * <p>
 * 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * 示例 2：
 * <p>
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 * 示例 3：
 * <p>
 * 输入：intervals = [[1,4],[2,3],[3,4]]
 * 输出：[-1,2,-1]
 * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 2 * 104
 * intervals[i].length == 2
 * -106 <= starti <= endi <= 106
 * 每个间隔的起点都 不相同
 */
public class Code14 {

    private class Node {

        //坐标
        private int left;
        private int right;
        //源索引
        private int index;

        //初始化
        public Node(int[] o1, int index) {
            this.left = o1[0];
            this.right = o1[1];
            this.index = index;
        }

    }

    public int[] findRightInterval(int[][] intervals) {
        //初始化节点列表
        List<Node> nodeList = new ArrayList<>(intervals.length);
        //循环
        for (int i = 0; i < intervals.length; i++) {
            //初始化节点
            nodeList.add(new Node(intervals[i], i));
        }
        //按照规则排序
        nodeList.sort((a, b) -> a.left != b.left ? a.left - b.left : a.right - b.right);
        //初始化结果
        int[] result = new int[intervals.length];
        //跳出标记
        out:
        //循环
        for (int i = 0; i < nodeList.size(); i++) {
            //当前节点
            Node node = nodeList.get(i);
            //如果自己就是
            if (node.left == node.right) {
                //记录结果
                result[node.index] = node.index;
                //本轮过
                continue;
            }
            //循环2
            for (int j = i + 1; j < nodeList.size(); j++) {
                //下一个节点
                Node nextNode = nodeList.get(j);
                //如果找到本节点目标
                if (node.right <= nextNode.left) {
                    //记录结果
                    result[node.index] = nextNode.index;
                    //本轮过
                    continue out;
                }
            }
            //如果没有,默认
            result[node.index] = -1;
        }
        //返回
        return result;
    }

    //[0,-1]
    public static void main(String[] args) {
        int[] result = new Code14().findRightInterval(new int[][]{
                new int[]{1, 1},
                new int[]{3, 4}
        });
        System.out.println();
    }

}
