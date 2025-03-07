package easy12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-10-06
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 * <p>
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 */
public class Code8 {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        //b缓存
        Set<Integer> set = new HashSet<>(bobSizes.length);
        //a、b和
        int a = 0, b = 0;
        //循环
        for (int aliceSize : aliceSizes) {
            //累加
            a += aliceSize;
        }
        //循环
        for (int bobSize : bobSizes) {
            //累加
            b += bobSize;
            //记录
            set.add(bobSize);
        }
        //结果差
        int minus = (b - a) / 2;
        //循环
        for (int aliceSize : aliceSizes) {
            //需要的结果
            int max = aliceSize + minus;
            //如果存在
            if (set.contains(max)) {
                //返回
                return new int[]{aliceSize, max};
            }
        }
        //默认
        return new int[2];
    }

    public static void main(String[] args) {
        for (int i : new Code8().fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})) {
            System.out.println(i + ",");
        }
    }

}
