package easy10;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author ayl
 * @Date 2021-07-07
 * 1588. 所有奇数长度子数组的和
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * <p>
 * 子数组 定义为原数组中的一个连续子序列。
 * <p>
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 * <p>
 * 输入：arr = [10,11,12]
 * 输出：66
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 */
public class Code7 {

    //结果
    int sum = 0;
    //全局
    int[] arr;

    public void setAndAdd(int size) {
        //当前和
        int sum = 0;
        //队列
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        //指针
        int p = 0;
        //循环
        while (p < size) {
            //当前值
            int num = this.arr[p++];
            //先累加
            sum += num;
            //记录队列
            queue.addLast(num);
        }
        //叠加
        this.sum += sum;
        //循环
        for (int i = p; i < this.arr.length; i++) {
            //当前值
            int num = this.arr[i];
            //加入最后队列
            queue.addLast(num);
            //计算sum,退出第一个队列
            sum += num - queue.removeFirst();
            //叠加
            this.sum += sum;
        }
    }

    public int sumOddLengthSubarrays(int[] arr) {
        //全局
        this.arr = arr;
        //长度
        int size = 1;
        //循环
        while (size <= this.arr.length) {
            //计算
            setAndAdd(size);
            //+2
            size += 2;
        }
        //返回
        return this.sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }

}
