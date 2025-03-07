package normal39;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-01-23
 * 2962. 统计最大元素出现至少 K 次的子数组
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums 和一个 正整数 k 。
 * <p>
 * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
 * <p>
 * 子数组是数组中的一个连续元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,3,3], k = 2
 * 输出：6
 * 解释：包含元素 3 至少 2 次的子数组为：[1,3,2,3]、[1,3,2,3,3]、[3,2,3]、[3,2,3,3]、[2,3,3] 和 [3,3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,2,1], k = 3
 * 输出：0
 * 解释：没有子数组包含元素 4 至少 3 次。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= k <= 105
 */
public class Code13 {

    //节点
    private static class Node {

        //数字
        private int num;

        //出现次数,默认1次
        private int count = 1;

        //初始化
        public Node(int num) {
            this.num = num;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("num=%s,count=%s", this.num, this.count);
        }

    }

    public long countSubarrays(int[] nums, int k) {

        /**
         * 找到最大元素
         */

        //获取最大元素
        int max = nums[0];
        //最大元素出现次数
        int maxCount = 0;
        //循环
        for (int num : nums) {
            //如果更大
            if (num > max) {
                //覆盖
                max = num;
                maxCount = 1;
            }
            //如果相同
            else if (num == max) {
                //+1
                maxCount++;
            }
        }
        //如果不够
        if (maxCount < k) {
            //过
            return 0L;
        }

        /**
         * 计算
         */

        //结果
        long result = 0L;
        //节点缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //滑动
        int start = 0;
        int end = 0;
        //循环
        while (start <= nums.length) {
            //如果不满足
            while (nodeMap.containsKey(max) == false || nodeMap.get(max).count < k) {
                //如果越界
                if (end == nums.length) {
                    //跳出
                    break;
                }
                //获取数字
                int endNum = nums[end++];
                //如果存在 并且 不是默认节点
                if (nodeMap.containsKey(endNum)) {
                    //+1
                    nodeMap.get(endNum).count++;
                } else {
                    //初始化新节点
                    Node node = new Node(endNum);
                    nodeMap.put(endNum, node);
                }
            }
            //如果满足条件
            if (nodeMap.containsKey(max) == false || nodeMap.get(max).count >= k) {
                //记录本次结果
                result += nums.length - end + 1;
            }
            //如果后面还有
            if (start < nums.length) {
                //删除队列最早的节点，准备下一个阶段
                --nodeMap.get(nums[start]).count;
            }
            //+1
            start++;
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().countSubarrays(new int[]{
                        28, 5, 58, 91, 24, 91, 53, 9, 48, 85, 16, 70, 91, 91, 47, 91, 61, 4, 54, 61, 49
                }, 1
        ));
    }

}
