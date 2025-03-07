package normal36;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-10-24
 * 3186. 施咒的最大总伤害
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一个魔法师有许多不同的咒语。
 * <p>
 * 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。
 * <p>
 * 已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] + 1 或者 power[i] + 2 的咒语。
 * <p>
 * 每个咒语最多只能被使用 一次 。
 * <p>
 * 请你返回这个魔法师可以达到的伤害值之和的 最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：power = [1,1,3,4]
 * <p>
 * 输出：6
 * <p>
 * 解释：
 * <p>
 * 可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：power = [7,1,6,6]
 * <p>
 * 输出：13
 * <p>
 * 解释：
 * <p>
 * 可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= power.length <= 105
 * 1 <= power[i] <= 109
 */
public class Code14 {

    //节点
    private static class Node {

        //当前数字
        private int number;

        //当前相同数字的和
        private long sum;

        //初始化
        public Node(int number) {
            this.number = number;
            this.sum = 0;
        }

    }

    public long maximumTotalDamage(int[] power) {
        //节点map
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环
        for (int num : power) {
            //如果不存在
            if (nodeMap.containsKey(num) == false) {
                //初始化
                nodeMap.put(num, new Node(num));
            }
            //叠加和
            nodeMap.get(num).sum += num;
        }
        //排序,转为数组
        Node[] nodeArr = nodeMap
                .values()
                .stream()
                .sorted(Comparator.comparingInt(a -> a.number))
                .toArray(Node[]::new);
        //初始化动态规划数组
        long[] sumArr = new long[nodeArr.length];
        //循环
        for (int i = 0; i < sumArr.length; i++) {
            //获取当前节点
            Node node = nodeArr[i];
            //上一个最大可能
            long lastMax = 0L;
            //如果有上一个节点
            if (i - 1 >= 0) {
                //获取上一个节点
                Node lastNode = nodeArr[i - 1];
                //如果不冲突
                if (node.number - lastNode.number > 2) {
                    //两者都可以
                    lastMax = node.sum + sumArr[i - 1];
                } else {
                    //两者都可以
                    lastMax = sumArr[i - 1];
                }
            }
            //上上一个最大可能
            long last2Max = 0L;
            //如果有上一个节点
            if (i - 2 >= 0) {
                //获取上上一个节点
                Node last2Node = nodeArr[i - 2];
                //如果不冲突
                if (node.number - last2Node.number > 2) {
                    //两者都可以
                    last2Max = node.sum + sumArr[i - 2];
                } else {
                    //两者都可以
                    last2Max = sumArr[i - 2];
                }
            }
            //上上上一个最大可能,默认可以是当前的
            long last3Max = node.sum;
            //如果有上一个节点
            if (i - 3 >= 0) {
                //肯定可以
                last3Max = node.sum + sumArr[i - 3];
            }
            //最大情况
            sumArr[i] = Math.max(Math.max(lastMax, last2Max), last3Max);
        }
        //目标结果
        long result = sumArr[sumArr.length - 1];
        //如果不止一个
        if (sumArr.length > 1) {
            //对比第二个
            result = Math.max(result, sumArr[sumArr.length - 2]);
        }
        //如果不止二个
        if (sumArr.length > 2) {
            //对比第二个
            result = Math.max(result, sumArr[sumArr.length - 3]);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().maximumTotalDamage(new int[]{1, 3, 5, 5, 5, 6, 7, 9, 10}));
    }

}
