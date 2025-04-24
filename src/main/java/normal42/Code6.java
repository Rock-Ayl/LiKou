package normal42;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-04-24
 * 1481. 不同整数的最少数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 * 示例 2：
 * <p>
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 */
public class Code6 {

    //节点
    private static class Node {

        //数字
        private int number;

        //数量
        private int count = 0;

        //初始化
        public Node(int number) {
            this.number = number;
        }

        //调试
        @Override
        public String toString() {
            return String.format("number=%s,count=%s", this.number, this.count);
        }

    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环
        for (int number : arr) {
            //初始化
            nodeMap.putIfAbsent(number, new Node(number));
            //+1
            nodeMap.get(number).count++;
        }
        //转为列表
        List<Node> nodeList = new ArrayList<>(nodeMap.values());
        //排序
        nodeList.sort((a, b) -> a.count - b.count);
        //循环
        for (int i = 0; i < nodeList.size(); i++) {
            //获取本次count
            int count = nodeList.get(i).count;
            //删除之
            k -= count;
            //如果正好
            if (k <= 0) {
                //返回结果
                return nodeList.size() - i - (k == 0 ? 1 : 0);
            }
        }
        //默认
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
    }

}
