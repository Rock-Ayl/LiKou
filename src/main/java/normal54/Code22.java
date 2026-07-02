package normal54;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 3224. 使差值相等的最少数组改动次数
 * 算术评级: 7
 * 第 135 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1996
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums ，n 是 偶数 ，同时给你一个整数 k 。
 * <p>
 * 你可以对数组进行一些操作。每次操作中，你可以将数组中 任一 元素替换为 0 到 k 之间的 任一 整数。
 * <p>
 * 执行完所有操作以后，你需要确保最后得到的数组满足以下条件：
 * <p>
 * 存在一个整数 X ，满足对于所有的 (0 <= i < n) 都有 abs(a[i] - a[n - i - 1]) = X 。
 * 请你返回满足以上条件 最少 修改次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,1,2,4,3], k = 4
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * 我们可以执行以下操作：
 * <p>
 * 将 nums[1] 变为 2 ，结果数组为 nums = [1,2,1,2,4,3] 。
 * 将 nums[3] 变为 3 ，结果数组为 nums = [1,2,1,3,4,3] 。
 * 整数 X 为 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,2,3,3,6,5,4], k = 6
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * 我们可以执行以下操作：
 * <p>
 * 将 nums[3] 变为 0 ，结果数组为 nums = [0,1,2,0,3,6,5,4] 。
 * 将 nums[4] 变为 4 ，结果数组为 nums = [0,1,2,0,4,6,5,4] 。
 * 整数 X 为 4 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n == nums.length <= 105
 * n 是偶数。
 * 0 <= nums[i] <= k <= 105
 */
public class Code22 {

    private static class Node {

        //左边
        private Integer left;

        //右边
        private Integer right;

        //差
        private Integer sub;

        //初始化
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
            this.sub = Math.abs(right - left);
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("left=%s,right=%s,sub=%s", left, right, sub);
        }

    }

    public int minChanges(int[] nums, int k) {

        /**
         * 构建节点
         */

        //节点列表
        List<Node> nodeList = new ArrayList<>();
        //索引
        int left = 0;
        int right = nums.length - 1;
        //循环
        while (left < right) {
            //构建节点
            Node node = new Node(nums[left++], nums[right--]);
            //记录节点
            nodeList.add(node);
        }
        //节点按照分组转map
        Map<Integer, List<Node>> groupNodeMap = nodeList
                .stream()
                .collect(Collectors.groupingBy(p -> p.sub));

        /**
         * 计算
         */

        //最小操作次数
        int minChangeCount = nums.length;
        //按照长度排序
        List<Map.Entry<Integer, List<Node>>> entryList = groupNodeMap.entrySet()
                .stream()
                //越长的排月前
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .collect(Collectors.toList());
        //循环每种情况作为X
        for (Map.Entry<Integer, List<Node>> entry : entryList) {
            //不需要调整的长度
            int size = entry.getValue().size();
            //需要调整的长度
            int otherSize = nums.length - size * 2;
            //如果每个都是最小调整,仍然无法更新记录
            if (otherSize / 2 >= minChangeCount) {
                //本轮过
                continue;
            }
            //获取key
            Integer groupX = entry.getKey();
            //当前操作次数
            int changeCount = 0;
            //循环所有
            for (Map.Entry<Integer, List<Node>> entry2 : entryList) {
                //如果是同一个分组
                if (entry2.getKey().equals(groupX)) {
                    //本轮过
                    continue;
                }
                //循环
                for (Node node : entry2.getValue()) {
                    //计算本次
                    changeCount += countChange(node, groupX, k);
                }
            }
            //刷新最小结果
            minChangeCount = Math.min(changeCount, minChangeCount);
        }
        //返回
        return minChangeCount;
    }

    //根据x,计算操作次数
    private int countChange(Node node, Integer groupX, int k) {
        //四种情况
        int a = node.left + groupX;
        int b = node.left - groupX;
        int c = node.right + groupX;
        int d = node.right - groupX;
        //判断修改 1次 or 2次
        if ((a >= 0 && a <= k) || (b >= 0 && b <= k) || (c >= 0 && c <= k) || (d >= 0 && d <= k)) {
            //1次
            return 1;
        } else {
            //2次
            return 2;
        }
    }

    public static void main(String[] args) {
        //System.out.println(new Code22().minChanges(new int[]{0, 1, 2, 3, 3, 6, 5, 4}, 6));

        System.out.println(new Code22().minChanges(new int[]{9, 2, 7, 7, 8, 9, 1, 5, 1, 9, 4, 9, 4, 7}, 9));
    }

}
