package normal45;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-07-15
 * 2948. 交换得到字典序最小的数组
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的 正整数 数组 nums 和一个 正整数 limit 。
 * <p>
 * 在一次操作中，你可以选择任意两个下标 i 和 j，如果 满足 |nums[i] - nums[j]| <= limit ，则交换 nums[i] 和 nums[j] 。
 * <p>
 * 返回执行任意次操作后能得到的 字典序最小的数组 。
 * <p>
 * 如果在数组 a 和数组 b 第一个不同的位置上，数组 a 中的对应元素比数组 b 中的对应元素的字典序更小，则认为数组 a 就比数组 b 字典序更小。例如，数组 [2,10,3] 比数组 [10,2,3] 字典序更小，下标 0 处是两个数组第一个不同的位置，且 2 < 10 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,3,9,8], limit = 2
 * 输出：[1,3,5,8,9]
 * 解释：执行 2 次操作：
 * - 交换 nums[1] 和 nums[2] 。数组变为 [1,3,5,9,8] 。
 * - 交换 nums[3] 和 nums[4] 。数组变为 [1,3,5,8,9] 。
 * 即便执行更多次操作，也无法得到字典序更小的数组。
 * 注意，执行不同的操作也可能会得到相同的结果。
 * 示例 2：
 * <p>
 * 输入：nums = [1,7,6,18,2,1], limit = 3
 * 输出：[1,6,7,18,1,2]
 * 解释：执行 3 次操作：
 * - 交换 nums[1] 和 nums[2] 。数组变为 [1,6,7,18,2,1] 。
 * - 交换 nums[0] 和 nums[4] 。数组变为 [2,6,7,18,1,1] 。
 * - 交换 nums[0] 和 nums[5] 。数组变为 [1,6,7,18,1,2] 。
 * 即便执行更多次操作，也无法得到字典序更小的数组。
 * 示例 3：
 * <p>
 * 输入：nums = [1,7,28,19,10], limit = 3
 * 输出：[1,7,28,19,10]
 * 解释：[1,7,28,19,10] 是字典序最小的数组，因为不管怎么选择下标都无法执行操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= limit <= 109
 */
public class Code2 {

    private static class Node {

        //索引
        private int index;

        //分组
        private int group;

        //数字
        private int num;

        //对应分组的对应索引,默认-1,只有root节点才有
        private int groupIndex = -1;

        //初始化
        public Node(int index, int num) {
            this.index = index;
            this.group = index;
            this.num = num;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("index=%s,group=%s,num=%s,groupIndex=%s", this.index, this.group, this.num, this.groupIndex);
        }

    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        /**
         * 构建节点数组
         */

        //节点数组
        Node[] nodeArr = new Node[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //初始化并组装
            nodeArr[i] = new Node(i, nums[i]);
        }

        /**
         * 为临近节点分组
         */

        //克隆出新数组
        Node[] sortArr = nodeArr.clone();
        //排序
        Arrays.sort(sortArr, (a, b) -> a.num - b.num);
        //指针
        int index = 0;
        //循环
        while (index < sortArr.length) {
            //第一个节点,也就是该分组root节点
            Node node = sortArr[index];
            //记录其分组索引
            node.groupIndex = index;
            //下一个节点索引
            index++;
            //循环
            while (index < sortArr.length && sortArr[index].num - node.num <= limit) {
                //是同一个分组
                sortArr[index].group = node.group;
                //下一个
                node = sortArr[index];
                index++;
            }
        }

        /**
         * 计算结果
         */

        //循环
        for (int i = 0; i < nums.length; i++) {
            ///获取对应节点的对应分组root,主节点下索引就是结果,记录并+1
            nums[i] = sortArr[nodeArr[nodeArr[i].group].groupIndex++].num;
        }

        //返回结果
        return nums;
    }

    public static void main(String[] args) {
        int[] ints = new Code2().lexicographicallySmallestArray(new int[]{1, 7, 6, 18, 2, 1}, 3);
        System.out.println();
    }

}
