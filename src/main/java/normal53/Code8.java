package normal53;

import java.util.HashSet;
import java.util.Set;

/**
 * 2829. k-avoiding 数组的最小总和
 * 算术评级: 4
 * 第 359 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1347
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数 n 和 k 。
 * <p>
 * 对于一个由 不同 正整数组成的数组，如果其中不存在任何求和等于 k 的不同元素对，则称其为 k-avoiding 数组。
 * <p>
 * 返回长度为 n 的 k-avoiding 数组的可能的最小总和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, k = 4
 * 输出：18
 * 解释：设若 k-avoiding 数组为 [1,2,4,5,6] ，其元素总和为 18 。
 * 可以证明不存在总和小于 18 的 k-avoiding 数组。
 * 示例 2：
 * <p>
 * 输入：n = 2, k = 6
 * 输出：3
 * 解释：可以构造数组 [1,2] ，其元素总和为 3 。
 * 可以证明不存在总和小于 3 的 k-avoiding 数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n, k <= 50
 */
public class Code8 {

    public int minimumSum(int n, int k) {
        //不允许的元素集合
        Set<Integer> notSet = new HashSet<>();
        //当前和
        int sum = 0;
        //数字
        int num = 1;
        //当前计数器
        int count = 0;
        //循环
        while (count < n) {
            //如果被禁止了
            if (notSet.contains(num)) {
                //+1
                num++;
                //本轮过
                continue;
            }
            //叠加
            sum += num;
            //记录被禁止的
            notSet.add(k - num);
            //+1
            count++;
            //下一个
            num++;

        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().minimumSum(5, 4));;
    }

}
