package normal30;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-04-10
 * 15. 三数之和
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Code15 {

    //每种可能节点
    private static class Node {

        //最小数字1
        private int first;

        //中间数字2
        private int second;

        //最大数字3
        private int third;

        //初始化
        public Node(int a, int b, int c) {
            //初始化
            int[] arr = new int[]{a, b, c};
            //排序
            Arrays.sort(arr);
            //赋值
            this.first = arr[0];
            this.second = arr[1];
            this.third = arr[2];
        }

        //转化为所需列表
        public List<Integer> toList() {
            //返回
            return Arrays.asList(first, second, third);
        }

        @Override
        public int hashCode() {
            return first * 9 + second * 3 + third;
        }

        @Override
        public boolean equals(Object obj) {
            //如果不是该对象
            if (obj instanceof Node == false) {
                //不是
                return false;
            }
            //强转
            Node other = (Node) obj;
            //返回
            return other.first == this.first &&
                    other.second == this.second &&
                    other.third == this.third;
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {

        /**
         * 初始化缓存
         */

        //索引缓存map,记录每个数字最后一次出现的位置
        Map<Integer, Integer> indexMap = new HashMap<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前数字
            Integer num = nums[i];
            //覆盖原有位置
            indexMap.put(num, i);
        }

        /**
         * 根据缓存 双指针 计算 所有可能
         */

        //结果集
        Set<Node> nodeSet = new HashSet<>();
        //已经走过的缓存
        Set<Integer> walkedSet = new HashSet<>();
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //第一个值
            int firstKey = nums[i];
            //如果存在
            if (walkedSet.contains(firstKey)) {
                //本轮过
                continue;
            }
            //记录已经走过
            walkedSet.add(firstKey);
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //需要数字
                Integer needNum = -firstKey + nums[j];
                //如果不存在
                if (indexMap.containsKey(needNum) == false) {
                    //本轮过
                    continue;
                }
                //获取所需结果最后一个索引
                Integer lastIndex = indexMap.get(needNum);
                //如果不满足条件
                if (lastIndex <= j) {
                    //本轮过
                    continue;
                }
                //初始化对应节点并组装
                nodeSet.add(new Node(nums[i], nums[j], nums[lastIndex]));
            }
        }

        /**
         * 返回结果
         */

        //转化为结果,返回
        return nodeSet.stream().map(Node::toList).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Code15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println();
    }

}
