package normal49;

import java.util.Arrays;

/**
 * 870. 优势洗牌
 * 尝试过
 * 算术评级: 4
 * 第 93 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1648
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定两个长度相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 nums1 的 任意 排列，使其相对于 nums2 的优势最大化。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= 105
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 109
 *
 */
public class Code14 {

    private static class Node {

        //索引
        private int index;

        //数字
        private int num;

        //目标索引
        private int targetIndex = -1;

        //初始化
        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }

    }

    public int[] advantageCount(int[] nums1, int[] nums2) {

        /**
         * 构建节点、排序
         */

        Node[] node1Arr = new Node[nums1.length];
        Node[] node2Arr = new Node[nums2.length];

        //循环
        for (int i = 0; i < nums1.length; i++) {
            //初始化
            node1Arr[i] = new Node(i, nums1[i]);
        }
        //循环
        for (int i = 0; i < nums2.length; i++) {
            //初始化
            node2Arr[i] = new Node(i, nums2[i]);
        }
        //排序
        Arrays.sort(node1Arr, (a, b) -> a.num - b.num);
        Arrays.sort(node2Arr, (a, b) -> a.num - b.num);

        /**
         * 计算
         */

        //索引
        int index1 = 0;
        int index2 = 0;

        //循环
        while (index1 < node1Arr.length) {
            //获取当前节点
            Node node1 = node1Arr[index1];
            Node node2 = node2Arr[index2];
            //如果优势
            if (node1.num > node2.num) {
                //记录优势索引
                node1.targetIndex = node2.index;
                //+1
                index1++;
                index2++;
            } else {
                //+1
                index1++;
            }
        }
        //重新来
        index1 = 0;
        //循环2
        while (index2 < node2Arr.length) {
            //获取当前节点
            Node node1 = node1Arr[index1];
            //如果已经有了
            if (node1.targetIndex != -1) {
                //+1
                index1++;
                //本轮过
                continue;
            }
            //获取节点2
            Node node2 = node2Arr[index2];
            //记录填充索引
            node1.targetIndex = node2.index;
            //+1
            index1++;
            index2++;
        }

        /**
         * 返回结果
         */

        //结果
        return Arrays
                .stream(node1Arr)
                //排序
                .sorted((a, b) -> a.targetIndex - b.targetIndex)
                //拆箱
                .mapToInt(p -> p.num)
                //返回
                .toArray();
    }

    public static void main(String[] args) {
        int[] ints = new Code14().advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11});
        System.out.println();
    }

}
