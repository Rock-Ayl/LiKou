package normal53;

/**
 * 1053. 交换一次的先前排列
 * 算术评级: 5
 * 第 138 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1633
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 * <p>
 * 如果无法这么操作，就请返回原数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1]
 * 输出：[3,1,2]
 * 解释：交换 2 和 1
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,5]
 * 输出：[1,1,5]
 * 解释：已经是最小排列
 * 示例 3：
 * <p>
 * 输入：arr = [1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：交换 9 和 7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 104
 */
public class Code16 {

    public int[] prevPermOpt1(int[] arr) {

        /**
         * 找到左边要交换的索引,从后往前,如果当前数字在后面有更小的,视为左边交换索引
         */

        //最小数字
        int min = arr[arr.length - 1];
        //左边索引
        int leftIndex = -1;
        //循环
        for (int i = arr.length - 2; i >= 0; i--) {
            //如果当前更大
            if (arr[i] > min) {
                //记录索引
                leftIndex = i;
                //跳出
                break;
            }
            //刷新最小
            min = Math.min(min, arr[i]);
        }
        //如果没有找到
        if (leftIndex == -1) {
            //返回原本的
            return arr;
        }

        /**
         * 基于左边索引,寻找右边索引
         * -
         * 右边索引数字要尽量大,而且要尽量靠后,但是要小于左边索引数字
         */

        //右边索引
        int rightIndex = -1;
        //循环
        for (int i = arr.length - 1; i > leftIndex; i--) {
            //如果当前数字大于等于左边索引
            if (arr[i] >= arr[leftIndex]) {
                //本轮过
                continue;
            }
            //如果是第一次记录
            if (rightIndex == -1) {
                //直接记录
                rightIndex = i;
            } else {
                //如果更大 or 相同
                if (arr[i] >= arr[rightIndex]) {
                    //记录
                    rightIndex = i;
                }
            }
        }

        /**
         * 交换并返回
         */

        //交换
        int num = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = num;
        //返回结果
        return arr;
    }

    public static void main(String[] args) {
        //int[] ints = new Code16().prevPermOpt1(new int[]{1, 9, 4, 6, 7});
        int[] ints = new Code16().prevPermOpt1(new int[]{3, 1, 1, 3});
        System.out.println();
    }

}
