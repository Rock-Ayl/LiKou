package normal48;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-11-25
 * 2915. 和为目标值的最长子序列的长度
 * 算术评级: 6
 * 第 116 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1659
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 target 。
 * <p>
 * 返回和为 target 的 nums 子序列中，子序列 长度的最大值 。如果不存在和为 target 的子序列，返回 -1 。
 * <p>
 * 子序列 指的是从原数组中删除一些或者不删除任何元素后，剩余元素保持原来的顺序构成的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5], target = 9
 * 输出：3
 * 解释：总共有 3 个子序列的和为 9 ：[4,5] ，[1,3,5] 和 [2,3,4] 。最长的子序列是 [1,3,5] 和 [2,3,4] 。所以答案为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,1,3,2,1,5], target = 7
 * 输出：4
 * 解释：总共有 5 个子序列的和为 7 ：[4,3] ，[4,1,2] ，[4,2,1] ，[1,1,5] 和 [1,3,2,1] 。最长子序列为 [1,3,2,1] 。所以答案为 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5,4,5], target = 3
 * 输出：-1
 * 解释：无法得到和为 3 的子序列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * 1 <= target <= 1000
 */
public class Code7 {

    //节点
    private static class Node {

        //和
        private Integer sum;

        //count
        private Integer count;

        //初始化
        public Node(Integer sum, Integer count) {
            this.sum = sum;
            this.count = count;
        }

    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //第一种情况
        map.put(0, 0);
        //循环
        for (Integer num : nums) {
            //临时缓存
            Node[] nodeArr = new Node[map.size()];
            //临时缓存索引
            int nodeIndex = 0;
            //循环
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                //和
                int sum = entry.getKey() + num;
                //如果越界
                if (sum > target) {
                    //本路过
                    continue;
                }
                //数量
                int count = entry.getValue() + 1;
                //记录本次结果
                nodeArr[nodeIndex++] = new Node(sum, count);
            }
            //循环
            for (Node node : nodeArr) {
                //判空
                if (node == null) {
                    //跳出
                    break;
                }
                //如果存在
                if (map.containsKey(node.sum)) {
                    //刷新最大
                    map.put(node.sum, Math.max(node.count, map.get(node.sum)));
                } else {
                    //记录
                    map.put(node.sum, node.count);
                }
            }
        }
        //返回
        return map.getOrDefault(target, -1);
    }

    public static void main(String[] args) {
        System.out.println(new Code7().star(Arrays.asList(4, 1, 3, 2, 1, 5), 7));
    }

    //推到思路...
    public int star(List<Integer> nums, int target) {
        //缓存
        int[] arr = new int[target + 1];
        //填充
        Arrays.fill(arr, Integer.MIN_VALUE);
        //初始化0的情况
        arr[0] = 0;
        //循环
        for (int num : nums) {
            //循环2
            for (int j = target; j >= num; j--) {
                //最大
                arr[j] = Math.max(arr[j], arr[j - num] + 1);
            }
        }
        //返回结果
        return arr[target] > 0 ? arr[target] : -1;
    }

}
