package normal58;

import java.util.Arrays;

/**
 * 2191. 将杂乱无章的数字排序
 * 算术评级: 4
 * 第 73 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1496
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 mapping ，它表示一个十进制数的映射规则，mapping[i] = j 表示这个规则下将数位 i 映射为数位 j 。
 * <p>
 * 一个整数 映射后的值 为将原数字每一个数位 i （0 <= i <= 9）映射为 mapping[i] 。
 * <p>
 * 另外给你一个整数数组 nums ，请你将数组 nums 中每个数按照它们映射后对应数字非递减顺序排序后返回。
 * <p>
 * 注意：
 * <p>
 * 如果两个数字映射后对应的数字大小相同，则将它们按照输入中的 相对顺序 排序。
 * nums 中的元素只有在排序的时候需要按照映射后的值进行比较，返回的值应该是输入的元素本身。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38]
 * 输出：[338,38,991]
 * 解释：
 * 将数字 991 按照如下规则映射：
 * 1. mapping[9] = 6 ，所有数位 9 都会变成 6 。
 * 2. mapping[1] = 9 ，所有数位 1 都会变成 9 。
 * 所以，991 映射的值为 669 。
 * 338 映射为 007 ，去掉前导 0 后得到 7 。
 * 38 映射为 07 ，去掉前导 0 后得到 7 。
 * 由于 338 和 38 映射后的值相同，所以它们的前后顺序保留原数组中的相对位置关系，338 在 38 的前面。
 * 所以，排序后的数组为 [338,38,991] 。
 * 示例 2：
 * <p>
 * 输入：mapping = [0,1,2,3,4,5,6,7,8,9], nums = [789,456,123]
 * 输出：[123,456,789]
 * 解释：789 映射为 789 ，456 映射为 456 ，123 映射为 123 。所以排序后数组为 [123,456,789] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * mapping.length == 10
 * 0 <= mapping[i] <= 9
 * mapping[i] 的值 互不相同 。
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] < 109
 */
public class Code13 {

    public int[] sortJumbled(int[] mapping, int[] nums) {

        //创建节点数组
        Node[] nodeArr = new Node[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //初始化
            nodeArr[i] = new Node(i, nums[i], mapping);
        }

        //排序
        Arrays.sort(nodeArr, (o1, o2) -> {
            //如果相同
            if (o1.mappedNum == o2.mappedNum) {
                //按照索引
                return o1.index - o2.index;
            }
            //默认按照映射后数字
            return o1.mappedNum - o2.mappedNum;
        });

        //创建结果数组
        int[] result = new int[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //记录结果
            result[i] = nodeArr[i].num;
        }
        //返回
        return result;
    }

    //节点
    private static class Node {

        //索引
        private int index;

        //数字
        private int num;

        //映射后的值
        private int mappedNum;

        //初始化
        public Node(int index, int num, int[] mapping) {
            this.index = index;
            this.num = num;
            this.mappedNum = getMappedNum(num, mapping);
        }

        //获取映射后的值
        private int getMappedNum(int num, int[] mapping) {
            //映射后的数字
            int mappedNum = 0;
            //倍数
            int hit = 1;
            //循环
            while (num > 9) {
                //获取当前位
                mappedNum += mapping[num % 10] * hit;
                //下一个
                num /= 10;
                hit *= 10;
            }
            //处理个位结束
            mappedNum += mapping[num % 10] * hit;
            //返回
            return mappedNum;
        }

        //输出
        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", num=" + num +
                    ", mappedNum=" + mappedNum +
                    '}';
        }

    }

    public static void main(String[] args) {

        //int[] ints = new Code13().sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, new int[]{991, 338, 38});


        int[] ints = new Code13().sortJumbled(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println();


    }

}
