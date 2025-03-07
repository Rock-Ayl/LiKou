package normal37;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-11-06
 * 2530. 执行 K 次操作后的最大分数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。
 * <p>
 * 在一步 操作 中：
 * <p>
 * 选出一个满足 0 <= i < nums.length 的下标 i ，
 * 将你的 分数 增加 nums[i] ，并且
 * 将 nums[i] 替换为 ceil(nums[i] / 3) 。
 * 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。
 * <p>
 * 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,10,10,10,10], k = 5
 * 输出：50
 * 解释：对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,3,3,3], k = 3
 * 输出：17
 * 解释：可以执行下述操作：
 * 第 1 步操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。
 * 第 2 步操作：选中 i = 1 ，nums 变为 [1,2,3,3,3] 。分数增加 4 。
 * 第 3 步操作：选中 i = 2 ，nums 变为 [1,2,1,3,3] 。分数增加 3 。
 * 最后分数是 10 + 4 + 3 = 17 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, k <= 105
 * 1 <= nums[i] <= 109
 */
public class Code3 {

    private static class Node {

        //数字
        private int num;

        //数量
        private int count = 0;

        //初始化
        public Node(int num) {
            this.num = num;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("num=%s,count=%s", num, count);
        }

    }

    public long maxKelements(int[] nums, int k) {
        //节点map
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环
        for (int num : nums) {
            //如果不存在
            if (nodeMap.containsKey(num) == false) {
                //初始化
                nodeMap.put(num, new Node(num));
            }
            //+1
            nodeMap.get(num).count++;
        }
        //优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.num - a.num);
        //加入所有
        queue.addAll(nodeMap.values());
        //结果
        long result = 0L;
        //循环
        while (k > 0 && queue.isEmpty() == false) {
            //获取节点
            Node node = queue.poll();
            //如果下一个节点和现在的相同
            while (queue.isEmpty() == false && queue.peek().num == node.num) {
                //拉取、叠加
                node.count += queue.poll().count;
            }
            //判断本次是否够
            if (k <= node.count) {
                //计算本次结果
                result += k * (long) node.num;
                //跳出循环
                break;
            }
            //计算本次结果
            result += node.count * (long) node.num;
            //清算
            k -= node.count;
            //计算出下一个数字,节点值变更
            node.num = (int) Math.ceil((double) node.num / 3D);
            //加入回去
            queue.add(node);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
    }

}
