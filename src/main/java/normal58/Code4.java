package normal58;

import java.util.*;

/**
 * 2831. 找出最长等值子数组
 * 算术评级: 6
 * 第 359 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1976
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
 * <p>
 * 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
 * <p>
 * 子数组 是数组中一个连续且可能为空的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,3,1,3], k = 3
 * 输出：3
 * 解释：最优的方案是删除下标 2 和下标 4 的元素。
 * 删除后，nums 等于 [1, 3, 3, 3] 。
 * 最长等值子数组从 i = 1 开始到 j = 3 结束，长度等于 3 。
 * 可以证明无法创建更长的等值子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,2,1,1], k = 2
 * 输出：4
 * 解释：最优的方案是删除下标 2 和下标 3 的元素。
 * 删除后，nums 等于 [1, 1, 1, 1] 。
 * 数组自身就是等值子数组，长度等于 4 。
 * 可以证明无法创建更长的等值子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= nums.length
 * 0 <= k <= nums.length
 */
public class Code4 {

    private static class Node {

        //数字
        private int num;

        //数字索引列表
        private LinkedList<Integer> indexList = new LinkedList<>();

        //初始化
        public Node(int num) {
            this.num = num;
        }

        //加入下一个index,并删除过期index
        public void addIndex(int index, int k) {
            //加入
            indexList.add(index);
            //如果有多个
            while (indexList.size() > 1) {
                //当前数量
                int count = indexList.size();
                //获取左右索引
                int left = indexList.getFirst();
                int right = indexList.getLast();
                //总共这些
                int all = right - left + 1;
                //多出来的非本数字的节点
                int other = all - count;
                //如果超了
                if (other > k) {
                    //删除第一个
                    indexList.removeFirst();
                } else {
                    //跳出
                    break;
                }
            }
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("num:%d,indexList:%s", num, indexList.size());
        }

    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        //初始化map
        Map<Integer, Node> map = new HashMap<>();
        //结果
        int max = 0;
        //循环
        for (int i = 0; i < nums.size(); i++) {
            //当前数字
            Integer num = nums.get(i);
            //获取节点
            Node node = map.get(num);
            //如果不存在
            if (node == null) {
                //初始化
                node = new Node(num);
                //加入map
                map.put(num, node);
            }
            //加入
            node.addIndex(i, k);
            //刷新最大
            max = Math.max(max, node.indexList.size());
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().longestEqualSubarray(Arrays.asList(1, 3, 2, 3, 1, 3), 3));
    }

}
