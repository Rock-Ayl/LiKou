package easy41;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-12-07
 * 3769. 二进制反射排序
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 二进制反射 是对一个 正整数 的二进制表示按顺序反转（忽略前导零）后，将反转得到的二进制数转为十进制的结果。
 * <p>
 * 请按每个元素的二进制反射值的 升序 对数组进行排序。如果两个不同的数字具有相同的二进制反射值，则 较小 的原始数字应排在前面。
 * <p>
 * 返回排序后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4,5,4]
 * <p>
 * 输出： [4,4,5]
 * <p>
 * 解释：
 * <p>
 * 二进制反射值为：
 * <p>
 * 4 -> (二进制) 100 -> (反转) 001 -> 1
 * 5 -> (二进制) 101 -> (反转) 101 -> 5
 * 4 -> (二进制) 100 -> (反转) 001 -> 1
 * 根据反射值排序为 [4, 4, 5]。
 * 示例 2：
 * <p>
 * 输入： nums = [3,6,5,8]
 * <p>
 * 输出： [8,3,6,5]
 * <p>
 * 解释：
 * <p>
 * 二进制反射值为：
 * <p>
 * 3 -> (二进制) 11 -> (反转) 11 -> 3
 * 6 -> (二进制) 110 -> (反转) 011 -> 3
 * 5 -> (二进制) 101 -> (反转) 101 -> 5
 * 8 -> (二进制) 1000 -> (反转) 0001 -> 1
 * 根据反射值排序为 [8, 3, 6, 5]。
 * 注意，3 和 6 的反射值相同，因此需要按原始值的升序排列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 109
 */
public class Code28 {

    //节点
    private static class Node {

        //数字
        private int num;

        //排序
        private int sort;

        //初始化
        public Node(int num) {
            this.num = num;
            this.sort = countSort(num);
        }

        //排序
        public int compareTo(Node another) {
            //如果不同排序值
            if (this.sort != another.sort) {
                //使用排序
                return this.sort - another.sort;
            }
            //默认使用数字
            return this.num - another.num;
        }

        //计算排序
        private int countSort(int num) {
            //转为二进制、翻转
            StringBuilder reverse = new StringBuilder(Integer.toBinaryString(num)).reverse();
            //转为数字
            return Integer.parseInt(reverse.toString(),2);
        }

        //调试
        @Override
        public String toString() {
            return String.format("num=%s,sort=%s", this.num, this.sort);
        }

    }

    public int[] sortByReflection(int[] nums) {
        //数组
        Node[] nodeArr = new Node[nums.length];
        //循环
        for (int i = 0; i < nodeArr.length; i++) {
            //初始化
            nodeArr[i] = new Node(nums[i]);
        }
        //排序
        Arrays.sort(nodeArr, Node::compareTo);
        //返回
        return Arrays.stream(nodeArr).mapToInt(p -> p.num).toArray();
    }

    public static void main(String[] args) {
        //int[] ints = new Code18().sortByReflection(new int[]{3, 6, 5, 8});
        int[] ints1 = new Code28().sortByReflection(new int[]{423819});
        System.out.println();
    }

}
