package normal43;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2025-06-10
 * 3572. 选择不同 X 值三元组使 Y 值之和最大
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数数组 x 和 y，长度均为 n。你必须选择三个 不同 的下标 i ，j 和 k，满足以下条件：
 * <p>
 * x[i] != x[j]
 * x[j] != x[k]
 * x[k] != x[i]
 * 你的目标是在满足这些条件下 最大化 y[i] + y[j] + y[k] 的值。返回通过选择这样一组三元组下标所能获得的 最大 可能和。
 * <p>
 * 如果不存在这样的三元组，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = [1,2,1,3,2], y = [5,3,4,6,2]
 * <p>
 * 输出：14
 * <p>
 * 解释：
 * <p>
 * 选择 i = 0（x[i] = 1，y[i] = 5），j = 1（x[j] = 2，y[j] = 3），k = 3（x[k] = 3，y[k] = 6）。
 * 选出的三个 x 中的值互不相同。5 + 3 + 6 = 14 是我们能获得的最大值。因此输出为 14。
 * 示例 2：
 * <p>
 * 输入：x = [1,2,1,2], y = [4,5,6,7]
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * <p>
 * x 中只有两个不同的值。因此输出为 -1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == x.length == y.length
 * 3 <= n <= 105
 * 1 <= x[i], y[i] <= 106
 */
public class Code21 {

    private static class Node {

        //分组
        private int group;

        //数字
        private int num;

        //初始化
        public Node(int group, int num) {
            this.group = group;
            this.num = num;
        }

        //输出
        @Override
        public String toString() {
            return String.format("group=%s,num=%s", this.group, this.num);
        }

    }

    public int maxSumDistinctTriplet(int[] x, int[] y) {
        //初始化节点列表
        List<Node> nodeList = new ArrayList<>();
        //循环
        for (int i = 0; i < x.length; i++) {
            //初始化节点
            Node node = new Node(x[i], y[i]);
            //加入
            nodeList.add(node);
        }
        //节点列表
        List<Integer> numList = nodeList
                .stream()
                //分组
                .collect(Collectors.groupingBy(p -> p.group))
                //只需要内容列表
                .values()
                .stream()
                //每个列表选最大值
                .map(p -> p.stream().map(q -> q.num).mapToInt(Integer::intValue).max().getAsInt())
                //排序,倒序
                .sorted((a, b) -> b - a)
                //只需要前3个
                .limit(3)
                .collect(Collectors.toList());
        //如果不够
        if (numList.size() < 3) {
            //过
            return -1;
        }
        //返回结果
        return numList.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Code21().maxSumDistinctTriplet(new int[]{1, 2, 1, 2}, new int[]{4, 5, 6, 7}));
    }

}