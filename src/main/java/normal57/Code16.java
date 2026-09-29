package normal57;

import java.util.Arrays;

/**
 * 3290. 最高乘法得分
 * 算术评级: 5
 * 第 415 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1692
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个大小为 4 的整数数组 a 和一个大小 至少为 4 的整数数组 b。
 * <p>
 * 你需要从数组 b 中选择四个下标 i0, i1, i2, 和 i3，并满足 i0 < i1 < i2 < i3。你的得分将是 a[0] * b[i0] + a[1] * b[i1] + a[2] * b[i2] + a[3] * b[i3] 的值。
 * <p>
 * 返回你能够获得的 最大 得分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： a = [3,2,5,6], b = [2,-6,4,-5,-3,2,-7]
 * <p>
 * 输出： 26
 * <p>
 * 解释：
 * 选择下标 0, 1, 2 和 5。得分为 3 * 2 + 2 * (-6) + 5 * 4 + 6 * 2 = 26。
 * <p>
 * 示例 2：
 * <p>
 * 输入： a = [-1,4,5,-2], b = [-5,-1,-3,-2,-4]
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * 选择下标 0, 1, 3 和 4。得分为 (-1) * (-5) + 4 * (-1) + 5 * (-2) + (-2) * (-4) = -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * a.length == 4
 * 4 <= b.length <= 105
 * -105 <= a[i], b[i] <= 105
 */
public class Code16 {

    public long maxScore(int[] a, int[] b) {

        //四种情况
        long[][] arr = new long[4][b.length];

        /**
         * 初始化第一次选择
         */

        //第一个索引
        int firstIndex = 0;
        //第一个
        long[] firstArr = arr[firstIndex];
        //初始化第一个
        firstArr[firstIndex] = (long) a[firstIndex] * b[firstIndex];
        //循环
        for (int i = firstIndex + 1; i < firstArr.length; i++) {
            //计算第一次
            firstArr[i] = Math.max((long) a[firstIndex] * b[i], firstArr[i - 1]);
        }

        /**
         * 迭代后续层级
         */

        //索引
        int levelIndex = 1;
        //循环
        while (levelIndex < 4) {
            //获取当前 and 上一个
            long[] levelArr = arr[levelIndex];
            long[] lastArr = arr[levelIndex - 1];
            //循环,从对应位置开始
            for (int i = 0; i < levelArr.length; i++) {
                //如果不够
                if (i < levelIndex) {
                    //设置为最小值
                    levelArr[i] = Long.MIN_VALUE;
                    //本轮过
                    continue;
                }
                //计算本次最大
                levelArr[i] = Math.max(levelArr[i - 1], lastArr[i - 1] + (long) a[levelIndex] * b[i]);
            }
            //下一个
            levelIndex++;
        }
        //返回
        return Arrays.stream(arr[arr.length - 1]).max().getAsLong();
    }

    public static void main(String[] args) {
        System.out.println(new Code16().maxScore(new int[]{3, 2, 5, 6}, new int[]{2, -6, 4, -5, -3, 2, -7}));
    }

}
