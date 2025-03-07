package normal41;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-03-07
 * 2615. 等值距离和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。现有一个长度等于 nums.length 的数组 arr 。对于满足 nums[j] == nums[i] 且 j != i 的所有 j ，arr[i] 等于所有 |i - j| 之和。如果不存在这样的 j ，则令 arr[i] 等于 0 。
 * <p>
 * 返回数组 arr 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1,1,2]
 * 输出：[5,0,3,4,0]
 * 解释：
 * i = 0 ，nums[0] == nums[2] 且 nums[0] == nums[3] 。因此，arr[0] = |0 - 2| + |0 - 3| = 5 。
 * i = 1 ，arr[1] = 0 因为不存在值等于 3 的其他下标。
 * i = 2 ，nums[2] == nums[0] 且 nums[2] == nums[3] 。因此，arr[2] = |2 - 0| + |2 - 3| = 3 。
 * i = 3 ，nums[3] == nums[0] 且 nums[3] == nums[2] 。因此，arr[3] = |3 - 0| + |3 - 2| = 4 。
 * i = 4 ，arr[4] = 0 因为不存在值等于 2 的其他下标。
 * 示例 2：
 * <p>
 * 输入：nums = [0,5,3]
 * 输出：[0,0,0]
 * 解释：因为 nums 中的元素互不相同，对于所有 i ，都有 arr[i] = 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 */
public class Code1 {

    //节点
    private static class Node {

        //索引列表
        private List<Integer> indexList = new ArrayList<>();

        //索引,默认0
        private int index = 0;

        //左边和
        private long leftSum = 0L;
        //右边和
        private long rightSum = 0L;

    }

    public long[] distance(int[] nums) {

        /**
         * step 1. 构建索引数组
         */

        //索引列表缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //获取数字
            int num = nums[i];
            //如果不存在,加入
            nodeMap.putIfAbsent(num, new Node());
            //获取节点
            Node node = nodeMap.get(num);
            //记录索引
            node.indexList.add(i);
            //叠加索引和
            node.rightSum += i;
        }

        /**
         * step 2. 计算结果
         */

        //结果
        long[] result = new long[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {

            /**
             * 获取数字对应节点
             */

            //获取数字
            int num = nums[i];
            //获取节点
            Node node = nodeMap.get(num);
            //获取数字对应索引列表
            List<Integer> indexList = node.indexList;
            //如果不够
            if (indexList.size() < 2) {
                //本轮过
                continue;
            }

            /**
             * 计算距离
             */

            //获取列表对应索引
            int index = node.index;
            //距离
            long way = 0L;
            //如果有左边
            if (index > 0) {
                //叠加左边距离
                way += ((long) index * i) - node.leftSum;
            }
            //如果有右边的
            if (index < indexList.size() - 1) {
                //叠加右边距离
                way += node.rightSum - i - ((long) (indexList.size() - index - 1) * i);
            }
            //记录距离
            result[i] = way;

            /**
             * 变更为下一个索引
             */

            //下一个参数
            node.index++;
            node.leftSum += i;
            node.rightSum -= i;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        long[] distance = new Code1().distance(new int[]{2, 0, 2, 2, 6, 5, 2});
        System.out.println();
    }

}
