package normal57;

import java.util.Arrays;

/**
 * 1806. 还原排列的最少操作步数
 * 算术评级: 4
 * 第 234 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1491
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个偶数 n​​​​​​ ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i​（下标 从 0 开始 计数）。
 * <p>
 * 一步操作中，你将创建一个新数组 arr ，对于每个 i ：
 * <p>
 * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
 * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 * 然后将 arr​​ 赋值​​给 perm 。
 * <p>
 * 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：最初，perm = [0,1]
 * 第 1 步操作后，perm = [0,1]
 * 所以，仅需执行 1 步操作
 * 示例 2：
 * <p>
 * 输入：n = 4
 * 输出：2
 * 解释：最初，perm = [0,1,2,3]
 * 第 1 步操作后，perm = [0,2,1,3]
 * 第 2 步操作后，perm = [0,1,2,3]
 * 所以，仅需执行 2 步操作
 * 示例 3：
 * <p>
 * 输入：n = 6
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 * n​​​​​​ 是一个偶数
 */
public class Code1 {

    public int reinitializePermutation(int n) {
        //初始化
        int[] permArr = new int[n];
        //循环
        for (int i = 0; i < permArr.length; i++) {
            //默认
            permArr[i] = i;
        }
        //记录首次数组
        int[] firstArr = permArr.clone();
        //先变一次
        permArr = changeArr(permArr);
        //总次数
        int count = 1;
        //循环
        while (Arrays.equals(permArr, firstArr) == false) {
            //变换一次
            permArr = changeArr(permArr);
            //+1
            count++;
        }
        //返回
        return count;
    }

    //变换数组
    private int[] changeArr(int[] permArr) {
        //新数组
        int[] newArr = new int[permArr.length];
        //循环
        for (int i = 0; i < permArr.length; i++) {
            //判断是否是偶数
            if (i % 2 == 0) {
                //是偶数
                newArr[i] = permArr[i / 2];
            } else {
                //是奇数
                newArr[i] = permArr[permArr.length / 2 + (i - 1) / 2];
            }
        }
        //返回
        return newArr;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().reinitializePermutation(4));
    }

}
