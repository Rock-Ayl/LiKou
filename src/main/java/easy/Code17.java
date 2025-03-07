package easy;

/**
 * Created By Rock-Ayl on 2020-08-23
 * LCP 06. 拿硬币
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[4,2,1]
 * <p>
 * 输出：4
 * <p>
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,3,10]
 * <p>
 * 输出：8
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 */
public class Code17 {

    public static int minCount(int[] coins) {
        //和
        int sum = 0;
        //循环
        for (int coin : coins) {
            //如果不能整除2
            if ((coin % 2) > 0) {
                //变成整除
                coin++;
            }
            //余
            int x = coin / 2;
            //累加
            sum = sum + x;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minCount(new int[]{2, 3, 10}));
    }

}
