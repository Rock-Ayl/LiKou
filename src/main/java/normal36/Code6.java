package normal36;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-10-16
 * 1424. 对角线遍历 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,4,2,7,5,3,8,6,9]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * 输出：[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 * 示例 3：
 * <p>
 * 输入：nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
 * 输出：[1,4,2,5,3,8,6,9,7,10,11]
 * 示例 4：
 * <p>
 * 输入：nums = [[1,2,3,4,5,6]]
 * 输出：[1,2,3,4,5,6]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i].length <= 10^5
 * 1 <= nums[i][j] <= 10^9
 * nums 中最多有 10^5 个数字。
 */
public class Code6 {

    private static class Node {

        //正常坐标x
        private int x;

        //正常坐标y
        private int y;

        //对应数字
        private int number;

        //根据队列首节点分组
        private Integer startX;

        //初始化
        public Node(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
            //计算队首坐标
            this.startX = x + y;
        }

        //自定义排序
        public int compareTo(Node another) {
            //按照y排序
            return this.y - another.y;
        }

        //方便调试
        @Override
        public String toString() {
            return String.valueOf(this.number);
        }

    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        //按照队列为节点分组
        Map<Integer, List<Node>> nodeMap = new HashMap<>();
        //最大坐标
        int maxStartX = 0;
        //循环1
        for (int i = 0; i < nums.size(); i++) {
            //获取列表
            List<Integer> list = nums.get(i);
            //循环2
            for (int j = 0; j < list.size(); j++) {
                //获取数字
                Integer number = list.get(j);
                //初始化对应节点
                Node node = new Node(i, j, number);
                //当前开始节点
                Integer startX = node.startX;
                //如果不存在
                if (nodeMap.containsKey(startX) == false) {
                    //初始化
                    nodeMap.put(startX, new ArrayList<>());
                }
                //加入
                nodeMap.get(startX).add(node);
                //刷新最大情况
                maxStartX = Math.max(maxStartX, startX);
            }
        }
        //初始化结果列表
        List<Integer> resultList = new ArrayList<>();
        //循环
        for (int i = 0; i <= maxStartX; i++) {
            //获取对应节点列表
            List<Node> nodeList = nodeMap.get(i);
            //排序,拆分结果,加入到最终结果
            resultList.addAll(nodeList.stream().sorted(Node::compareTo).map(p -> p.number).collect(Collectors.toList()));
        }
        //返回为数组
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] diagonalOrder = new Code6().findDiagonalOrder(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7),
                Arrays.asList(8),
                Arrays.asList(9, 10, 11),
                Arrays.asList(12, 13, 14, 15, 16)));
        System.out.println();
    }

}
